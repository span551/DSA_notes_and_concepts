#importing necessary libraries
import numpy as np
import tensorflow
from tensorflow.keras.preprocessing import image
from keras.layers import GlobalMaxPooling2D
from tensorflow.keras.applications.resnet50 import ResNet50, preprocess_input
from numpy.linalg import norm
import pickle
from sklearn.neighbors import NearestNeighbors
import cv2

#importing the models
feature_list = np.array(pickle.load(open("features.pkl", "rb")))
file_names = pickle.load(open("imagefiles.pkl", "rb"))

#print("feature_list")

#creating a ResNet50 model with pre-trained weights on ImageNet dataset
model = ResNet50(weights="imagenet", include_top=False, input_shape=(224,224,3))

#freezing the layers of the ResNet50 model to prevent them from being updated during training
model.trainable = False

#creating a sequential model by stacking the ResNet50 model and a GlobalMaxPooling2D layer
model = tensorflow.keras.Sequential([
    model,  #adding the pre-trained ResNet50 model
    GlobalMaxPooling2D()  #adding a GlobalMaxPooling2D layer to pool spatial information
])


#loading the image and resize it to the target size of (224, 224, 3)
img = image.load_img("C:/Users/Sobhan/Machine Learning/Deep Learning/fashion_recommendation_system/test_image/saree.jpeg", target_size=(224, 224, 3))

#converting the image to a numpy array
img_array = image.img_to_array(img)

#adding an extra dimension to the array to match the model's input shape
expanded_img_array = np.expand_dims(img_array, axis=0)

#preprocess the input image array according to the preprocessing function of the model
preprocessed_img = preprocess_input(expanded_img_array)

#using the provided model to extract features from the preprocessed image
result = model.predict(preprocessed_img).flatten()

#normalizing the extracted features
normalized_result = result / norm(result)


#initialize a NearestNeighbors object with parameters: 10 neighbors, brute force algorithm, and Euclidean distance metric
neighbors = NearestNeighbors(n_neighbors=10, algorithm="brute", metric="euclidean")

#fit the NearestNeighbors model to the feature_list, which contains the extracted features
neighbors.fit(feature_list)

#Calculate the distances and indices of the 10 nearest neighbors to the normalized_result
distances, indices = neighbors.kneighbors([normalized_result])

#printing the indices of the nearest neighbors
print(indices)

#display the images corresponding to the indices of the nearest neighbors (excluding the first one, which is the query image)
for file in indices[0][1:10]:

    #read the image corresponding to the file index from the filenames list
    temp_img = cv2.imread(file_names[file])

    #resize the image to 512x512 pixels and display it

    cv2.imshow("output", cv2.resize(temp_img, (512, 512)))
    #wait for a key press to proceed to the next image
    cv2.waitKey(0)