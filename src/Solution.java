import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Solution {
    /*public int[] twoSum(int[] nums, int target) {
        int[] origin = nums.clone();
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        int found = 0;
        while(target != nums[start]+ nums[end]){
            found = quickFind(start+1, end, target-nums[start], nums);
            if(found != -1) break;
            start++;
        }


        int[] ret = new int[2];
        if(target == nums[start]+nums[found]){
            for(int i = 0; i < nums.length; i++){
                if(nums[start] == origin[i]) ret[0] = i;

            }
            for(int i = nums.length-1; i >= 0; i--){
                if(nums[found] == origin[i]) ret[1] = i;
            }
        }
        return ret;

    }*/

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

    public static void main(String[] args){
        int test[] = {230,863,916,585,981,404,316,785,88,12,70,435,384,778,887,755,740,337,86,92,325,422,815,650,920,125,277,336,221,847,168,23,677,61,400,136,874,363,394,199,863,997,794,587,124,321,212,957,764,173,314,422,927,783,930,282,306,506,44,926,691,568,68,730,933,737,531,180,414,751,28,546,60,371,493,370,527,387,43,541,13,457,328,227,652,365,430,803,59,858,538,427,583,368,375,173,809,896,370,789};

        Solution slo = new Solution();
        int[] ret = slo.twoSum(test, 524);

        System.out.println(ret[0]);
    }
}

