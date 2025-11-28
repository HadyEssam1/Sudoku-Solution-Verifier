package modes;

import java.util.List;

public interface ValidationStrategy {
    List<String> validate(int[][]grid);
}
