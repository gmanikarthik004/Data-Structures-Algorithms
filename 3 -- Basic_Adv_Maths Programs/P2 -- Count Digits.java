// GFG Question

/*
    Given a positive integer n, count the number of digits in n that divide n evenly (i.e., without leaving a remainder). 
    Return the total number of such digits.

    Condition: A digit d of n divides n evenly if the remainder when n is divided by d is 0 (n % d == 0).
    Digits of n should be checked individually. If a digit is 0, it should be ignored because division by 0 is undefined.
*/

// Solution
class Solution {
    static int evenlyDivides(int n) {
        int d, count = 0;
        int originalNum = n;
        
        while(n > 0) {
            d = n % 10;
            if(d > 0) {
                if(originalNum % d == 0) count++;
            }
            n = n / 10;
        }
        
        return count;
    }
}