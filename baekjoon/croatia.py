words = input()

two_words = ['c=','c-','d-','lj','nj','s=','z=']
three_words = ['dz=']

j = 0
n = 0

if len(words)==1:
    print(1)

elif len(words)==2:
    if words in two_words:
        print(1)
    else:
        print(2)

else:
    while(j<len(words)):
        if words[j:j+3] in three_words:
            n = n+1
            j = j+3
        elif words[j:j+2] in two_words:
            n = n+1
            j = j+2
        else:
            n = n+1
            j= j+1

    print(n)


