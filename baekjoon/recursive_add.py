count = 0

def f(start, sum):

    if sum in [1,2]:
        return sum
  
    if start == sum:
        global count
        count = count+1
    elif start<sum:
        f(start+1, sum)
        f(start+2, sum)
        f(start+3, sum)
    return count

n = input()
i = 0

while i<int(n):
    sum = input()
    sum = int(sum)
    print(f(0, sum))
    count = 0
    i = i+1


     
