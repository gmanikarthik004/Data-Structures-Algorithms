/*
class Pattern_13 {
    public static void main(String[] args) {
        int n = 5;

        for(int i = 0; i < n; i++) {
            for(char j = 'A'; j <= 'A' + i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
*/

/*
class Pattern_14 {
    public static void main(String[] args) {
        int n = 5;

        for(int i = n; i > 0; i--) {
            for(char j = 'A'; j < 'A' + i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
*/

class Pattern_15 {
    public static void main(String[] args) {
        int n = 5;

        for(int i = 0; i < n; i++) {
            char ch = (char)('A' + i);
            for(int j = 0; j <= i; j++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}