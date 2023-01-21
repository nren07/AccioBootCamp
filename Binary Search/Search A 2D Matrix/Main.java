import java.util.*;

public class Main {
    public static boolean SearchA2DMatrix(int[][] mat, int target) {

        int row = mat.length;
        int col = mat[0].length;
        int n = row * col - 1;
        int start = 0, end = n;

        while (start <= end) {
            int mid = (start + end) / 2;
            // nrow=mid/col; && ncol=mid%col;
            int newRow = mid / col;
            int newCol = mid % col;

            if (mat[newRow][newCol] == target)
                return true;
            else if (mat[newRow][newCol] < target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();
        }
        int x = sc.nextInt();
        if (SearchA2DMatrix(mat, x))
            System.out.println("true");
        else
            System.out.println("false");
    }
}