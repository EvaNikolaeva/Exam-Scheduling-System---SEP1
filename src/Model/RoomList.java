package Model;
import java.util.ArrayList;

/**
 * A class representing a room list.
 *
 * @author Group 8
 * @version 1 - December 2019
 */
public class RoomList
{
    private ArrayList<Room> rooms;

    /**
     * An empty constructor instantiating a new ArrayList of rooms.
     */
    public RoomList()
    {
        this.rooms = new ArrayList<>();
    }

    /**
     * Adding a room to the list.
     *
     * @param room the room added
     */
    public void addRoom(Room room)
    {
        rooms.add(room);
    }

    /**
     * Removing a room from a list.
     *
     * @param room the room removed
     */
    public void removeRoom(Room room)
    {
        rooms.remove(room);
    }

    /**
     * Getting a room by its number.
     *
     * @param room the room number
     * @return the room with the specific number
     */
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

    /**
     * Getting the available rooms on a specific day.
     *
     * @param day the day
     * @return an ArrayList including the available rooms on a specific day
     */
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

    /**
     * Getting rooms with cables.
     *
     * @return an ArrayList including the rooms with cables
     */
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

    /**
     * Getting the rooms with projector.
     *
     * @return an ArrayList including the rooms with a projector
     */
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

    /**
     * Getting the rooms with cables and projector.
     *
     * @return an ArrayList including the rooms with cables and projector
     */
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

    /**
     * Returning all the rooms in the list and all the information about them.
     * @return a string including all rooms
     */
    public String toString()
    {
        String x = "";
        for(int i = 0; i < rooms.size(); i++)
        {
            x += rooms.get(i) + ", ";
        }
        return x;
    }

    /**
     * Getting the size of the list.
     *
     * @return an integer representing how many rooms there are
     */
    public int getSize() {
        return rooms.size();
    }

    /**
     * Getting the room at a specific index.
     *
     * @param i the index
     * @return the room
     */
    public Room getRoomByIndex(int i) {
        return rooms.get(i);
    }

    /**
     * Setter for the list.
     *
     * @param arrayList the new list of rooms
     */
    public void setAll(ArrayList arrayList) {
        this.rooms=arrayList;
    }
}
