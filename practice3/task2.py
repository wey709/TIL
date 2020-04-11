# task1과 같은 데이터셋 공유해야함.
import numpy as np
from task1 import trainX, testX, trainY, testY, m, n,  sigmoid, cross_entropy

k = 1000
b = np.array([1.0, 1.0])  # each layer's b
w_1 = np.array([1.0, 1.0])
w_2 = 0
alpha = 0.009


def relu(X):
    return np.maximum(0, X)


for i in range(k):
    z_1 = np.dot(w_1, trainX) + b[0]  # (1,2) (2,m) => (1,m)
    a_1 = sigmoid(z_1)  # (1,m)
    z_2 = np.dot(w_2, a_1) + b[1]  # (1,m) 1~m까지 거의 다 같은 값 0.358정도로 수렴...왜지..?
    a_2 = sigmoid(z_2)  # (1,m)

    # back prop
    j = np.sum(a_2 - trainY)
    dz_2 = a_2 - trainY  # (1,m)
    dw_2 = 1/m*np.dot(dz_2, a_1.T)  # (1,m) (m,1)
    db_2 = 1/m*np.sum(dz_2, keepdims=True)
    da_1 = 1/m*np.dot(w_2, dz_2)  # (1,m)
    dz_1 = np.multiply(da_1, a_1*(1-a_1))  # (1,m) (1,m)
    #dz_1 = np.multiply(np.dot(w_2, dz_2), sigmoid(z_1)*(1-sigmoid(z_1)))
    dw_1 = 1/m*np.dot(dz_1, trainX.T)
    db_1 = 1/m*np.sum(dz_1, keepdims=True)

    w_1 = w_1 - alpha*dw_1
    w_2 = w_2 - alpha*dw_2
    b[0] = b[0] - alpha*db_1
    b[1] = b[1] - alpha*db_2

testA_1 = sigmoid(np.dot(w_1, testX) + b[0])
testZ_2 = np.dot(w_2, testA_1) + b[1]
testA_2 = sigmoid(testZ_2)
testY_hat = np.round(testA_2)
acc_test = 0

for i in range(len(testY_hat)):
    if testY[i] == testY_hat[i]:
        acc_test = acc_test + 1

#print('TEST_Y_HAT:', testY_hat, 'testa_2:', testA_2)
print("trainX:", trainX)
print("z_1:", z_1)
print('a_1', a_1)
print('z_2:', z_2)
print('a_2', a_2)

print("w_1:", w_1, "w_2:", w_2, "b:", b)
print("task2:", acc_test)

