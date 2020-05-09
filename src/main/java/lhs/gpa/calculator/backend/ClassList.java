package lhs.gpa.calculator.backend;

import static lhs.gpa.calculator.backend.Class.HALF_YEAR;
import static lhs.gpa.calculator.backend.Department.*;
import static lhs.gpa.calculator.backend.Level.*;

public class ClassList {
    /*
     * =============================================================
     * =================== BUSINESS DEPARTMENT =====================
     * =============================================================
     */
    public static final Class INTRODUCTION_TO_BUSINESS           = new Class("INTRODUCTION TO BUSINESS", 5, CP, BUSINESS_DEPARTMENT, 613);
    public static final Class COMPUTER_APPLICATIONS              = new Class("COMPUTER APPLICATIONS", 5, CP, BUSINESS_DEPARTMENT, 623);
    public static final Class CAREER_EXPLORATION                 = new Class("CAREER EXPLORATION", 5, CP, BUSINESS_DEPARTMENT, 771);
    public static final Class CAREER_INTERNSHIP_PROGRAM_1        = new Class("CAREER INTERNSHIP PROGRAM 1", 5, CP, BUSINESS_DEPARTMENT, 772);
    public static final Class CAREER_INTERNSHIP_PROGRAM_2        = new Class("CAREER INTERNSHIP PROGRAM 2", 5, CP, BUSINESS_DEPARTMENT, 773);
    public static final Class COMMUNITY_BASED_INSTRUCTION        = new Class("COMMUNITY BASED INSTRUCTION", 5, CP, BUSINESS_DEPARTMENT, 6);
    public static final Class ACCOUNTING_1                       = new Class("ACCOUNTING 1", 5, CP, BUSINESS_DEPARTMENT, 621);
    public static final Class ACCOUNTING_2                       = new Class("ACCOUNTING 2", 5, CP, BUSINESS_DEPARTMENT, 632);
    public static final Class COOPERATIVE_WORK_EXPERIENCE        = new Class("COOPERATIVE WORK EXPERIENCE", 15, CP, BUSINESS_DEPARTMENT, 642);
    public static final Class BUSINESS_LAW_1                     = new Class("BUSINESS LAW 1", 5, CP, BUSINESS_DEPARTMENT, 635);
    public static final Class BUSINESS_LAW_2                     = new Class("BUSINESS LAW 2", 5, CP, BUSINESS_DEPARTMENT, 638);
    public static final Class ENTREPRENEURSHIP                   = new Class("ENTREPRENEURSHIP", 5, CP, BUSINESS_DEPARTMENT, 636);
    public static final Class MARKETING                          = new Class("MARKETING", 5, CP, BUSINESS_DEPARTMENT, 634);
    public static final Class MICROSOFT_OFFICE_SPECIALIST        = new Class("MICROSOFT OFFICE SPECIALIST", 5, CP, BUSINESS_DEPARTMENT, 625);
    public static final Class GLOBAL_BUSINESS                    = new Class("GLOBAL BUSINESS", 5, CP, BUSINESS_DEPARTMENT, 640);
    public static final Class AP_ECONOMICS                       = new Class("AP ECONOMICS", 5, AP, BUSINESS_DEPARTMENT, 650);
    public static final Class ECONOMICS                          = new Class("ECONOMICS", 2.5, CP, BUSINESS_DEPARTMENT, 633, HALF_YEAR);
    public static final Class INVESTING                          = new Class("INVESTING", 2.5, CP, BUSINESS_DEPARTMENT, 614, HALF_YEAR);
    public static final Class PERSONAL_FINANCIAL_LITERACY        = new Class("PERSONAL FINANCIAL LITERACY", 2.5, CP, BUSINESS_DEPARTMENT, 626, HALF_YEAR);
    public static final Class PERSONAL_FINANCIAL_LITERACY_HYBRID = new Class("PERSONAL FINANCIAL LITERACY HYBRID", 2.5, CP, BUSINESS_DEPARTMENT, 626, HALF_YEAR);
    public static final Class SPORTS_AND_ENTERTAINMENT_MARKETING = new Class("SPORTS AND ENTERTAINMENT MARKETING", 2.5, CP, BUSINESS_DEPARTMENT, 615, HALF_YEAR);
    public static final Class SOCIAL_MEDIA_MARKETING             = new Class("SOCIAL MEDIA MARKETING", 2.5, CP, BUSINESS_DEPARTMENT, 616, HALF_YEAR);
    public static final Class WEB_DESIGN                         = new Class("WEB DESIGN", 2.5, CP, BUSINESS_DEPARTMENT, 627, HALF_YEAR);
    
