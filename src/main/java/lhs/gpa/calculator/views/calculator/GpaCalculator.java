package lhs.gpa.calculator.views.calculator;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import lhs.gpa.calculator.views.main.MainView;

@Route(value = "calculator", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
public class GpaCalculator extends VerticalLayout {

}
