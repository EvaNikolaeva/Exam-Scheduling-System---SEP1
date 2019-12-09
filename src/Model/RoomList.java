package Model;
import java.util.ArrayList;

public class RoomList
{
    private ArrayList<Room> rooms;

    public RoomList()
    {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room)
    {
        rooms.add(room);
    }


    public void removeRoom(Room room)
    {
        rooms.remove(room);
    }

    public Room getRoomByNumber(Room room)
    {
        for(int i = 0; i < rooms.size(); i++)
        {
            if(rooms.get(i).equals(room))
            {
                return room;
            }
        }
        return null;
    }

    
}
