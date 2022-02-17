package Medium;

public class Mano {
    public static void main(String[] args) {
        String[] arr = {"...X..","......","......","......"};
        System.out.println(solution(arr));

    }
    public static void printArr(int[] arr){
        for(int num : arr) System.out.print(num +" ");
        System.out.println();
    }
    public static int solution(String[] arr){
        int height = arr.length;
        int width = arr[0].length();
        int[][] room = new int[height][width];
        // empty = 0  block = -1  clean =1
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                char c = arr[i].charAt(j);
                if(c == '.') room[i][j] = 0;
                else if (c == 'X') room[i][j] = -1;
            }
        }

        //for(int[] ar: room) printArr(ar);
        clean(0, 0, 0, room);
        for(int[] ar: room) printArr(ar);
        int count =0;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(room[i][j] == 1 || room[i][j] == 2) count +=1;
            }
        }
        return count;
    }

    public static boolean isSafe(int row, int col, int[][] room){
        int height = room.length;
        int width = room[0].length;
        return 0<=row && row<height && 0<=col && col<width && room[row][col] != -1 && room[row][col] < 2 ;
    }

    public static void clean(int row, int col, int dir, int[][] room){

        room[row][col] += 1;

        int[] dx = {0,1,-1,0};
        int[] dy = {1,0,0,-1};

        for(int i=0; i<4; i++){
            int xNext = row + dx[dir];
            int yNext = col + dy[dir];
            System.out.println(xNext +" "+yNext +" "+isSafe(xNext, yNext, room));
            if(isSafe(xNext, yNext, room)) clean(xNext, yNext, dir, room);
            else dir = (dir+1)%4;
        }

    }


}
