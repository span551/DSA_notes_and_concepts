#importing necessary libraries
import numpy as np
import tensorflow
from tensorflow.keras.preprocessing import image
from keras.layers import GlobalMaxPooling2D
from tensorflow.keras.applications.resnet50 import ResNet50, preprocess_input
from numpy.linalg import norm
import pickle
from sklearn.neighbors import NearestNeighbors
import streamlit as st
import os
from PIL import Image


#importing the models
feature_list = np.array(pickle.load(open("features.pkl", "rb")))
file_names = pickle.load(open("imagefiles.pkl", "rb"))


#creating a ResNet50 model with pre-trained weights on ImageNet dataset
model = ResNet50(weights="imagenet", include_top=False, input_shape=(224,224,3))

#freezing the layers of the ResNet50 model to prevent them from being updated during training
model.trainable = False

#creating a sequential model by stacking the ResNet50 model and a GlobalMaxPooling2D layer
model = tensorflow.keras.Sequential([
    model,  #adding the pre-trained ResNet50 model
    GlobalMaxPooling2D()  #adding a GlobalMaxPooling2D layer to pool spatial information
])


#title
st.title("Fashion Recommendation System")


#define a function to save an uploaded file
def save_uploaded_file(uploaded_file):
    try:
        #open the file in binary write mode and save it in the "files" directory with its original name
        with open(os.path.join("files", uploaded_file.name), "wb") as f:

            #write the contents of the uploaded file to the opened file
            f.write(uploaded_file.getbuffer())

        #return 1 to indicate successful file saving
        return 1

    except:
        #return 0 to indicate failure in saving the file
        return 0


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


#define a function named recommender that takes two arguments: features and feature_list
def recommender(features, feature_list):

    #initialize a NearestNeighbors object with parameters: 10 neighbors, brute force algorithm, and Euclidean distance metric
    neighbors = NearestNeighbors(n_neighbors=10, algorithm="brute", metric="euclidean")

    #fit the NearestNeighbors model to the feature_list, which contains the extracted features
    neighbors.fit(feature_list)

    #Calculate the distances and indices of the 10 nearest neighbors to the normalized_result
    distances, indices = neighbors.kneighbors([features])

    #return the indices of the nearest neighbors
    return indices

#printing the indices of the nearest neighbors
#print(indices)


#display a file uploader widget to allow the user to choose an image file
uploaded_file = st.file_uploader("Choose an Image")

# Check if an image file has been uploaded
if uploaded_file is not None:
    #check if the uploaded file was successfully saved
    if save_uploaded_file(uploaded_file):
        #display the uploaded image
        display_image = Image.open(uploaded_file)
        st.image(display_image)

        #extract features from the uploaded image
        features = feature_extract(os.path.join("files", uploaded_file.name), model)

        #get recommendations based on the extracted features
        indices = recommender(features, feature_list)

        #display the recommended images in a grid layout
        col1, col2, col3, col4, col5, col6 = st.columns(6)

        # Display the first five recommended images in separate columns
        with col1:
            st.image(file_names[indices[0][0]])
        with col2:
            st.image(file_names[indices[0][1]])
        with col3:
            st.image(file_names[indices[0][2]])
        with col4:
            st.image(file_names[indices[0][3]])
        with col5:
            st.image(file_names[indices[0][4]])
        with col6:
            st.image(file_names[indices[0][5]])
    else:
        #display an error message if there was an issue with file upload
        st.header("Error Occurred in File Upload")

