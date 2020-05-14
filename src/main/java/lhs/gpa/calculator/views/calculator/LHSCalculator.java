package lhs.gpa.calculator.views.calculator;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.PWA;
import lhs.gpa.calculator.backend.Class;
import lhs.gpa.calculator.backend.*;
import lhs.gpa.calculator.views.main.MainView;

import java.util.*;

@Route(value = "lhs-calculator/single-year", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PWA(name = "LHS Course Profiler", shortName = "LHS GPA",
     description = "Helps in the management of LHS Courses and helps calculate GPA")
@PreserveOnRefresh
public class LHSCalculator extends VerticalLayout {
    
    private final List<Class>      classList            = ClassList.getClassList(this.getClass().getResourceAsStream("/data/class-list.classes"));
    private final List<Department> departments          = Department.getDepartments();
    private final List<Grade>      gradeChoices         = Grade.gradeList();
    private final HorizontalLayout fullYearOption       = new HorizontalLayout();
    private final HorizontalLayout singleSemesterOption = new HorizontalLayout();
    
    List<Course> singleSemesterCourses = new ArrayList<>(10);
    
    public LHSCalculator() {
        departments.add(Department.ALL_DEPARTMENTS);
        add(new H2("Single Year Calculator"));
        ComboBox<String> numSelect = new ComboBox<>();
        numSelect.setItems("Single Semester", "Full Year");
        numSelect.setLabel("Type of Selection");
        numSelect.addValueChangeListener(valueChangeEvent -> {
            if (valueChangeEvent.getValue().contains("Single")) {
                setSingleSemesterOption();
            } else if (valueChangeEvent.getValue().contains("Full")) {
                setFullYearOption();
            }
        });
        
        add(numSelect);
    }
    
    public void setSingleSemesterOption() {
        try {
            remove(fullYearOption);
        } catch (Exception e) {
            //Do Nothing
        }
    
        FormLayout formLayout = new FormLayout();
        formLayout.setResponsiveSteps(
                new ResponsiveStep("0", 1),
                new ResponsiveStep("32em", 2),
                new ResponsiveStep("40em", 3),
                new ResponsiveStep("50em", 4),
                new ResponsiveStep("60em", 5)
        );
    
        for (int i = 0; i < 10; i++) {
            Course current;
            if (singleSemesterCourses.size() >= 10) {
                current = singleSemesterCourses.get(i);
            } else {
                current = new Course(false);
                singleSemesterCourses.add(current);
            }
        
            ComboBox<Class> classChoices = new ComboBox<>("Class", classList);
            try {
                classChoices.setValue(current.getaClass());
            } catch (Exception e) {
                //Ignore it
            }
            ComboBox<Grade> gradeComboBox = new ComboBox<>("Grade", gradeChoices);
            try {
                gradeComboBox.setValue(current.getGrade());
            } catch (Exception e) {
                //Ignore it
            }
            classChoices.addValueChangeListener(onChange -> {
                try {
                    current.setClass(onChange.getValue());
                    current.setReal(gradeComboBox.getValue() != null);
                } catch (Exception e) {
                    //Do Nothing
                }
            });
        
            gradeComboBox.addValueChangeListener(grade -> {
                current.setGrade(grade.getValue());
                current.setReal(classChoices.getValue() != null);
            });
        
            ComboBox<Department> departmentComboBox = new ComboBox<>("Department (For Sorting)", departments);
            departmentComboBox.setValue(Department.ALL_DEPARTMENTS);
            departmentComboBox.addValueChangeListener(onChange -> {
                if (onChange.getValue().equals(Department.ALL_DEPARTMENTS)) classChoices.setItems(classList);
                else classChoices.setItems(ClassList.getClassList(classList, onChange.getValue()));
            });
        
            formLayout.add(departmentComboBox, 2);
            formLayout.add(classChoices, 2);
            formLayout.add(gradeComboBox, 1);
        }
    
        Button calculate        = createCalculateButton("Calculate", singleSemesterCourses, false);
        Button calculateWithMax = createCalculateButton("Calculate (With Max)", singleSemesterCourses, true);
    
        HorizontalLayout buttonBar = new HorizontalLayout(calculate, calculateWithMax);
    
        add(formLayout, buttonBar);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setWidth("86em");
    }
    
    public void setFullYearOption() {
        try {
            remove(singleSemesterOption);
        } catch (Exception e) {
            //Do Nothing
        }
    }
    
    public Button createCalculateButton(String buttonName, List<Course> courseListIn, boolean withMax) {
        Button calculate = new Button(buttonName);
        calculate.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        calculate.addClickListener(buttonClickEvent -> {
            //Create the Notification For GPA
            Notification gpaNotify = new Notification();
            gpaNotify.setPosition(Notification.Position.MIDDLE);
            
            VerticalLayout GPAInfo = new VerticalLayout();
            
            CourseList courseList = new CourseList(courseListIn);
            GPAValue   gpaAll     = courseList.getAllCourseGPA();
            GPAValue   gpaAllMax  = courseList.getMaxAllCourseGPA();
            GPAValue   gpaCore    = courseList.getCoreGPA();
            GPAValue   gpaCoreMax = courseList.getMaxCoreGPA();
            GPAValue   gpaUW      = courseList.getUnweightedGPA();
            GPAValue   gpaUWMax   = courseList.getMaxUnweightedGPA();
            
            VerticalLayout gpa;
            
            if (withMax) {
                GPAInfo.add(new H2("Calculated GPA: Current/Max"));
                
                gpa = new VerticalLayout(
                        new Html(String.format("<p style='font-size:150%%'>%s/%s</p>", gpaAll.toString(), gpaAllMax.toString())),
                        new Html(String.format("<p style='font-size:150%%'>%s/%s</p>", gpaCore.toString(), gpaCoreMax.toString())),
                        new Html(String.format("<p style='font-size:150%%'>%s/%s</p>", gpaUW.toString(), gpaUWMax.toString()))
                );
            } else {
                GPAInfo.add(new H2("Calculated GPA"));
                
                gpa = new VerticalLayout(
                        new Html(String.format("<p style='font-size:150%%'>%s</p>", gpaAll.toString())),
                        new Html(String.format("<p style='font-size:150%%'>%s</p>", gpaCore.toString())),
                        new Html(String.format("<p style='font-size:150%%'>%s</p>", gpaUW.toString()))
                );
            }
            
            gpa.setWidth("25%");
            
            VerticalLayout gpaLevels = new VerticalLayout(
                    new Html("<p style='font-size:150%'><strong>Weighted All Course GPA: </strong></p>"),
                    new Html("<p style='font-size:150%'><strong>Weighted Core GPA: </strong></p>"),
                    new Html("<p style='font-size:150%'><strong>Unweighted GPA: </strong></p>")
            );
            
            gpaLevels.setWidth("23em");
            
            
            HorizontalLayout gpaValues = new HorizontalLayout(gpaLevels, gpa);
            gpaValues.setSpacing(false);
            gpaValues.setJustifyContentMode(JustifyContentMode.CENTER);
            gpaValues.setSizeFull();
            
            GPAInfo.add(gpaValues);
            
            GPAInfo.setWidth("100%");
            GPAInfo.setHeight("100%");
            
            GPAInfo.setJustifyContentMode(JustifyContentMode.CENTER);
            GPAInfo.setAlignItems(Alignment.CENTER);
            
            Button closeNotification = new Button("Close", buttonClickEvent1 -> gpaNotify.close());
            closeNotification.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
            
            GPAInfo.add(closeNotification);
            
            gpaNotify.add(GPAInfo);
            
            gpaNotify.open();
        });
        
        return calculate;
    }
}