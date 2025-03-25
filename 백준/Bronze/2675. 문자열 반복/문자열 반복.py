for num in range(int(input())):
    info = input().split()
    for word in info[1]:
        print(word*int(info[0]), end='')
    print()