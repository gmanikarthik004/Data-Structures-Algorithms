class ReverseNumber {  // Renamed to follow Java naming conventions
    static int reverse(int x) {
        int numRev = 0;

        while (x != 0) {
            int lastD = x % 10;

            // Positive Overflow Condition
            if (numRev > Integer.MAX_VALUE / 10 || (numRev == Integer.MAX_VALUE / 10 && lastD > 7)) {
                return 0;
            }
            // Negative Overflow Condition
            if (numRev < Integer.MIN_VALUE / 10 || (numRev == Integer.MIN_VALUE / 10 && lastD < -8)) {
                return 0;
            }

            numRev = (numRev * 10) + lastD;
            x = x / 10;
        }

        return numRev;
    }

    public static void main(String[] args) {
        int num = 939392;
        System.out.println("Reversed Number: " + reverse(num)); // Print the result
    }
}
