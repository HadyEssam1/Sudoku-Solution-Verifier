package checkers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RowChecker extends Checker {
    public RowChecker(int[][] grid) {
        super(grid);
    }
    @Override
    public void run() {
        for(int row =0;row<9;row++){
            int[] count=new int[10];
            for(int column=0;column<9;column++)
            {
                int n = grid[row][column];
                if(n==0)
                {
                    addError("ROW "+(row+1)+" contains 0 (empty cell)");
                    continue;
                }
                else if (n<0||n>9)
                {
                    addError("ROW "+(row+1)+" contains invalid number " +n);
                    continue;
                }
                count[n]++;
            }
            for (int i=1;i<=9;i++)
            {
                if(count[i]>1)
                {
                    List<Integer> pos =new ArrayList<>();
                    for (int col=0;col<9;col++)
                    {
                        if (grid[row][col]==i)
                        {
                            pos.add(col);
                        }
                    }
                    addError("ROW " + (row + 1) + ", #" + i + ", " + pos.toString());
                }
            }
        }
    }
}
