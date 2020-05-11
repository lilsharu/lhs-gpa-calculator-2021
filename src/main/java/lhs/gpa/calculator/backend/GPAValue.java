package lhs.gpa.calculator.backend;

import java.math.BigDecimal;

public class GPAValue {
    BigDecimal gpa;
    
    public GPAValue(double gpa) {
        this.gpa = new BigDecimal(Double.toString(((double) ((int) (gpa * 100))) / 100.0));
    }
    
    public GPAValue(BigDecimal gpa) {
        this.gpa = new BigDecimal(Double.toString(((double) ((int) (gpa.doubleValue() * 100))) / 100.0));
    }
    
    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder(Double.toString(((double) ((int) (gpa.doubleValue() * 100))) / 100.0));
        while (toReturn.length() < 4) toReturn.append("0");
        return toReturn.toString();
    }
}
