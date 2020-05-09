package lhs.gpa.calculator.backend;

import java.math.BigDecimal;
import java.util.*;

public class Level {
    private final String level;
    
    public static final Level CP     = new Level("CP");
    public static final Level HONORS = new Level("HONORS");
    public static final Level AP     = new Level("AP");
    
    private Level(String level) {
        this.level = level;
    }
    
    public String getLevel() {
        return level;
    }
    
    @Override
    public String toString() {
        return level;
    }
    
    public BigDecimal getGPAIncrement() {
        if (CP.equals(this)) {
            return new BigDecimal("0.00");
        } else if (HONORS.equals(this)) {
            return new BigDecimal("0.50");
        } else if (AP.equals(this)) {
            return new BigDecimal("1.00");
        } else return new BigDecimal("0.00");
    }
    
    public static Level getLevel(String level) {
        level = level.toUpperCase();
        switch (level) {
            case "HONORS":
                return HONORS;
            case "AP":
                return AP;
            default:
                return CP;
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Level level1 = (Level) o;
        
        return getLevel().equals(level1.getLevel());
    }

    public static List<Level> getLevels() {
        return new ArrayList<>(Arrays.asList(CP, HONORS, AP));
    }
}
