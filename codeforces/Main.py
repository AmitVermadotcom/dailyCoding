def f(x):
	x += 1
	while(x % 10 == 0):
		x //= 10
	return x

a = set()
n = int(input())

while(not(n in a)):
	a.add(n)
	n = f(n)
print(len(a))