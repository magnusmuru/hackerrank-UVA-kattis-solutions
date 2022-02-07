# 07. February

References to all materials used are in the start of the block for specific exercises.

## Class exercises

### Insert a node at a specific position in a linked list

Reference: https://www.geeksforgeeks.org/insert-a-node-at-a-specific-position-in-a-linked-list/

Used above article as a good reference point for the task. Overall quite a simple task that can be used for the other
tasks that come later.

Since position is given at start then first check should be for a new head of the list. Just a quick if block to check
for `pos == 0`. After that just loop through the whole linkedlist one by one, updating the head each time you swap to a
new link and then setting the new node as the next for the previous node and the head for the tail of the list if there
is one.

### Reverse a linked list

Reference: https://www.geeksforgeeks.org/reverse-a-linked-list/

Another article from GeeksforGeeks again, though not really necessary. Just speeds up the writing process.

In essence, it is similar to the last task but just requires to loop through the whole linkedlist. Start by finding the
head and checking the next node, then reference the original node to null as it would be the end of the loop. From there
you can just move on to referencing the second node to the first and so forth until you end on the original lists end
node. There just reference it to the second to last node and put it as the new head of the linkedlist. Now the list is
in reverse.

### Reverse a doubly linked list

Reference: https://www.geeksforgeeks.org/reverse-a-doubly-linked-list/

Same as before. In here just on linking need to make sure that we link up both sides. So we give the node we previously
linked back to being the next in line to have a head of the node we are currently working on. Not much to say compared
to the single linked list just an extra step. Null endpoints don't get linked back to nodes since they are well, null.

### Cycle Detection

No reference here. Done originally on Java, but I also saw it had a working C# template, so I also did that. Allowed for
some null safe checks to reduce the if statement overhead. Simply just use a high performance data structure with O(1)
search speeds such as a HashSet. Add all the already visited nodes into it and compare if a similar node shows up. This
result is really fast due to Java/C# saving a memory pointer to the object rather than the object itself. Just loop
through the whole list, look for nodes that show up again, if it does, return true, else just let the loop run to
conclusion and return false. Also check for null loops.

### Sparse Arrays

The best exercise yet. I had a blast with this, it was such a joy to write in C#. Java would have required some
streaming and other stuff. With C# just make a new List, count all the occurrences of the query string in the string
list and add them to the new list. Simple 4 lines of code.

## Home exercises

Out of the two exercises I picked UVA-12192 Grapevine. Currently, I got it to work with the example provided in the pdf
but I am going over the 3s time limit. I first created a datastructures that would ingest and hold the problems that
would come in with the solution. Took a while to figure out what was necessary to get the Runtime errors to stop in
UVA (turns out its the public in Main). After that I just made a way to loop through the whole list of items and check
for the largest boxes.

I have recently realized I should be checking diagonally instead of everything to save massive time, and I will try to
finish it still today before midnight.