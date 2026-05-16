# [Minimum Vertical Sum](https://www.geeksforgeeks.org/problems/minimum-vertical-sum-1593518814/1?page=1&category=Java&difficulty=Medium&sortBy=latest)
## Medium
Given a vector of vector arr[][]. Find the minimum&nbsp;vertical sum. Vector inside the vector arr&nbsp;may not be of the same size.
Example:
Input: arr = [[2, 3, 5], [1, 2], [1, 4, 5, 1]]
Output: 1
Explanation:
2 3 5
1 2
1 4 5 1
So, the vertical sums are [2+1+1], [3+2+4], [5+5], [1]. 1 is the minimum vertical sum.
Input: arr = [[1, 2, 3, 4], [3, 3], [1, 2, 5, 9]]Output: 5Explanation:1 2 3 43 31 2 5 9So, the vertical sums are [1+3+1], [2+3+2], [3+5], [4+9]. 5 is the minimum vertical sum.
Constraints:1 &nbsp;&lt;= &nbsp;arr.size() &nbsp;&lt;= &nbsp;1031 &nbsp;&lt;= &nbsp;arr[i].size() &nbsp;&lt;= &nbsp;1031 &nbsp;&lt;= &nbsp;arr[i][j] &lt;= &nbsp;105