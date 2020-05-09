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
    
    public BigDecimal getAllCourseGPA() {
        BigDecimal credits = new BigDecimal(0);
        BigDecimal gpaSum  = new BigDecimal(0);
        
        for (Course c : courseList) {
            BigDecimal credit = BigDecimal.valueOf(c.getCredits());
            credits = credits.add(credit);
            gpaSum  = gpaSum.add(credits.multiply(c.getGPA()));
        }
        
        return gpaSum.multiply(BigDecimal.valueOf(100))
                .divide(credits, RoundingMode.HALF_UP)
                .divide(BigDecimal.valueOf(100));
    }
}
