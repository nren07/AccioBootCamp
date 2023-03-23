import java.util.*;

public class Main{

	private static int[]dr={-1,0,1,0};
    private static int []dc={0,1,0,-1};

    private static void dfs(int [][]image,int r, int c, int color,boolean[][]visited){
        int myColour=image[r][c];
        int rows=image.length;
        int cols=image[0].length;
        image[r][c]=color;
        visited[r][c]=true;

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr<0 || nr>=rows || nc<0 || nc>=cols) continue;
            if(!visited[nr][nc] && image[nr][nc]==myColour) dfs(image,nr,nc,color,visited);
        }
    }
	
    public static void FloodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return;
        int rows=image.length;
        int cols=image[0].length;

        boolean[][]visited=new boolean[rows][cols];
        dfs(image,sr,sc,color,visited);
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] w = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; ++j)
                w[i][j] = sc.nextInt();
        }
        int x = sc.nextInt(), y = sc.nextInt(), c = sc.nextInt();
	    FloodFill(w, x, y, c);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)
                System.out.print(w[i][j] + " ");
            System.out.println();
        }
    }
}