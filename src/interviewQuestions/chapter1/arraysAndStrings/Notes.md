# Notes

## Hash Tables
A hash table is a data structure that maps keys to values for highly efficient lookup. 

Look up time is O(1)

## ArrayList & Resizable Arrays
The array or list will grow as you append items.

- An ArrayList is an array that resizes itself as needed while still providing O(1) access.
- When the array is full, the array doubles in size. Each doubling takes O(n) times, but happens so rarely that its amortized insertion time is still O(1);

## StringBuilder
On each string concatenation, a new copy of the string is created, and the two strings are copied over. 

StringBuilder simply creates a resizable array of all the strings, copyinf them back to a string only when necessary.