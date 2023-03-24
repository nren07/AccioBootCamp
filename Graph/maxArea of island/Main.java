class Solution {
    
    private  int[]dr={-1,0,1,0};
    private  int []dc={0,1,0,-1};

    private  int dfs(int [][]grid,int r, int c,boolean[][]visited){
        
        int rows=grid.length;
        int cols=grid[0].length;
        visited[r][c]=true;
        int cnt=1;
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr<0 || nr>=rows || nc<0 || nc>=cols) continue;
            if(!visited[nr][nc] && grid[nr][nc]==1) cnt+=dfs(grid,nr,nc,visited);
        }
        return cnt;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;

        boolean[][]visited=new boolean[rows][cols];
        int maxArea=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    int res=dfs(grid,i,j,visited);
                    maxArea=Math.max(res,maxArea);
                }
            }
        }
        return maxArea;
    }
}