package Hard;

import java.util.Arrays;

public class MaximumSumRectangularSubMatrix {
    public static void main(String[] args) {
        int[] arr = {3,-1,4,-7,-1,9,7,7,-11,2,10};
        int[][] mat = {
                {2,1,-3,-4,5},
                {0,6,3,4,1},
                {2,-2,-1,4,-5},
                {-3,3,1,0,3}
        };
        int[] sum = maximumSumRectangularSubMatrix(mat);
        System.out.println(sum[0] +" "+sum[1]+" "+sum[2]+" "+sum[3]+" "+sum[4]);

    }
    public static int[] maximumSumRectangularSubMatrix(int[][] matrix){
        int height = matrix.length;
        int width = matrix[0].length;

        int[] mat = new int[height];

        int max = Integer.MIN_VALUE;
        int left = -1, right = -1, up = -1, down = -1;
        for(int i=0; i<width; i++){
            Arrays.fill(mat, 0);
            for(int j=i; j<width; j++){
                for(int k=0; k<height; k++) mat[k] += matrix[k][j];
                int[] sum = maxSubArraySum(mat);
                if(max < sum[0]){
                    max = sum[0];
                    left = i; right = j;
                    up = sum[1]; down = sum[2];
                }
            }
        }
        return new int[]{max, left, right, up, down};
    }

    public static int[] maxSubArraySum(int[] arr){
        int max = arr[0], curr = arr[0];
        int left = 0, right = 0;
        int l = 0;
        for(int i=1; i<arr.length; i++){
            if(curr + arr[i] < arr[i] ){
                curr = arr[i];
                l = i;
            }
            else{
                curr = curr + arr[i];
            }
            if(max < curr){
                max = curr;
                left = l;
                right = i;
            }
        }
        return new int[]{max, left, right};
    }

}
