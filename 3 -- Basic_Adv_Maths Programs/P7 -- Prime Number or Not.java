class PrimeOrNot {
    static boolean isPrime(int num) {
        int cnt = 0;
        
        for(int i = 1; i * i <= num; i++) {
            if(num%i == 0) {
                cnt++;
                if((num/i) != i) {
                    cnt++;
                }
            }
        }
        
        return (cnt==2) ? true : false;
    }
    public static void main(String[] args) {
        int num = 11;
        
        if(isPrime(num)) {
            System.out.println("Yes, it's a prime number!");
        } else {
            System.out.println("No, not an prime number!");
        }
    }
}