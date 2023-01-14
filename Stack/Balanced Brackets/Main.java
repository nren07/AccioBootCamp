import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        Solution Obj = new Solution();
        Obj.balancedBrackets(s, n);
		sc.close();
    }
}
class Solution{
	public char open(char ch){
		if(ch==')') return '(';
		else if(ch=='}') return '{';
		else  return '[';
	}
    public void balancedBrackets(String s, int n) {
		Stack<Character>st=new Stack<>();
		for(int i=0;i<n;i++){
			char ch=s.charAt(i);
	        if(ch=='(' || ch=='{' || ch=='['){
				st.push(ch);
			}else{
				if(st.size()>0 && st.peek()==open(ch)){
					st.pop();
				}else{
					System.out.print("NO");
					return;
				}
			}
		}
		while(st.size()>0){
			System.out.print("NO");
			st.pop();
			return;
		}
		System.out.print("YES");
		return;
    }
}