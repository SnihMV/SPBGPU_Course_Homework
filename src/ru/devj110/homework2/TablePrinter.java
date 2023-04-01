package ru.devj110.homework2;

public class TablePrinter {
    private static final String FIRST_COLUMN_HEADER = "File name";
    private static final String SECOND_COLUMN_HEADER = "Size";
    private static final String THIRD_COLUMN_HEADER = "Details";
    private static final int MIN_PADDING = 2;
    private int filesNumber, firstColWidth, secondColWidth, thirdColWidth;


    public TablePrinter(File[] files) {
        if (files==null)
            throw new IllegalArgumentException("Null can't be printed");
        this.firstColWidth = FIRST_COLUMN_HEADER.length()+MIN_PADDING*2;
        this.secondColWidth = SECOND_COLUMN_HEADER.length()+MIN_PADDING*2;
        this.thirdColWidth = THIRD_COLUMN_HEADER.length()+MIN_PADDING*2;

        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().length() > firstColWidth)
                firstColWidth=files[i].getName().length();
            if (files[i].getSize() > secondColWidth)
                firstColWidth=files[i].getName().length();


        }

    }
}
