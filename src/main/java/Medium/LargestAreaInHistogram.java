package Medium;

import java.util.Stack;

public class LargestAreaInHistogram {
    public static void main(String[] args) {
        int[] arr = {2,3,4,3,4,0,3,4,3,7,7};
        int[] area = largestAreaInHistogram(arr);
        System.out.println(area[0]+" "+area[1]+" "+area[2]);

    }
    private static void printArr(int[] arr){
        for(int num : arr) System.out.print(num + " ");
        System.out.println();
    }
    public static int[] largestAreaInHistogram(int[] arr){
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) stack.pop();
            if(stack.isEmpty()) left[i] = -1;
            else left[i] = stack.peek();
            stack.add(i);
        }
        stack.clear();

        for(int i=n-1; i>=0; i--){
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) stack.pop();
            if(stack.isEmpty()) right[i] = n;
            else right[i] = stack.peek();
            stack.add(i);
        }
        printArr(arr);
        printArr(left);
        printArr(right);
        int max=0, l=-1, r=-1;
        for(int i=0; i<n; i++){
            int curr = arr[i] * (right[i] - left[i] - 1);
            System.out.println(curr+" "+arr[i]+" "+right[i] + " "+ left[i]);
            if(max < curr){
                max = curr;
                l = left[i]+1;
                r = right[i]-1;
            }
        }
        return new int[]{max, l, r};
    }
}
