### Bonus Question: What is significant about log2(MAX_BOUNDARY-MIN_BOUNDARY)? Why did we pick this for the line between GOOD and EXCELLENT grades?

There are initially n choices for the solution, where n = max_boundary - min_boundary. Each iteration of the algorithm reduces the number of choices by a factor of two, then the number of iterations needed to select a single choice is again the integral part of log2(n). It is similar to binary search, where the number of iterations needed to find a single element is log2(n).

**Example Scenario**:

- If we need to choose a number between 0 to 11 (non-inclusive), there will be 10 choices initially.

- In the most efficient way of logically choosing a number, we will pick a number that is in between of the two extremes (1 and 10), i.e. 5. That will give us an idea of whether it is in the lower or the upper half of the range, and cut the number of possibilities by half for the next iteration.

- If the right answer is greater than 5, then we will pick a number that is in between 5 and 10, i.e. 8. If the right answer is less than 5, then we will pick a number that is in between 1 and 5, i.e. 3. This process will continue until we find the right answer.
- As we can see, the number of iterations needed to find a single choice is 4 at maximum, which is log2(10) rounded up.

What separates GOOD and EXCELLENT grades is the number of iterations needed to find a single choice. If the number of iterations is less than log2(n) required by binary search, which happens to be the most efficient way in which you can logically search for the right answer, then the grade is EXCELLENT, otherwise it is GOOD.
