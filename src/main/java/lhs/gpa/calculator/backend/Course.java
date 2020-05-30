package lhs.gpa.calculator.backend;

import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Course extends Class {
    private Grade mainGrade;
    private Grade firstSemester;
    private Grade secondSemester;
    private Grade finals;
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
        this.mainGrade = grade;
    }
    
    public Course(Class aClass) {
        super(aClass);
    }
    
    public Course(String name, double credits, Level level, Department department, int classNumber, Grade grade) {
        super(name, credits, level, department, classNumber);
        this.mainGrade = grade;
    }
    
    public Course(String name, double credits, Level level, Department department, int classNumber, String length, Grade grade) {
        super(name, credits, level, department, classNumber, length);
        this.mainGrade = grade;
    }
    
    public Grade getGrade() {
        return mainGrade;
    }
    
    public void setGrade(Grade grade) {
        this.mainGrade = grade;
    }
    
    public void setGrade(Grade firstSemester, Grade secondSemester, Grade finals) {
        if (finals == null || finals.equals(Grade.NONE)) {
            this.firstSemester = firstSemester;
            if (secondSemester == null || secondSemester.equals(Grade.NONE)) {
                setGrade(firstSemester);
            }
            else {
                setGradeNoFinals(firstSemester, secondSemester);
                this.secondSemester = secondSemester;
            }
        } else if (secondSemester == null || secondSemester.equals(Grade.NONE)) {
            setGradeWithFinals(firstSemester, finals);
            this.firstSemester = firstSemester;
            this.finals = finals;
        } else {
            setGradeWithFinals(firstSemester, secondSemester, finals);
            this.firstSemester = firstSemester;
            this.secondSemester = secondSemester;
            this.finals = finals;
        }
    }
    
    public void setGradeNoFinals(Grade firstSemester, Grade secondSemester) {
        this.mainGrade = Grade.averageNoFinals(firstSemester, secondSemester);
    }
    
    public void setGradeWithFinals(Grade firstSemester, Grade finals) {
        this.mainGrade = Grade.averageWithFinals(firstSemester, finals);
    }
    
    public void setGradeWithFinals(Grade firstSemester, Grade secondSemester, Grade finals) {
        this.mainGrade = Grade.averageWithFinals(firstSemester, secondSemester, finals);
    }
    
    public boolean isReal() {
        return real;
    }
    
    public void setReal(boolean real) {
        this.real = real;
    }
    
    public Grade getFirstSemester() {
        return firstSemester;
    }
    
    public void setFirstSemester(Grade firstSemester) {
        this.firstSemester = firstSemester;
        setGrade(firstSemester, secondSemester, finals);
    }
    
    public Grade getSecondSemester() {
        return secondSemester;
    }
    
    public void setSecondSemester(Grade secondSemester) {
        this.secondSemester = secondSemester;
        setGrade(firstSemester, secondSemester, finals);
    }
    
    public Grade getFinals() {
        return finals;
    }
    
    public void setFinals(Grade finals) {
        this.finals = finals;
        setGrade(firstSemester, secondSemester, finals);
    }
    
    public BigDecimal getGPA() {
        return GPA.getGPA(mainGrade, getLevel()).calculateGPA();
    }
    
    public BigDecimal getMaxGPA() {
        return GPA.getGPA(Grade.A, getLevel()).calculateGPA();
    }
    
    public String toStringExport() {
        StringBuilder exportString = new StringBuilder(83);
        exportString.append(super.getName())
                .append("|")
                .append(super.getClassNumber().toString())
                .append("|")
                .append(super.getCredits())
                .append("|")
                .append(super.getLevel().toString())
                .append("|")
                .append(super.getDepartment().toStringExport())
                .append("|");
        
        if (firstSemester == null) exportString.append("None");
        else exportString.append(firstSemester.toString());
        
        exportString.append("|");
    
        if (secondSemester == null) exportString.append("None");
        else exportString.append(secondSemester.toString());
    
        exportString.append("|");
    
        if (finals == null) exportString.append("None");
        else exportString.append(finals.toString());
    
        return exportString.toString();
    }
    
    public static Course parseCourse(String courseToParse) {
        try {
            Course course = new Course();
    
            StringTokenizer st = new StringTokenizer(courseToParse, "|");
    
            course.setName(st.nextToken());
            course.setClassNumber(new ClassNumber(st.nextToken()));
            course.setCredits(Double.parseDouble(st.nextToken()));
            course.setLevel(Level.parseLevel(st.nextToken()));
            course.setDepartment(Department.parseDepartment(st.nextToken()));
            course.setGrade(Grade.parseGrade(st.nextToken()), Grade.parseGrade(st.nextToken()), Grade.parseGrade(st.nextToken()));
    
            return course;
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Parsing Course Failed", e);
        }
    }
}
