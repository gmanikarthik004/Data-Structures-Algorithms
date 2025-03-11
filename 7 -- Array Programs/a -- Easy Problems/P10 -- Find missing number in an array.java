class MissingNumber {
    // Optimal-Sol 1 Using Sum
    /*
    static int isMissing(int[] arr, int N){
        int actualSum = (N * (N+1))/2;
        int currSum = 0;
        for(int i : arr) {
            currSum += i;
        }
        return actualSum - currSum;
    }
    */
    
    // Optimal-Sol 2 Using XOR
    static int isMissing(int[] arr, int N) {
        int XOR_1 = 0, XOR_2 = 0;
        for(int i = 0; i < N-1; i++) {
            XOR_2 ^= arr[i];
            XOR_1 ^= (i+1);
        }
        XOR_1 ^= N;
        
        return XOR_1 ^ XOR_2;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        int N = 5;
        
        int res = isMissing(arr, N);
        System.out.println("Missing Number: " + res);
    }
}