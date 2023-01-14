import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public boolean ExtraBrackets(String exp) {
        Stack<Character>st=new Stack<>();
		for(int i=0;i<exp.length();i++){
			char ch=exp.charAt(i);
			if(ch!=')'){
				st.push(ch);
			}
			else{
				if(st.size()>0 && st.peek()=='(') return true;
				else{
					while(st.peek()!='('){
						st.pop();
					}
					st.pop();
				}
			}
		}
		return false;
       
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
	    Solution Obj = new Solution();
        if(Obj.ExtraBrackets(exp))
            System.out.println("false");
        else
            System.out.println("true");
    }
}