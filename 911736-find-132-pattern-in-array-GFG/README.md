# [Find 132 Pattern in Array](https://www.geeksforgeeks.org/problems/find-132-pattern-in-array/1?page=1&category=Java,Hash,Matrix,Linked%20List,Stack,Heap,Queue&difficulty=Easy,Medium&sortBy=latest)
## Medium
You are given an array&nbsp;arr[].&nbsp;The task is to determine whether the array contains a 132 pattern, i.e., three indices i,&nbsp; j&nbsp;and k such that i &lt; j &lt; k , arr[i] &lt; arr[j] &gt; arr[k] and arr[i] &lt; arr[k].Return true if such a triplet exists, otherwise return false.
Examples:
Input: arr[] = [4, 7, 11, 5, 13, 2]Output: trueExplanation: Triplet [4, 7, 5] satisfies the condition since 4 &lt; 7, 5 &lt; 7 and 4 &lt; 5.
Input: arr[] = [11, 11, 12, 9]Output: falseExplanation: No triplet satisfies the given conditions.
Constraints:3 ≤ arr.size( ) ≤ 1051&nbsp;≤ arr[i] ≤ 105