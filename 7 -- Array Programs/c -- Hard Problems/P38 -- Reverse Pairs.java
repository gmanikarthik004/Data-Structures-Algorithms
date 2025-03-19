import java.util.ArrayList;

class ReversePairs {
    public static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        
        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        
        // Leftover elements if any
        while(left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        
        while(right <= high) {
            temp.add(arr[right]);
            right++;
        }
        
        // Copy sorted values back into arr[]
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
    
    public static int countPairs(int[] arr, int low, int mid, int high) {
        int cnt = 0, right = mid + 1;
        for(int i = low; i <= mid; i++) {
            while(right <= high && arr[i] > 2 * arr[right]) right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }
    
    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        
        if(low >= high) return cnt;
        
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid); // mergeSort left half
        cnt += mergeSort(arr, mid + 1, high); // mergeSort right half
        cnt += countPairs(arr, low, mid, high); // cntPairs using sorted left & right halves
        merge(arr, low, mid, high); // merge 2 sorted halves
        
        return cnt;
    }
    
    public static void main(String[] args) {
        int[] arr = {40, 25, 19, 12, 9, 6, 2};
        int n = arr.length;
        
        System.out.println("No.of Reverse Pairs: " + mergeSort(arr, 0, n - 1));
    }
}