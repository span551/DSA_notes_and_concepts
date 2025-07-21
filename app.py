#importing necessary libraries
import numpy as np
import tensorflow
from tensorflow.keras.preprocessing import image
from keras.layers import GlobalMaxPooling2D
from tensorflow.keras.applications.resnet50 import ResNet50, preprocess_input
from numpy.linalg import norm
import os
from tqdm import tqdm
import pickle


#creating a ResNet50 model with pre-trained weights on ImageNet dataset
model = ResNet50(weights="imagenet", include_top=False, input_shape=(224,224,3))

#freezing the layers of the ResNet50 model to prevent them from being updated during training
model.trainable = False

#creating a sequential model by stacking the ResNet50 model and a GlobalMaxPooling2D layer
model = tensorflow.keras.Sequential([
    model,  #adding the pre-trained ResNet50 model
    GlobalMaxPooling2D()  #adding a GlobalMaxPooling2D layer to pool spatial information
])

#summary of the model
#print(model.summary())


def feature_extract(img_path, model):
    #loading the image and resize it to the target size of (224, 224, 3)
    img = image.load_img(img_path, target_size=(224, 224, 3))

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

    return normalized_result

#initialize an empty list to store filenames
filenames = []

for file in os.listdir("images"):  #iterate through each file in the "images" directory
    filenames.append(os.path.join("images", file))  #append the path of each file to the filenames list

#print(len(filenames))  #total number of filenames in the list
#print(filenames[0:5])  #first 5 filenames in the list


#initialize an empty list to store extracted features
feature_list = []

for file in tqdm(filenames):  #iterate through each file in the list of filenames
    feature_list.append(feature_extract(file, model))  #extract features from each file and append to feature_list

print(np.array(feature_list).shape)  #shape of the array containing the extracted features

#dump the list of extracted features into a file named "features.pkl"
pickle.dump(feature_list, open("features.pkl", "wb"))

#dump the list of filenames into a file named "imagefiles.pkl"
pickle.dump(filenames, open("imagefiles.pkl", "wb"))


