class Pattern_18 {
    public static void main(String[] args) {
        int n = 5;
        int start=2;

        for(int i=0; i<n; i++) {
            // stars
            for(int j=0; j<n-i; j++) {
                System.out.print("*");
            }
            // spaces
            for(int j=0; j<2*i; j++) {
                System.out.print(" ");
            }
            // stars
            for(int j=0; j<n-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=0; i<n; i++) {
            // stars
            for(int j=0; j<=i; j++) {
                System.out.print("*");
            }
            // spaces
            for(int j=0; j<2*n-start; j++) {
                System.out.print(" ");
            }
            start += 2;
            // stars
            for(int j=0; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}