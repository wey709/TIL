#!/usr/bin/env python
# coding: utf-8

# In[1]:


import tensorflow as tf


# In[2]:


from tensorflow.keras import datasets, layers, models


# In[3]:


from PIL import Image
import matplotlib.pyplot as plt
import numpy as np


# In[4]:


(x_train, _), (x_test, _) = datasets.cifar10.load_data()


# In[5]:


x_train = x_train.reshape((50000, 32, 32, 3))
x_test = x_test.reshape((10000, 32, 32, 3))


# In[6]:


x_train, x_test = x_train/255.0, x_test/255.0 


# In[7]:


y_train, y_test = x_train, x_test 


# In[8]:


input_ = layers.Input(shape=(None, None, 3))
gaussian = layers.GaussianNoise(0.1)(input_)
conv1 = layers.Conv2D(64,(3,3), padding='SAME')(gaussian)
relu1 = tf.keras.activations.relu(conv1)
conv2 = layers.Conv2D(64,(3,3), padding='SAME')(relu1)
relu2 = tf.keras.activations.relu(conv2)
conv3 = layers.Conv2D(64,(3,3), padding='SAME')(relu2)
relu3 = tf.keras.activations.relu(conv3)
conv4 = layers.Conv2D(64,(3,3), padding='SAME')(relu3)
relu4 = tf.keras.activations.relu(conv4)
conv5 = layers.Conv2D(3,(3,3), padding='SAME')(relu4)
residual_added = layers.Add()([gaussian, conv5])


# In[9]:


model2_train = models.Model(inputs=[input_],outputs= residual_added)


# In[10]:


model2_train.compile(optimizer ='adam', loss= tf.keras.losses.MeanSquaredError())


# In[11]:


model2_train.fit(x_train, y_train, epochs=100, batch_size=32)


# In[12]:


model2_train.save('./model2')


# In[13]:


model2_train.save_weights('./model2_weights')


# In[14]:


def Model2_test():
    input_ = layers.Input(shape=(None, None, 3))
    conv1 = layers.Conv2D(64,(3,3), padding='SAME')(input_)
    relu1 = tf.keras.activations.relu(conv1)
    conv2 = layers.Conv2D(64,(3,3), padding='SAME')(relu1)
    relu2 = tf.keras.activations.relu(conv2)
    conv3 = layers.Conv2D(64,(3,3), padding='SAME')(relu2)
    relu3 = tf.keras.activations.relu(conv3)
    conv4 = layers.Conv2D(64,(3,3), padding='SAME')(relu3)
    relu4 = tf.keras.activations.relu(conv4)
    conv5 = layers.Conv2D(3,(3,3), padding='SAME')(relu4)
    residual_added = layers.Add()([input_, conv5])
    model = tf.keras.Model(input_,residual_added)
    return model


# In[15]:


model2_test = Model2_test()


# In[16]:


model2_test.load_weights('./model2_weights')


# In[17]:


image_data= []
test_image = Image.open('./noisy.png')


# In[18]:


image_data.append(np.array(test_image))
image_data = np.array(image_data)


# In[19]:


image_data = image_data / 255.0


# In[20]:


image_data.shape


# In[21]:


model2_test.predict(image_data)


# In[22]:


after = model2_test.predict(image_data)


# In[23]:


squeezed = np.squeeze(after)*255.0


# In[24]:


Image.fromarray(squeezed.astype('uint8'),'RGB')


# In[25]:


output = Image.fromarray(squeezed.astype('uint8'),'RGB')


# In[26]:


output.save('./Model2.png')

