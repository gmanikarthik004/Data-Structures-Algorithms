import java.util.*;

class MajorityElement {
    // OPTIMAL SOLUTION
    public static ArrayList<Integer> findMajorityElement(int[] arr)
    {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        
        int cnt1 = 0, cnt2 = 0, ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        
        for(int i : arr) {
            if(cnt1 == 0 && i != ele2) {
                cnt1 = 1;
                ele1 = i;
            }
            else if(cnt2 == 0 && i != ele1) {
                cnt2 = 1;
                ele2 = i;
            }
            else if(i == ele1) cnt1++;
            else if(i == ele2) cnt2++;
            else {
                cnt1--; cnt2--;
            }
        }
        
        // Verify whether they are majorityElements or not
        cnt1 = 0; 
        cnt2 = 0;
        for(int i : arr) {
            if(i == ele1) cnt1++;
            if(i == ele2) cnt2++;
        }
        
        int min = (int)n/3 + 1;
        if(cnt1 >= min) ans.add(ele1);
        if(cnt2 >= min) ans.add(ele2);
        
        return ans;
    }

    // BETTER SOLUTION
    /*
    public static ArrayList<Integer> findMajorityElement(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int min = (int)(n/3) + 1;
        Map<Integer, Integer> mpp = new HashMap<>();
        
        for(int i : arr) {
            // if already exists, get its count
            int value = mpp.getOrDefault(i, 0);
            // add into map and then increment it's count
            mpp.put(i, value+1);
            // if cnt == min, add into list
            if(mpp.get(i) == min) {
                ans.add(i);
            }
            // if reached 2 elements, break over here
            if(ans.size() == 2) break;
        }
        return ans;
    }
    */
    
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 3, 3, 3};
        
        System.out.println("Given Array: " + Arrays.toString(arr));
        
        ArrayList<Integer> res = findMajorityElement(arr);
        System.out.println("Majority Element is: "+ res);
    }
}