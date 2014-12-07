/*
 * Demonstrates basic exception handling.
 * Demonstrates constructor overloading and copy constructor
 * From "Java How To Program, 10/e, Early Objects" - Chapter 8.
 */

public class Time {
    private int hour;
    private int minute;
    private int second;
    
    //Constructor with 3 values
    //Throws exception if invalid
    public Time(int nHour, int nMinute, int nSecond) {
        if (nHour <0 || nHour > 24 || nMinute < 0 || nMinute >= 60 || nSecond < 0 || nSecond >= 60 ) {
            throw new IllegalArgumentException ("Invalid initial Time");
        }
        
        this.hour = nHour;
        this.minute = nMinute;
        this.second = nSecond;
    }
    
    //Constructor with hour and minute
    public Time(int nHour, int nMinute) {
        this(nHour, nMinute, 0);
    }
    
    //Constructor with just hour
    public Time(int nHour) {
        this(nHour, 0, 0);
    }
    
    //Default constructor
    public Time() {
        this(0,0,0);
    }
    
    //Copy constructor
    public Time(Time nTime) {
        this(nTime.getHour(), nTime.getMinute(), nTime.getSecond());
    }
    
    //Setters and getters
    
    //Sets time, throws exception if invalid value
    public void setTime(int nHour, int nMinute, int nSecond) {
        //Validate time
        if (nHour <0 || nHour > 24 || nMinute < 0 || nMinute >= 60 || nSecond < 0 || nSecond >= 60 ) {
            throw new IllegalArgumentException ("Invalid Time");
        }
        
        this.hour = nHour;
        this.minute = nMinute;
        this.second = nSecond;
    }
    
    public void setHour(int nHour) {
        if(nHour < 0 || nHour > 24) {
            throw new IllegalArgumentException("Invalid hour");
        }
        
        this.hour = nHour;
    }
    
    public void setMinute(int nMinute) {
        if(nMinute < 0 || nMinute >= 60) {
            throw new IllegalArgumentException("Invalid minute");
        }
        
        this.minute = nMinute;
    }
    
    public void setSecond(int nSecond) {
        if(nSecond < 0 || nSecond >= 60) {
            throw new IllegalArgumentException("Invalid second");
        }
        
        this.minute = nSecond;
    } 
    
    public int getHour() {
        return hour;
    }
    
    public int getMinute(){
        return minute;
    }
    
    public int getSecond(){
        return second;
    }
    
    //Methods for string conversion
    //Convert to universal time HH:MM:SS
    public String toUniString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
    
    //Convert to standard time H:MM:SS AM or PM
    public String toString() {
        return String.format("%d:%02d:%02d %s",((hour == 0 || hour == 12) ? 12 : hour % 12), minute, second, (hour < 12 ? "AM" : "PM")); 
    }
    
    //Test class for Time
    public static void main(String[] args) {
        Time myTime = new Time();
        
        System.out.printf("Initial time: %s %s %n", myTime.toUniString(), myTime.toString());
        
        
        try {
            myTime.setTime(13,27,6);
        } catch (IllegalArgumentException e) {
            System.out.printf("Exception: %s%n%n", e.getMessage());
        }
        System.out.printf("After setting time: %s %s %n", myTime.toUniString(), myTime.toString());
        
        System.out.println("Trying to set time to invalid values");
        try {
            myTime.setTime(99,99,99); //Invalid values
        } catch (IllegalArgumentException e) {
            System.out.printf("Exception: %s%n%n", e.getMessage());
        }
                
        Time allThree = new Time(13, 55, 45);
        System.out.printf("Time1 generated using full constructor: %n %s %s %n", allThree.toUniString(), allThree.toString());
        
        Time hourAndMin = new Time(13, 55);
        System.out.printf("Time2 generated using hour and minute constructor: %n %s %s %n", hourAndMin.toUniString(), hourAndMin.toString());

        Time justHour = new Time(13);
        System.out.printf("Time3 generated using just hour constructor: %n %s %s %n", justHour.toUniString(), justHour.toString());
        
        Time copyTime = new Time(allThree);
        System.out.printf("Time generated using copy constructor: %n %s %s %n", copyTime.toUniString(), copyTime.toString());
        
        System.out.println("Trying to initialize object with invalid values");
        try {
            Time badTime = new Time(99,99,99); //Invalid values
        }catch (IllegalArgumentException e) {
            System.out.printf("Exception: %s%n%n", e.getMessage());
        }

    }//End Main
    
}//End Time
