package honeyzstar.entity;

enum Month {
    January(1),
    February(2),
    March(3),
    April(4),
    May(5),
    June(6),
    July(7),
    August(8),
    September(9),
    October(10),
    November(11),
    December(12);

    private int value;

    Month(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class Date {
	private final int year;
    private final Month month;
    private final int day;

    public Date(int day, Month month, int year){
    	this.year = year;
        this.month = month;
        this.day = day;
    }
    
    public int getYear() {
    	return year;
    }

    public Month getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public String toString(){
        return String.format("%d %s %d", day, String.valueOf(month), year);
    }
}