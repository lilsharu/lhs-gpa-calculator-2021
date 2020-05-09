package lhs.gpa.calculator.backend;

import java.math.BigDecimal;

import static lhs.gpa.calculator.backend.Level.CP;

public class GPA {
    private Grade grade;
    private Level level;
    
    public GPA() {
        grade = Grade.F;
        level = CP;
    }
    
    public GPA(Grade grade) {
        this();
        this.grade = grade;
    }
    
    public GPA(Grade grade, Level level) {
        this.grade = grade;
        this.level = level;
    }
    
    public static GPA getGPA(Grade grade, Level level) {
        return new GPA(grade, level);
    }
    
    public Grade getGrade() {
        return grade;
    }
    
    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    
    public Level getLevel() {
        return level;
    }
    
    public void setLevel(Level level) {
        this.level = level;
    }
    
    public BigDecimal calculateGPA() {
        BigDecimal beforeLevelGPA = grade.getGPAValue();
        
        if (beforeLevelGPA.intValue() == 0) return beforeLevelGPA;
        
        return beforeLevelGPA.add(level.getGPAIncrement());
    }
}