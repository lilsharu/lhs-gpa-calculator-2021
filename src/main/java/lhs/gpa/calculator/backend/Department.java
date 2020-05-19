package lhs.gpa.calculator.backend;

import java.util.*;

public class Department {
    /* Class Departments */
    public static final Department BUSINESS_DEPARTMENT        = new Department("Business");
    public static final Department ENGLISH_DEPARTMENT         = new Department("English");
    public static final Department FCS_DEPARTMENT             = new Department("Family Consumer Science");
    public static final Department PE_DEPARTMENT              = new Department("Health and Physical Education");
    public static final Department MATH_DEPARTMENT            = new Department("Mathematics");
    public static final Department PERFORMING_ARTS_DEPARTMENT = new Department("Performing Arts");
    public static final Department SCIENCE_DEPARTMENT         = new Department("Science");
    public static final Department SOCIAL_STUDIES_DEPARTMENT  = new Department("Social Studies");
    public static final Department TECHNOLOGY_DEPARTMENT      = new Department("Technology, Design, and Engineering");
    public static final Department VISUAL_ART_DEPARTMENT      = new Department("Visual Arts");
    public static final Department WORLD_LANGUAGE_DEPARTMENT  = new Department("World Language");
    public static final Department ALL_DEPARTMENTS            = new Department("All");
    
    public static final List<Department> DEPARTMENT_LIST = getDepartments();
    
    private final String department;
    
    public Department(String department) {
        this.department = department;
    }
    
    public boolean isCore() {
        return (this.equals(ENGLISH_DEPARTMENT) ||
                this.equals(MATH_DEPARTMENT) ||
                this.equals(SCIENCE_DEPARTMENT) ||
                this.equals(SOCIAL_STUDIES_DEPARTMENT) ||
                this.equals(WORLD_LANGUAGE_DEPARTMENT)
        );
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
    
        Department that = (Department) o;
    
        return getDepartment().equals(that.getDepartment());
    }
    
    public String getDepartment() {
        return department;
    }
    
    public static Department parseDepartment(String departmentName) {
        String department = departmentName.toUpperCase();
        switch (department) {
            case "BUSINESS_DEPARTMENT":
                return BUSINESS_DEPARTMENT;
            case "ENGLISH_DEPARTMENT":
                return ENGLISH_DEPARTMENT;
            case "FCS_DEPARTMENT":
                return FCS_DEPARTMENT;
            case "MATH_DEPARTMENT":
                return MATH_DEPARTMENT;
            case "PE_DEPARTMENT":
                return PE_DEPARTMENT;
            case "PERFORMING_ARTS_DEPARTMENT":
                return PERFORMING_ARTS_DEPARTMENT;
            case "SCIENCE_DEPARTMENT":
                return SCIENCE_DEPARTMENT;
            case "SOCIAL_STUDIES_DEPARTMENT":
                return SOCIAL_STUDIES_DEPARTMENT;
            case "TECHNOLOGY_DEPARTMENT":
                return TECHNOLOGY_DEPARTMENT;
            case "VISUAL_ART_DEPARTMENT":
                return VISUAL_ART_DEPARTMENT;
            case "WORLD_LANGUAGE_DEPARTMENT":
                return WORLD_LANGUAGE_DEPARTMENT;
            default:
                throw new IllegalArgumentException(department + " does not match any of the known departments");
        }
    }
    
    @Override
    public String toString() {
        return department;
    }
    
    public String toStringExport() {
        if (BUSINESS_DEPARTMENT.equals(this)) {
            return "BUSINESS_DEPARTMENT";
        } else if (ENGLISH_DEPARTMENT.equals(this)) {
            return "ENGLISH_DEPARTMENT";
        } else if (FCS_DEPARTMENT.equals(this)) {
            return "FCS_DEPARTMENT";
        } else if (MATH_DEPARTMENT.equals(this)) {
            return "MATH_DEPARTMENT";
        } else if (PE_DEPARTMENT.equals(this)) {
            return "PE_DEPARTMENT";
        } else if (PERFORMING_ARTS_DEPARTMENT.equals(this)) {
            return "PERFORMING_ARTS_DEPARTMENT";
        } else if (SCIENCE_DEPARTMENT.equals(this)) {
            return "SCIENCE_DEPARTMENT";
        } else if (SOCIAL_STUDIES_DEPARTMENT.equals(this)) {
            return "SOCIAL_STUDIES_DEPARTMENT";
        } else if (TECHNOLOGY_DEPARTMENT.equals(this)) {
            return "TECHNOLOGY_DEPARTMENT";
        } else if (VISUAL_ART_DEPARTMENT.equals(this)) {
            return "VISUAL_ART_DEPARTMENT";
        } else if (WORLD_LANGUAGE_DEPARTMENT.equals(this)) {
            return "WORLD_LANGUAGE_DEPARTMENT";
        }
        throw new IllegalArgumentException(department + " does not match any of the known departments");
    }
    
    public static List<Department> getDepartments() {
        return new ArrayList<>(Arrays.asList(
                BUSINESS_DEPARTMENT,
                ENGLISH_DEPARTMENT,
                FCS_DEPARTMENT,
                MATH_DEPARTMENT,
                PE_DEPARTMENT,
                PERFORMING_ARTS_DEPARTMENT,
                SCIENCE_DEPARTMENT,
                SOCIAL_STUDIES_DEPARTMENT,
                TECHNOLOGY_DEPARTMENT,
                VISUAL_ART_DEPARTMENT,
                WORLD_LANGUAGE_DEPARTMENT
        ));
    }
}
