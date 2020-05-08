package lhs.gpa.calculator.backend;

public class Class {

    private String name;
    private double credits;
    private String level;
    private String department;
    private String length = FULL_YEAR;
    private int courseNumber;

    public static final String FULL_YEAR = "Full Year";
    public static final String HALF_YEAR = "Half Year";

    public static final String AP = "AP";
    public static final String HONORS = "H";
    public static final  String CP = "CP";

    public static final String BUSINESS_DEPARTMENT = "Business";
    public static final String ENGLISH_DEPARTMENT = "English";
    public static final String FCS_DEPARTMENT = "Family Consumer Science";
    public static final String PE_DEPARTMENT = "Health and Physical Education";
    public static final String MATH_DEPARTMENT = "Mathematics";
    public static final String PERFORMING_ARTS_DEPARTMENT = "Performing Arts";
    public static final String SCIENCE_DEPARTMENT = "Science";
    public static final String SOCIAL_STUDIES_DEPARTMENT = "Social Studies";
    public static final String TECHNOLOGY_DEPARTMENT = "Technology, Design, and Engineering";
    public static final String VISUAL_ART_DEPARTMENT = "Visual Arts";
    public static final String WORLD_LANGUAGE_DEPARTMENT = "World Language";

    public Class(String name, double credits, String level, String department, int courseNumber) {
        this.name = name;
        this.credits = round(credits);
        this.level = level;
        this.department = department;
        this.courseNumber = courseNumber;
    }

