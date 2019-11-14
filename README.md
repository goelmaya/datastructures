This repository contains all the source code related to following Data structures.
Refer to this repository if you want to learn how data structures can be implemented in Java.
You may raise a pull request for any modifications.**
Youtube: <<Fill this soon>>
Arrays
Linked Lists
Stacks
Queues
Heaps and Priority queues
Trees
Graphs
Disjoint sets
Hash Table

The goal of hash table is to construct a mapping from keys to values.Example: Number of times a word has appeared in a text could be organised using a hash table
key: word, value: frequency of the word in the text. 

Properties of hash function

Hash functions converts keys to whole numbers.
 If h(x)=h(y), then x and y might be equal. But if h(x) <> h(y), h and y are definitely not equal.
 h(x) should be deterministic. It must always produce the same result.
 Hash collision is when two objects x and y have the same hash value i.e h(x)=h(y). We should try to minimize hash collisions. There are many techniques for doing this. Separate chaining and open addressing are the most popular ones.
 An hashable key should be immutable. For example: A set shouldn't be used as a key. If it's not immutable, The hash function may not be deterministic.
 Insertion, Removal and search can be done in O(1) given our hash function is deterministic and there are no collisions.
Separate chaining
Open addressing
Linear probing - May lead to cycles and infinite loop if probing function is flawed. for ex: p(x)=4x on a size of 12 . The solution is to have a probing function that creates a cycle of n size. select GCD(size, A)=1 
quadratic probing
Double hashing
Psuedo random number generator.
Universal hash functions
Fenwick Tree
 Used to get prefixed sum of an array. For example if an array of 6 elements is given, We can get sum of array[0...5] etc
 Takes o(n) to store a fenwick tree
 Time to search in a fenwick tree is o(logn)
 Time to update every element in fenwick tree is o(logn)
 Time to create a fenwick tree for the first time o(nlogn)
 Alternates to Fenwick tree:
 Segment tree. Is more complicated. Takes 4n space and 4logn time for array of length n
 Maintain an array and keep storing sum till an index in an array. Problem with this approach is that any updation of an element in the original array will cause O(n) to update the sum array.