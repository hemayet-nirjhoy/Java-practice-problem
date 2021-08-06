package leetcode;

public class PalindromeInt {
	
	public static boolean isPalindrome(int x) {
		System.out.println("Palindrome checking!");
		if(x<0 || (x!=0 && x%10==0)){
            return false;
        }
        int re = 0;
        while(x>re){
           re = (re*10)+x%10;
            x=x/10;
        }
        System.out.println(re);
        System.out.println(x);
        if(x==re || (x==(re/10))){
            return true;
        }
		
		return false;
	}
	
	public static void  main(String[] argc) {
		int x = 121;
		System.out.println(isPalindrome(x));
	}

}
