package lhs.gpa.calculator.backend;

public class ClassNumber {
    private final int    number;
    private       String addition = "";
    
    public ClassNumber(int number) {
        this.number = number;
    }
    
    public ClassNumber(int number, String addition) {
        this.number   = number;
        this.addition = addition;
    }
    
    public ClassNumber(String courseNumber) {
        this.number = Integer.parseInt(courseNumber.substring(0, 3));
        if (courseNumber.length() > 3) {
            addition = courseNumber.substring(3);
        }
    }
    
    public int getNumber() {
        return number;
    }
    
    public String getAddition() {
        return addition;
    }
    
    public void setAddition(String addition) {
        this.addition = addition;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        ClassNumber that = (ClassNumber) o;
        
        if (number != that.number) return false;
        return this.addition.equals(that.addition);
    }
    
    @Override
    public String toString() {
        String num = Integer.toString(number);
        while (num.length() < 3) num = "0" + num;
        
        return num + addition;
    }
}
