from generating import trainX, trainY, testX, testY, m, n, sigmoid
import math
import numpy as np




w = np.array([0.0, 0.0])
b = 0
k = 1000
alpha = 0.45

for i in range(k):
    Z = np.dot(w, trainX) + b  # (1,2) (2,m) = (1,m)
    A = sigmoid(Z)
    dZ = A - trainY  # 1*m vector
    dW_1 = np.dot(trainX[0], dZ.T)  # (1,m) (m,1)
    dW_1 = 1/m * dW_1
    dW_2 = np.dot(trainX[1], dZ.T)
    dW_2 = 1/m * dW_2
    db = 1/m * np.sum(dZ)

    w[0] = w[0] - alpha*dW_1
    w[1] = w[1] - alpha*dW_2

    b = b - alpha*db

accuracy_test = 0
print("w of task1", w, "B", b)

z = np.dot(w, testX) + b
for i in range(n):
    z_i = z[i]
    if testY[0][i] == (round(sigmoid(z_i))):
        accuracy_test = accuracy_test + 1


print("task1: ", accuracy_test)