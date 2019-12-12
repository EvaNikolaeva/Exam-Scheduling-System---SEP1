package Model;

public class Test
{
    public static void main(String[] args)
    {
        Equipment equipment = new Equipment(true, true, 30, 10);

        equipment.setNumberOfChairs(99);
        System.out.println(equipment.toString());

        Room room = new Room(equipment, "A201", true);

        room.setAvailability(false);
        System.out.println(room.toString());
    }
}
