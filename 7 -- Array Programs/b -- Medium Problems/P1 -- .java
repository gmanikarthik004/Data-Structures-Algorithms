class RemoveDuplicates {
    static int uniqueElements(int[] nums, int n) {
        if (n == 0) return 0; // Edge case: empty array
        
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (nums[j] != nums[i]) { 
                i++;
                nums[i] = nums[j]; // Assign before incrementing i
                
            }
        }
        return i + 1; // Unique count
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 3, 3, 3};
        int k = uniqueElements(nums, nums.length);

        System.out.println("No. of unique elements: " + k);
        System.out.println("Unique Elements are:");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
