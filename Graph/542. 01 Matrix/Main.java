class Solution {
    public int []dr=new int[]{-1,0,1,0};
    public int[]dc=new int[]{0,1,0,-1};

    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        Queue<int[]>q=new LinkedList<>();
        boolean [][]visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                    visited[i][j]=true;
                }
                
            }
        }
        int level=0;
        while(q.size()>0){
            int size=q.size();
            for(int j=0;j<size;j++){
                int[] temp=q.remove();
                int sr=temp[0];
                int sc=temp[1];
                mat[sr][sc]=level;
                for(int i=0;i<4;i++){
                    int nr=sr+dr[i];
                    int nc=sc+dc[i];
                    if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
                    if(!visited[nr][nc]){
                        q.add(new int[]{nr,nc});
                        visited[nr][nc]=true;
                    }
                }
            }
            level++;
        }
        return mat;
    }
}