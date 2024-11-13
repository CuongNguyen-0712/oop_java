package StaffManager;

abstract class Staff implements IBookStore {
    private String id;
    private String name;
    private int salary;

    public Staff() {
    }

    public Staff(Staff newStaff) {
        id = newStaff.id;
        name = newStaff.name;
        salary = newStaff.salary;
    }

    public Staff(String id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void add() {

    }

    @Override
    public void display() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public void work() {

    }
}
