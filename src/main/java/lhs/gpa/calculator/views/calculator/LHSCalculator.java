package lhs.gpa.calculator.views.calculator;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.PWA;
import lhs.gpa.calculator.backend.Class;
import lhs.gpa.calculator.backend.ClassList;
import lhs.gpa.calculator.views.main.MainView;

import java.util.*;

@Route(value = "lhs-calculator/single-year", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PWA(name = "LHS Course Profiler", shortName = "LHS GPA",
     description = "Helps in the management of LHS Courses and helps calculate GPA")
@PreserveOnRefresh
public class LHSCalculator extends VerticalLayout {
    
    private final List<Class>      classList            = ClassList.getClassList(this.getClass().getResourceAsStream("/data/class-list.classes"));
    private final HorizontalLayout fullYearOption       = new HorizontalLayout();
    private final HorizontalLayout singleSemesterOption = new HorizontalLayout();
    
    public LHSCalculator() {
        add(new H2("Single Year Calculator"));
        Select<String> numSelect = new Select<>("Single Semester", "Full Year");
        numSelect.setLabel("Number of Input Fields");
        numSelect.addValueChangeListener(valueChangeEvent -> {
            if (valueChangeEvent.getValue().contains("Single")) {
                setSingleSemesterOption();
            } else if (valueChangeEvent.getValue().contains("Full")) {
                setFullYearOption();
            }
        });
    }
    
    public void setSingleSemesterOption() {
        try {
            remove(fullYearOption);
        } catch (Exception e) {
            //Do Nothing
        }
        
        
    }
    
    public void setFullYearOption() {
        try {
            remove(singleSemesterOption);
        } catch (Exception e) {
            //Do Nothing
        }
    }
}