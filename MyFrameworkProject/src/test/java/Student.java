public class Student
{
    int sid ;
    String sname ;

    /*void m2(String name, int id)
    {
        this.sid = id;
        this.sname = name;
    }*/
    void mi()
    {
        System.out.println("Student name = "+sname);
        System.out.println("Student id = "+ sid);
    }

    Student(String name, int id)
    {
        this.sid = id;
        this.sname = name;

    }
}
