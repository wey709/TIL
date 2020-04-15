import numpy as np
from task2 import trainX, testX, trainY, testY, m, n
from generating import sigmoid

k = 1000
alpha = 0.45

w_1 = np.random.rand(3, 2)  # from layer0 to layer 1
b_1 = np.random.rand(3, 1)
w_2 = np.random.rand(1, 3)  # from layer1 to layer 2
b_2 = np.random.rand(1, 1)


for i in range(k):
    z_1 = np.dot(w_1, trainX) + b_1  # (3, 2) (2,1000)
    a_1 = sigmoid(z_1)
    z_2 = np.dot(w_2, a_1) + b_2
    a_2 = sigmoid(z_2)
    dz_2 = a_2 - trainY
    dw_2 = 1/m*np.dot(dz_2, a_1.T)
    db_2 = 1/m*np.sum(dz_2, axis=1, keepdims= True)
    tmp_left = np.dot(w_2.T, dz_2)
    tmp_right = a_1 * (1-a_1)
    dz_1 = np.multiply(tmp_left, tmp_right)
    dw_1 = 1/m * np.dot(dz_1, trainX.T)
    db_1 = 1/m * np.sum(dz_1, axis=1, keepdims=True)
    w_1 = w_1-alpha*dw_1
    w_2 = w_2-alpha*dw_2
    b_1 = b_1-alpha*db_1
    b_2 = b_2-alpha*db_2

testZ_1 = np.dot(w_1, testX) + b_1
testA_1 = sigmoid(testZ_1)
testZ_2 = np.dot(w_2, testA_1) + b_2
testA_2 = sigmoid(testZ_2)
testY_hat = np.round(testA_2)
acc_test_3 = 0


for i in range(len(testY_hat[0])):
    if testY_hat[0][i] == testY[0][i]:
        acc_test_3 = acc_test_3 + 1

print("task3:", acc_test_3)


