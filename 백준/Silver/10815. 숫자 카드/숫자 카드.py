import bisect
N = int(input())
card = list(map(int, input().split()))
M = int(input())
other = list(map(int, input().split()))
card.sort()
answer = [0] * M
for o in other:
    l = bisect.bisect_left(card, o)
    r = bisect.bisect_right(card, o)
    print(r - l, end=' ')