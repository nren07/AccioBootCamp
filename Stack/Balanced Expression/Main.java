import java.io.*;
import java.util.*;

class Solution{
	public char open(char ch){
		if(ch==')') return '(';
		else if(ch=='}') return '{';
		else if(ch==']') return '[';
		else return '0';
	}
    boolean expBalanced(String s){
	    Stack<Character>st=new Stack<>();
		int n=s.length();
		for(int i=0;i<n;i++){
			char ch=s.charAt(i);
	        if(ch=='(' || ch=='{' || ch=='['){
				st.push(ch);
			}else{
				if(st.size()>0 && st.peek()==open(ch)){
					st.pop();
				}
			}
		}
		if(st.size()>0){
			return false;
		}else{
			return true;
		}
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Solution Obj = new Solution();
        System.out.println(Obj.expBalanced(str));
    }
}