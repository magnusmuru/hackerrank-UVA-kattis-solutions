def word_distance(word, typo):
    keyboard_rows = ["qwertyuiop", "asdfghjkl", "zxcvbnm"]
    difference = 0

    word_row, word_col = 0, 0
    typo_row, type_col = 0, 0

    for index in range(len(word)):
        word_letter = word[index]
        typo_letter = typo[index]

        for keyboard_row in range(len(keyboard_rows)):
            if word_letter in keyboard_rows[keyboard_row]:
                word_row = keyboard_row
                word_col = keyboard_rows[keyboard_row].find(word_letter)
            if typo_letter in keyboard_rows[keyboard_row]:
                typo_row = keyboard_row
                type_col = keyboard_rows[keyboard_row].find(typo_letter)

        difference += abs(word_row - typo_row) + abs(word_col - type_col)

    return difference


for i in range(int(input())):
    keyword, amount = list(input().split())

    typos = []

    for j in range(int(amount)):
        typos.append(input())

    typos.sort(key=lambda typo: (word_distance(keyword, typo), typo))

    for diff in typos:
        print("{} {}".format(diff, word_distance(keyword, diff)))
