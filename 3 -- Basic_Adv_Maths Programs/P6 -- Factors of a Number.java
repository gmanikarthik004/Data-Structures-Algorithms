// Time Complexity: O(N)
/*
class divisorsOfNum {
    public static void main(String[] args) {
        int num = 12;
        
        for(int i = 1; i <= num; i++) {
            if(num % i == 0) {
                System.out.print(i + " ");
            }
        }
    }
}
*/

// Time Complexity: O(sqrt N)
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class divisorsOfNum {
    public static void main(String[] args) {
        int num = 36;
        
        List<Integer> arr = new ArrayList<>();
        
        for(int i = 1; i*i <= num; i++) {
            if(num % i == 0) {
                arr.add(i);
                
                if(num / i != i) {
                    arr.add(num/i);
                }
            }
        }
        
        Collections.sort(arr);
        
        System.out.print("Divisors are: ");
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}