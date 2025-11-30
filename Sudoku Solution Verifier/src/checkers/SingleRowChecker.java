package checkers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleRowChecker extends Checker {
    private int row;
    public SingleRowChecker(int[][] grid,int row) {
        super(grid);
        this.row=row;
    }

    @Override
    public void run() {
        int []count=new int[10];
        for(int column =0;column<9;column++){
            int n = grid[row][column];
            if (n >= 1 && n <= 9) {
                count[n]++;
            }
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
                        pos.add(col+1);
                    }
                }
                addError("ROW " + (row + 1) + ", #" + i + ", " + pos.toString());
            }
        }
    }
}
