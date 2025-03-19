class MaxSAProduct {
    public static int maxProduct(int[] arr, int n) {
        int maxPrdt = Integer.MIN_VALUE;
        
        int prefixPrdt = 1, suffixPrdt = 1;
        for(int i = 0; i < n; i++) {
            if(prefixPrdt == 0) prefixPrdt = 1;
            if(suffixPrdt == 0) suffixPrdt = 1;
            prefixPrdt *= arr[i];
            suffixPrdt *= arr[n-i-1];
            
            maxPrdt = Math.max(maxPrdt, Math.max(prefixPrdt, suffixPrdt));
        }
        
        return maxPrdt;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 0, -4, -5};
        int n = arr.length;
        
        System.out.println("Maximum Product SubArray: " + maxProduct(arr, n));
    }
}