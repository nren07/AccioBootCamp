import java.util.*;

class Solution {

	private static void dfs(int row,int col,int [][]vis,int [][]grid,ArrayList<String>list,int row0,int col0){
        int n=grid.length;
        int m=grid[0].length;
        list.add(toString(row-row0,col-col0));
        vis[row][col]=1;
        int []delRow={-1,0,1,0};
        int []delCol={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow,ncol,vis,grid,list,row0,col0);
            }
        }
    }
	private static  String toString(int r,int c)
    {
		// System.out.println(Integer.toString(r)+" "+Integer.toString(c));
        return Integer.toString(r)+" "+Integer.toString(c);
    }
  public static int countDistinctIslands(int[][] grid) {
		  
		int n=grid.length;
        int m=grid[0].length;
        int [][]vis=new int[n][m];
        HashSet<ArrayList<String>>st=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    ArrayList<String>list=new ArrayList<>();
                    dfs(i,j,vis,grid,list,i,j);
                    st.add(list);
                }
            }
        }
        return st.size();
  }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        Solution ob = new Solution();
        int ans = ob.countDistinctIslands(grid);
        System.out.println(ans);
    }
}