    /*
     * =============================================================
     * ==================== ENGLISH DEPARTMENT =====================
     * =============================================================
     */
    public static final Class GENERAL_ENGLISH_1                     = new Class("GENERAL ENGLISH 1", 5, CP, ENGLISH_DEPARTMENT, 171);
    public static final Class ENGLISH_1_CP                          = new Class("ENGLISH 1 CP", 5, CP, ENGLISH_DEPARTMENT, 112);
    public static final Class ENGLISH_1_HUMANITIES_CP               = new Class("ENGLISH 1 HUMANITIES CP", 5, CP, ENGLISH_DEPARTMENT, 112);
    public static final Class ENGLISH_1_HONORS                      = new Class("ENGLISH 1 HONORS", 5, HONORS, ENGLISH_DEPARTMENT, 110);
    public static final Class ENGLISH_1_HUMANITIES_HONORS           = new Class("ENGLISH 1 HUMANITIES HONORS", 5, HONORS, ENGLISH_DEPARTMENT, 110);
    public static final Class GENERAL_ENGLISH_2                     = new Class("GENERAL ENGLISH 2", 5, CP, ENGLISH_DEPARTMENT, 172);
    public static final Class ENGLISH_2_CP                          = new Class("ENGLISH 2 CP", 5, CP, ENGLISH_DEPARTMENT, 122);
    public static final Class ENGLISH_2_HUMANITIES_CP               = new Class("ENGLISH 2 HUMANITIES CP", 5, CP, ENGLISH_DEPARTMENT, 122);
    public static final Class ENGLISH_2_HONORS                      = new Class("ENGLISH 2 HONORS", 5, HONORS, ENGLISH_DEPARTMENT, 120);
    public static final Class ENGLISH_2_HUMANITIES_HONORS           = new Class("ENGLISH 2 HUMANITIES HONORS", 5, HONORS, ENGLISH_DEPARTMENT, 120);
    public static final Class GENERAL_ENGLISH_3                     = new Class("GENERAL ENGLISH 3", 5, CP, ENGLISH_DEPARTMENT, 173);
    public static final Class ENGLISH_3_CP                          = new Class("ENGLISH 3 CP", 5, CP, ENGLISH_DEPARTMENT, 132);
    public static final Class ENGLISH_3_HUMANITIES_CP               = new Class("ENGLISH 3 HUMANITIES CP", 5, CP, ENGLISH_DEPARTMENT, 132);
    public static final Class ENGLISH_3_HONORS                      = new Class("ENGLISH 3 HONORS", 5, HONORS, ENGLISH_DEPARTMENT, 130);
    public static final Class ENGLISH_3_HUMANITIES_HONORS           = new Class("ENGLISH 3 HUMANITIES HONORS", 5, HONORS, ENGLISH_DEPARTMENT, 130);
    public static final Class AP_ENGLISH_LANGUAGE_AND_COMPOSITION   = new Class("AP ENGLISH LANGUAGE AND COMPOSITION", 5, AP, ENGLISH_DEPARTMENT, 131);
    public static final Class GENERAL_ENGLISH_4                     = new Class("GENERAL ENGLISH 4", 5, CP, ENGLISH_DEPARTMENT, 174);
    public static final Class ENGLISH_4_CP                          = new Class("ENGLISH 4 CP", 5, CP, ENGLISH_DEPARTMENT, 142);
    public static final Class ENGLISH_4_HONORS                      = new Class("ENGLISH 4 HONORS", 5, HONORS, ENGLISH_DEPARTMENT, 140);
    public static final Class AP_ENGLISH_LITERATURE_AND_COMPOSITION = new Class("AP ENGLISH LITERATURE AND COMPOSITION", 5, AP, ENGLISH_DEPARTMENT, 141);
    public static final Class CREATIVE_WRITING_1                    = new Class("CREATIVE WRITING 1", 5, CP, ENGLISH_DEPARTMENT, 118);
    public static final Class CREATIVE_WRITING_2                    = new Class("CREATIVE WRITING 2", 5, CP, ENGLISH_DEPARTMENT, 129);
    public static final Class CREATIVE_WRITING_3                    = new Class("CREATIVE WRITING 3", 5, CP, ENGLISH_DEPARTMENT, 149);
    public static final Class JOURNALISM                            = new Class("JOURNALISM", 5, CP, ENGLISH_DEPARTMENT, 125);
    public static final Class PUBLIC_SPEAKING_AND_DEBATE            = new Class("PUBLIC SPEAKING AND DEBATE", 5, CP, ENGLISH_DEPARTMENT, 135);
    public static final Class READING_AND_WRITING_FOR_SUCCESS_1     = new Class("READING AND WRITING FOR SUCCESS 1", 5, CP, ENGLISH_DEPARTMENT, 180);
    public static final Class READING_AND_WRITING_FOR_SUCCESS_2     = new Class("READING AND WRITING FOR SUCCESS 2", 5, CP, ENGLISH_DEPARTMENT, 181);
    public static final Class READING_AND_WRITING_FOR_SUCCESS_3     = new Class("READING AND WRITING FOR SUCCESS 3", 5, CP, ENGLISH_DEPARTMENT, 182);
    public static final Class READING_AND_WRITING_FOR_SUCCESS_4     = new Class("READING AND WRITING FOR SUCCESS 4", 5, CP, ENGLISH_DEPARTMENT, 184);
    public static final Class SPEECH_AND_DRAMA                      = new Class("SPEECH AND DRAMA", 5, CP, ENGLISH_DEPARTMENT, 136);
    public static final Class AP_SEMINAR_HUMANITIES                 = new Class("AP SEMINAR: HUMANITIES", 5, AP, ENGLISH_DEPARTMENT, 234);
    public static final Class AP_RESEARCH_HUMANITIES                = new Class("AP RESEARCH: HUMANITIES", 5, AP, ENGLISH_DEPARTMENT, 235);
    public static final Class WORLD_FILM                            = new Class("WORLD FILM", 5, CP, ENGLISH_DEPARTMENT, 138);
    public static final Class YEARBOOK                              = new Class("YEARBOOK", 5, CP, ENGLISH_DEPARTMENT, 155);
    public static final Class NEWSPAPER                             = new Class("NEWSPAPER", 5, CP, ENGLISH_DEPARTMENT, 157);
    public static final Class ENGLISH_ENRICHMENT_12                 = new Class("ENGLISH ENRICHMENT 12", 5, CP, ENGLISH_DEPARTMENT, 103);
    public static final Class MEDIA_LITERACY                        = new Class("MEDIA LITERACY", 2.5, CP, ENGLISH_DEPARTMENT, 134, HALF_YEAR);
    public static final Class SHAKESPEARE_AND_DRAMA                 = new Class("SHAKESPEARE AND DRAMA", 2.5, CP, ENGLISH_DEPARTMENT, 139, HALF_YEAR);
    public static final Class ENGLISH_FOR_SUCCESS_1                 = new Class("ENGLISH FOR SUCCESS 1", 5, CP, ENGLISH_DEPARTMENT, 116);
    public static final Class ENGLISH_FOR_SUCCESS_2                 = new Class("ENGLISH FOR SUCCESS 2", 5, CP, ENGLISH_DEPARTMENT, 117);
    
