/*
class Pattern_5 {
    public static void main(String[] args) {
        // Pattern for each row: Space Star Space
        for(int i = 0; i < 5; i++) {
            for(int j=0; j<5-i-1; j++) {
                System.out.print(" ");
            }
            
            for(int j=0; j<2*i+1; j++) {
                System.out.print("*");
            }
            
            for(int j=0; j<5-i-1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
*/


class Pattern_6 {
    public static void main(String[] args) {
        // Pattern for each row: Space Star Space
        for(int i = 4; i >= 0; i--) {
            for(int j=0; j<5-i-1; j++) {
                System.out.print(" ");
            }
            
            for(int j=0; j<2*i+1; j++) {
                System.out.print("*");
            }
            
            for(int j=0; j<5-i-1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

// Pattern 6 in another way
class Pattern__6 {
    public static void main(String[] args) {
        int n = 5;
        // Pattern for each row: Space Star Space
        for(int i = 0; i < n; i++) {
            for(int j=0; j<i; j++) {
                System.out.print(" ");
            }
            
            for(int j=0; j<2*n-(2*i+1); j++) {
                System.out.print("*");
            }
            
            for(int j=0; j<i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
