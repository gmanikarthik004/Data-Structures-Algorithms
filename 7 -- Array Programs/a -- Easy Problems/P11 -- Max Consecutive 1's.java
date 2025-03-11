class ConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 1, 1, 0, 1, 1};
        
        int maxi = 0, curMaxi = 0;
        
        for(int i : arr) {
            if(i == 1) {
                curMaxi++;
                maxi = Math.max(maxi, curMaxi);
            }
            else {
                curMaxi = 0;
            }
        }
        
        System.out.println("Consecutive no.of 1's: " + maxi);
    }
}