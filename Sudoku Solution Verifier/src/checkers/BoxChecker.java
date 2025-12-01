package checkers;

import java.util.Arrays;

public class BoxChecker extends Checker {
    public BoxChecker(int[][] grid) {
        super(grid);
    }

    @Override
    public void run() {

        for (int box=0 ; box<9 ; box++){
            int [] count =new int[10];
            int startRow = (box/3)*3;
            int startColumn = (box%3)*3;

            for (int row=startRow ; row<startRow+3 ; row++){
                for(int column=startColumn ; column<startColumn+3 ; column++){
                    int n = grid[row][column];
                    if (n==0){
                        addError("ROW "+(row+1)+" contains 0 (empty cell)");
                        continue;
                    }
                    else if (n<1 || n>9){
                        addError("Row "+(row+1)+" contains invalid number "+n);
                        continue;
                    }
                    count[n]++;
                }
            }
            for(int i=1 ; i<=9 ; i++){
                if (count[i]>1){
                    addError("Box "+(box+1)+", #"+i+", "+ Arrays.toString(getBoxArray(startRow,startColumn,i)));
                }
            }
        }
    }
//    public int[][] getBoxArray(int startRow, int startColumn){
//        int[][] box =new int[3][3];
//        for (int row = 0; row <3 ; row++){
//            System.arraycopy(grid[startRow+row] , startColumn , box[row], 0,3 );
//        }
//        return box;
//    }
//        public int[][] getBoxArray(int startRow, int startColumn, int duplicatedValue) {
//
//        int[][] positions = new int[9][2];
//        int index = 0;
//
//        for (int row = startRow; row < startRow + 3; row++) {
//            for (int column = startColumn; column < startColumn + 3; column++) {
//                if (grid[row][column] == duplicatedValue) {
//                    positions[index][0] = row + 1;
//                    positions[index][1] = column + 1;
//                    index++;
//                 }
//            }
//        }
//        return java.util.Arrays.copyOf(positions, index);
//    }
//    public int[] getBoxArray(int startRow, int startColumn, int duplicatedValue) {
//
//        int[] positions = new int[9];
//        int index = 0;
//
//        for (int row = startRow; row < startRow + 3; row++) {
//            for (int column = startColumn; column < startColumn + 3; column++) {
//                positions[index] = grid[row][column];
//                index++;
//            }
//        }
//        return positions;
//    }
//
    public int[] getBoxArray(int startRow, int startColumn, int duplicatedValue) {

        int original = -1;
        int duplicate = -1;
        int boxIndex = 1;

        for (int row = startRow; row < startRow + 3; row++) {
            for (int column = startColumn; column < startColumn + 3; column++) {
                if (grid[row][column] == duplicatedValue) {
                    if (original == -1) {
                        original = boxIndex;
                    }
                    else {
                        duplicate = boxIndex;
                        return new int[]{original, duplicate};
                    }
                }
                boxIndex++;
            }
        }
        return new int[]{original, duplicate};
    }
}
