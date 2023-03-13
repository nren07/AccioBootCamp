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

import java.util.*;

class Pair {
    int row1;
    int row2;
    int col1;
    int col2;
}

class Solution {

    public List<Integer> solve(int matrix[][], Pair query[]) {
        int n=matrix.length;
		int l=query.length;
		ArrayList<Integer>ans=new ArrayList<>();
		for(int i=0;i<n;i++){
			for(int j=1;j<matrix[0].length;j++){
				matrix[i][j]+=matrix[i][j-1];	
			}			
		}
		
		for(int i=1;i<n;i++){
			for(int j=0;j<matrix[0].length;j++){
				matrix[i][j]+=matrix[i-1][j];
			}
		}
        for(int i=0;i<query.length;i++){
			Pair temp=query[i];
			int r1=temp.row1;
			int r2=temp.row2;
			int c1=temp.col1;
			int c2=temp.col2;
			int sum=matrix[r2][c2];
			int extraSum= ((r1!=0 )? matrix[r1-1][c2] : 0) + ((c1!=0) ? matrix[r2][c1-1] : 0) ;
			extraSum-=((r1!=0) && (c1!=0) ? matrix[r1-1][c1-1] : 0);
			int actualSum=sum-extraSum;
			ans.add(actualSum);
		}
		return ans;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int matrix[][] = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            matrix[i][j]=sc.nextInt();
        }
        int q = sc.nextInt();
        Pair query[] = new Pair[q];

        Solution obj = new Solution();
        for (int i = 0; i < q; i++) {
            Pair p=new Pair();
            p.row1 = sc.nextInt();
            p.col1 = sc.nextInt();
            p.row2 = sc.nextInt();
            p.col2 = sc.nextInt();
            query[i]=p;
        }
        List<Integer> ans = obj.solve(matrix, query);
        for(int x: ans)
        System.out.println(x);
        sc.close();
    }
}