    /*
     * =============================================================
     * ====================== FCS DEPARTMENT =======================
     * =============================================================
     */
    public static final Class FASHION_1                           = new Class("FASHION 1", 5, CP, FCS_DEPARTMENT, 711);
    public static final Class FASHION_2                           = new Class("FASHION 2", 5, CP, FCS_DEPARTMENT, 721);
    public static final Class FOODS_AND_NUTRITION                 = new Class("FOODS AND NUTRITION", 5, CP, FCS_DEPARTMENT, 722);
    public static final Class SENIOR_SERVICE                      = new Class("SENIOR SERVICE", 5, CP, FCS_DEPARTMENT, 658);
    public static final Class INTERIOR_DESIGN                     = new Class("INTERIOR DESIGN", 2.5, CP, FCS_DEPARTMENT, 712);
    public static final Class HOTEL_AND_RESTAURANT_MANAGEMENT     = new Class("HOTEL AND RESTAURANT MANAGEMENT", 2.5, CP, FCS_DEPARTMENT, 720);
    public static final Class FAMILY_AND_CHILD_DEVELOPMENT_1      = new Class("FAMILY AND CHILD DEVELOPMENT 1", 2.5, CP, FCS_DEPARTMENT, 730);
    public static final Class FAMILY_AND_CHILD_DEVELOPMENT_2      = new Class("FAMILY AND CHILD DEVELOPMENT 2", 2.5, CP, FCS_DEPARTMENT, 737);
    public static final Class INDEPENDENT_STUDY_IN_TECHNOLOGY_746 = new Class("INDEPENDENT STUDY IN TECHNOLOGY", 2.5, CP, FCS_DEPARTMENT, 746, HALF_YEAR);
    public static final Class INDEPENDENT_STUDY_IN_TECHNOLOGY_747 = new Class("INDEPENDENT STUDY IN TECHNOLOGY", 2.5, CP, FCS_DEPARTMENT, 747);
    
