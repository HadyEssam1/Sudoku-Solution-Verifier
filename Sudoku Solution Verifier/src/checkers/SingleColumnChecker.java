package checkers;

import java.util.Arrays;

public class SingleColumnChecker extends Checker {
    private int column;
    public SingleColumnChecker(int[][] grid,int column) {
        super(grid);
        this.column=column;
    }
    @Override
    public void run() {
        int []count=new int[10];
        int []arr=new int[9];
        for(int row =0;row<9;row++){
            int n = grid[row][column];
            arr[row]=grid[row][column];
            if (n >= 1 && n <= 9) {
                count[n]++;
            }        }
        for (int i=1;i<=9;i++)
        {
            if(count[i]>1)
            {
                addError("COL " + (column + 1) + ", #" + i + ", " + Arrays.toString(arr));
            }
        }
    }
}
