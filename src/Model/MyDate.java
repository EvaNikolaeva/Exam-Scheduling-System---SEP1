package Model;
import java.time.LocalDate;

/**
 *A class representing a date.
 *
 * @author Group 8
 * @version 1 - December 2019
 */
public class MyDate
{
    private int day;
    private int month;
    private int year;
    /**
     * The constant LEGAL_MONTH.
     */
    public static final String LEGAL_MONTH[] = {"January", "June"};

    /**
     * Three-argument constructor instantiating  a new My date.
     *
     * @param day   the day
     * @param month the month as an integer in the range 1-12
     * @param year  the year
     */
    public MyDate(int day, int month, int year)
    {
        setDate(day, month, year);
    }

    /**
     * Zero-argument constructor setting the date to the current date.
     */
    public MyDate()
    {
        LocalDate today = LocalDate.now();

        day = today.getDayOfMonth();
        month = today.getMonthValue();
        year = today.getYear();
    }

    /**
     * Getter for day.
     *
     * @return the day of the date
     */
    public int getDay()
    {
        return day;
    }

    /**
     * Setter for day.
     *
     * @param day the day
     */
    public void setDay(int day)
    {
        this.day = day;
    }

    /**
     * Getter for  month.
     *
     * @return the month of the date
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * Sets the month if it is legal.
     *
     * @param month the month
     */
    public void setMonth(int month)
    {
        boolean illegal = true;

        if (getMonthName(month).equals(LEGAL_MONTH[0]) || getMonthName(month).equals(LEGAL_MONTH[1]))
        {
            this.month = month;
            illegal = false;
        }
        if (illegal)
        {
            throw new IllegalArgumentException("Illegal argument for month!!!!");

        } else
        {
            System.out.println("success");
        }
    }

    /**
     * Getter for year.
     *
     * @return the year of the date
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Setter for year.
     *
     * @param year the year
     */
    public void setYear(int year)
    {
        this.year = year;
    }

    /**
     * Sets the date and checks if the month is legal.
     *
     * @param day   the day
     * @param month the month
     * @param year  the year
     * @throws IllegalArgumentException the illegal argument exception
     */
    public void setDate(int day, int month, int year) throws IllegalArgumentException
    {
        this.day = day;

        boolean illegal = true;

        if (getMonthName(month).equals(LEGAL_MONTH[0]) || getMonthName(month).equals(LEGAL_MONTH[1]))
        {
            this.month = month;
            illegal = false;
        }
        if (illegal)
        {
            throw new IllegalArgumentException("Illegal argument for month!!!!");

        } else
        {
            System.out.println("success");
        }

        this.year = year;
    }

    /**
     * Converts a month number to the corresponding month name.
     *
     * @param month the month as an integer in the range 1-12.
     * @return the month as one of the following strings: {"January", "February", "March", "April", "May", "June",
     *         "July", "August", "September", "October", "November", "December"}.
     */
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

    /**
     * Returning if a date is before another date.
     *
     * @param other the comparing date
     * @return true if the date is before the other date. Otherwise return false.
     */
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

    /**
     * Returning the date in a proper format.
     * @return the date as a string
     */
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

    /**
     * Returning if two dates are the same.
     * @param obj the date compared to
     * @return true if the dates are identical. Otherwise return false.
     */
    public boolean equals(Object obj)
    {
        if (!(obj instanceof MyDate))
        {
            return false;
        }
        MyDate other = (MyDate) obj;
        return day == other.day && month == other.month && year == other.year;
    }

    /**
     * Creates a copy of the date.
     *
     * @return the copy
     */
    public MyDate copy()
    {
        MyDate other = new MyDate(day, month, year);
        return other;
    }
}
