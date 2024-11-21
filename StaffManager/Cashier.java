package StaffManager;

class Cashier extends Staff{
    private int extraMoney;

    public Cashier() {
    }

    public Cashier(Staff newCashier, int extraMoney) {
        super(newCashier);
        this.extraMoney = extraMoney;
    }

    @Override
    public void add() {

    }

    @Override
    public void display() {

    }

    @Override
    public void work() {

    }
}


