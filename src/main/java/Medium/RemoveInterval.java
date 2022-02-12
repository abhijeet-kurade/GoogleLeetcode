package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveInterval {
    public static void main(String[] args) {

        // [[0,2],[3,4],[5,7]]
        // [1,6]
        int[][] intervals = {{0,2},{3,4},{5,7}};
        int[] tbr = {1,6};

        System.out.println(removeInterval(intervals, tbr));

    }

    public static List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {

        List<List<Integer>> removeInterval = new ArrayList<>();

        int x1 = toBeRemoved[0];
        int y1 = toBeRemoved[1];

        for(int[] interval : intervals){
            int x = interval[0];
            int y = interval[1];
            if(Math.max(x, x1) - Math.min(y, y1) > 0){
                removeInterval.add(new ArrayList<>(Arrays.asList(x,y)));
            }
            else if(Math.min(x, x1) == x && Math.max(y,y1)== y){
                if(x != x1) removeInterval.add(new ArrayList<>(Arrays.asList(x,x1)));
                if(y != y1) removeInterval.add(new ArrayList<>(Arrays.asList(y,y1)));

            }
            else if(Math.min(x,x1)==x1 && Math.min(y,y1)==y1){
                if(y != y1) removeInterval.add(new ArrayList<>(Arrays.asList(y1,y)));
            }
            else if(Math.max(x,x1)==x1 && Math.max(y,y1)==y1){
                if(x != x1) removeInterval.add(new ArrayList<>(Arrays.asList(x,x1)));
            }
        }
        return removeInterval;
    }

}
