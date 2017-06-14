import numpy as np
from scipy import interpolate

n = int(raw_input())
prices = []
for i in xrange(n):
    time, price = raw_input().split("\t")
    prices.append(price)
x = []
prices_float = []
missing = []
for i in xrange(n):
    if not "Missing" in prices[i]:
        x.append(i)
        prices_float.append(float(prices[i]))
    else:
        missing.append(i)
y = np.array(prices_float)
f = interpolate.UnivariateSpline(x, y, s=3)

for i in missing:
    print f(i)
