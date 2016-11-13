# test_gauleg.py  test  gauleg.py  function gaulegf
from gauleg import gaulegf
import math

def f(p):
  return math.sin(p)

print "hw3_1b.py integrate f(p)=sin(x) from 0 to 1"
print "calling x,w = gaulegf(0.0, 1.0, 8)"
n = 8
x,w = gaulegf(0.0, 1.0, n)
print "**************** n =", 8, "*****************"
print "x=",
print x
print "w=",
print w

area = 0.0
for i in range(1, n+1):
  area += w[i]*f(x[i])

print "exact area=1.0-cos(1.0)"
print "computed area= ",
print area
print "error= ",
print math.fabs(area - 1.0 - math.cos(1.0))

n = 16
print "**************** n =", n,  "*****************"
x,w = gaulegf(0.0, 1.0, n)
print "x=",
print x
print "w=",
print w

area = 0.0
for i in range(1, n+1):
  area += w[i]*f(x[i])

print "exact area=1.0-cos(1.0)"
print "computed area= ",
print area
print "error= ",
print math.fabs(area - 1.0 - math.cos(1.0))
