package ru.devj110.homework2;

public abstract class File {
    private String name;
    private long size;
    private String format;

    public File(String name, long size, String format) {
        setName(name);
        setSize(size);
        setFormat(format);
    }


    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        if (format==null) throw new IllegalArgumentException("Format is null");
        if (format.isEmpty()) throw new IllegalArgumentException("Format is empty");
        this.format = format;
    }

    public void setName(String name) {
        if (name==null) throw new IllegalArgumentException("Name is null");
        if (name.isEmpty()) throw new IllegalArgumentException("Name is empty");
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        if (size<4) throw new IllegalArgumentException("File size is too small");
        this.size=size;
    }

    @Override
    public String toString() {
        return name+"|"+size+"|"+getDetails();
    }

    protected String getDetails(){
        return getFormat();
    }


}
