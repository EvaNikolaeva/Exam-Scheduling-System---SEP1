package Model;

public class Test
{
    public static void main(String[] args)
    {
        Equipment equipment = new Equipment(true, true, 30, 10);

        Room room = new Room(equipment, "A208");

        MyDate date1 = new MyDate(6, 1, 2020);

        MyDate date2 = new MyDate();

        Course course = new Course("sdj1x", "Oral", 34,1);

        Examiner examiner1 = new Examiner("Steffen Andersen", "22479652", "1234",  course);

            Examiner examiner2 = new Examiner("Bob the Builder",  "50416377", "4563", course);

        Examiner examiner3 = new Examiner("Mona Andersen",  "23252714", "2366",  course);

        Exam exam1 = new Exam(date1, course, room, examiner1);

        System.out.println(room.toString());

        System.out.println(date1.toString());

        System.out.println(course.toString());

        System.out.println(examiner2.toString());

        System.out.println(exam1.toString());

    }
}
