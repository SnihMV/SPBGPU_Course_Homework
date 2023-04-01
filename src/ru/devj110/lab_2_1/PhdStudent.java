package ru.devj110.lab_2_1;

public class PhdStudent extends AbstractStudent{
    private String thesisTopic;

    public PhdStudent(String firstName, String lastName, Gender gender, Department department, String thesisTopic) {
        super(firstName, lastName, gender, department);
        setThesisTopic(thesisTopic);
    }

    public void setThesisTopic(String thesisTopic) {
     if (thesisTopic==null ||thesisTopic.isEmpty()) throw new IllegalArgumentException("Thesis topic is null or empty");
        this.thesisTopic = thesisTopic;
    }

    @Override
    public String getDetailedInfo() {
        return getGender().getPosPronoun()+" thesis title is "+thesisTopic+".";
    }
}
