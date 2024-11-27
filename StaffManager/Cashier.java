package StaffManager;
import feature.*;

class Cashier extends Staff{
    private int countBill;
    public Cashier() {
    }

    public Cashier(Staff newCashier, int countBill) {
        super(newCashier);
        this.countBill = countBill;
    }

    public void setCountBill(int bill)
    {
        countBill = bill;
    }

    @Override
    public void add() {
        super.add();
        System.out.print("Nhap tien bo cua thu ngan: ");
        countBill = Integer.parseInt(inputScanner.input.nextLine());
    }

    @Override
    public void display() {
        formatString.toStringTypeStaff(this.getID(), this.getName(), this.getSalary(), String.valueOf(countBill), "Tien bo");
    }

    @Override
    public void work() {
        setSalary(countBill+getSalary());
    }
    @Override
    public String getOwnAtributte(){
        return "Tien bo";
    }
    @Override
    public void showUnique(){
        System.out.println("Tien bo cu la : "+countBill);
    }
}


