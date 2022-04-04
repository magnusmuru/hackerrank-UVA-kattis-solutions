import sys

total_fish, fishmongers = map(int, input().split())
sellable_fish = [int(x) for x in input().split()]
fish_monger_dictionary = {}
for _ in range(fishmongers):
    quantity, money = map(int, input().split())
    if money in fish_monger_dictionary:
        fish_monger_dictionary[money] += quantity
    else:
        fish_monger_dictionary[money] = quantity

sellable_fish.sort(reverse=True)

output = 0

i = 0
for price, purchasable_fish in sorted(fish_monger_dictionary.items(), reverse=True):
    while purchasable_fish > 0:
        if i >= total_fish:
            print(output)
            sys.exit(0)
        output += sellable_fish[i] * price
        purchasable_fish -= 1
        i += 1

print(output)
