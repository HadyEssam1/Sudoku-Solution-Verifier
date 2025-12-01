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
                addError("BOX " + (box + 1) + ", #" + i + ", " + Arrays.toString(getBoxArray(startRow, startColumn, i)));
            }
        }
    }

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
