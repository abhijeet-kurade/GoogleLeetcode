package StriverSdeSheet.Arrays.PartI;

public class SetMatrixZero {
    public static void main(String[] args) {

    }

    public static void setZeros(int[][] matrix){
        int temp = 1;
        int rows = matrix.length, cols = matrix[0].length;
        for(int i=0; i<cols; i++){
            if(matrix[0][i] == 0){
                temp = 0;
                break;
            }
        }

        for(int i=0; i<rows; i++){
            if(matrix[i][0] == 0){
                matrix[0][0] = 0;
                break;
            }
        }

        for(int i=1; i<rows; i++){
            for(int j=1; j<cols; j++){
                int val = matrix[i][j];
                if(val == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i=1; i<rows; i++){
            for(int j=1; j<cols; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int i=0; i<rows; i++){
                matrix[i][0] = 0;
            }
        }

        if(temp == 0){
            for(int i=0; i<cols; i++){
                matrix[0][i] = 0;
            }
        }
    }
}
