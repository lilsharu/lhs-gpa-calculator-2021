package lhs.gpa.calculator.backend;

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
    private final       String     department;
    
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
}
