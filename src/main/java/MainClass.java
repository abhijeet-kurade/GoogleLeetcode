public class MainClass {
    public static void main(String[] args) {
        System.out.println("Hello from Mars.");
        int[] arr = {1,2,2,2,5,5,5,8};
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr){
        int  move = 0;
        for(int i=0;  i<arr.length; i++){
            if( i!=0 && arr[i] == arr[i-1] ) continue;
            int lastIdx = bSearch(arr, arr[i]);
            int occurrence = lastIdx - i + 1;
            move += Math.min(occurrence, Math.abs(occurrence - arr[i]));
        }
        return move;
    }

    public static int bSearch(int[] arr, int num){
        int left = 0;
        int right = arr.length - 1;
        int idx = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] == num ){
                idx = mid;
                left = mid+1;
            }
            else if(arr[mid] < num){
                left = mid + 1;
            }
            else right = mid -1;
        }
        return idx;
    }
}
