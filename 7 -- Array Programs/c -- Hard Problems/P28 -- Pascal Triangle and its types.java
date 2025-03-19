import java.util.ArrayList;

class PascalsTriangle {
    // Type-1 Fn -- Using n-1Cr-1
    public static int type1(int n, int r) {
        int res = 1;
        for(int i = 0 ; i < r; i++) {
            res = res * (n-i);
            res = res / (i+1);
        }
        return res;
    }
    
    // Type-2 Fn -- Using row-col/col
    public static ArrayList<Integer> type2(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        
        int ans = 1;
        res.add(ans);
        for(int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            res.add(ans);
        }
        
        return res;
    }
    
    // Type-3 Fn
    public static ArrayList<ArrayList<Integer>> type3(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        for(int i = 1; i <= n; i++) {
            res.add(type2(i));
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // Type-1 Given Row & Col, give element at that position
        int row = 6, col = 2;
        System.out.println("Element at given row & col of pascalTriangle is: " + type1(row-1, col-1));
        
        // Type-2 Given n, return the entire row
        int n = 6;
        ArrayList<Integer> res = type2(n);
        System.out.println(n +"-th row of pascal triangle: " + res);
        
        // Type-3 Given n, print entire pascalTriangle
        // Print n=6 pascalTriangle
        ArrayList<ArrayList<Integer>> pascalTriangle = type3(n);
        System.out.print("Entire pascal triangle till " + n + "-th row: " + pascalTriangle);
    }
}