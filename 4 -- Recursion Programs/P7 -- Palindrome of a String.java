import java.util.*;

class palindromeString {
    public static void main(String[] args) {
        String name = "AMMA";
        int N = name.length();
        
        if(isPalindrome(name, 0, N)) {
            System.out.println("Yes, an palindrome.");
        } else {
            System.out.println("Not an palindrome.");
        }
    }

    static boolean isPalindrome(String name, int i, int length) {
        if(i >= length/2) {
            return true;
        }
        
        if(name.charAt(i) != name.charAt(length-i-1)) {
            return false;
        }
        
        return isPalindrome(name, i+1, length);
    }
}
