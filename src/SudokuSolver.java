public class SudokuSolver {
    public static void main(String[] args) {
        int[] sudoku = new int[81];
//        Sudoku s = new Sudoku(InputSudokuHelper.inputFromString("023456789000000000000000000000000000000000000000000000000000000000000000000000000"));
        Sudoku s = new Sudoku(InputSudokuHelper.inputFromString(
                "029073408" +
                        "007160095" +
                        "530004072" +
                        "000310024" +
                        "060058109" +
                        "015240700" +
                        "052001060" +
                        "080905247" +
                        "003620850"));
        s.initializeSudoku();
        s.solveSudoku();
        s.printSudoku();
    }
}
