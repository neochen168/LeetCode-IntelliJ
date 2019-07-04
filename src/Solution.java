import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Solution {
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> dic = new HashMap();

        for(int i = 0; i < nums.length; i++){
            if(dic.containsKey(nums[i]))
                dic.put(nums[i], dic.get(nums[i])+1);
            else
                dic.put(nums[i], 1);
        }

        Iterator<Integer> itr = dic.keySet().iterator();
        Integer key = 0;
        Integer value = 0;
        while(itr.hasNext()){
            key = itr.next();
            value = dic.get(key);
            dic.put(key, value-1);
            if(dic.containsKey(target-key) && dic.get(target-key) >= 1) break;
            dic.put(key, value);
        }

        int[] ret = new int[2];

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == key) {
                ret[0] = i;
                break;
            }
        }

        for(int i = nums.length-1; i>=0; i--){
            if(nums[i] == target-key) {
                ret[1] = i;
                break;
            }
        }
        return ret;

    }

    public static int quickFind(int s, int e, int t, int[] nums){
        if(s > e) return -1;
        int m = (e - s)/2 + s;
        if(t == nums[m]) return m;
        else if(t > nums[m]) return quickFind(m+1, e, t, nums);
        else return quickFind(s, m, t, nums);
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> dic = new HashMap();

        for(int i = 0; i < nums.length; i++){
            int counter = target-nums[i];
            if(dic.containsKey(counter)){
                return new int[]{dic.get(counter), i};
            }
            dic.put(nums[i], i);
        }

        return null;
    }
}

