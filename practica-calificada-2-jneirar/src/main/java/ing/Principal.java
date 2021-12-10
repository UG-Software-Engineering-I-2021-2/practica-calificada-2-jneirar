package ing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Principal {
    private final Map<Integer, YearTeachers> allYearsTeachers;

    private final int yearToCalculate;

    private static final Logger logger = Logger.getLogger(Principal.class.getName());

    private Float calculateGradeAcordingToGradesWeigthSum(Float grade, int gradesWeightSum){
        if(gradesWeightSum > 100){
            return -1f;
        }else if(gradesWeightSum < 100){
            return -2f;
        }else{
            return grade;
        }
    }

    public Principal(int yearToCalculate) {
        this.yearToCalculate = yearToCalculate;

        this.allYearsTeachers = new HashMap<>();

        YearTeachers yearTeachers2020 = new YearTeachers(2020);
        yearTeachers2020.addTeacher(new Teacher("Josefina"), true);
        yearTeachers2020.addTeacher(new Teacher("Edonisio"), true);
        yearTeachers2020.addTeacher(new Teacher("Josefina"), false);
        this.allYearsTeachers.put(2020, yearTeachers2020);

        YearTeachers yearTeachers2019 = new YearTeachers(2019);
        yearTeachers2019.addTeacher(new Teacher("Eduarda"), false);
        yearTeachers2019.addTeacher(new Teacher("Abelardo"), false);
        yearTeachers2019.addTeacher(new Teacher("Francisca"), false);
        this.allYearsTeachers.put(2019, yearTeachers2019);
    }

    public float calculateGrades(final List<Pair<Integer, Float>> examsStudents, final boolean hasReachedMinimumClasses) {
        if(examsStudents.isEmpty()){
            return 0f;
        }

        float gradesSum       = 0f;
        int   gradesWeightSum = 0;
        Boolean hasToIncreaseOneExtraPoint = allYearsTeachers.get(this.yearToCalculate).increaseOneExtraPoint();
        for (Pair<Integer, Float> examGrade : examsStudents) {
            gradesSum += (examGrade.first() * examGrade.second() / 100);
            gradesWeightSum += examGrade.first();
        }

        gradesSum = calculateGradeAcordingToGradesWeigthSum(gradesSum, gradesWeightSum);

        if(gradesSum < 0) {
            return gradesSum;
        }
        if (hasReachedMinimumClasses) {
            return Boolean.TRUE.equals(hasToIncreaseOneExtraPoint) ?  Float.min(10f, gradesSum + 1) : gradesSum;
        } else {
            return 0f;
        }
    }
    public List<String> printTeachersAgreedWithGiveExtraPoints(){
        List<String> response = new ArrayList<>();
        List<Teacher> teachers = this.allYearsTeachers.get(this.yearToCalculate).getTteachersAgreedWithExtraPoints();
        for(Teacher teacher : teachers){
            logger.info(teacher.getName());
            response.add(teacher.getName());
        }
        return response;
    }
    public boolean studentHasExtraPoints() {
        return allYearsTeachers.get(this.yearToCalculate).increaseOneExtraPoint();
    }
    public void printStudentWithExtraPoints(List<Student> students){
        for(Student student: students){
            if(student.hasExtraPointInYear(this.yearToCalculate)){
                logger.info(student.getName());
            }
        }
    }
    public static void main(String[] args) {
        logger.info("Hola");
    }
}
