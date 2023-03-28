import java.util.*;

class Solution {
    public static int solve(List<List<Integer>> A) {
    // Write your code here
		Collections.sort(A,(a,b)->{
			return a.get(0)-b.get(0);
		});
		int csp=-1;
		int cep=-1;
		int cnt=0;
		for(int i=0;i<A.size();i++){
			int istart=A.get(i).get(0);
			int iend=A.get(i).get(1);
			// check wheather merge or not 
			if(cep>=istart){
				// check current end point is greater then ith end point 
				if(cep>iend){
					csp=istart; //updte current start and end point 
					cep=iend;
				}
			}else{
				csp=istart;
				cep=iend;
				cnt++;
			}
		}
		return cnt;
	}
}
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            List<Integer> interval = Arrays.asList(a, b);
            A.add(interval);
        }
        int ans = Solution.solve(A);
        System.out.println(ans);
    }
}
