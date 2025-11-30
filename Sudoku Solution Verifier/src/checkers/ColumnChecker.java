package checkers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColumnChecker extends Checker{
    public ColumnChecker(int[][] grid) {
        super(grid);
    }

    @Override
    public void run() {
        for(int column =0;column<9;column++){
            int[] count=new int[10];
            for(int row=0;row<9;row++)
            {
                int n =grid[row][column];
                if(n==0)
                {
                    addError("COL "+(column+1)+" contains 0 (empty cell)");
                    continue;
                }
                else if (n<0||n>9)
                {
                    addError("COL "+(column+1)+" contains invalid number " +n);
                    continue;
                }
                count[n]++;
            }
            for (int i=1;i<=9;i++)
            {
                if(count[i]>1)
                {
                    List<Integer> pos =new ArrayList<>();
                    for (int row=0;row<9;row++)
                    {
                        if (grid[row][column]==i)
                        {
                            pos.add(row);
                        }
                    }
                    addError("COL " + (column + 1) + ", #" + i + ", " + pos.toString());
                }
            }
        }
    }
}
