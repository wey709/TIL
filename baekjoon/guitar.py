input_n_m = input()
num_guitar = int(input_n_m.split(' ')[0]) # 필요한 기타줄 개수
num_brand = int(input_n_m.split(' ')[1]) # 브랜드 개수

package_list = []
piece_list = []
mini_list = []

for i in range(num_brand):
    package_piece = input()
    package = int(package_piece.split(' ')[0]) # 패키지 가격
    piece = int(package_piece.split(' ')[1]) # 피스 가격
    package_list.append(package)
    piece_list.append(piece)


package = min(package_list)
piece = min(piece_list)

if(package>piece*6):
    mini_list.append(piece*num_guitar)

else:
    num_guitar_d = num_guitar // 6
    num_guitar_r = num_guitar % 6

    if(piece*num_guitar_r>package):
        mini_list.append(package*num_guitar_d+package)
    else:
        mini_list.append(package*num_guitar_d+piece*num_guitar_r)


print((min(mini_list)))