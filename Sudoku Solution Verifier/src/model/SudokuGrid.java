package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SudokuGrid {
    final String path;
    private static SudokuGrid instance;
    int [][] grid;
    private SudokuGrid(String path) throws IOException {
        this.path=path;
        grid = new int[9][9];
        load();
    }
    public  static SudokuGrid getInstance(String path) throws IOException {
        if (instance==null)
        {
             instance=new SudokuGrid(path);
        }
            return instance;
    }

    public int[][] getGrid() {
        return grid;
    }
    public void load() throws IOException {

        List<String>lines = Files.readAllLines(Paths.get(path));
        if (lines.size() < 9)
            throw new IOException("File does not contain 9 rows.");

        for(int r=0;r<9;r++)
        {
            String[]nums= lines.get(r).split(",");
            if (nums.length < 9)
                throw new IOException("Row " + (r+1) + " has fewer than 9 numbers.");

            for(int c=0;c<9;c++)
            {
                grid[r][c]=Integer.parseInt(nums[c]);
            }
        }
    }
}
