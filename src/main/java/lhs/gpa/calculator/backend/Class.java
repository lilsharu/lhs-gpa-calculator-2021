package lhs.gpa.calculator.backend;

public class Class {

    private String name;
    private double credits;
    /* Class Levels */
    public static final double AP = 5.0;
    private String department;
    private String length = FULL_YEAR;
    public static final double HONORS = 4.5;
    public static final double CP = 4.0;
    /* Class Lengths */
    public static final String FULL_YEAR = "Full Year";
    /* Class Departments */
    public static final String BUSINESS_DEPARTMENT = "Business";
    private double level;
    public static final String HALF_YEAR = "Half Year";
    private int classNumber;
    public static final String ENGLISH_DEPARTMENT = "English";
    public static final String FCS_DEPARTMENT = "Family Consumer Science";
    public static final String PE_DEPARTMENT = "Health and Physical Education";
    public static final String MATH_DEPARTMENT = "Mathematics";
    public static final String PERFORMING_ARTS_DEPARTMENT = "Performing Arts";
    public static final String SCIENCE_DEPARTMENT = "Science";
    public static final String SOCIAL_STUDIES_DEPARTMENT = "Social Studies";
    public static final String TECHNOLOGY_DEPARTMENT = "Technology, Design, and Engineering";
    public static final String VISUAL_ART_DEPARTMENT = "Visual Arts";
    public static final String WORLD_LANGUAGE_DEPARTMENT = "World Language";

    public Class(String name, double credits, double level, String department, int classNumber) {
        this.name = name;
        this.credits = round(credits);
        this.level = level;
        this.department = department;
        this.classNumber = classNumber;
    }

    public Class(String name, double credits, double level, String department, int classNumber, String length) {
        this.name = name;
        this.credits = round(credits);
        this.level = level;
        this.department = department;
        this.length = length;
        this.classNumber = classNumber;
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

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    /* Other Useful Methods */
    public static double round(double in) {
        in *= 10;
        in += 0.5;
        double out = (int) in;
        return out / 10;
    }
}
