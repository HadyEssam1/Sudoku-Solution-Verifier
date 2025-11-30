package modes;

import checkers.BoxChecker;
import checkers.ColumnChecker;
import checkers.RowChecker;

import java.util.ArrayList;
import java.util.List;

public class TripleThreadValidationStrategy implements ValidationStrategy {
    @Override
    public List<String> validate(int[][] grid) {
        RowChecker r=new RowChecker(grid);
        ColumnChecker c=new ColumnChecker(grid);
        BoxChecker b=new BoxChecker(grid);

        Thread r1=new Thread(r);
        Thread c1=new Thread(c);
        Thread b1=new Thread(b);

        r1.start();
        c1.start();
        b1.start();
        try {
            r1.join();
            c1.join();
            b1.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return List.of("Validation interrupted: "+ e.getMessage());
        }

        ArrayList<String> list=new ArrayList<>();
        list.addAll(r.getErrors());
        list.addAll(c.getErrors());
        list.addAll(b.getErrors());

        return list;
    }
}
