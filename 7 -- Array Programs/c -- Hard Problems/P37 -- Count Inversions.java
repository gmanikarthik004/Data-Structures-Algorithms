import java.util.ArrayList;

class CountInversions {
    public static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> tempList = new ArrayList<>();
        int cnt = 0;
        int left = low;
        int right = mid + 1;
        
        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                tempList.add(arr[left]);
                left++;
            }
            else {
                tempList.add(arr[right]);
                cnt += mid - left + 1;
                right++;
            }
        }
        
        while(left <= mid) {
            tempList.add(arr[left]);
            left++;
        }
        
        while(right <= high) {
            tempList.add(arr[right]);
            right++;
        }
        
        return cnt;
    }
    
    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if(low >= high) return cnt;
        
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid); // left half
        cnt += mergeSort(arr, mid + 1, high); // right half
        cnt += merge(arr, low, mid, high); // merge sorted halves
        
        return cnt;
    }
    
    public static int cntInversions(int[] arr) {
        int cnt = mergeSort(arr, 0, arr.length - 1);
        return cnt;
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        
        System.out.println("No.of Inversions: " + cntInversions(arr));
    }
}