class isPalindromeNumber {
    public boolean isPalindrome(int x) {
        int originalNumber = x;
        int reversedNumber = 0;

        while(x > 0) {
            int lastDigit = x % 10;
            reversedNumber = (reversedNumber * 10) + lastDigit;
            x = x / 10;
        }

        return (reversedNumber == originalNumber) ? true : false;
    }
}