package Model;

public class Test
{
    public static void main(String[] args)
    {
        Equipment equipment = new Equipment(true, true, 30, 10);

        Room room = new Room(equipment, "A208", true);

        System.out.println(room.toString());
    }
}
