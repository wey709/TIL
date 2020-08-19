

lines = []

# print('enter: ')

while True:
    line = input()
    dot = "."
    if line != dot:
        lines.append(line)
    else:
        # print(lines)
        break


for line in lines:
    tmp_stack = []
    flag_printed = False
    if len(line)==0:
        break
    for s in range(len(line)):
        if (line[s] == "(" or line[s] == "["):
            tmp_stack.append(line[s])
        elif (line[s] == ")"):
            if(len(tmp_stack)==0):
                flag_printed = True
                print("no")
                break
            if(tmp_stack[-1] == "("):
                tmp_stack.pop()
                continue
            else:
                flag_printed = True
                print("no")
                break
        elif (line[s] == "]"):
            if(len(tmp_stack)==0):
                flag_printed = True
                print("no")
                break
            if(tmp_stack[-1] == "["):
                tmp_stack.pop()
                continue
            else:
                flag_printed = True
                print("no")
                break
        else:
            continue
    if not flag_printed:
        if len(tmp_stack)==0:
            print("yes")
        else:
            print("no")




