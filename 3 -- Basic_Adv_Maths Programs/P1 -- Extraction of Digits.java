class DigitExtraction {
    public static void main(String[] args) {
        int N = 35597;
        
        while(N != 0) {
            int lastDigit = N % 10;
            System.out.print(lastDigit + ", "); 
            N = N / 10;
        }
    }
}