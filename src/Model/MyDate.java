package Model;
import java.time.LocalDate;

public class MyDate
{
    private int day;
    private int month;
    private int year;
    public static final String LEGAL_MONTH[] = {"January", "June"};

    public MyDate(int day, int month, int year)
    {
        setDate(day, month, year);
    }

    public MyDate()
    {
        LocalDate today = LocalDate.now();

        day = today.getDayOfMonth();
        month = today.getMonthValue();
        year = today.getYear();
    }

    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
       try
       {
           if (getMonthName(month).equals(LEGAL_MONTH[0]) || getMonthName(month).equals(LEGAL_MONTH[1]))
           {
               this.month = month;
           }
       }
       catch (IllegalArgumentException e)
       {
           e.printStackTrace();
       }
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public void setDate(int day, int month, int year)
    {
        this.day = day;

        try
        {
            if (getMonthName(month).equals(LEGAL_MONTH[0]) || getMonthName(month).equals(LEGAL_MONTH[1]))
            {
                this.month = month;
            }
        }
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }

        this.year = year;
    }

    public String getMonthName(int month)
    {
        switch(month)
        {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            default: return "December";
        }
    }

    public boolean isBefore(MyDate other)
    {
        if (this.year < other.year)
        {
            return true;
        }
        else if (this.year > other.year)
        {
            return false;
        }
        if (this.month < other.month)
        {
            return true;
        }
        else if (this.month > other.month)
        {
            return false;
        }
        return this.day < other.day;
    }

    public String toString()
    {
        String s ="";
        if (day < 10)
        {
            s += "0";
        }
        s += day + "/";
        if (month < 10)
        {
            s += "0";
        }
        s += month + "/";
        s += year;
        return s;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof MyDate))
        {
            return false;
        }
        MyDate other = (MyDate) obj;
        return day == other.day && month == other.month && year == other.year;
    }

    public MyDate copy()
    {
        MyDate other = new MyDate(day, month, year);
        return other;
    }
}