    /*
     * =============================================================
     * ================= HEALTH AND PE DEPARTMENT ==================
     * =============================================================
     */
    public static final Class PHYSICAL_EDUCATION_HEALTH_9                   = new Class("PHYSICAL EDUCATION 9/HEALTH 9", 2.5, CP, PE_DEPARTMENT, 15, HALF_YEAR);
    public static final Class PHYSICAL_EDUCATION_9                          = new Class("PHYSICAL EDUCATION 9", 2.5, CP, PE_DEPARTMENT, 15);
    public static final Class PHYSICAL_EDUCATION_10_DRIVER_EDUCATION        = new Class("PHYSICAL EDUCATION 10/DRIVER EDUCATION", 2.5, CP, PE_DEPARTMENT, 25, HALF_YEAR);
    public static final Class PHYSICAL_EDUCATION_10                         = new Class("PHYSICAL EDUCATION 10", 2.5, CP, PE_DEPARTMENT, 25, HALF_YEAR);
    public static final Class PHYSICAL_EDUCATION_11                         = new Class("PHYSICAL EDUCATION 11", 2.5, CP, PE_DEPARTMENT, 35, HALF_YEAR);
    public static final Class PHYSICAL_EDUCATION_HEALTH_11                  = new Class("PHYSICAL EDUCATION/HEALTH 11", 2.5, CP, PE_DEPARTMENT, 35, HALF_YEAR);
    public static final Class PHYSICAL_EDUCATION_12                         = new Class("PHYSICAL EDUCATION 12", 2.5, CP, PE_DEPARTMENT, 45, HALF_YEAR);
    public static final Class PHYSICAL_EDUCATION_HEALTH_12                  = new Class("PHYSICAL EDUCATION/HEALTH 12", 2.5, CP, PE_DEPARTMENT, 45, HALF_YEAR);
    public static final Class ADAPTED_PHYSICAL_EDUCATION_AND_GENERAL_HEALTH = new Class("ADAPTED PHYSICAL EDUCATION & GENERAL HEALTH", 5, CP, PE_DEPARTMENT, 55, HALF_YEAR);
    public static final Class DANCE                                         = new Class("DANCE", 2.5, CP, PE_DEPARTMENT, 65, HALF_YEAR);
    
