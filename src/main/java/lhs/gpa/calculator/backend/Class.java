package lhs.gpa.calculator.backend;

public class Class {
    
    private String      name;
    private double      credits;
    private Level       level;
    private Department  department;
    private String      length = FULL_YEAR;
    private ClassNumber classNumber;
    private boolean     core;
    
    /* Class Lengths */
    public static final String FULL_YEAR = "Full Year";
    public static final String HALF_YEAR = "Half Year";
    
    public Class() {
    
    }
    
    public Class(String name, double credits, Level level, Department department, int classNumber) {
        this.name        = name;
        this.credits     = round(credits);
        this.level       = level;
        this.department  = department;
        this.classNumber = new ClassNumber(classNumber);
        this.core        = department.isCore() || level.equals(Level.AP);
    }
    
    public Class(String name, double credits, Level level, Department department, String classNumber) {
        this.name        = name;
        this.credits     = round(credits);
        this.level       = level;
        this.department  = department;
        this.classNumber = new ClassNumber(classNumber);
        this.core        = department.isCore() || level.equals(Level.AP);
    }
    
    public Class(String name, double credits, Level level, Department department, int classNumber, String length) {
        this.name        = name;
        this.credits     = round(credits);
        this.level       = level;
        this.department  = department;
        this.length      = length;
        this.classNumber = new ClassNumber(classNumber);
        this.core        = department.isCore() || level.equals(Level.AP);
    }
    
    public Class(String name, double credits, Level level, Department department, String classNumber, String length) {
        this.name        = name;
        this.credits     = round(credits);
        this.level       = level;
        this.department  = department;
        this.length      = length;
        this.classNumber = new ClassNumber(classNumber);
        this.core        = department.isCore() || level.equals(Level.AP);
    }
    
    public Class(Class aClass) {
        this.name        = aClass.getName();
        this.credits     = round(aClass.getCredits());
        this.level       = aClass.getLevel();
        this.department  = aClass.getDepartment();
        this.length      = aClass.getLength();
        this.classNumber = aClass.getClassNumber();
        this.core        = aClass.isCore();
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getCredits() {
        return round(credits);
    }
    
    public void setCredits(double credits) {
        this.credits = round(credits);
    }
    
    public Level getLevel() {
        return level;
    }
    
    public void setLevel(Level level) {
        this.level = level;
        setCore((department != null && department.isCore()) || (level != null && level.equals(Level.AP)));
    }
    
    public Department getDepartment() {
        return department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
        setCore((department != null && department.isCore()) || (level != null && level.equals(Level.AP)));
    }
    
    public boolean isCore() {
        return core;
    }
    
    public void setCore(boolean core) {
        this.core = core;
    }
    
    public String getLength() {
        return length;
    }
    
    public void setLength(String length) {
        this.length = length;
    }
    
    public ClassNumber getClassNumber() {
        return classNumber;
    }
    
    public void setClassNumber(int classNumber) {
        this.classNumber = new ClassNumber(classNumber);
    }
    
    public void setClassNumber(ClassNumber classNumber) {
        this.classNumber = classNumber;
    }
    
    public Class getaClass() {
        return this;
    }
    
    public void setClass(Class aClass) {
        this.name        = aClass.getName();
        this.credits     = round(aClass.getCredits());
        this.level       = aClass.getLevel();
        this.department  = aClass.getDepartment();
        this.length      = aClass.getLength();
        this.classNumber = aClass.getClassNumber();
        this.core        = aClass.isCore();
    }
    
    /* Other Useful Methods */
    public static double round(double in) {
        in *= 10;
        in += 0.5;
        double out = (int) in;
        return out / 10;
    }
    
    @Override
    public String toString() {
        return String.format("%s (%s)", name, classNumber.toString());
    }
}
