package Model;

/**
 * A class representing the equipment found in a classroom.
 *
 * @author Group 8
 * @version 1 - December 2019
 */
public class Equipment
{
    private boolean hasCables;
    private boolean hasProjector;
    private int numberOfChairs;
    private int numberOfTables;

    /**
     * Four-argument constructor instantiating a new Equipment.
     *
     * @param hasCables      connection cables in the classroom
     * @param hasProjector   projector in the classroom
     * @param numberOfChairs the number of chairs in the classroom
     * @param numberOfTables the number of tables in the classroom
     */
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

    /**
     * Checks if a classroom has the necessary cables.
     *
     * @return true if there are cables in a classroom. Otherwise return false.
     */
    public boolean getCables()
    {
        return hasCables;
    }

    /**
     * Checks if a classroom has a projector.
     *
     * @return true if there is a projector in a classroom. Otherwise return false.
     */
    public boolean getProjector()
    {
        return hasProjector;
    }

    /**
     * Getter for the number of chairs.
     *
     * @return the number of chairs
     */
    public int getNumberOfChairs()
    {
        return numberOfChairs;
    }

    /**
     * Getter for number of tables.
     *
     * @return the number of tables
     */
    public int getNumberOfTables()
    {
        return numberOfTables;
    }

    /**
     * Setter for cables.
     *
     * @param cables the cables
     */
    public void setCables(boolean cables)
    {
        this.hasCables = cables;
    }

    /**
     * Setter for projector.
     *
     * @param projector the projector
     */
    public void setProjector(boolean projector)
    {
        hasProjector = projector;
    }

    /**
     * Sets the number of chairs and checks if it is different from null.
     *
     * @param numberOfChairs the number of chairs
     */
    public void setNumberOfChairs(int numberOfChairs)
    {
        try
        {
            this.numberOfChairs = numberOfChairs;
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Sets number of tables and checks if it is different from null.
     *
     * @param numberOfTables the number of tables
     */
    public void setNumberOfTables(int numberOfTables)
    {
        try
        {
            this.numberOfTables = numberOfTables;
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Returning the information about equipment.
     * @return a string including the equipment found in a classroom
     */
    public String toString()
    {
        return "Cables: " + hasCables + ", Projector: " + hasProjector +
                ", Number of chairs: " + numberOfChairs + ", Number of tables: " + numberOfTables;
    }

    /**
     * Returning if two equipments are the same.
     * @param obj the equipment compared to
     * @return true if the equipments are identical. Otherwise return false.
     */
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Equipment))
            return false;
        Equipment other = (Equipment) obj;
        return hasCables == other.hasCables && hasProjector == other.hasProjector &&
                numberOfChairs == other.numberOfChairs && numberOfTables == other.numberOfTables;
    }
}
