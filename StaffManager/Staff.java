package StaffManager; 

import IBook.IBookStore;
import feature.inputScanner;

abstract class Staff implements IBookStore {
    private String id;
    private String name;
    private int salary;

    public Staff() {
        id = StaffManager.getId();
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
        System.out.println("Nhap ten nhan vien :");
        name = inputScanner.input.nextLine();
        System.out.println("Nhap luong co ban cua nhan vien : ");
        salary = inputScanner.input.nextInt();
        inputScanner.input.nextLine();
    }

    public String getID(){
        return id;
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

    public abstract void work();
    public abstract String getOwnAtributte();
    public abstract void showUnique();
}
