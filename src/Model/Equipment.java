package Model;
public class Equipment
{
    private boolean hasCables;
    private boolean hasProjector;
    private int numberOfChairs;
    private int numberOfTables;

    public Equipment(boolean hasCables, boolean hasProjector, int numberOfChairs, int numberOfTables)
    {
        this.hasCables = hasCables;
        this.hasProjector = hasProjector;
        try
        {
            this.numberOfChairs = numberOfChairs;
        }
        catch(NullPointerException e )
        {
            e.printStackTrace();
        }
        try
        {
            this.numberOfTables = numberOfTables;
        }
        catch(NullPointerException e )
        {
            e.printStackTrace();
        }
    }

    public boolean getCables()
    {
        return hasCables;
    }

    public boolean getProjector()
    {
        return hasProjector;
    }

    public int getNumberOfChairs()
    {
        return numberOfChairs;
    }

    public int getNumberOfTables()
    {
        return numberOfTables;
    }

    public void setCables(boolean hasCables)
    {
        this.hasCables = hasCables;
    }

    public void setProjector(boolean projector)
    {
        hasProjector = projector;
    }

    public void setNumberOfChairs(int numberOfChairs)
    {

    }

    public void setNumberOfTables(int numberOfTables)
    {

    }

    public String toString()
    {
        return "Cables: " + hasCables + ", Projector: " + hasProjector +
                ", Number of chairs: " + numberOfChairs + ", Number of tables: " + numberOfTables;
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Equipment))
            return false;
        Equipment other = (Equipment) obj;
        return hasCables == other.hasCables && hasProjector == other.hasProjector &&
                numberOfChairs == other.numberOfChairs && numberOfTables == other.numberOfTables;
    }
}
