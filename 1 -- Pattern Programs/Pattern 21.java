class Pattern_21 {
    public static void main(String[] args) {
        int n = 4;

        for(int i = 0; i < 2*n-1; i++) {
            for(int j = 0; j < 2*n-1; j++) {
                int top, left, bottom, right;
                top = i;
                left = j;
                bottom = (2*n-1)-1-i;
                right = (2*n-1)-1-j;

                System.out.print(n-Math.min(Math.min(top, bottom), Math.min(left, right))+ " ");
            }
            System.out.println();
        }
    }
}
