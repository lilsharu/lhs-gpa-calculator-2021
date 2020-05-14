package lhs.gpa.calculator.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import static lhs.gpa.calculator.backend.Class.FULL_YEAR;
import static lhs.gpa.calculator.backend.Class.HALF_YEAR;

public class ClassList {
    
    private static List<Class> classList;
    
    public static List<Class> getClassList(InputStream classFileData) {
        try {
            List<Class>    classList = new ArrayList<>(283);
            BufferedReader read      = new BufferedReader(new InputStreamReader(classFileData));
            String         line;
            while ((line = read.readLine()) != null) {
                StringTokenizer st   = new StringTokenizer(line, "|");
                String          name = st.nextToken();
                if (name.contains("###"))
                    continue;
                String     classNumber = st.nextToken();
                double     credits     = Double.parseDouble(st.nextToken());
                Level      level       = Level.parseLevel(st.nextToken());
                Department department  = Department.parseDepartment(st.nextToken());
                String     length;
    
                if (credits < 3) length = HALF_YEAR;
                else length = FULL_YEAR;
    
                classList.add(new Class(name, credits, level, department, classNumber, length));
            }
    
            classList.sort(Comparator.comparing(Class::getName));
    
            ClassList.classList = classList;
    
            return classList;
        } catch (IOException ioe) {
            throw new IllegalArgumentException("The Class File that was included contains errors");
        }
    }
    
    public static List<Class> getClassList(InputStream classFileData, Department department) {
        ArrayList<Class> classListIn = (ArrayList<Class>) getClassList(classFileData);
        List<Class>      classList   = (List<Class>) classListIn.clone();
        classList.removeIf(c -> !c.getDepartment().equals(department));
        
        return classList;
    }
    
    public static List<Class> getClassList(List<Class> classListIn, Department department) {
        List<Class> classList = (List<Class>) ((ArrayList<Class>) classListIn).clone();
        classList.removeIf(c -> !c.getDepartment().equals(department));
        
        return classList;
    }
}