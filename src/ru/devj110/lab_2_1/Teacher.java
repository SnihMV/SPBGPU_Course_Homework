package ru.devj110.lab_2_1;

public class Teacher extends Person{
    private Degree degree;
    private String spec;

    public Teacher(String firstName, String lastName, Gender gender, Department department, Degree degree, String spec) {
        super(firstName, lastName, gender, department, "teaches");
        setDegree(degree);
        setSpec(spec);
    }

    private void setDegree(Degree degree) {
        if (degree==null) throw new IllegalArgumentException("Degree can't be null");
        this.degree = degree;

    }

    public void setSpec(String spec) {
        if (spec==null) throw new IllegalArgumentException("Spec can't be null");
        this.spec = spec;
    }

    public Degree getDegree() {
        return degree;
    }

    public String getSpec() {
        return spec;
    }

    @Override
    public String getDetailedInfo() {
        return getGender().getPronoun()+" has "+getDegree().getTitle()+" degree in "+spec+".";
    }
}
