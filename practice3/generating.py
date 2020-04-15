import numpy as np
import random
import math

# generate training and test dataset

m = 1000
n = 100
k = 1000

x1_train = []
x2_train = []
y_train = []

for i in range(m):
    x1_train.append(random.uniform(-2, 2))
    x2_train.append(random.uniform(-2, 2))
    if x1_train[-1]*x2_train[-1] > x2_train[-1]:
        y_train.append(1)
    else:
        y_train.append(0)

x1_test = []
x2_test = []
y_test = []

for j in range(n):
    x1_test.append(random.uniform(-2, 2))
    x2_test.append(random.uniform(-2, 2))
    if x1_test[-1] * x2_test[-1] > x2_test[-1]:
        y_test.append(1)
    else:
        y_test.append(0)


trainX = np.array([x1_train, x2_train])
trainY = np.array([y_train])

testX = np.array([x1_test, x2_test])
testY = np.array([y_test])


def sigmoid(z):
    fz = 1.0/(1.0+np.exp(-z))
    return fz


def cross_entropy(y, y_hat):
    ce = -(y*math.log(y_hat)+(1-y)*math.log(1-y_hat))
    return ce

