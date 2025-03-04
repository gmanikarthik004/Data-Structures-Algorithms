class Pattern_17 {
    public static void main(String[] args) {
        int n = 5;

        for(int i = 0; i < n; i++) {
            for(char j = (char)('E'- i); j <= 'E'; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}