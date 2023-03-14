import java.util.*;

class Solution {
	public long rangeSum(long []arr, int l, int r){
        if (r<0) return 0;
        if(l==0) return arr[r];
        return arr[r]-arr[l-1];
    }
    public long solve(int grid[][]) {
          int n=grid[0].length;
        long row0[]=new long[n];
        long row1[]=new long [n];

       long ans=Long.MAX_VALUE;

        row0[0]=grid[0][0];
        for(int i=1;i<n;i++) row0[i]=grid[0][i]+row0[i-1];

        row1[0]=grid[1][0];
        for(int i=1;i<n;i++) row1[i]=grid[1][i]+row1[i-1];

        for(int i=0;i<n;i++){
            long option1Robot2=rangeSum(row0,i+1,n-1);
            long option2Robot2=rangeSum(row1,0,i-1);

            long robot2Choice=Math.max(option1Robot2,option2Robot2);

            ans=Math.min(ans, robot2Choice);
        }
        return ans;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int grid[][]=new int[2][n];
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<n;j++)
                grid[i][j]=sc.nextInt();

        }
        
        Solution obj=new Solution();
        System.out.println(obj.solve(grid));
        sc.close();
    }
}