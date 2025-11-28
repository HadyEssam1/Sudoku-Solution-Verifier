package checkers;

import java.util.ArrayList;
import java.util.List;

public abstract class Checker implements Runnable {
    private List<String> errors;
    protected int[][]grid;
    public Checker(int [][]grid)
    {
        this.grid=grid;
        errors=new ArrayList<String>();
    }
    public List<String> getErrors() {
        return errors;
    }

    public void addError(String error) {
errors.add(error);
    }

}
