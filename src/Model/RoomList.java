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

    public ArrayList<Room> getAvailableRooms(int day)
    {
        ArrayList<Room> availableRooms = new ArrayList<>();
        for(int i = 0; i < rooms.size(); i++)
        {
            if(rooms.get(i).getAvailability(day))
            {
                availableRooms.add(rooms.get(i));
            }
        }
        return availableRooms;
    }

    public ArrayList<Room> getRoomsWithCables()
    {
        ArrayList<Room> roomsWithCables = new ArrayList<>();
        for(int i = 0; i < rooms.size(); i++)
        {
            if(rooms.get(i).getEquipment().getCables())
            {
                roomsWithCables.add(rooms.get(i));
            }
        }
        return roomsWithCables;
    }

    public ArrayList<Room> getRoomsWithProjector()
    {
        ArrayList<Room> roomsWithProjector = new ArrayList<>();
        for(int i = 0; i < rooms.size(); i++)
        {
            if(rooms.get(i).getEquipment().getProjector())
            {
                roomsWithProjector.add(rooms.get(i));
            }
        }
        return roomsWithProjector;
    }

    public ArrayList<Room> getRoomsWithCablesAndProjector()
    {
        ArrayList<Room> roomsWithEverything = new ArrayList<>();
        for(int i = 0; i < rooms.size(); i++)
        {
            if(rooms.get(i).getEquipment().getProjector() && rooms.get(i).getEquipment().getCables())
            {
                roomsWithEverything.add(rooms.get(i));
            }
        }
        return roomsWithEverything;
    }

    public String toString()
    {
        String x = "";
        for(int i = 0; i < rooms.size(); i++)
        {
            x += rooms.get(i) + ", ";
        }
        return x;
    }

    public int getSize() {
        return rooms.size();
    }

    public Room getRoomByIndex(int i) {
        return rooms.get(i);
    }

    public void setAll(ArrayList arrayList) {
        this.rooms=arrayList;
    }
}