    /*
     * =============================================================
     * ================== MATHEMATICS DEPARTMENT ===================
     * =============================================================
     */
    public static final Class GENERAL_PRE_ALGEBRA                = new Class("GENERAL PRE-ALGEBRA", 5, CP, MATH_DEPARTMENT, 377);
    public static final Class GENERAL_ALGEBRA                    = new Class("GENERAL ALGEBRA", 5, CP, MATH_DEPARTMENT, 376);
    public static final Class ALGEBRA_1_LAB_CP                   = new Class("ALGEBRA 1 LAB CP", 5, CP, MATH_DEPARTMENT, 316);
    public static final Class ALGEBRA_1_CP                       = new Class("ALGEBRA 1 CP", 5, CP, MATH_DEPARTMENT, 312);
    public static final Class ALGEBRA_1_NJSLA_LAB                = new Class("ALGEBRA 1 NJSLA LAB", 5, CP, MATH_DEPARTMENT, 317);
    public static final Class ALGEBRA_1_HONORS                   = new Class("ALGEBRA 1 HONORS", 5, HONORS, MATH_DEPARTMENT, 313);
    public static final Class GENERAL_GEOMETRY                   = new Class("GENERAL GEOMETRY", 5, CP, MATH_DEPARTMENT, 378);
    public static final Class GEOMETRY_LAB_CP                    = new Class("GEOMETRY LAB CP", 5, CP, MATH_DEPARTMENT, 321);
    public static final Class GEOMETRY_CP                        = new Class("GEOMETRY CP", 5, CP, MATH_DEPARTMENT, 322);
    public static final Class GEOMETRY_HONORS                    = new Class("GEOMETRY HONORS", 5, HONORS, MATH_DEPARTMENT, 310);
    public static final Class GENERAL_INTERMEDIATE_ALGEBRA       = new Class("GENERAL INTERMEDIATE ALGEBRA", 5, CP, MATH_DEPARTMENT, 379);
    public static final Class INTERMEDIATE_ALGEBRA               = new Class("INTERMEDIATE ALGEBRA", 5, CP, MATH_DEPARTMENT, 329);
    public static final Class ALGEBRA_2_LAB_CP                   = new Class("ALGEBRA 2 LAB CP", 10, CP, MATH_DEPARTMENT, 318);
    public static final Class ALGEBRA_2_CP                       = new Class("ALGEBRA 2 CP", 5, CP, MATH_DEPARTMENT, 332);
    public static final Class ALGEBRA_2_HONORS                   = new Class("ALGEBRA 2 HONORS", 5, HONORS, MATH_DEPARTMENT, 320);
    public static final Class APPLICATION_OF_MATHEMATICS         = new Class("APPLICATION OF MATHEMATICS", 5, CP, MATH_DEPARTMENT, 374);
    public static final Class PRECALCULUS_CP                     = new Class("PRECALCULUS CP", 5, CP, MATH_DEPARTMENT, 342);
    public static final Class COLLEGE_ALGEBRA_AND_TRIGONOMETRY   = new Class("COLLEGE ALGEBRA AND TRIGONOMETRY", 5, CP, MATH_DEPARTMENT, 345);
    public static final Class COLLEGE_MATH_SEMINAR               = new Class("COLLEGE MATH SEMINAR", 5, CP, MATH_DEPARTMENT, 348);
    public static final Class PRECALCULUS_HONORS                 = new Class("PRECALCULUS HONORS", 5, HONORS, MATH_DEPARTMENT, 331);
    public static final Class CALCULUS_CP                        = new Class("CALCULUS CP", 5, CP, MATH_DEPARTMENT, 347);
    public static final Class AP_CALCULUS_AB                     = new Class("AP CALCULUS AB", 5, AP, MATH_DEPARTMENT, 351);
    public static final Class INTRODUCTION_TO_CALCULUS_BC_HONORS = new Class("INTRODUCTION TO CALCULUS BC HONORS", 5, HONORS, MATH_DEPARTMENT, 340);
    public static final Class AP_CALCULUS_BC                     = new Class("AP CALCULUS BC", 5, AP, MATH_DEPARTMENT, 350);
    public static final Class MULTIVARIABLE_CALCULUS             = new Class("MULTIVARIABLE CALCULUS", 5, AP, MATH_DEPARTMENT, 349);
    public static final Class COMPUTER_PROGRAMMING               = new Class("COMPUTER PROGRAMMING", 5, CP, MATH_DEPARTMENT, 315, HALF_YEAR);
    public static final Class AP_STATISTICS                      = new Class("AP STATISTICS", 5, AP, MATH_DEPARTMENT, 352);
    public static final Class AP_COMPUTER_SCIENCE_A              = new Class("AP COMPUTER SCIENCE A", 5, AP, MATH_DEPARTMENT, 353);
    public static final Class MATH_ENRICHMENT_12                 = new Class("MATH ENRICHMENT 12", 2.5, CP, MATH_DEPARTMENT, 303, HALF_YEAR);
    public static final Class DATA_ANALYSIS_AND_PROBABILITY      = new Class("DATA ANALYSIS & PROBABILITY", 2.5, CP, MATH_DEPARTMENT, 360, HALF_YEAR);
    public static final Class STATISTICS                         = new Class("STATISTICS", 2.5, CP, MATH_DEPARTMENT, 361, HALF_YEAR);
    
