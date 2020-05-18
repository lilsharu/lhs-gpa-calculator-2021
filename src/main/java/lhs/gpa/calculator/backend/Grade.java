package lhs.gpa.calculator.backend;

import java.math.BigDecimal;
import java.util.*;

public class Grade {
    private String grade;
    
    public static final Grade A       = new Grade("A");
    public static final Grade A_MINUS = new Grade("A-");
    public static final Grade B_PLUS  = new Grade("B+");
    public static final Grade B       = new Grade("B");
    public static final Grade B_MINUS = new Grade("B-");
    public static final Grade C_PLUS  = new Grade("C+");
    public static final Grade C       = new Grade("C");
    public static final Grade C_MINUS = new Grade("C-");
    public static final Grade D_PLUS  = new Grade("D+");
    public static final Grade D       = new Grade("D");
    public static final Grade D_MINUS = new Grade("D-");
    public static final Grade F       = new Grade("F");
    public static final Grade NONE = new Grade("None");
    
    private Grade(String grade) {
        this.grade = grade;
    }
    
    public String getGrade() {
        return grade;
    }
    
    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    public BigDecimal getGPAValue() {
        if (A.equals(this)) {
            return new BigDecimal("4.00");
        } else if (A_MINUS.equals(this)) {
            return new BigDecimal("3.66");
        } else if (B_PLUS.equals(this)) {
            return new BigDecimal("3.33");
        } else if (B.equals(this)) {
            return new BigDecimal("3.00");
        } else if (B_MINUS.equals(this)) {
            return new BigDecimal("2.66");
        } else if (C_PLUS.equals(this)) {
            return new BigDecimal("2.33");
        } else if (C.equals(this)) {
            return new BigDecimal("2.00");
        } else if (C_MINUS.equals(this)) {
            return new BigDecimal("1.66");
        } else if (D_PLUS.equals(this)) {
            return new BigDecimal("1.33");
        } else if (D.equals(this)) {
            return new BigDecimal("1.00");
        } else if (D_MINUS.equals(this)) {
            return new BigDecimal("0.66");
        }
        return new BigDecimal("0.00");
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Grade grade1 = (Grade) o;
        
        return getGrade().equals(grade1.getGrade());
    }
    
    @Override
    public String toString() {
        return grade;
    }
    
    public static List<Grade> gradeList() {
        return Arrays.asList(A, A_MINUS,
                             B_PLUS, B, B_MINUS,
                             C_PLUS, C, C_MINUS,
                             D_PLUS, D, D_MINUS,
                             F, NONE            );
    }
    
    public static Grade averageNoFinals(Grade firstSemesterGrade, Grade secondSemesterGrade) {
        BigDecimal firstSemester  = firstSemesterGrade.getGPAValue();
        BigDecimal secondSemester = secondSemesterGrade.getGPAValue();
        
        return getGrade((firstSemester.multiply(new BigDecimal("0.50"))).add((secondSemester.multiply(new BigDecimal("0.50")))));
    }
    
    public static Grade averageWithFinals(Grade firstSemesterGrade, Grade finalsGrade) {
        BigDecimal firstSemester = firstSemesterGrade.getGPAValue();
        BigDecimal finals        = finalsGrade.getGPAValue();
        
        return getGrade((firstSemester.multiply(new BigDecimal("0.90"))).add((finals.multiply(new BigDecimal("0.10")))));
    }
    
    public static Grade averageWithFinals(Grade firstSemesterGrade, Grade secondSemesterGrade, Grade finalsGrade) {
        BigDecimal firstSemester  = firstSemesterGrade.getGPAValue();
        BigDecimal secondSemester = secondSemesterGrade.getGPAValue();
        BigDecimal finals         = finalsGrade.getGPAValue();
        
        return getGrade((firstSemester.multiply(new BigDecimal("0.45")).add((secondSemester.multiply(new BigDecimal("0.45"))).add(finals.multiply(new BigDecimal("0.10"))))));
    }
    
    public static Grade getGrade(BigDecimal gpaValue) {
        double gpa = gpaValue.doubleValue();
        
        if (gpa > 3.825) return A;
        else if (gpa >= 3.495) return A_MINUS;
        else if (gpa >= 3.155) return B_PLUS;
        else if (gpa >= 2.825) return B;
        else if (gpa >= 2.495) return B_MINUS;
        else if (gpa >= 2.155) return C_PLUS;
        else if (gpa >= 1.825) return C;
        else if (gpa >= 1.495) return C_MINUS;
        else if (gpa >= 1.155) return D_PLUS;
        else if (gpa >= 0.825) return D;
        else if (gpa >= 0.495) return D_MINUS;
        else return F;
    }
}
