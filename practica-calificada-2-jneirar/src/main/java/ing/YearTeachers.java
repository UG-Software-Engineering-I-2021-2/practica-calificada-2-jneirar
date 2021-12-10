package ing;

import java.util.ArrayList;
import java.util.List;

public class YearTeachers {
    private final int year;
    private final List<Teacher> teachers;
    private final List<Teacher> teachersAgreedWithExtraPoints;
    private Boolean hasToIncreaseOneExtraPoint;
    public YearTeachers(int year) {
        this.year = year;
        this.teachers = new ArrayList<>();
        this.teachersAgreedWithExtraPoints = new ArrayList<>();
        this.hasToIncreaseOneExtraPoint = false;
    }
    public void addTeacher(Teacher teacher, Boolean isAgreed){
        this.teachers.add(teacher);

        if(Boolean.TRUE.equals(isAgreed)){
            this.teachersAgreedWithExtraPoints.add(teacher);
            this.hasToIncreaseOneExtraPoint = true;
        }
    }
    public Boolean increaseOneExtraPoint(){
        return this.hasToIncreaseOneExtraPoint;
    }
    public List<Teacher> getTteachersAgreedWithExtraPoints(){
        return this.teachersAgreedWithExtraPoints;
    }
}
