# sorts-tjanderson-yola

## Problem Description
There are a number of different sorting algorithms but which one should used when? This assignment takes 7 sorts and compares their times when given the same list of random integers. Each of these sorts must read in a list from std in and sort the list then print it to std out. 


## Cheater Check

java generator 42 1400 | grep 9| ~/../../usr/bin/time java BubbleSort
java generator 42 1400 | grep -v 9| ~/../../usr/bin/time java BubbleSort

while the first command was faster, this is because the size of the list is less than for the second command, so spongebob is wrong.
