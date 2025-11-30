package modes;

import checkers.Checker;
import checkers.SingleBoxChecker;
import checkers.SingleColumnChecker;
import checkers.SingleRowChecker;

import java.util.ArrayList;
import java.util.List;

public class FullParallelValidationStrategy implements ValidationStrategy {
    @Override
    public List<String> validate(int[][] grid) {
<<<<<<< HEAD
        ArrayList<Thread> threads = new ArrayList<>();
        ArrayList<Checker> checkers = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            SingleRowChecker src = new SingleRowChecker(grid, i);
            checkers.add(src);
            Thread t1 = new Thread(src);
            threads.add(t1);
        }
        for (int i = 0; i < 9; i++) {
            SingleColumnChecker scc = new SingleColumnChecker(grid, i);
            checkers.add(scc);
            Thread t1 = new Thread(scc);
            threads.add(t1);
        }
        for (int i =0;i <= 6;i+=3) {
            for (int j =0;j<= 6;j+= 3) {
                SingleBoxChecker sbc = new SingleBoxChecker(grid, i, j);
                checkers.add(sbc);
                Thread t1 = new Thread(sbc);
                threads.add(t1);
            }
        }
        for (Thread t : threads) {
            t.start();
        }

        try {
            for (Thread t : threads) {
                    t.join();
                }
        } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return List.of("Validation interrupted: "+e.getMessage());
                }

        ArrayList<String> list=new ArrayList<>();
        for(Checker c:checkers){
            list.addAll(c.getErrors());
        }
            return list;
        }
    }
=======
        return list;
    }
}
>>>>>>> d8f7905e3a28afb2b1e7d31134475bcf226b8ac5
