import java.util.Scanner;

class Hashing_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter string of only lowercase characters: ");
        String str = sc.nextLine();
        
        // HashArray/Freq Array -- Pre-Computing
        int[] hashArr = new int[26];
        for(int i=0; i<str.length(); i++) {
            hashArr[str.charAt(i) - 'a']++;
        }
        
        // Fetch userQueries
        System.out.print("Enter how many queries you have: ");
        int q = sc.nextInt();
        
        while(q-- != 0) {
            System.out.print("Enter query in lowercase character: ");
            char ch = sc.next().charAt(0);
            System.out.println("Fetching...");
            System.out.println(hashArr[ch-'a']);
        }

        sc.close();
    }
}