// n1 = 9 && n2 = 12

class GCDorHCF {
    // T.C: O(min(num1, num2))
    /*
    static int gcd(int num1, int num2) {
        int res = 1;
        for(int i = 1; i <= Math.min(num1, num2); i++) {
            if(num1 % i == 0 && num2 % i == 0) {
                res = i;
            }
        }
        return res;
    }
    */

    // T.C: O(log min(num1, num2))
    static int gcd(int num1, int num2) {
        while(num1 > 0 && num2 > 0) {
            if(num1 > num2) num1 = num1 % num2;
            else num2 = num2 % num1;
        }
        // GCD/HCF
        if(num1 == 0) return num2;
        else return num1;

        // LCM
        //lcm = num1/gcd * num2
    }

    public static void main(String[] args) {
        int n1 = 52, n2 = 10;
        System.out.println("GCD of 2 Numbers: "+gcd(n1, n2));
    }
}