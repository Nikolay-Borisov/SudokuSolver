import java.util.HashSet;

class SudokuCell {
    private int lineNumber;
    private int columnNumber;
    private int blockNumber;
    private int cellNumber;
    HashSet<Integer> validNumbers;

    SudokuCell(int line, int column, int block) {
        lineNumber = line;
        columnNumber = column;
        blockNumber = block;
        cellNumber = 0;
        validNumbers = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            validNumbers.add(i + 1);
        }
    }

    int getLineNumber() {
        return lineNumber;
    }

    int getColumnNumber() {
        return columnNumber;
    }

    int getBlockNumber() {
        return blockNumber;
    }

    void setNumber(int number) {
        cellNumber = number;
    }

    int getNumber() {
        return cellNumber;
    }

    int getNumberOfValidNumbers() {
        return validNumbers.size();
    }

    void addInvalidNumber(int invalidNumber) {
        validNumbers.remove(invalidNumber);
    }
}
