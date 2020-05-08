package lhs.gpa.calculator.backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level {
    private String level;

    public static final Level CP = new Level("CP");
    public static final Level HONORS = new Level("HONORS");
    public static final Level AP = new Level("AP");

    private Level(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return level;
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
    public boolean equals(Object obj) {
        if (!(obj instanceof Level)) return false;
        else return level.equals(((Level) obj).getLevel());
    }

    public static List<Level> getLevels() {
        return new ArrayList<>(Arrays.asList(CP, HONORS, AP));
    }
}
