package lhs.gpa.calculator.backend;

import java.math.BigDecimal;

public class Course extends Class {
    private Grade   grade;
    private boolean real = true;
    
    public Course() {
        super();
    }
    
    public Course(boolean real) {
        this();
        this.real = real;
    }
    
    public Course(Class aClass, Grade grade) {
        super(aClass);
        this.grade = grade;
    }
    
    public Course(Class aClass) {
        super(aClass);
    }
    
    public Course(String name, double credits, Level level, Department department, int classNumber, Grade grade) {
        super(name, credits, level, department, classNumber);
        this.grade = grade;
    }
    
    public Course(String name, double credits, Level level, Department department, int classNumber, String length, Grade grade) {
        super(name, credits, level, department, classNumber, length);
        this.grade = grade;
    }
    
    public Grade getGrade() {
        return grade;
    }
    
    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    
    public void setGrade(Grade firstSemester, Grade secondSemester, Grade finals) {
        if (finals == null) {
            setGradeNoFinals(firstSemester, secondSemester);
        } else if (secondSemester == null) {
            setGradeWithFinals(firstSemester, finals);
        } else {
            setGradeWithFinals(firstSemester, secondSemester, finals);
        }
    }
    
    public void setGradeNoFinals(Grade firstSemester, Grade secondSemester) {
        this.grade = Grade.averageNoFinals(firstSemester, secondSemester);
    }
    
    public void setGradeWithFinals(Grade firstSemester, Grade finals) {
        this.grade = Grade.averageWithFinals(firstSemester, finals);
    }
    
    public void setGradeWithFinals(Grade firstSemester, Grade secondSemester, Grade finals) {
        this.grade = Grade.averageWithFinals(firstSemester, secondSemester, finals);
    }
    
    public boolean isReal() {
        return real;
    }
    
    public void setReal(boolean real) {
        this.real = real;
    }
    
    public BigDecimal getGPA() {
        return GPA.getGPA(grade, getLevel()).calculateGPA();
    }
    
    public BigDecimal getMaxGPA() {
        return GPA.getGPA(Grade.A, getLevel()).calculateGPA();
    }
}
