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
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.spring.annotation.UIScope;
import lhs.gpa.calculator.backend.*;
import lhs.gpa.calculator.views.main.MainView;

import java.util.*;

@Route(value = "generic-calculator", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PWA(name = "LHS Course Profiler", shortName = "LHS GPA",
     description = "Helps in the management of LHS Courses and helps calculate GPA")
@PreserveOnRefresh
@UIScope
@PageTitle("Generic GPA Calculator | GPA Genie")
public class GenericGPACalculator extends VerticalLayout {
    
    private final List<Course>     courseList     = new ArrayList<>();
    private final List<Department> departmentList = Department.getDepartments();
    private final List<Level>      levels         = Level.getLevels();
    
    public GenericGPACalculator() {
        genericGPACalculator();
    }
    
    public void genericGPACalculator() {
        FormLayout formLayout = new FormLayout();
        formLayout.setResponsiveSteps(
                new ResponsiveStep("0", 1),
                new ResponsiveStep("32em", 2),
                new ResponsiveStep("40em", 3),
                new ResponsiveStep("50em", 4),
                new ResponsiveStep("60em", 5),
                new ResponsiveStep("70em", 6),
                new ResponsiveStep("84em", 7)
        );
        
        for (int i = 0; i < 10; i++) {
            final Course course = new Course(false);
            course.setCredits(5);
            course.setGrade(Grade.A);
            course.setLevel(Level.CP);
            
            
            TextField courseName = new TextField("Course Name");
            courseName.addValueChangeListener(change -> {
                if (!course.isReal()) {
                    course.setReal(true);
                    courseList.add(course);
                }
                course.setName(change.getValue());
            });
            
            ComboBox<Department> department = new ComboBox<>("Course Department");
            department.setItems(departmentList);
            department.setRequiredIndicatorVisible(true);
            department.addValueChangeListener(change -> {
                if (!course.isReal()) {
                    course.setReal(true);
                    courseList.add(course);
                }
                course.setDepartment(change.getValue());
            });
            
            ComboBox<Level> levels = new ComboBox<>("Course Level");
            levels.setItems(this.levels);
            levels.setValue(Level.CP);
            levels.setRequiredIndicatorVisible(true);
            levels.addValueChangeListener(change -> {
                if (!course.isReal()) {
                    course.setReal(true);
                    courseList.add(course);
                }
                course.setLevel(change.getValue());
            });
            
            NumberField credits = new NumberField("Course Credits");
            credits.setHasControls(true);
            credits.setStep(0.5);
            credits.setValue(5D);
            credits.setRequiredIndicatorVisible(true);
            credits.addValueChangeListener(change -> {
                if (!course.isReal()) {
                    course.setReal(true);
                    courseList.add(course);
                }
                course.setCredits(change.getValue());
            });
            
            ComboBox<Grade> gradePicker = new ComboBox<>("Course Grade");
            gradePicker.setItems(Grade.gradeList());
            gradePicker.setValue(Grade.A);
            gradePicker.setRequiredIndicatorVisible(true);
            gradePicker.addValueChangeListener(change -> {
                if (!course.isReal()) {
                    course.setReal(true);
                    courseList.add(course);
                }
                course.setGrade(change.getValue());
            });
            
            formLayout.add(courseName, 2);
            formLayout.add(department, 2);
            formLayout.add(levels, 1);
            formLayout.add(credits, 1);
            formLayout.add(gradePicker, 1);
        }
        
        Button calculate = new Button("Calculate");
        calculate.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        calculate.addClickListener(buttonClickEvent -> {
            //Create the Notification For GPA
            Notification gpaNotify = new Notification();
            gpaNotify.setPosition(Notification.Position.MIDDLE);
            
            VerticalLayout GPAInfo = new VerticalLayout();
            
            CourseList courseList = new CourseList(this.courseList);
            GPAValue   gpaAll     = courseList.getAllCourseGPA();
            GPAValue   gpaCore    = courseList.getCoreGPA();
            GPAValue   gpaUW      = courseList.getUnweightedGPA();
            
            GPAInfo.add(new H2("Calculated GPA"));
            VerticalLayout gpaLevels = new VerticalLayout(
                    new Html("<p style='font-size:150%'><strong>Weighted All Course GPA: </strong></p>"),
                    new Html("<p style='font-size:150%'><strong>Weighted Core GPA: </strong></p>"),
                    new Html("<p style='font-size:150%'><strong>Unweighted GPA: </strong></p>")
            );
            gpaLevels.setWidth("23em");
            
            VerticalLayout gpa = new VerticalLayout(
                    new Html(String.format("<p style='font-size:150%%'>%s</p>", gpaAll.toString())),
                    new Html(String.format("<p style='font-size:150%%'>%s</p>", gpaCore.toString())),
                    new Html(String.format("<p style='font-size:150%%'>%s</p>", gpaUW.toString()))
            );
            gpa.setWidth("25%");
            
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
        
        add(formLayout, calculate);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setWidth("86em");
    }
}
