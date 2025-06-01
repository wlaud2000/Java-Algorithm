# 0. 입력받기
import sys
input = sys.stdin.readline

N, M = map(int,input().split())
cards = list(map(int,input().split()))
sum = 0

# 1. 모든 수 계산
for i in range(N):
    for j in range(i+1, N-1):
        for k in range(j+1, N):
        	# 첫자리를 더한 수가 M보다 클 경우 다시 뽑음
            if cards[i] + cards[j] + cards[k] > M:
                continue
            # 아니라면 M과 최대한 가깝게 만들기
            else:
                sum = max(sum, (cards[i]+cards[j]+cards[k]))


print(sum)