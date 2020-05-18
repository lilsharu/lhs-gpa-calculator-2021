package lhs.gpa.calculator.views.calculator;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.PWA;
import lhs.gpa.calculator.backend.Class;
import lhs.gpa.calculator.backend.ClassList;
import lhs.gpa.calculator.backend.Course;
import lhs.gpa.calculator.backend.Grade;
import lhs.gpa.calculator.views.main.MainView;

import java.util.*;

@Route(value = "lhs-calculator/all-years", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PWA(name = "LHS Course Profiler", shortName = "LHS GPA",
     description = "Helps in the management of LHS Courses and helps calculate GPA")
@PageTitle("All Years Calculator | GPA Genie")
public class AllYearsLHSCalculator extends VerticalLayout {
    private final List<Class> classList    = ClassList.getClassList(this.getClass().getResourceAsStream("/data/class-list.classes"));
    private final List<Grade> gradeChoices = Grade.gradeList();
    
    private final VerticalLayout freshmanYear  = new VerticalLayout();
    private final VerticalLayout sophomoreYear = new VerticalLayout();
    private final VerticalLayout juniorYear    = new VerticalLayout();
    private final VerticalLayout seniorYear    = new VerticalLayout();
    
    private final List<Course> freshmanCourses  = new ArrayList<>();
    private final List<Course> sophomoreCourses = new ArrayList<>();
    private final List<Course> juniorCourses    = new ArrayList<>();
    private final List<Course> seniorCourses    = new ArrayList<>();
    
    private final List<List<Course>>   courseList = Arrays.asList(freshmanCourses, sophomoreCourses, juniorCourses, seniorCourses);
    private final List<VerticalLayout> layoutList = Arrays.asList(freshmanYear, sophomoreYear, juniorYear, seniorYear            );
    
    private int currentCourseYearSelection = 0;
    
    private Button calculateButton        = new Button("Calculate"           );
    private Button calculateWithMaxButton = new Button("Calculate (With Max)");
    private Button clearButton            = new Button("Clear"               );
    
    public AllYearsLHSCalculator() {
        setUpYears();
    }
    
    public void setUpYears() {
        for (int i = 0; i < layoutList.size(); i++) {
            VerticalLayout v = layoutList.get(i);
            String year = String.format("%s Year", getYear(i));
            
            H1 heading = new H1(year);
            v.add(heading);
            
            HorizontalLayout buttonBar = getButtonBar(i);
            v.add(buttonBar);
            
            v.setHorizontalComponentAlignment(Alignment.CENTER, heading, buttonBar);
            
            FormLayout formLayout = new FormLayout();
            formLayout.setResponsiveSteps(
                    new ResponsiveStep("0", 1),
                    new ResponsiveStep("40em", 7)
            );
            
            List<Course> courses = courseList.get(i);
            
            for (int x = 0; x < 10; x++) {
                Course current;
                if (courseList.get(i).size() > x) {
                    current = courses.get(x);
                } else {
                    current = new Course(false);
                    courses.add(current);
                }
    
                ComboBox<Class> classChoices = new ComboBox<>("Class", classList);
                try {
                    classChoices.setValue(current.getaClass());
                } catch (Exception e) {
                    //Ignore it
                }
    
                ComboBox<Grade> firstSemester = new ComboBox<>("First Semester", gradeChoices);
                try {
                    firstSemester.setValue(current.getFirstSemester());
                } catch (Exception e) {
                    //Ignore it
                }
    
                ComboBox<Grade> secondSemester = new ComboBox<>("Second Semester", gradeChoices);
                try {
                    secondSemester.setValue(current.getSecondSemester());
                } catch (Exception e) {
                    //Ignore it
                }
    
                ComboBox<Grade> finalsGrade = new ComboBox<>("Finals (If Applicable)", gradeChoices);
                try {
                    finalsGrade.setValue(current.getFinals());
                } catch (Exception e) {
                    //Ignore it
                }
    
                ComboBox<Grade> gradeValue = new ComboBox<>("Final Grade", gradeChoices);
                gradeValue.setEnabled(false);
                try {
                    gradeValue.setValue(current.getGrade());
                } catch (Exception e) {
                    //Ignore it
                }
                
                classChoices.addValueChangeListener(onChange -> {
                    try {
                        current.setClass(onChange.getValue());
                        current.setReal(firstSemester.getValue() != null);
                    } catch (Exception e) {
                        //Do Nothing
                    }
                });
    
                firstSemester.addValueChangeListener(grade -> {
                    current.setFirstSemester(grade.getValue());
                    current.setReal(classChoices.getValue() != null);
                    gradeValue.setValue(current.getGrade());
                });
    
                secondSemester.addValueChangeListener(grade -> {
                    current.setSecondSemester(grade.getValue());
                    gradeValue.setValue(current.getGrade());
                });
    
                finalsGrade.addValueChangeListener(grade -> {
                    current.setFinals(grade.getValue());
                    gradeValue.setValue(current.getGrade());
                });
    
                formLayout.add(classChoices, 3);
                formLayout.add(firstSemester, 1);
                formLayout.add(secondSemester, 1);
                formLayout.add(finalsGrade, 1);
                formLayout.add(gradeValue, 1);
            }
        }
    }
    
    public HorizontalLayout getButtonBar(int year) {
    
    }
    
    public String getYear(int year) {
        switch(year) {
            case -1:
            case 0:
                return "Freshman";
            case 1:
                return "Sophomore";
            case 2:
                return "Junior";
            default:
                return "Senior";
        }
    }
}
