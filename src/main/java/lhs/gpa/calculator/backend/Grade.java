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
        return new ArrayList<>(Arrays.asList(A, A_MINUS,
                                             B_PLUS, B, B_MINUS,
                                             C_PLUS, C, C_MINUS,
                                             D_PLUS, D, D_MINUS,
                                             F));
    }
}
