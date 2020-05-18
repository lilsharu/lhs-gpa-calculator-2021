package lhs.gpa.calculator.backend;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;

public class MultiYearCourseList {
    private final List<List<Course>> courseList;
    
    public MultiYearCourseList(List<List<Course>> courseList) {
        this.courseList = courseList;
    }
    
    public GPAValue getAllCourseGPA() {
        BigDecimal credits = BigDecimal.ZERO;
        BigDecimal gpaSum  = BigDecimal.ZERO;
        for (List<Course> cList : courseList) {
            for (Course c : cList) {
                if (c.isReal()) {
                    BigDecimal credit = BigDecimal.valueOf(c.getCredits());
                    credits = credits.add(credit);
                    gpaSum  = gpaSum.add(credit.multiply(c.getGPA()));
                }
            }
        }
        return new GPAValue(gpaSum.multiply(BigDecimal.valueOf(100))
                                    .divide(credits, RoundingMode.HALF_UP)
                                    .divide(BigDecimal.valueOf(100)));
    }
    
    public GPAValue getMaxAllCourseGPA() {
        BigDecimal credits = BigDecimal.ZERO;
        BigDecimal gpaSum  = BigDecimal.ZERO;
        for (List<Course> cList : courseList) {
            for (Course c : cList) {
                if (c.isReal()) {
                    BigDecimal credit = BigDecimal.valueOf(c.getCredits());
                    credits = credits.add(credit);
                    gpaSum  = gpaSum.add(credit.multiply(c.getMaxGPA()));
                }
            }
        }
        return new GPAValue(gpaSum.multiply(BigDecimal.valueOf(100))
                                    .divide(credits, RoundingMode.HALF_UP)
                                    .divide(BigDecimal.valueOf(100)));
    }
    
    public GPAValue getCoreGPA() {
    
        BigDecimal credits = BigDecimal.ZERO;
        BigDecimal gpaSum  = BigDecimal.ZERO;
    
        for (List<Course> courseListIn : courseList) {
            List<Course> courseList = (List<Course>)((ArrayList<Course>) courseListIn).clone();
            courseList.removeIf(course -> !course.isReal() || !course.isCore());
            //Makes sure no two classes are from the same department and not AP
            List<Department> departmentList = Department.getDepartments();
            for (Department d : departmentList) {
                List<Course> courseDepartment = new ArrayList<>();
                for (Course c : courseList) {
                    if (c.getDepartment().equals(d) && !c.getLevel().equals(Level.AP)) {
                        courseDepartment.add(c);
                    }
                }
        
                if (courseDepartment.size() > 1) {
                    Course     maxCourse = new Course();
                    BigDecimal maxGPA    = BigDecimal.ZERO;
                    for (Course c : courseDepartment) {
                        if (c.getGPA().doubleValue() > maxGPA.doubleValue()) {
                            maxCourse = c;
                            maxGPA    = c.getGPA();
                        }
                    }
            
                    final Course use = maxCourse;
                    courseList.removeIf(course -> !course.equals(use) && course.getDepartment().equals(d) && !course.getLevel().equals(Level.AP));
                }
            }
    
            for (Course c : courseList) {
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
    
    public GPAValue getMaxCoreGPA() {
    
        BigDecimal credits = BigDecimal.ZERO;
        BigDecimal gpaSum  = BigDecimal.ZERO;
    
        for (List<Course> courseListIn : courseList) {
            List<Course> courseList = (List<Course>)((ArrayList<Course>) courseListIn).clone();
            courseList.removeIf(course -> !course.isReal() || !course.isCore());
            //Makes sure no two classes are from the same department and not AP
            List<Department> departmentList = Department.getDepartments();
            for (Department d : departmentList) {
                List<Course> courseDepartment = new ArrayList<>();
                for (Course c : courseList) {
                    if (c.getDepartment().equals(d) && !c.getLevel().equals(Level.AP)) {
                        courseDepartment.add(c);
                    }
                }
            
                if (courseDepartment.size() > 1) {
                    Course     maxCourse = new Course();
                    BigDecimal maxGPA    = BigDecimal.ZERO;
                    for (Course c : courseDepartment) {
                        if (c.getMaxGPA().doubleValue() > maxGPA.doubleValue()) {
                            maxCourse = c;
                            maxGPA    = c.getMaxGPA();
                        }
                    }
                
                    final Course use = maxCourse;
                    courseList.removeIf(course -> !course.equals(use) && course.getDepartment().equals(d) && !course.getLevel().equals(Level.AP));
                }
            }
        
            for (Course c : courseList) {
                BigDecimal credit = BigDecimal.valueOf(c.getCredits());
                credits = credits.add(credit);
                gpaSum  = gpaSum.add(credit.multiply(c.getMaxGPA()));
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
        BigDecimal credits = BigDecimal.ZERO;
        BigDecimal gpaSum  = BigDecimal.ZERO;
        for (List<Course> courses : courseList) {
            for (Course c : courses) {
                if (c.isReal()) {
                    BigDecimal credit = BigDecimal.valueOf(c.getCredits());
                    credits = credits.add(credit);
                    gpaSum  = gpaSum.add(credit.multiply(c.getGrade().getGPAValue()));
                }
            }
        }
        return new GPAValue(gpaSum.multiply(BigDecimal.valueOf(100))
                                    .divide(credits, RoundingMode.HALF_UP)
                                    .divide(BigDecimal.valueOf(100)));
    }
    
    public GPAValue getMaxUnweightedGPA() {
        return new GPAValue(new BigDecimal(BigInteger.valueOf(4L)));
    }
}
