package ru.devj110.lab_2_1;


public class RegularStudent extends AbstractStudent{
    private int course;

    private Stage stage;

    public RegularStudent(String firstName, String lastName, Gender gender, Department department, int course, Stage stage) {
        super(firstName, lastName, gender, department);
        setCourse(course);
        setStage(stage);
    }

    public void setCourse(int course) {
        if (course<1 ||course >6) throw new IllegalArgumentException("Course must be from 1 to 6");
        this.course = course;
    }

    public void setStage(Stage stage) {
        if (stage==null) throw new IllegalArgumentException("Stage can't be null");
        this.stage = stage;
    }

    @Override
    public String getDetailedInfo() {
        return getGender().getPronoun()+" is "+course+((course==2)?"nd":"th")+" year "+stage.getTitle()+" student.";
    }
}
