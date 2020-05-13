package lhs.gpa.calculator.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class ClassList {
    
    private final List<Class> classList;
    
    private ClassList(List<Class> classList) {
        this.classList = classList;
    }
    
    public static List<Class> getClassList(InputStream classFileData) {
        try {
            List<Class>    classList = new ArrayList<>(283);
            BufferedReader read      = new BufferedReader(new InputStreamReader(classFileData));
            String         line;
            while ((line = read.readLine()) != null) {
                System.out.println(line);
                StringTokenizer st   = new StringTokenizer(line, "|");
                String          name = st.nextToken();
                if (name.contains("###"))
                    continue;
                String     classNumber = st.nextToken();
                double     credits     = Double.parseDouble(st.nextToken());
                Level      level       = Level.parseLevel(st.nextToken());
                Department department  = Department.parseDepartment(st.nextToken());
    
                classList.add(new Class(name, credits, level, department, classNumber));
            }
    
            classList.sort(Comparator.comparing(Class::getName));
    
            return classList;
        } catch (IOException ioe) {
            throw new IllegalArgumentException("The Class File that was included contains errors");
        }
    }
}