package Hard;

import java.util.Arrays;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        System.out.println("This question is damn hard.");
        int[] arr = {7,2,5,10,8,17,9,15,11};
        //System.out.println(splitArray(arr, 2));
        SplitSum splitSum = new SplitSum();
        System.out.print("Arr - ");splitSum.printArr(arr);
        System.out.println(splitSum.splitArray(arr, 4));
    }

    public static int getMinLargestSum(int[][] memo, int[] prefixSum, int curr, int count){
        int n = prefixSum.length - 1;

        if(memo[curr][count] != -1)  return memo[curr][count];
        if(count == 1) return memo[curr][count] = prefixSum[n] - prefixSum[curr];

        int minSum = Integer.MAX_VALUE;

        for(int i=curr; i<n; i++){
            int sum1 = prefixSum[i+1] - prefixSum[curr];
            int sum2 = getMinLargestSum(memo, prefixSum, i+1, count-1);
            int largest = Math.max(sum1, sum2);
            minSum = Math.min(minSum, largest);
            if(sum1 >= minSum) break;
        }
        return memo[curr][count] = minSum;
    }

    public static int splitArray(int[] arr, int m){
        int n = arr.length;
        int[][] memo = new int[n+1][m+1];
        int[] prefixSum = new int[n+1];

        for(int[] ar : memo) Arrays.fill(ar, -1);

        for(int i=1; i<=n; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i-1];
        }

        return getMinLargestSum(memo, arr, 0, m);
    }
}

class SplitSum {


    private int getMinimumLargestSplitSum(Integer[][] memo, int[] prefixSum, int currIndex, int subArrayCount, int d) {
        int n = prefixSum.length - 1;

        // We have already calculated the answer so no need to go into recursion
        if (memo[currIndex][subArrayCount] != null) {
            return memo[currIndex][subArrayCount];
        }

        // Base Case: If there is only one subArray left, then all of the remaining numbers
        // must go in the current subarray. So return the sum of the remaining numbers.
        if (subArrayCount == 1) {
            return memo[currIndex][subArrayCount] = prefixSum[n] - prefixSum[currIndex];
        }

        // Otherwise, use the recurrence relation to determine the minimum largest subarray
        // sum between currIndex and the end of the array with subArrayCount subarrays remaining.
        int minimumLargestSplitSum = Integer.MAX_VALUE;
        for (int i = currIndex; i <= n - subArrayCount; i++) {
            // Store the sum of the first subarray.
            int firstSplitSum = prefixSum[i + 1] - prefixSum[currIndex];

            printSpace(d);
            System.out.print(i +" "+prefixSum[i + 1] +" "+ prefixSum[currIndex] +" "+subArrayCount );
            System.out.println();


            // Find the maximum subarray sum for the current first split.
            int sum = getMinimumLargestSplitSum(memo, prefixSum, i + 1, subArrayCount - 1, d+2);
            int largestSplitSum = Math.max(firstSplitSum,
                    sum);

            // Find the minimum among all possible combinations.
            minimumLargestSplitSum = Math.min(minimumLargestSplitSum, largestSplitSum);


            printSpace(d);
            System.out.print(i+" "+firstSplitSum+" "+sum);
            System.out.println();


            if (firstSplitSum >= minimumLargestSplitSum) {
                break;
            }
        }


        return memo[currIndex][subArrayCount] = minimumLargestSplitSum;
    }

    public void printSpace(int n){
        for(int i=0; i<n; i++) System.out.print(" ");
    }

    public void printArr(int[] arr){
        for(int num : arr) System.out.print(num +" ");
        System.out.println();
    }

    public void printArr(Integer[] arr){
        for(Integer num : arr) System.out.print(num +" ");
        System.out.println();
    }

    public int splitArray(int[] nums, int m) {

        // Store the prefix sum of nums array.
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        Integer[][] memo = new Integer[n+1][m+1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }


        System.out.print("Prefix - ");printArr(prefixSum);
        //printArr(prefixSum);

        int num = getMinimumLargestSplitSum(memo, prefixSum, 0, m, 0);
        System.out.println();
        for (Integer[] ar : memo) printArr(ar);
        System.out.println();
        return num;
    }
}
