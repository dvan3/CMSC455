# test_passing_function.py
import math

def f(x):
  return math.sin(x)

def trap_int(f, xmin, xmax, nstep): # integrate f(x) from xmin to xmax
  area=(f(xmin)+f(xmax))/2.0
  h = (xmax-xmin)/nstep
  for i in range(1,nstep):
    x = xmin+i*h
    area = area + f(x)

  return area*h # trapezoidal method

xmin = 0.0
xmax = 1.0
exact = -math.cos(1.0)+math.cos(0.0)
for i in range(0, 5):
  n = 2**(3+i)
  area = trap_int(f, xmin, xmax, n)
  print "Point: ", n, " Area: ", area, " Error: ", math.fabs(area - (1.0 * math.cos(1.0)))
