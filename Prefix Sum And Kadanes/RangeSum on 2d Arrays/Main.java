/*Given a 2D matrix matrix, your task is to handle the multiple queries of the following type.

Calculate the sum of the elements of the matrix inside the rectangle formed by its upper left corner (row1,col1) and lower right corner(row2,col2).

Your are given q queries of such type and you need to find the output for every query.

Input Format
The first line of input contains the number of rows and columns n and m, respectively.

The next n lines contains m space seperated seperated integers.

The next line contains the number of queries q.

The next q lines contains 4 space seperated integers row1,col1,row2,and col2 respectively.

Output Format
Return the sum for each query in new line.

Example 1
Input

5 5
3 0 1 4 2
5 6 3 2 1
1 2 0 1 5
4 1 0 1 7
1 0 3 0 5
3
2 1 4 3
1 1 2 2
1 2 2 4
Output

8
11
12
Explanation



The first query is marked in red and the output is 8.

The second query is marked in green and the sum is 11.

the third query is marked in blue and the sum is 12.

Example 2
Input

2 2
1 1
2 2
1
0 0 1 1
Output

6
Explanation

The complete sum of the 2D array is 6.

Constraints
1 <= n,m <= 200

10-4 <= matrix[i] <= 104

1 <= q <= 10000
*/

