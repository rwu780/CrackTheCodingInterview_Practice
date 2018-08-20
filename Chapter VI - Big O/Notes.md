# Cracking the Coding Interview

The focus of <b>Cracking the Coding Interview</b> is algorithm, coding, and design questions.

## Big O
Big O time is the language and metric we use to describe the efficiency of algorithms.



### Time Complexity
Concept of asymptotic runtime or big O time.

We can describe our runtime for an algorithm in three different day

- <b>Best Case</b>, not a very useful concept. Every algorithm can get O(1) in the best case
	- Lower Bound of the runtime
- <b>Worst Case</b>
	- Upper Bound of the runtime
- <b>Expected Case</b>
	- Tight Bound(between upper and lower) of the runtime
	- For many algorithms, worst case and expected case are the same.

### Space Complexity
Time is not the only thing that matters in an algorithm. We might also care about the amount of memory or space required by algorithm

Space complexity is a parallel concept to time complexity.

### Rate of Increase
A final way to approach the runtime is to think about how the runtime changes as n gets bigger. After all, this is exactly what big O time means