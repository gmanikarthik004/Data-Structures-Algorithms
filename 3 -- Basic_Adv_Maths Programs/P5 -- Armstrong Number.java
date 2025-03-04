class Armstrong {
    static boolean isArmstrong(int num) {
        int originalNum = num;
        int sum = 0, no_of_digits = 0;

        // Count the number of digits
        int temp = num;
        while (temp > 0) {
            temp /= 10;
            no_of_digits++;
        }

        // Calculate the sum of each digit raised to the power of 'digits'
        temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, no_of_digits);
            temp /= 10;
        }

        return sum == originalNum;
    }
    
    public static void main(String[] args) {
        int n = 9474;
        
        if(isArmstrong(n)) {
            System.out.println("Yep! Armstrong Number");
        }
        else {
            System.out.println("Nope! Not an Armstrong Number");
        }
    }
}