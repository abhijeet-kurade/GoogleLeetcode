package Hard;

public class LongestPathInMatrix {
    public static void main(String[] args) {
        //[[9,9,4],[6,6,8],[2,1,1]]
        int[][] arr = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        System.out.println(longestIncreasingPath(arr));

    }

    public static void  printArr(int[] arr){
        for(int num : arr) System.out.print(num +" ");
        System.out.println();
    }

    public static int longestIncreasingPath(int[][] arr){
        int height = arr.length;
        int width = arr[0].length;

        int[][] cache = new int[height][width];
        int maxPath = 1;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(cache[i][j] != 0) continue;
                int path = getLongestPath(i, j, arr, cache);
                maxPath = Math.max(maxPath, path);
            }
        }
        for(int[] ar : cache) printArr(ar);
        return maxPath-1;
    }


    public static boolean isSafe(int[][] arr, int row, int col, int val){
        int height = arr.length;
        int width = arr[0].length;

        return 0<=row && row<height && 0<=col && col<width && arr[row][col]>val;
    }

    public static int getLongestPath(int row, int col, int[][] arr, int[][] cache){
        int[] dx = {1, -1, 0,0};
        int[] dy = {0,0,1,-1};
        int maxPath = 1;
        for(int i=0; i<4; i++){
            int x = row + dx[i];
            int y = col + dy[i];
            //System.out.println(x +" "+y  );
            if(!isSafe(arr, x, y, arr[row][col])) continue;
            //System.out.println("  - "+arr[x][y]);
            if(cache[x][y] != 0){
                maxPath = Math.max(maxPath, cache[x][y]+1);
            }
            else{
                int path = getLongestPath(x, y, arr, cache);
                maxPath = Math.max(maxPath, path+1);
            }
        }
        cache[row][col] = maxPath;
        return maxPath;
    }

}
