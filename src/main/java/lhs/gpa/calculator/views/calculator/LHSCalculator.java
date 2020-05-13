package lhs.gpa.calculator.views.calculator;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.PWA;
import lhs.gpa.calculator.backend.Class;
import lhs.gpa.calculator.backend.ClassList;
import lhs.gpa.calculator.views.main.MainView;

import java.util.*;

@Route(value = "lhs-calculator", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PWA(name = "LHS Course Profiler", shortName = "LHS GPA",
     description = "Helps in the management of LHS Courses and helps calculate GPA")
@PreserveOnRefresh
public class LHSCalculator extends VerticalLayout {
    
    private final List<Class> classList = ClassList.getClassList(this.getClass().getResourceAsStream("/data/class-list.classes"));
    
    public LHSCalculator() {
        add(new H2("Hello"));
        getClassList();
    }
    
    public void getClassList() {
    
    }
}