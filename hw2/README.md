# 1583 Assignment 2: Class Average Calculator

## Problem Statement

Write a program that computes the class average for a test. Your user is a teacher that will input numerical grades like: 98, 100, 42, 99, 78

Your program will first display the text:

```
Please begin typing your scores. Insert a negative number to end the program.
>
```

After each score entry you will Display the running class average, along with a total number of grades that have been inputted thus far. The average should show no more than 2 decimals. Once any negative number is provided your program will output a summary of the scores entered. It will include:

- an average of the scores rounded to the second decimal.
- a letter grade (refer to this class’ syllabus for the ranges for each letter grade)
- the total number of submitted grades.

## How to run

```
$ javac ClassAverage.java
$ java ClassAverage
```

## Example Output

```
Please begin typing your scores. Insert a negative number to end the program.
> 88
Class average: 88.00 (graded 1)
Enter your next score (-1 to end):
> 99
Class average: 93.50 (graded 2)
Enter your next score (-1 to end):
> 98
Class average: 95.00 (graded 3)
Enter your next score (-1 to end):
> 97
Class average: 95.50 (graded 4)
Enter your next score (-1 to end):
> 96
Class average: 95.60 (graded 5)
Enter your next score (-1 to end):
> 23
Class average: 83.50 (graded 6)
Enter your next score (-1 to end):
> -1
Your class average was 83.50 (B) with a total of 6 grades entered.
```
