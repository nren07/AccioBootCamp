import java.util.*;

class Solution {
	// 
	// check start and end of string equal or not
	// if equal then keep moving end from start and from end
	// by comparing start element 
	// whenever we got different try recursion 
	static String solve1(String s){
		if(s.length()==0) return "";
		int sp1=0;
		int sp2=0;
		if(s.charAt(0)==s.charAt(s.length()-1)){
			while(s.charAt(sp1)!=s.charAt(0) && sp1<=sp2){
				sp1++;
			}
			while(s.charAt(sp2)!=s.charAt(0) && sp1<=sp2){
				sp2--;
			}
		}
		return solve1(s.substring(sp1,sp2+1));
	}
	static int solve(String s) {
		
		int n=s.length();
		int sp=0;
		int ep=n-1;
		while(sp<ep && s.charAt(sp)==s.charAt(ep)){
			char c=s.charAt(ep);
			while(sp<=ep && s.charAt(sp)==c){
				sp++;
			}
			while(sp<=ep && s.charAt(ep)==c){
				ep--;
			}
		}
		if(sp>=ep) return 0;
		return ep-sp+1;
	}
}
public class Main{
	public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String s = sc.next();
      System.out.println(Solution.solve(s));
   }
}