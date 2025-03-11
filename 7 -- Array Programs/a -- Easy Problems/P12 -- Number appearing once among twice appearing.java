class OnceAppearance {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 5, 5, 6, 6};

        int XOR = 0;
        for(int i : arr) {
            XOR ^= i;
        }

        System.out.println("Number appearing once: " + XOR);
    }
}