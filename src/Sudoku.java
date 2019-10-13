class Sudoku {

    private int size = 9;
    private int cellsNumber = size * size;
    private SudokuCell[] cells = new SudokuCell[cellsNumber];

    Sudoku(int[] inputCells) {
        for (int i = 0; i < cellsNumber; i++) {
            int lineNumber = i / 9 + 1;
            int columnNumber = i % 9 + 1;
            int blockNumber = ((columnNumber - 1) / 3 + 1) + 3 * ((lineNumber - 1) / 3);
            cells[i] = new SudokuCell(lineNumber, columnNumber, blockNumber);
            if (inputCells[i] != 0) {
                cells[i].setNumber(inputCells[i]);
            }
        }
    }

    void initializeSudoku() {
        for (int i = 0; i < cellsNumber; i++) {
            int number = cells[i].getNumber();
            if (number > 0) {
                removeValidNumberFromLine(number, cells[i].getLineNumber());
                removeValidNumberFromColumn(number, cells[i].getColumnNumber());
                removeValidNumberFromBlock(number, cells[i].getBlockNumber());
                cells[i].validNumbers.clear();
            }
        }
    }

    void solveSudoku() {
        boolean changeFlag = true;
        while (changeFlag) {
            for (int i = 0; i < cellsNumber; i++) {
                if (cells[i].validNumbers.size() == 1) {
                    setNumber(cells[i].validNumbers.iterator().next(), i);
                    changeFlag = true;
                    break;
                } else {
                    changeFlag = false;
                }
            }

        }
    }

    void printSudoku() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(cells[j + size * i].getNumber());
            }
            System.out.println();
        }
    }

    private void setNumber(int number, int cellIndex) {
        cells[cellIndex].setNumber(number);
        removeValidNumberFromLine(number, cells[cellIndex].getLineNumber());
        removeValidNumberFromColumn(number, cells[cellIndex].getColumnNumber());
        removeValidNumberFromBlock(number, cells[cellIndex].getBlockNumber());
        cells[cellIndex].validNumbers.clear();
    }

    private void removeValidNumberFromLine(int number, int lineNumber) {
        int firstIndexInLine = (lineNumber - 1) * size;
        for (int i = 0; i < size; i++) {
            cells[firstIndexInLine + i].addInvalidNumber(number);
        }
    }

    private void removeValidNumberFromColumn(int number, int columnNumber) {
        int firstIndexInColumn = columnNumber - 1;
        for (int i = 0; i < size; i++) {
            cells[firstIndexInColumn + size * i].addInvalidNumber(number);
        }
    }

    private void removeValidNumberFromBlock(int number, int blockNumber) {
        int firstIndexInBlock = (blockNumber - 1) % 3 * 3 + (blockNumber - 1) / 3 * 27;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[firstIndexInBlock + i * size + j].addInvalidNumber(number);
            }
        }
    }
}
