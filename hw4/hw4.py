import math

def main():
    print "********************Part one********************"
    print math.factorial(52)

    print "********************Part two********************"
    print math.factorial(52) / (math.factorial(52 - 7) * math.factorial(7))

main()
