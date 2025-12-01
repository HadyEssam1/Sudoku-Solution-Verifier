package checkers;

import java.util.Arrays;

public class SingleBoxChecker extends Checker {
    private int box;

    public SingleBoxChecker(int[][] grid, int box){
        super(grid);
        this.box=box;
    }

    @Override
    public void run() {

        int startRow = (box/3)*3;
        int startColumn = (box%3)*3;
        int []count = new int [10];

        for(int row=startRow ; row<startRow+3 ; row++){
            for(int column=startColumn ; column<startColumn+3 ; column++){
                int n = grid[row][column];
                if (n>=1 && n<=9){
                    count[n]++;
                }
            }
        }
        for (int i=1 ; i<=9 ; i++){
            if (count[i]>1){
                addError("Box "+(box+1)+", #"+i+", "+ Arrays.toString(getBoxArray(startRow,startColumn,i)));
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
//    public int[][] getBoxArray(int startRow, int startColumn, int duplicatedValue) {
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
//                }
//            }
//        }
//        return java.util.Arrays.copyOf(positions, index);
//    }
    public int[] getBoxArray(int startRow, int startColumn, int duplicatedValue) {

        int[] positions = new int[9];
        int index = 0;

        for (int row = startRow; row < startRow + 3; row++) {
            for (int column = startColumn; column < startColumn + 3; column++) {
                positions[index] = grid[row][column];
                index++;
            }
        }
        return positions;
    }
}
