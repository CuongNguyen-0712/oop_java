package StaffManager;
import inputValue.inputScanner;

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
        System.out.println("Nhap tien bo cua thu ngan :");
        countBill = inputScanner.input.nextInt();
        inputScanner.input.nextLine();
    }

    @Override
    public void display() {

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


