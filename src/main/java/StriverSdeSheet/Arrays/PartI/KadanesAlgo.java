package StriverSdeSheet.Arrays.PartI;

public class KadanesAlgo {

    public static int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;

        int maxSum = Integer.MIN_VALUE, curr = 0;
        for(int num : nums){
            curr += num;
            maxSum = curr > maxSum ? curr : maxSum;
            curr = curr < 0 ? 0 : curr;
        }

        return maxSum;
    }
}
