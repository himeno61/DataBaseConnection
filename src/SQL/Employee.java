package SQL;

public class Employee {
    private long pesel;
    private String firstName;
    private String Surname;
    private int age;
    private long phone;

    public Employee(long pesel, String firstName, String surname, int age, long phone) {
        this.pesel = pesel;
        this.firstName = firstName;
        Surname = surname;
        this.age = age;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "pesel=" + pesel +
                ", firstName='" + firstName + '\'' +
                ", Surname='" + Surname + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                '}';
    }
}
