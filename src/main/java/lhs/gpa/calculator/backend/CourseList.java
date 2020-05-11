package lhs.gpa.calculator.backend;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class CourseList {
    private final List<Course> courseList;
    
    public CourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
    
    public CourseList(Course... courses) {
        this.courseList = new ArrayList<>(Arrays.asList(courses));
    }
    
    public void addCourse(Course... courses) {
        courseList.addAll(Arrays.asList(courses));
    }
    
    public GPAValue getAllCourseGPA() {
        BigDecimal credits = new BigDecimal(0);
        BigDecimal gpaSum  = new BigDecimal(0);
        
        for (Course c : courseList) {
            if (c.isReal()) {
                BigDecimal credit = BigDecimal.valueOf(c.getCredits());
                credits = credits.add(credit);
                gpaSum  = gpaSum.add(credit.multiply(c.getGPA()));
            }
        }
        
        return new GPAValue(gpaSum.multiply(BigDecimal.valueOf(100))
                                    .divide(credits, RoundingMode.HALF_UP)
                                    .divide(BigDecimal.valueOf(100)));
    }
    
    public GPAValue getCoreGPA() {
        List<Course> courseList = (List<Course>) ((ArrayList<Course>) this.courseList).clone();
        BigDecimal   credits    = new BigDecimal(0);
        BigDecimal   gpaSum     = new BigDecimal(0);
        
        for (Course c : courseList) {
            if (c.isReal() && c.isCore()) {
                BigDecimal credit = BigDecimal.valueOf(c.getCredits());
                credits = credits.add(credit);
                gpaSum  = gpaSum.add(credit.multiply(c.getGPA()));
            }
        }
        
        try {
            return new GPAValue(gpaSum.multiply(BigDecimal.valueOf(100))
                                        .divide(credits, RoundingMode.HALF_UP)
                                        .divide(BigDecimal.valueOf(100)));
        } catch (ArithmeticException e) {
            return new GPAValue(0);
        }
    }
    
    public GPAValue getUnweightedGPA() {
        BigDecimal credits = new BigDecimal(0);
        BigDecimal gpaSum  = new BigDecimal(0);
        
        for (Course c : courseList) {
            if (c.isReal()) {
                BigDecimal credit = BigDecimal.valueOf(c.getCredits());
                credits = credits.add(credit);
                gpaSum  = gpaSum.add(credit.multiply(c.getGrade().getGPAValue()));
            }
        }
        
        return new GPAValue(gpaSum.multiply(BigDecimal.valueOf(100))
                                    .divide(credits, RoundingMode.HALF_UP)
                                    .divide(BigDecimal.valueOf(100)));
    }
}
