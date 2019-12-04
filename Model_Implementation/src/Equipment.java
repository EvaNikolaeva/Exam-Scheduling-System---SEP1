public class Equipment
{
    private boolean isHDMI;
    private boolean isVGA;
    private boolean isDisplayPort;
    private boolean isProjector;
    private int numberOfChairs;
    private int numberOfTables;

    Equipment(boolean isHDMI, boolean isVGA, boolean isDisplayPort, boolean isProjector, int numberOfChairs, int numberOfTables)
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
}
