package ing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
    private final String name;
    private final List<Pair<Integer, Pair<Float, Boolean>>> grades;

    Student(String name) {
        this.name = name;
        grades = new ArrayList<>();
    }
    public void addYearGrade(Integer year, float grade, boolean hasBonus){
        grades.add(new Pair<>(year, new Pair<>(grade, hasBonus)));
    }
    public String getName(){
        return this.name;
    }
    public boolean hasExtraPointInYear(Integer year){
        for(Pair<Integer, Pair<Float, Boolean>> grade : grades){
            if(Objects.equals(grade.first(), year)){
                return grade.second().second();
            }
        }
        return false;
    }
}
