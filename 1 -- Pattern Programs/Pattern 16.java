class Pattern_16 {
    public static void main(String[] args) {
        int n = 4;

        for (int i = 0; i < n; i++) {
            // Leading spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            // Alphabet pyramid
            char ch = 'A';
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print(ch);
                if (j < i) ch++; // Increment until midpoint
                else ch--;       // Decrement after midpoint
            }

            // Trailing spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}
