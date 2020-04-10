from generating import trainX, trainY, testX, testY, m, n
import math
import numpy as np


def sigmoid(z):
    fz = 1.0/(1.0+np.exp(-z))
    return fz


def cross_entropy(y, y_hat):
    ce = -(y*math.log(y_hat)+(1-y)*math.log(1-y_hat))
    return ce


w = np.array([-1, -1])
b = 0
k = 1000
alpha = 0.009

for i in range(k):
    Z = np.dot(w, trainX) + b  # (1,2) (2,m) = (1,m)
    A = 1.0/(1.0+np.exp(-Z))
    dZ = A - trainY  # 1*m vector
    dW_1 = np.dot(trainX[0], dZ.T)  # (1,m) (1,m)
    #print(X_TRAIN[0], "XT0")
    dW_1 = 1/m * dW_1
    #print(dW_1)
    dW_2 = np.dot(trainX[1], dZ.T)
    dW_2 = 1/m * dW_2
    db = 1/m * np.sum(dZ)

    w[0] = w[0] - alpha*dW_1
    w[1] = w[1] - alpha*dW_2
    #print('w', w)
    b = b - alpha*db
    #print('b', b)

accuracy_test = 0
print("w", w, "B", b)
z = np.dot(w, testX) + b
for i in range(n):
    z_i = z[i]
    if testY[i] == round(sigmoid(z_i)):
        accuracy_test = accuracy_test + 1

#print(X_TRAIN)
print(trainY)
print(accuracy_test)