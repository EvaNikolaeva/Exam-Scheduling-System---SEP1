package Model;
public class Equipment
{
    private boolean isHDMI;
    private boolean isVGA;
    private boolean isDisplayPort;
    private boolean isProjector;
    private int numberOfChairs;
    private int numberOfTables;

    public Equipment(boolean isHDMI, boolean isVGA, boolean isDisplayPort, boolean isProjector, int numberOfChairs, int numberOfTables)
    {
        this.isHDMI = isHDMI;
        this.isVGA = isVGA;
        this.isDisplayPort = isDisplayPort;
        this.isProjector = isProjector;
        if(numberOfChairs <= 100)
        {
            this.numberOfChairs = numberOfChairs;
        }
        if(numberOfTables <= 100)
        {
            this.numberOfTables = numberOfTables;
        }
    }

    public boolean getHDMI()
    {
        return isHDMI;
    }

    public boolean getVGA()
    {
        return isVGA;
    }

    public boolean getDisplayPort()
    {
        return isDisplayPort;
    }

    public boolean getProjector()
    {
        return isProjector;
    }

    public int getNumberOfChairs()
    {
        return numberOfChairs;
    }

    public int getNumberOfTables()
    {
        return numberOfTables;
    }

    public void setHDMI(boolean HDMI)
    {
        isHDMI = HDMI;
    }

    public void setVGA(boolean VGA)
    {
        isVGA = VGA;
    }

    public void setDisplayPort(boolean displayPort)
    {
        isDisplayPort = displayPort;
    }

    public void setProjector(boolean projector)
    {
        isProjector = projector;
    }

    public void setNumberOfChairs(int numberOfChairs)
    {
        this.numberOfChairs = numberOfChairs;
    }

    public void setNumberOfTables(int numberOfTables)
    {
        this.numberOfTables = numberOfTables;
    }

    public String toString()
    {
        return "HDMI: " + isHDMI + ", VGA: " + isVGA + ", Display port: " + isDisplayPort
                + ", Projector: " + isDisplayPort + ", Number of chairs: " + numberOfChairs
                + ", Number of tables: " + numberOfTables;
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Equipment))
            return false;
        Equipment other = (Equipment) obj;
        return isHDMI == other.isHDMI && isVGA == other.isVGA && isDisplayPort == other.isDisplayPort
                && isProjector == other.isProjector && numberOfChairs == other.numberOfChairs &&
                numberOfTables == other.numberOfTables;
    }
}
