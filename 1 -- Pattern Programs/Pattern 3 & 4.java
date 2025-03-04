class Pattern_3 {
    public static void main(String[] args) {
        for(int i = 5; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }  
}

class Pattern_4 {
    public static void main(String[] args) {
        for(int i = 5; i > 0; i--) {
            for(int j = 1; j <= i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }  
}