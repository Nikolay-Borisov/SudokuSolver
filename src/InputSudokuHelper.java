class InputSudokuHelper {
    static int[] inputFromString(String sudokuNumbersString) {
        int[] cells = new int[81];
        for (int i = 0; i < 81; i++) {
            cells[i] = Character.getNumericValue(sudokuNumbersString.charAt(i));
        }
        return cells;
    }
}
