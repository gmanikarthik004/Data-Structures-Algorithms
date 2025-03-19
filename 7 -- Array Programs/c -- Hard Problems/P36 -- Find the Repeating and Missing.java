class MissingAndRepeating {
    // BETTER SOLUTION
    /*
    public static int[] missingAndRepeating(int[] arr) {
        int n = arr.length;
        int repeatingNumber = -1, missingNumber = -1;
        
        // Create hashArray
        int[] hashArray = new int[n + 1];
        
        // Fill hashArray with frequencies
        for(int i = 0; i < n; i++) {
            hashArray[arr[i]]++;
        }
        
        // Find Repeating & Missing
        for(int i = 1; i < hashArray.length; i++) {
            if(hashArray[i] == 2) { // Repeating
                repeatingNumber = i;
            }
            if(hashArray[i] == 0) { // Missing
                missingNumber = i;
            }
            
            // If updated
            if(repeatingNumber != -1 && missingNumber != -1) break;
        }
        
        return new int[]{repeatingNumber, missingNumber};
    }
    */
    
    // OPTIMAL SOLUTION -- T.C: O(N) and S.C: O(1)
    public static int[] missingAndRepeating(int[] arr) {
        long n = arr.length;
        
        // X -> RepeatingNo. and Y -> MissingNo.
        
        // Find Sn and S2n
        long Sn = (n * (n + 1)) / 2;
        long S2n = (n * (n + 1) * (2 * n + 1)) / 6;
        
        // Calculate S & S2 
        long S = 0, S2 = 0;
        for(int i : arr) {
            S += i;
            S2 += (long)i * (long)i;
        }
        
        // Calculate X-Y
        long val1 = S - Sn;
        
        // Calculate X+Y => X^2 - Y^2
        long val2 = S2 - S2n;
        val2 = val2 / val1;
        
        // Calculate the X-Y and X+Y and get the X and Y
        long x = (val1 + val2) / 2;
        long y = (val2 - x);
        
        return new int[]{(int)x, (int)y};
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 1, 6};
        
        int[] result = missingAndRepeating(arr);
        System.out.println("Repeating Number: " + result[0] + ", " + "Missing Number: " + result[1]);
    }
}