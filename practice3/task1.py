import numpy as np
import random
import math
import time

# generate training and test dataset & function



m = 1000
n = 100
k = 1000
alpha = 0.3

x1_train = []
x2_train = []
y_train = []

for i in range(m):
    x1_train.append(random.uniform(-2, 2))
    x2_train.append(random.uniform(-2, 2))
    if x1_train[-1]*x1_train[-1] > x2_train[-1]:
        y_train.append(1)
    else:
        y_train.append(0)

x1_test = []
x2_test = []
y_test = []

for j in range(n):
    x1_test.append(random.uniform(-2, 2))
    x2_test.append(random.uniform(-2, 2))
    if x1_test[-1] * x1_test[-1] > x2_test[-1]:
        y_test.append(1)
    else:
        y_test.append(0)


trainX = np.array([x1_train, x2_train])
trainY = np.array([y_train])

testX = np.array([x1_test, x2_test])
testY = np.array([y_test])


np.savez("data_set.npz", trainX=trainX, trainY=trainY, testX=testX, testY=testY)


def sigmoid(z):
    fz = 1.0/(1.0+np.exp(-z))
    return fz


def cross_entropy(y, y_hat):
    ce = -(y*math.log(y_hat)+(1-y)*math.log(1-y_hat))
    return ce


# initialize and training
train_start = time.time()

w = np.random.rand(1, 2)
b = np.random.rand(1, 1)


for i in range(k):
    z = np.dot(w, trainX) + b # (1,2) (2, m)
    a = sigmoid(z)  # (1,m)
    dz = a - trainY  # (1,m)
    dw = 1/m * np.dot(trainX, dz.T)  # (2,m) (m,1)
    db = 1/m * np.sum(dz)
    w = w - alpha*dw.T
    b = b - alpha*db

train_end = time.time()
print("train time:", train_end-train_start)
print("w of task1", w, "B", b)

trainZ = np.dot(w, trainX) + b
trainA = sigmoid(trainZ)
train_hat = np.round(trainA)
acc_train = 0

for i in range(m):
    if train_hat[0][i] == trainY[0][i]:
        acc_train = acc_train + 1
print("train acc: ", acc_train)

# get accuracy of test set

test_start = time.time()

testZ = np.dot(w, testX) + b
testA = sigmoid(testZ)
test_hat = np.round(testA)
acc_test = 0

for i in range(n):
    if test_hat[0][i] == testY[0][i]:
        acc_test = acc_test + 1

test_end = time.time()
print("test time:", test_end-test_start)
print("test acc: ", acc_test)
