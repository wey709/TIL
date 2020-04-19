import numpy as np
import time

m = 1000
n = 100
k = 1000
alpha = 0.3

w_1 = np.random.rand(3, 2)  # from layer0 to layer 1
b_1 = np.random.rand(3, 1)
w_2 = np.random.rand(1, 3)  # from layer1 to layer 2
b_2 = np.random.rand(1, 1)

load = np.load("data_set.npz")
trainX = load['trainX']
trainY = load['trainY']
testX = load['testX']
testY = load['testY']


def sigmoid(z):
    fz = 1.0/(1.0+np.exp(-z))
    return fz


train_start = time.time()

for i in range(k):
    z_1 = np.dot(w_1, trainX) + b_1  # (3, 2) (2,1000)
    a_1 = sigmoid(z_1)
    z_2 = np.dot(w_2, a_1) + b_2
    a_2 = sigmoid(z_2)
    dz_2 = a_2 - trainY
    dw_2 = 1/m*np.dot(dz_2, a_1.T)
    db_2 = 1/m*np.sum(dz_2, axis=1, keepdims= True)
    tmp_left = np.dot(w_2.T, dz_2)
    tmp_right = a_1* (1-a_1)
    dz_1 = np.multiply(tmp_left, tmp_right)
    dw_1 = 1/m * np.dot(dz_1, trainX.T)
    db_1 = 1/m * np.sum(dz_1, axis=1, keepdims=True)
    w_1 = w_1 - alpha * dw_1
    w_2 = w_2-alpha*dw_2
    b_1 = b_1-alpha*db_1
    b_2 = b_2-alpha*db_2

train_end = time.time()
train_time = train_end-train_start
print("train time: ", train_time)

trainZ_1 = np.dot(w_1, trainX) + b_1
trainA_1 = sigmoid(trainZ_1)
trainZ_2 = np.dot(w_2, trainA_1) + b_2
trainA_2 = sigmoid(trainZ_2)
trainY_hat = np.round(trainA_2)
acc_train = 0

for j in range(len(trainY_hat[0])):
    if trainY_hat[0][j] == trainY[0][j]:
        acc_train = acc_train + 1
print("train acc: ", acc_train)

test_start = time.time()
testZ_1 = np.dot(w_1, testX) + b_1
testA_1 = sigmoid(testZ_1)
testZ_2 = np.dot(w_2, testA_1) + b_2
testA_2 = sigmoid(testZ_2)
testY_hat = np.round(testA_2)
test_end = time.time()
test_time = test_end-test_start
print("test time: ", test_time)
acc_test = 0

for j in range(len(testY_hat[0])):
    if testY_hat[0][j] == testY[0][j]:
        acc_test = acc_test + 1

print("w of task3", w_1, w_2, "B", b_1, b_2)
print("test acc", acc_test)
