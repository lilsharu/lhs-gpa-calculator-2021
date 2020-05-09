package lhs.gpa.calculator.backend;

import java.math.BigDecimal;

public class Course extends Class {
    private Grade grade;
    
    public Course(Class aClass, Grade grade) {
        super(aClass);
        this.grade = grade;
    }
    
    public Course(Class aClass) {
        super(aClass);
        grade = Grade.F;
    }
    
    public Grade getGrade() {
        return grade;
    }
    
    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    
    public BigDecimal getGPA() {
        return GPA.getGPA(grade, getLevel()).calculateGPA();
    }
}