    /*
     * =============================================================
     * ================ PERFORMING ARTS DEPARTMENT =================
     * =============================================================
     */
    public static final Class CONCERT_BAND           = new Class("CONCERT BAND", 5, CP, PERFORMING_ARTS_DEPARTMENT, 909);
    public static final Class CONCERT_BAND_CHORUS    = new Class("CONCERT BAND/CHORUS", 5, CP, PERFORMING_ARTS_DEPARTMENT, 909);
    public static final Class CONCERT_CHORUS         = new Class("CONCERT CHORUS", 5, CP, PERFORMING_ARTS_DEPARTMENT, 912);
    public static final Class MUSIC_TECHNOLOGY_1     = new Class("MUSIC TECHNOLOGY 1", 5, CP, PERFORMING_ARTS_DEPARTMENT, 916);
    public static final Class MUSIC_TECHNOLOGY_2     = new Class("MUSIC TECHNOLOGY 2", 5, CP, PERFORMING_ARTS_DEPARTMENT, 917);
    public static final Class MUSIC_THEORY           = new Class("MUSIC THEORY", 5, CP, PERFORMING_ARTS_DEPARTMENT, 915);
    public static final Class AP_MUSIC_THEORY        = new Class("AP MUSIC THEORY", 5, AP, PERFORMING_ARTS_DEPARTMENT, 950);
    public static final Class ORCHESTRA_CHORUS       = new Class("ORCHESTRA/CHORUS", 5, CP, PERFORMING_ARTS_DEPARTMENT, 914);
    public static final Class STRING_ORCHESTRA       = new Class("STRING ORCHESTRA", 5, CP, PERFORMING_ARTS_DEPARTMENT, 914);
    public static final Class SYMPHONIC_BAND         = new Class("SYMPHONIC BAND", 5, CP, PERFORMING_ARTS_DEPARTMENT, 911);
    public static final Class SYMPHONIC_BAND_CHORUS  = new Class("SYMPHONIC BAND/CHORUS", 5, CP, PERFORMING_ARTS_DEPARTMENT, 911);
    public static final Class THEATRE_ARTS           = new Class("THEATRE ARTS", 5, CP, PERFORMING_ARTS_DEPARTMENT, 930);
    public static final Class WIND_SYMPHONY          = new Class("WIND SYMPHONY", 5, CP, PERFORMING_ARTS_DEPARTMENT, 910);
    public static final Class AMERICAN_POPULAR_MUSIC = new Class("AMERICAN POPULAR MUSIC", 2.5, CP, PERFORMING_ARTS_DEPARTMENT, 913, HALF_YEAR);
    public static final Class BEGINNER_GUITAR        = new Class("BEGINNER GUITAR", 2.5, CP, PERFORMING_ARTS_DEPARTMENT, 918, HALF_YEAR);
    public static final Class BEGINNER_PIANO         = new Class("BEGINNER PIANO", 2.5, CP, PERFORMING_ARTS_DEPARTMENT, 919, HALF_YEAR);
    
}