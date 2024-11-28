package StaffManager; 

import IBook.IBookStore;
import feature.inputScanner;

abstract public class Staff implements IBookStore {
    private String id;
    private String name;
    private int salary;

    public Staff(){

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
        id = "NV" + (int) (Math.random() * 1000);
        System.out.print("Nhap ten nhan vien: ");
        name = inputScanner.input.nextLine();
        System.out.print("Nhap luong co ban cua nhan vien (.000 VND): ");
        salary = Integer.parseInt(inputScanner.input.nextLine());
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

    @Override
    public void display() {}
    public abstract void work();
    public abstract String getAttributeTitle();
    public abstract String getAttributeValue();
    public abstract void showUnique();
}
