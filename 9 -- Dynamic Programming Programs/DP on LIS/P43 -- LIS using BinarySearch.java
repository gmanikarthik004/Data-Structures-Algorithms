import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> temp = new ArrayList<>();

        for(int num : nums) {
            int idx = Collections.binarySearch(temp, num);

            // If not found, returns -(insertionIdx) - 1
            if(idx < 0) {
                idx = -(idx + 1);
            }

            // Compare with temp
            if(idx == temp.size()) {
                temp.add(num);
            }
            else {
                temp.set(idx, num);
            }
        } 

        return temp.size();
    }
}
