#Name:       Dave Van
#Homework:   1
#Email:      dvan3@umbc.edu
#Class:      CMSC 455
#Instructor; Professor Squire

import sys
import math

def main():
    #gravity meters per second
    gravity = 9.80665
    #density of air
    airDensity = 1.293
    #time
    dt = 0.1
		
    #in meters
    length = 0.311
    diameter = 0.0241
    #square meters
    bodyArea = 0.000506
    finsArea = 0.00496
    #dimension less drag
    dragBody = 0.45
    dragFins = 0.01
    #kilograms
    mass = 0.0340
    initialEngine = 0.0242
    finalEngine = 0.0094
		
    #thrust listed in seconds
    thrust = [0.0, 6.0, 12.5, 5.0, 4.5, 4.5, 4.5, 4.5,
	      4.5, 4.5, 4.5, 4.5, 4.5, 4.5, 4.3, 4.3,
	      4.3, 4.3, 4.3, 0.0]
		
    t = 0.0 #time
    s = 0.0 #height
    v = 0.0 #velocity
    a = 0.0 #acceleration
    F = 0.0 #total force
    m = mass + initialEngine #mass
    vp = 0.0 #previous velocity
    sp = 0.0 #previous height

    print t, "", s, "", v, "", a, "", F, "", m

    while v >= 0.0:
        #time advancing
        t = t + dt
        
        #calculating force of drag on body
        FdBody = dragBody * airDensity * bodyArea * math.pow(v, 2) / 2
        
        #calculating force of drag on fins
        FdFins = dragFins * airDensity * finsArea * math.pow(v, 2) / 2
        
        #calculating force of gravity
        Fg = m * gravity
        
        #getting force of thrust
        index = (int)(t * 10)
        if index < len(thrust):
            Ft = thrust[index]
        else:
            Ft = 0.0
        
        #calculating total Force
        F = Ft - (FdBody + FdFins + Fg)
        
        #calculating acceleration
        a = F / m;
        
        #calculating change in velocity
        dv = a * dt;
        
        #calcuating new velocity
        v = vp + dv;
        vp = v; #previous velocity

        if v > 0.0:
            ds = v * dt;
            s = sp + ds;
            sp = s; #previous height

        #m = m - 0.0001644 * Ft
        m = m - 0.0001644 * Ft

        if v > 0.0:
            print t, "", s, "", v, "", a, "", F, "", m

main()
