package StaffManager;

import feature.*;

class Librarian extends Staff {
    private int specialization;

    public Librarian() {

    }

    public void setSpecial(int special)
    {
        specialization = special;
    }


    public Librarian(Staff newLibrian, int specialization) {
        super(newLibrian);
        this.specialization = specialization;
    }

    @Override
    public void add() {
        super.add();
        System.out.print("Nhap cap do sap xep cua thu thu: ");
        specialization = Integer.parseInt(inputScanner.input.nextLine());
    }

    @Override
    public void display() {
        formatString.toStringTypeStaff(this.getID(), this.getName(), this.getSalary(), String.valueOf(specialization), "Cap do sap xep");
    }

    @Override
    public void work() {
        setSalary(getSalary() * specialization);
    }
    @Override
    public String getOwnAtributte(){
        return "Cap do sap xep";
    }
    @Override
    public void showUnique(){
        System.out.println("Cap do sap xep cu la : "+specialization);
    }
}