    public Class(String name, double credits, String level, String department, int courseNumber, String length) {
        this.name = name;
        this.credits = round(credits);
        this.level = level;
        this.department = department;
        this.length = length;
        this.courseNumber = courseNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCredits() {
        return round(credits);
    }

    public void setCredits(double credits) {
        this.credits = round(credits);
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    /*
     * =============================================================
     * =================== BUSINESS DEPARTMENT =====================
     * =============================================================
     */
    public static Class INTRODUCTION_TO_BUSINESS() {
        return new Class("INTRODUCTION TO BUSINESS", 5, CP, BUSINESS_DEPARTMENT, 613);
    }
    
    public static Class COMPUTER_APPLICATIONS() {
        return new Class("COMPUTER APPLICATIONS", 5, CP, BUSINESS_DEPARTMENT, 623);
    }

    public static Class CAREER_EXPLORATION() { 
        return new Class("CAREER EXPLORATION", 5, CP, BUSINESS_DEPARTMENT, 771);
    }
    
    public static Class CAREER_INTERNSHIP_PROGRAM_1() {
        return new Class("CAREER INTERNSHIP PROGRAM 1", 5, CP, BUSINESS_DEPARTMENT, 772);
    }

    public static Class CAREER_INTERNSHIP_PROGRAM_2() {
        return new Class("CAREER INTERNSHIP PROGRAM 2", 5, CP, BUSINESS_DEPARTMENT, 773);
    }

    public static Class COMMUNITY_BASED_INSTRUCTION() {
        return new Class("COMMUNITY BASED INSTRUCTION", 5, CP, BUSINESS_DEPARTMENT, 6);
    }

    public static Class ACCOUNTING_1() {
        return new Class("ACCOUNTING 1", 5, CP, BUSINESS_DEPARTMENT, 621);
    }

    public static Class ACCOUNTING_2() {
        return new Class("ACCOUNTING 2", 5, CP, BUSINESS_DEPARTMENT, 632);
    }

    public static Class COOPERATIVE_WORK_EXPERIENCE() {
        return new Class("COOPERATIVE WORK EXPERIENCE", 15, CP, BUSINESS_DEPARTMENT, 642);
    }

    public static Class BUSINESS_LAW_1() {
        return new Class("BUSINESS LAW 1", 5, CP, BUSINESS_DEPARTMENT, 635);
    }

    public static Class BUSINESS_LAW_2() {
        return new Class("BUSINESS LAW 2", 5, CP, BUSINESS_DEPARTMENT, 638);
    }

    public static Class ENTREPRENEURSHIP() {
        return new Class("ENTREPRENEURSHIP", 5, CP, BUSINESS_DEPARTMENT, 636);
    }

    public static Class MARKETING() {
        return new Class("MARKETING", 5, CP, BUSINESS_DEPARTMENT, 634);
    }

    public static Class MICROSOFT_OFFICE_SPECIALIST() {
        return new Class("MICROSOFT OFFICE SPECIALIST", 5, CP, BUSINESS_DEPARTMENT, 625);
    }

    public static Class GLOBAL_BUSINESS() {
        return new Class("GLOBAL BUSINESS", 5, CP, BUSINESS_DEPARTMENT, 640);
    }

    public static Class AP_ECONOMICS() {
        return new Class("AP ECONOMICS", 5, AP, BUSINESS_DEPARTMENT, 650);
    }

    public static Class ECONOMICS() {
        return new Class("ECONOMICS", 2.5, CP, BUSINESS_DEPARTMENT, 633, HALF_YEAR);
    }

    public static Class INVESTING() {
        return new Class("INVESTING", 2.5, CP, BUSINESS_DEPARTMENT, 614, HALF_YEAR);
    }

    public static Class PERSONAL_FINANCIAL_LITERACY() {
        return new Class("PERSONAL FINANCIAL LITERACY", 2.5, CP, BUSINESS_DEPARTMENT, 626, HALF_YEAR);
    }

    public static Class PERSONAL_FINANCIAL_LITERACY_HYBRID() {
        return new Class("PERSONAL FINANCIAL LITERACY HYBRID", 2.5, CP, BUSINESS_DEPARTMENT, 626, HALF_YEAR);
    }

    public static Class SPORTS_AND_ENTERTAINMENT_MARKETING() {
        return new Class("SPORTS AND ENTERTAINMENT MARKETING", 2.5, CP, BUSINESS_DEPARTMENT, 615, HALF_YEAR);
    }

    public static Class SOCIAL_MEDIA_MARKETING() {
        return new Class("SOCIAL MEDIA MARKETING", 2.5, CP, BUSINESS_DEPARTMENT, 616, HALF_YEAR);
    }

    public static Class WEB_DESIGN() {
        return new Class("WEB DESIGN", 2.5, CP, BUSINESS_DEPARTMENT, 627, HALF_YEAR);
    }


    /*
     * =============================================================
     * ==================== ENGLISH DEPARTMENT =====================
     * =============================================================
     */
    public static Class ENGLISH_FOR_SUCCESS_1() {
        return new Class("ENGLISH FOR SUCCESS 1", 5, CP, ENGLISH_DEPARTMENT, 116);
    }

    public static Class ENGLISH_FOR_SUCCESS_2() {
        return new Class("ENGLISH FOR SUCCESS 2", 5, CP, ENGLISH_DEPARTMENT, 117);
    }

    public static Class GENERAL_ENGLISH_1() {
        return new Class("GENERAL ENGLISH 1", 5, CP, ENGLISH_DEPARTMENT, 171);
    }

    public static Class ENGLISH_1_CP() {
        return new Class("ENGLISH 1 CP", 5, CP, ENGLISH_DEPARTMENT, 112);
    }

    public static Class ENGLISH_1_HUMANITIES_CP() {
        return new Class("ENGLISH 1 HUMANITIES CP", 5, CP, ENGLISH_DEPARTMENT, 112);
    }

    public static Class ENGLISH_1_HONORS() {
        return new Class("ENGLISH 1 HONORS", 5, HONORS, ENGLISH_DEPARTMENT, 110);
    }

    public static Class ENGLISH_1_HUMANITIES_HONORS() {
        return new Class("ENGLISH 1 HUMANITIES HONORS", 5, HONORS, ENGLISH_DEPARTMENT, 110);
    }

    public static Class GENERAL_ENGLISH_2() {
        return new Class("GENERAL ENGLISH 2", 5, CP, ENGLISH_DEPARTMENT, 172);
    }

    public static Class ENGLISH_2_CP() {
        return new Class("ENGLISH 2 CP", 5, CP, ENGLISH_DEPARTMENT, 122);
    }

    public static Class ENGLISH_2_HUMANITIES_CP() {
        return new Class("ENGLISH 2 HUMANITIES CP", 5, CP, ENGLISH_DEPARTMENT, 122);
    }

    public static Class ENGLISH_2_HONORS() {
        return new Class("ENGLISH 2 HONORS", 5, HONORS, ENGLISH_DEPARTMENT, 120);
    }

    public static Class ENGLISH_2_HUMANITIES_HONORS() {
        return new Class("ENGLISH 2 HUMANITIES HONORS", 5, HONORS, ENGLISH_DEPARTMENT, 120);
    }

    public static Class GENERAL_ENGLISH_3() {
        return new Class("GENERAL ENGLISH 3", 5, CP, ENGLISH_DEPARTMENT, 173);
    }

    public static Class ENGLISH_3_CP() {
        return new Class("ENGLISH 3 CP", 5, CP, ENGLISH_DEPARTMENT, 132);
    }

    public static Class ENGLISH_3_HUMANITIES_CP() {
        return new Class("ENGLISH 3 HUMANITIES CP", 5, CP, ENGLISH_DEPARTMENT, 132);
    }

    public static Class ENGLISH_3_HONORS() {
        return new Class("ENGLISH 3 HONORS", 5, HONORS, ENGLISH_DEPARTMENT, 130);
    }

    public static Class ENGLISH_3_HUMANITIES_HONORS() {
        return new Class("ENGLISH 3 HUMANITIES HONORS", 5, HONORS, ENGLISH_DEPARTMENT, 130);
    }

    public static Class AP_ENGLISH_LANGUAGE_AND_COMPOSITION() {
        return new Class("AP ENGLISH LANGUAGE AND COMPOSITION", 5, AP, ENGLISH_DEPARTMENT, 131);
    }

    public static Class GENERAL_ENGLISH_4() {
        return new Class("GENERAL ENGLISH 4", 5, CP, ENGLISH_DEPARTMENT, 174);
    }

    public static Class ENGLISH_4_CP() {
        return new Class("ENGLISH 4 CP", 5, CP, ENGLISH_DEPARTMENT, 142);
    }

    public static Class ENGLISH_4_HONORS() {
        return new Class("ENGLISH 4 HONORS", 5, HONORS, ENGLISH_DEPARTMENT, 140);
    }

    public static Class AP_ENGLISH_LITERATURE_AND_COMPOSITION() {
        return new Class("AP ENGLISH LITERATURE AND COMPOSITION", 5, AP, ENGLISH_DEPARTMENT, 141);
    }

    public static Class CREATIVE_WRITING_1() {
        return new Class("CREATIVE WRITING 1", 5, CP, ENGLISH_DEPARTMENT, 118);
    }

    public static Class CREATIVE_WRITING_2() {
        return new Class("CREATIVE WRITING 2", 5, CP, ENGLISH_DEPARTMENT, 129);
    }

    public static Class CREATIVE_WRITING_3() {
        return new Class("CREATIVE WRITING 3", 5, CP, ENGLISH_DEPARTMENT, 149);
    }

    public static Class JOURNALISM() {
        return new Class("JOURNALISM", 5, CP, ENGLISH_DEPARTMENT, 125);
    }

    public static Class PUBLIC_SPEAKING_AND_DEBATE() {
        return new Class("PUBLIC SPEAKING AND DEBATE", 5, CP, ENGLISH_DEPARTMENT, 135);
    }

    public static Class READING_AND_WRITING_FOR_SUCCESS_1() {
        return new Class("READING AND WRITING FOR SUCCESS 1", 5, CP, ENGLISH_DEPARTMENT, 180);
    }

    public static Class READING_AND_WRITING_FOR_SUCCESS_2() {
        return new Class("READING AND WRITING FOR SUCCESS 2", 5, CP, ENGLISH_DEPARTMENT, 181);
    }

    public static Class READING_AND_WRITING_FOR_SUCCESS_3() {
        return new Class("READING AND WRITING FOR SUCCESS 3", 5, CP, ENGLISH_DEPARTMENT, 182);
    }

    public static Class READING_AND_WRITING_FOR_SUCCESS_4() {
        return new Class("READING AND WRITING FOR SUCCESS 4", 5, CP, ENGLISH_DEPARTMENT, 184);
    }

    public static Class SPEECH_AND_DRAMA() {
        return new Class("SPEECH AND DRAMA", 5, CP, ENGLISH_DEPARTMENT, 136);
    }

    public static Class AP_SEMINAR_HUMANITIES() {
        return new Class("AP SEMINAR: HUMANITIES", 5, AP, ENGLISH_DEPARTMENT, 234);
    }

    public static Class AP_RESEARCH_HUMANITIES() {
        return new Class("AP RESEARCH: HUMANITIES", 5, AP, ENGLISH_DEPARTMENT, 235);
    }

    public static Class WORLD_FILM() {
        return new Class("WORLD FILM", 5, CP, ENGLISH_DEPARTMENT, 138);
    }

    public static Class YEARBOOK() {
        return new Class("YEARBOOK", 5, CP, ENGLISH_DEPARTMENT, 155);
    }

    public static Class NEWSPAPER() {
        return new Class("NEWSPAPER", 5, CP, ENGLISH_DEPARTMENT, 157);
    }

    public static Class ENGLISH_ENRICHMENT_12() {
        return new Class("ENGLISH ENRICHMENT 12", 5, CP, ENGLISH_DEPARTMENT, 103);
    }

    public static Class MEDIA_LITERACY() {
        return new Class("MEDIA LITERACY", 2.5, CP, ENGLISH_DEPARTMENT, 134, HALF_YEAR);
    }

    public static Class SHAKESPEARE_AND_DRAMA() {
        return new Class("SHAKESPEARE AND DRAMA", 2.5, CP, ENGLISH_DEPARTMENT, 139, HALF_YEAR);
    }

    /*
     * =============================================================
     * ====================== FCS DEPARTMENT =======================
     * =============================================================
     */








    /* Other Useful Methods */
    public static double round(double in) {
        in *= 10;
        in += 0.5;
        double out = (int) in;
        return out / 10;
    }
}
