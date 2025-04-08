import java.util.List;
import java.util.ArrayList;

class PalindromePartitioning {
    public static void validPalindromicPartitions(int idx, String str, List<String> ls, List<List<String>> result) {
        // Base-Case
        if(idx == str.length()) {
            result.add(new ArrayList<>(ls));
            return;
        }
        for(int i = idx; i < str.length(); i++) {
            if(isPalindrome(idx, i, str)) {
                ls.add(str.substring(idx, i + 1));
                
                validPalindromicPartitions(i + 1, str, ls, result);
                
                ls.remove(ls.size() - 1);
            }
        }
    }
    public static boolean isPalindrome(int start, int end, String str) {
        while(start <= end) {
            if(str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        String str = "aabb";
        
        List<List<String>> result = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        validPalindromicPartitions(0, str, ls, result);
        
        System.out.println("Possible Palindromic Partitions: ");
        System.out.print("[ ");
        for(List<String> list : result) {
            System.out.print("[");
            for(String j : list) {
                System.out.print(j + " ");
            }
            System.out.print("]");
        }
        System.out.print(" ]");
    }
}