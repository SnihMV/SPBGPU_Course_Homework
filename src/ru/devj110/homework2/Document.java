package ru.devj110.homework2;

public class Document extends File {
    private int pages;

    public Document(String name, long size, int pages) {
        super(name, size, "docx");
        setPages(pages);
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        if (pages <= 0) throw new IllegalArgumentException("Number of pages lower than 1");
        this.pages = pages;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", " + getPages() + " pages";
    }
}
