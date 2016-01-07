from decimal import *

getcontext().prec = 180

a = "142857142857142857142857142857142857142857"

for i in range(len(a)-2):
    left = i
    right = i + 1
    while right < len(a):
        if (a[right] == a[left]):
            diff = right-left
            print diff
            break
        right += 1


for i in range(2, 1000):
    if ((i % 2 == 0) or (i % 3 == 0) or (i % 5 == 0)):
        continue
    num = str(Decimal(1)/Decimal(i))
    # print "D: " + str(i) + " : " + num
    a = num.split(".")[1]
    print i
    print a
    res = []
    for ii in range(len(a)-2):
        left = ii
        right = ii + 1
        while right < len(a):
            if (a[right] == a[left]):
                diff = right-left
                res.append(diff)
                break
            right += 1
    for d in range(20):
        print "count: " + str(res.count(d))
    print "-----------------"


