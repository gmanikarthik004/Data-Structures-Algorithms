class Recursion_1 {
    public static void main(String[] args) {
        int cnt = 0;
        fn(cnt);
    }

    static void fn(int cnt) {
        // Base Condition
        if(cnt == 2) return;
        
        System.out.print(cnt + " ");
        cnt++;

        fn(cnt);
    }
}