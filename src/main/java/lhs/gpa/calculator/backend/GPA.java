package lhs.gpa.calculator.backend;

import java.math.BigDecimal;

import static lhs.gpa.calculator.backend.Grade.*;

public class GPA extends Number {
    private BigDecimal gpa;

    public GPA(double gpa) {
        this.gpa = new BigDecimal(gpa);
    }

    public GPA(String gpaIn) {
        switch (gpaIn) {
            case A:
                gpa = new BigDecimal("4.00");
                return;
            case A_MINUS:
                gpa = new BigDecimal("3.66");
                return;
            case B_PLUS:
                gpa = new BigDecimal("3.33");
                return;
            case B:
                gpa = new BigDecimal("3.00");
                return;
            case B_MINUS:
                gpa = new BigDecimal("2.66");
                return;
            case C_PLUS:
                gpa = new BigDecimal("2.33");
                return;
            case C:
                gpa = new BigDecimal("2.00");
                return;
            case C_MINUS:
                gpa = new BigDecimal("1.66");
                return;
            case D_PLUS:
                gpa = new BigDecimal("1.33");
                return;
            case D:
                gpa = new BigDecimal("1.00");
                return;
            case D_MINUS:
                gpa = new BigDecimal("0.66");
                return;
            default:
                gpa = new BigDecimal("0.00");
        }
    }

    public double getGpa() {
        return gpa.doubleValue();
    }

    public void setGpa(double gpa) {
        this.gpa = BigDecimal.valueOf(gpa);
    }

    public static double getGPAValue(String gpa) {
        GPA val = new GPA(gpa);
        return val.getGpa();
    }

    /**
     * Returns the value of the specified number as an {@code int}.
     *
     * @return the numeric value represented by this object after conversion
     * to type {@code int}.
     */
    @Override
    public int intValue() {
        return gpa.intValue();
    }

    /**
     * Returns the value of the specified number as a {@code long}.
     *
     * @return the numeric value represented by this object after conversion
     * to type {@code long}.
     */
    @Override
    public long longValue() {
        return gpa.longValue();
    }

    /**
     * Returns the value of the specified number as a {@code float}.
     *
     * @return the numeric value represented by this object after conversion
     * to type {@code float}.
     */
    @Override
    public float floatValue() {
        return gpa.floatValue();
    }

    /**
     * Returns the value of the specified number as a {@code double}.
     *
     * @return the numeric value represented by this object after conversion
     * to type {@code double}.
     */
    @Override
    public double doubleValue() {
        return gpa.doubleValue();
    }
}
