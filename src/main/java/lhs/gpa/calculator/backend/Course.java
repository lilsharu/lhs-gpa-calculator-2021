package lhs.gpa.calculator.backend;

import java.math.BigDecimal;

public class Course extends Class {
    private Grade   grade;
    private boolean real = true;
    
    public Course() {
        super();
        grade = Grade.F;
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
        grade = Grade.F;
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
    
    @Override
    public String toString() {
        return super.toString() + " Grade = " + grade + " Credits = " + super.getCredits();
    }
}
