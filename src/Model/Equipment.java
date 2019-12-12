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

        if(numberOfChairs >= 100 || numberOfChairs <= 0)
        {
            System.out.println("Try again, wrong chair number input.");
        }

        if(numberOfChairs <= 100 && numberOfChairs >= 0)
        {
            this.numberOfChairs = numberOfChairs;
        }

        if(numberOfTables >= 100 || numberOfTables <= 0)
        {
            System.out.println("Try again, wrong table number input.");
        }

        if(numberOfTables <= 100 && numberOfTables >= 0)
        {
            this.numberOfTables = numberOfTables;
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
        if(numberOfChairs >= 100 || numberOfChairs <= 0)
        {
            System.out.println("Try again, wrong  chair number input.");
        }

        if(numberOfChairs <= 100 && numberOfChairs >= 0)
        {
            this.numberOfChairs = numberOfChairs;
        }
    }

    public void setNumberOfTables(int numberOfTables)
    {
        if(numberOfTables >= 100 || numberOfTables <= 0)
        {
            System.out.println("Try again, wrong table number input.");
        }

        if(numberOfTables <= 100 && numberOfTables >= 0)
        {
            this.numberOfTables = numberOfTables;
        }
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
