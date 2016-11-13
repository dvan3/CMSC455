# test_polyfit.py     polyfit in Python, needs numpy
from numpy import array
from numpy import polyfit
from numpy import polyval
import pylab

print "test_polyfit.py  a x,y,17) "

x=array([0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6,
	0.7, 0.8, 0.9, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7, 1.8,
	1.9])
print "x="
print  x
y=array([0.0, 5.0, 13.3, 5.0, 4.5, 4.5, 4.5,
	4.5, 4.5, 4.5, 4.5, 4.5, 4.5, 4.5, 4.5, 4.5, 4.5, 4.5, 4.5, 
	0.0])
print "y="
print y

p=polyfit(x,y,17)
print "polyfit p=polyfit(x,y,17)"
print p

# polyval
y1=polyval(p,x)
print "polyval y1=polyval(p,x)"
print y1

err=abs(y-y1)
print "err=abs(y-y1) an array",
print err

sumerr=sum(err)
print "sumerr=sum(err) a number",
print sumerr
