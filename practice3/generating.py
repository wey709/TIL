import numpy as np

# GENERATE TRAINING & TEST DATA SET

m = 10
n = 100

# random.randint와 달리 np.random.randint는 half-open임
trainX = np.random.randint(-2, 3, size=(2, m))
trainY = []
testX = np.random.randint(-2, 3, size=(2, n))
testY = []


for i in range(m):
    if trainX[0][i]*trainX[0][i] > trainX[1][i]:
        trainY.append(1)
    else:
        trainY.append(0)

for j in range(n):
    if testX[0][j]*testX[0][j] > testX[1][j]:
        testY.append(1)
    else:
        testY.append(0)



