/*
 * Simple program to demonstray basic exception handling
 * From "Java How To Program, 10/e, Early Objects" - Chapter 8.
 */

public class Time {
    private int hour;
    private int minute;
    private int second;
    
    //Set new time
    //Throw exception if invalid
    public void setTime(int nHour, int nMinute, int nSecond) {
        //Validate time
        if (nHour <0 || nHour > 24 || nMinute < 0 || nMinute >= 60 || nSecond < 0 || nSecond >= 60 ) {
            throw new IllegalArgumentException ("Invalid initial Time");
        }
        
        this.hour = nHour;
        this.minute = nMinute;
        this.second = nSecond;
    }
    
    //Connvert to universal time HH:MM:SS
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
        
        myTime.setTime(13,27,6);
        System.out.printf("After setting time: %s %s %n", myTime.toUniString(), myTime.toString());
        
        try {
            myTime.setTime(99,99,99); //Illegal values
        } catch (IllegalArgumentException e) {
            System.out.printf("Exception: %s%n%n", e.getMessage());
        }
        
        System.out.printf("After setting time with invalid values: %s %s %n ", myTime.toUniString(), myTime.toString());
           
    }//End Main
    
}//End Time
