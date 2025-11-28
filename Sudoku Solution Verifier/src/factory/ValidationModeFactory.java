package factory;

import modes.FullParallelValidationStrategy;
import modes.SequentialValidationStrategy;
import modes.TripleThreadValidationStrategy;
import modes.ValidationStrategy;

public class ValidationModeFactory {

    public static ValidationStrategy createValidationStrategy(int mode)
    {
        switch (mode)
        {
            case 0-> {
            return new SequentialValidationStrategy();
        }
        case 3-> {
            return new TripleThreadValidationStrategy();
        }
        case 27-> {
            return new FullParallelValidationStrategy();
        }
            default -> throw new IllegalArgumentException("Invalid validation mode: " + mode);
        }
        }
    }

