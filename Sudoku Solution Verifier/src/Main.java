import factory.ValidationModeFactory;
import model.SudokuGrid;
import modes.ValidationStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length<2)
        {
            System.out.println("invalid argument");
            return;
        }
        try{
        String path= args[0];
        int mode=Integer.parseInt(args[1]);
         SudokuGrid sudokuGrid=SudokuGrid.getInstance(path);
         ValidationStrategy validationStrategy=ValidationModeFactory.createValidationStrategy(mode);
         List <String>errors = validationStrategy.validate(sudokuGrid.getGrid());
         if (errors.isEmpty())
         {
             System.out.println("VALID");
         }
         else {
             System.out.println("INVALID");
             for (String e : errors) {
                 System.out.println(e);
             }
         }
        }
        catch (Exception e){
            System.out.println("Error"+e.getMessage());
        }

    }
    }