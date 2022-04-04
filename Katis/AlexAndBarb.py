data = input().split()

cards = int(data[0])
minimum = int(data[1])
maximum = int(data[2])

optimalStrategy = cards % (minimum + maximum)
alexWins = minimum <= optimalStrategy

if alexWins:
    print("Alex")
else:
    print("Barb")
