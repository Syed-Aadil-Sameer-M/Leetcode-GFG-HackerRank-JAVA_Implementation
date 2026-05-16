# [Max Heap implementation](https://www.geeksforgeeks.org/problems/max-heap-implementation/1?page=1&category=Java,Hash,Matrix,Linked%20List,Stack,Heap,Queue&difficulty=Easy,Medium&sortBy=latest)
## Easy
Implement a class&nbsp;maxHeap&nbsp;that supports the following operations:

push(x) –&nbsp;push element x into the heap
pop() – remove the top element from the heap
peek() – return top element from the heap, if empty return -1
size() - return the no of elements in the heap.

There will be a sequence of queries&nbsp;queries[][]. The queries are represented in numeric form:

1 x : call push(x)
2: call pop()
3: call peek()
4: call size()

The driver code will process the queries, call the corresponding functions, and print the outputs of peek(), size() operation.
You only need to implement the above four functions.
Examples :
Input: q = 5, queries[][] = [[1, 3], [1, 7], [3], [1, 2], [3]]
Output: [7, 7]
Explanation:
push(3): heap is [3]push(7): heap is [7, 3]peek(): return top element 7push(2): heap is [7, 3, 2]peek(): return top element 7
Input: q = 6, queries[][] = [[1, 4], [1, 8], [1, 7], [2], [3], [4]]
Output: [7, 2]
Explanation:
push(4): heap is [4]push(8): heap is [8, 4]push(7): heap is [8, 7, 4]pop(): remove top element 8, now heap is [7, 4]peek(): return top element 7size(): return no of elements in the heap
Constraints:1 ≤ q ≤ 1031 ≤ x ≤ 105