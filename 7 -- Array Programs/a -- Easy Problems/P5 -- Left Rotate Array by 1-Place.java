class LeftRotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;
        
        int temp = arr[0];
        for(int i=1; i<=n-1; i++) {
            arr[i-1] = arr[i];
        }
        arr[n-1] = temp;
        
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}