package StaffManager;

import IBook.IBookStore;

import IBook.IBookStore;
import feature.inputScanner;

import java.util.Vector;

public class StaffManager implements IBookStore {
    private Vector<Staff> listOfStaff;
    private static int member = 0;

    @Override
    public void add() {
        int choice;
        while (true) {
            System.out.println("Chon loai nhan vien ban muon them: 1. Thu ngan  2. Thu thu   3. Bao ve");
            try {
                choice = inputScanner.input.nextInt();
                inputScanner.input.nextLine();
                switch (choice) {
                    case 1:
                        Cashier ca = new Cashier();
                        ca.add();
                        listOfStaff.add(ca);
                        return;
                    case 2:
                        Librarian li = new Librarian();
                        li.add();
                        listOfStaff.add(li);
                        return;
                    case 3:
                        Guard ga = new Guard();
                        ga.add();
                        listOfStaff.add(ga);
                        return;
                    default:
                        System.out.println("Lua chon khong hop le !!!\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Vui long nhap so nguyen hop le!");
                inputScanner.input.nextLine();
            }
        }
    }

    @Override
    public void display() {

    }

    public void change() {
        boolean found = false;
        System.out.println("Nhap ma nhan vien muon sua: ");
        String id = inputScanner.input.nextLine();

        for (int i = 0; i < listOfStaff.size(); i++) {
            if (listOfStaff.get(i).getID().equalsIgnoreCase(id)) {
                found = false;
                while (true) {
                    System.out.println("Chon thong tin muon sua:");
                    System.out.println("1. Ten nhan vien");
                    System.out.println("2. Luong");
                    System.out.println("3." + listOfStaff.get(i).getOwnAtributte());
                    System.out.println("4. Thoat");

                    try {
                        System.out.print("Nhap lua chon cua ban: ");
                        int choice = inputScanner.input.nextInt();
                        inputScanner.input.nextLine();
                        switch (choice) {
                            case 1:
                                System.out.println("Nhap ten nhan vien moi: ");
                                String name = inputScanner.input.nextLine();
                                listOfStaff.get(i).setName(name);
                                System.out.println("Cap nhat ten nhan vien thanh cong!\n");
                                break;
                            case 2:
                                System.out.println("Nhap luong moi: ");
                                try {
                                    int salary = inputScanner.input.nextInt();
                                    inputScanner.input.nextLine();
                                    listOfStaff.get(i).setSalary(salary);
                                    System.out.println("Cap nhat luong thanh cong!\n");
                                } catch (Exception e) {
                                    System.out.println("Vui long nhap so nguyen hop le!");
                                    inputScanner.input.nextLine();
                                }
                                break;
                            case 3:
                                listOfStaff.get(i).showUnique();
                                if (listOfStaff.get(i) instanceof Cashier) {
                                    System.out.println("Nhap tien bo moi: ");
                                    try {
                                        int countBill = inputScanner.input.nextInt();
                                        inputScanner.input.nextLine();
                                        ((Cashier) listOfStaff.get(i)).setCountBill(countBill);
                                        System.out.println("Cap nhat tien bo thanh cong!\n");
                                    } catch (Exception e) {
                                        System.out.println("Vui long nhap so tien bo hop le!");
                                        inputScanner.input.nextLine();
                                    }
                                } else if (listOfStaff.get(i) instanceof Librarian) {
                                    try {
                                        System.out.println("Nhap cap do sap xep moi : ");
                                        int special = inputScanner.input.nextInt();
                                        inputScanner.input.nextLine();
                                        ((Librarian) listOfStaff.get(i)).setSpecial(special);
                                        System.out.println("Cap nhat cap do sap xep thanh cong!\n");
                                    } catch (Exception e) {
                                        System.out.println("Vui long nhap cap do sap xep hop le!");
                                        inputScanner.input.nextLine();
                                    }
                                } else {
                                    System.out.println("Nhap vo thuat moi : ");
                                    String ma = inputScanner.input.nextLine();
                                    ((Guard) listOfStaff.get(i)).setMA(ma);
                                    System.out.println("Cap nhat vo thuat thanh cong!\n");
                                }
                                break;
                            case 4:
                                System.out.println("Ket thuc sua thong tin nhan vien.\n");
                                return;
                            default:
                                System.out.println("Lua chon khong hop le, vui long thu lai!\n");
                        }
                    } catch (Exception e) {
                        System.out.println("Vui long nhap so nguyen !\n");
                    }
                }
            }
        }
        if (!found) {
            System.out.println("Ma nhan vien khong hop le!!!\n");
        }
    }

    public void delete() {
        inputScanner.input.nextLine();
        System.out.println("Nhap ma nhan vien muon xoa: ");
        String id = inputScanner.input.nextLine();
        boolean found = false;
        for (int i = 0; i < listOfStaff.size(); i++) {
            if (listOfStaff.get(i).getID().equalsIgnoreCase(id)) {
                listOfStaff.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay nhan vien!!!\n");
        }
    }

    public void search() {
        inputScanner.input.nextLine();
        boolean found = false;
        System.out.println("Nhap ma nhan vien muon tim: ");
        String id = inputScanner.input.nextLine();
        for (int i = 0; i < listOfStaff.size(); i++) {
            if (listOfStaff.get(i).getID().equalsIgnoreCase(id)) {
                System.out.println("----THONG TIN NHAN VIEN CAN TIM---\n");
                listOfStaff.get(i).display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay nhan vien!!!\n");
        }
    }

    public void listFind() {
        for (int i = 0; i < listOfStaff.size(); i++) {

        }
    }

    public Vector<Staff> getList() {
        return listOfStaff;
    }

    public static String getId() {
        return "Staff" + member++;
    }

    public static void manage() {

    }
}

