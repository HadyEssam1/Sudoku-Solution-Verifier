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

            for (int row=0 ; row<startRow+3 ; row++){
                for(int column=0 ; column<startColumn+3 ; column++){
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
            for(int i=0 ; i<9 ; i++){
                if (count[i]>1){
                    addError("Row "+(box+1)+" , #"+i+" , "+ Arrays.deepToString(getBoxArray(startRow,startColumn)));
                }
            }
        }
    }
    public int[][] getBoxArray(int startRow, int startColumn){
        int[][] box =new int[3][3];
        for (int row = 0; row <3 ; row++){
            System.arraycopy(grid[startRow+row] , startColumn , box[row], 0,3 );
        }
        return box;
    }
}
