package lhs.gpa.calculator.backend;

public class Grade {
    private String grade;

    public static final Grade A = new Grade("A");
    public static final Grade A_MINUS = new Grade("A-");
    public static final Grade B_PLUS = new Grade("B+");
    public static final Grade B = new Grade("B");
    public static final Grade B_MINUS = new Grade("B-");
    public static final Grade C_PLUS = new Grade("C+");
    public static final Grade C = new Grade("C");
    public static final Grade C_MINUS = new Grade("C-");
    public static final Grade D_PLUS = new Grade("D+");
    public static final Grade D = new Grade("D");
    public static final Grade D_MINUS = new Grade("D-");
    public static final Grade F = new Grade("F");

    public Grade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}
