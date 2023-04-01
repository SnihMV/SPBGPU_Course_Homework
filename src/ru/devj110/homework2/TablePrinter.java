package ru.devj110.homework2;

public class TablePrinter {
    private static final String FIRST_COLUMN_TITLE = "File name";
    private static final String SECOND_COLUMN_TITLE = "Size";
    private static final String THIRD_COLUMN_TITLE = "Details";
    private static final int MIN_HEADER_PADDING = 5;
    private final File[] files;
    private int firstColWidth, secondColWidth, thirdColWidth;
    private final int tableWidth;


    public TablePrinter(File[] files) {
        if (files == null)
            throw new IllegalArgumentException("Null can't be printed");
        this.files = files;
        this.firstColWidth = FIRST_COLUMN_TITLE.length() + MIN_HEADER_PADDING * 2;
        this.secondColWidth = SECOND_COLUMN_TITLE.length() + MIN_HEADER_PADDING * 2;
        this.thirdColWidth = THIRD_COLUMN_TITLE.length() + MIN_HEADER_PADDING * 2;

        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().length() > firstColWidth)
                firstColWidth = files[i].getName().length();
            if (files[i].getSize().toString().length() > secondColWidth)
                secondColWidth = files[i].getSize().toString().length();
            if (files[i].getDetails().length() > thirdColWidth)
                thirdColWidth = files[i].getDetails().length();
        }
        this.tableWidth = firstColWidth + secondColWidth + thirdColWidth + 4;

    }

    public void print() {
        System.out.println(getBorder());
        System.out.println(getTableHeader());
        for (int i = 0; i < files.length; i++) {
            System.out.println(getRowSeparator());
            System.out.println(getTableRow(files[i]));
        }
        System.out.println(getBorder());
    }

    private String getTableRow(File file) {
        String tableRow = '|' +
                getLeftAligned(file.getName(), firstColWidth) +
                '|' +
                getRightAligned(file.getSize().toString(), secondColWidth) +
                '|' +
                getLeftAligned(file.getDetails(), thirdColWidth) +
                '|';
        return tableRow;
    }

    private String getRowSeparator() {
        StringBuilder separator = new StringBuilder();
        separator.append('|');
        for (int i = 0; i < firstColWidth; i++) {
            separator.append('-');
        }
        separator.append('+');
        for (int i = 0; i < secondColWidth; i++) {
            separator.append('-');
        }
        separator.append('+');
        for (int i = 0; i < thirdColWidth; i++) {
            separator.append('-');
        }
        separator.append('|');
        return separator.toString();
    }

    private String getTableHeader() {
        String header = '|' +
                getCenterAligned(FIRST_COLUMN_TITLE, firstColWidth) +
                '|' +
                getCenterAligned(SECOND_COLUMN_TITLE, secondColWidth) +
                '|' +
                getCenterAligned(THIRD_COLUMN_TITLE, thirdColWidth) +
                '|';
        return header;
    }

    private String getBorder() {
        StringBuilder border = new StringBuilder();
        for (int i = 0; i < tableWidth; i++) {
            border.append('-');
        }
        return border.toString();
    }

    private String getCenterAligned(String text, int width) {
        int whiteSpace = width - text.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < whiteSpace / 2 + whiteSpace % 2; i++) {
            res.append(' ');
        }
        res.append(text);
        for (int i = 0; i < whiteSpace / 2; i++) {
            res.append(' ');
        }
        return res.toString();
    }

    private String getLeftAligned(String text, int width) {
        int whiteSpace = width - text.length();
        StringBuilder res = new StringBuilder();
        res.append(text);
        for (int i = 0; i < whiteSpace; i++) {
            res.append(' ');
        }
        return res.toString();
    }

    private String getRightAligned(String text, int width) {
        int whiteSpace = width - text.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < whiteSpace; i++) {
            res.append(' ');
        }
        res.append(text);
        return res.toString();
    }
}
