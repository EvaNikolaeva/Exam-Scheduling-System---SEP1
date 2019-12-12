package Model;
public class Room
{
    private Equipment equipment;
    private String room;
    private boolean availability;
    public static final String[] ROOM_LIST = {"A001", "A002", "A003", "A004", "A005", "A101", "A102", "A103", "A104", "A105",
            "A201", "A202", "A203", "A204", "A205", "A301", "A302", "A303", "A304", "A305", "B001", "B002", "B003", "B004", "B005",
            "B101", "B102", "B103", "B104", "B105", "B201", "B202", "B203", "B204", "B205", "B301", "B302", "B303", "B304", "B305",
            "C001", "C002", "C003", "C004", "C005", "C101", "C102", "C103", "C104", "C105", "C201", "C202", "C203", "C204", "C205",
            "C301", "C302", "C303", "C304", "C305"};

    public Room(Equipment equipment, String room, boolean availability)
    {
        this.equipment = equipment;
        for(int i = 0; i < ROOM_LIST.length; i++)
        {
            if(room.equals(ROOM_LIST[i]))
            {
                this.room = room;
            }
        }
        this.availability = availability;
    }

    public Equipment getEquipment()
    {
        return equipment;
    }

    public String getRoom()
    {
        return room;
    }

    public boolean getAvailability()
    {
        return availability;
    }

    public void setEquipment(Equipment equipment)
    {
        this.equipment = equipment;
    }

    public void setRoom(String room)
    {
        this.room = room;
    }

    public void setAvailability(boolean availability)
    {
        this.availability = availability;
    }

    public boolean isAvailable(Room room)
    {
        if(room.getAvailability() == true)
        {
            return true;
        }
        return false;
    }

    public String toString()
    {
        return room + ", Equipment: " + equipment + ", Available: " + availability;
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Room))
            return false;
        Room other = (Room) obj;
        return equipment.equals(other.equipment) && room.equals(other.room) &&
                availability == other.availability;
    }
}
