# task1과 같은 데이터셋 공유해야함.
import numpy as np
from task1 import trainX, testX, trainY, testY, m, n,  alpha, sigmoid, cross_entropy

k = 1000
b = np.array([0, 0])  # each layer's b
w_1 = np.array([0, 0])
w_2 = 0


for i in range(k):
    z_1 = np.dot(w_1, trainX) + b[0]  # (1,2) (2,m) => (1,m)
    a_1 = sigmoid(z_1)  # (1,m)
    z_2 = np.dot(w_2, a_1) + b[1]  # (1,m)
    a_2 = sigmoid(z_2)  # (1,m)
    j = np.sum(a_2 - trainY)
    dz_2 = a_2 - trainY  # (1,m)
    dw_2 = 1/m*np.dot(dz_2, a_1.T)  # (1,m) (m,1)
    db_2 = 1/m*np.sum(dz_2, keepdims=True)  # axis = 1 error
    dz_1 = np.multiply(sigmoid(z_1)*(1-sigmoid(z_1)), np.dot(w_2, dz_2))
    dw_1 = 1/m*np.dot(dz_1, trainX.T)
    db_1 = 1/m*np.sum(dz_1, keepdims=True)


testA_1 = sigmoid(np.dot(w_1, testX) + b[0])
testZ_2 = np.dot(w_2, testA_1) + b[1]
testA_2 = sigmoid(testZ_2)
testY_hat = np.round(testA_2)
acc_test = 0

for i in range(len(testY_hat)):
    if testY[i] == testY_hat[i]:
        acc_test = acc_test + 1

print("task2:", acc_test)

