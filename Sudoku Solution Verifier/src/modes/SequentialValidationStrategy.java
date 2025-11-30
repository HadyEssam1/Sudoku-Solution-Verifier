package modes;

import checkers.BoxChecker;
import checkers.ColumnChecker;
import checkers.RowChecker;

import java.util.ArrayList;
import java.util.List;

public class SequentialValidationStrategy implements ValidationStrategy {

    @Override
    public List<String> validate(int[][] grid) {
        RowChecker r=new RowChecker(grid);
        ColumnChecker c=new ColumnChecker(grid);
        BoxChecker b=new BoxChecker(grid);

        r.run();
        c.run();
        b.run();

        ArrayList<String> list=new ArrayList<>();
        list.addAll(r.getErrors());
        list.addAll(c.getErrors());
        list.addAll(b.getErrors());


        return list;
    }
}
