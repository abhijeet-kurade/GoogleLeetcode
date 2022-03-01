package Hard;

public class OptimalStrategy {
    public static void main(String[] args) {
        int[] arr= {3,9,1,2};
        int[] arr1= {8,15,3,7};
        int[] arr2= {5,3,7,10};
        int[] arr3= {3,9,1,2};
        System.out.println(optimalStrategy(arr2));

    }
    static class Pair{
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static int optimalStrategy(int[] arr){
        int n = arr.length;
        Pair[][] points = new Pair[n][n];

        for(int len=0; len<n; len++){
            for(int i=0; i<n; i++){
                int j=i+len;
                if(j>=n) continue;
                if(i==j){
                    points[i][j] = new Pair(arr[i], 0);
                }
                else{
                    if(arr[i] + points[i+1][j].second >= arr[j] + points[i][j-1].second){
                        points[i][j] = new Pair(arr[i] + points[i+1][j].second, points[i+1][j].first);
                    }
                    else{
                        points[i][j] = new Pair(arr[j] + points[i][j-1].second, points[i][j-1].first);
                    }
                }
            }
        }
        return points[0][n-1].first;
    }
}
