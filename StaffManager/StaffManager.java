package StaffManager;

import feature.*;

import java.util.*;
import java.io.*;

public class StaffManager {
    private static final Vector<Staff> listOfStaff = new Vector<>();
    private static final String filePath = "V:\\Develop\\Develop IntelliJ IDEA\\Project_1\\src\\data\\dataStaff.txt";
    // Hãy thay đổi đường dẫn file trên tùy thuộc vào IDE hoặc text-editor đang sử dụng

    public static Vector<Staff> getList() {
        return new Vector<>(listOfStaff);
    }

    public static void readData() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                int indexStaff = Integer.parseInt(line);
                String id = br.readLine();
                String name = br.readLine();
                int salary = Integer.parseInt(br.readLine());
                String privateAttribute = br.readLine();
                Staff staff = null;
                if (indexStaff == 1) {
                    staff = new Cashier(id, name, salary, Integer.parseInt(privateAttribute));
                } else if (indexStaff == 2) {
                    staff = new Librarian(id, name, salary, Integer.parseInt(privateAttribute));
                } else if (indexStaff == 3) {
                    staff = new Guard(id, name, salary, privateAttribute);
                }

                listOfStaff.add(staff);
                br.readLine();
            }

        } catch (Exception e) {
            System.out.println("Loi doc du lieu, vui long thu lai!");
            System.exit(1);
        }
    }

    public static void saveData() {
        try (BufferedWriter wt = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < listOfStaff.size(); i++) {
                if (listOfStaff.get(i) instanceof Cashier) {
                    wt.write("1" + "\n");
                } else if (listOfStaff.get(i) instanceof Librarian) {
                    wt.write("2" + "\n");
                } else if (listOfStaff.get(i) instanceof Guard) {
                    wt.write("3" + "\n");
                }
                wt.write(listOfStaff.get(i).getID() + "\n");
                wt.write(listOfStaff.get(i).getName() + "\n");
                wt.write(listOfStaff.get(i).getSalary() + "\n");
                wt.write(listOfStaff.get(i).getAttributeValue() + "\n");
                wt.write("\n");
            }
        } catch (Exception e) {
            System.out.println("Loi luu du lieu, vui long thu lai!");
        }
    }

    public static void add() {
        int choice;
        while (true) {
            System.out.println("Chon loai nhan vien ban muon them: 1. Thu ngan  2. Thu thu   3. Bao ve");
            System.out.print("Nhap lua chon cua ban: ");
            try {
                choice = Integer.parseInt(inputScanner.input.nextLine());

                Staff newStaff = null;

                switch (choice) {
                    case 1:
                        newStaff = new Cashier();
                        newStaff.add();
                        listOfStaff.add(newStaff);
                        return;
                    case 2:
                        newStaff = new Librarian();
                        newStaff.add();
                        listOfStaff.add(newStaff);
                        return;
                    case 3:
                        newStaff = new Guard();
                        newStaff.add();
                        listOfStaff.add(newStaff);
                        return;
                    default:
                        System.out.println("Lua chon khong hop le !!!\n");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen hop le! \n");
            }
        }
    }

    public static void delete() {
        StaffManager.display();
        System.out.print("\nNhap ma nhan vien muon xoa: ");
        String id = inputScanner.input.nextLine();
        boolean found = false;
        for (int i = 0; i < listOfStaff.size(); i++) {
            if (listOfStaff.get(i).getID().equalsIgnoreCase(id)) {
                if(listOfStaff.get(i) instanceof Cashier) {
                    Cashier.deCountStaff();
                }
                else if(listOfStaff.get(i) instanceof Guard) {
                    Guard.deCountStaff();
                }
                else if(listOfStaff.get(i) instanceof Librarian) {
                    Librarian.deCountStaff();
                }
                listOfStaff.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay nhan vien!!!\n");
        }
    }

    public static void modify() {
        StaffManager.display();

        boolean found = false;
        System.out.println("Nhap ma nhan vien muon sua: ");
        String id = inputScanner.input.nextLine();

        for (Staff staff : listOfStaff) {
            if (staff.getID().equalsIgnoreCase(id)) {
                found = true;
                while (true) {
                    System.out.println("Chon thong tin muon sua:");
                    System.out.println("1. Ten nhan vien");
                    System.out.println("2. Luong");
                    System.out.println("3." + staff.getAttributeTitle());
                    System.out.println("4. Thoat");

                    try {
                        System.out.print("Nhap lua chon cua ban: ");
                        int choice = Integer.parseInt(inputScanner.input.nextLine());
                        switch (choice) {
                            case 1:
                                System.out.println("Nhap ten nhan vien moi: ");
                                String name = inputScanner.input.nextLine();
                                staff.setName(name);
                                System.out.println("Cap nhat ten nhan vien thanh cong!\n");
                                break;
                            case 2:
                                System.out.println("Nhap luong moi: ");
                                try {
                                    int salary = inputScanner.input.nextInt();
                                    inputScanner.input.nextLine();
                                    staff.setSalary(salary);
                                    System.out.println("Cap nhat luong thanh cong!\n");
                                } catch (Exception e) {
                                    System.out.println("Vui long nhap so nguyen hop le!");
                                    inputScanner.input.nextLine();
                                }
                                break;
                            case 3:
                                staff.showUnique();
                                if (staff instanceof Cashier) {
                                    System.out.println("Nhap tien bo moi: ");
                                    try {
                                        int countBill = inputScanner.input.nextInt();
                                        inputScanner.input.nextLine();
                                        ((Cashier) staff).setCountBill(countBill);
                                        System.out.println("Cap nhat tien bo thanh cong!\n");
                                    } catch (Exception e) {
                                        System.out.println("Vui long nhap so tien bo hop le!");
                                        inputScanner.input.nextLine();
                                    }
                                } else if (staff instanceof Librarian) {
                                    try {
                                        System.out.println("Nhap cap do sap xep moi : ");
                                        int special = inputScanner.input.nextInt();
                                        inputScanner.input.nextLine();
                                        ((Librarian) staff).setSpecial(special);
                                        System.out.println("Cap nhat cap do sap xep thanh cong!\n");
                                    } catch (Exception e) {
                                        System.out.println("Vui long nhap cap do sap xep hop le!");
                                        inputScanner.input.nextLine();
                                    }
                                } else {
                                    System.out.println("Nhap vo thuat moi : ");
                                    String ma = inputScanner.input.nextLine();
                                    ((Guard) staff).setMA(ma);
                                    System.out.println("Cap nhat vo thuat thanh cong!\n");
                                }
                                break;
                            case 4:
                                System.out.println("Ket thuc sua thong tin nhan vien.\n");
                                return;
                            default:
                                System.out.println("Lua chon khong hop le, vui long thu lai!\n");
                                break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Vui long nhap so nguyen !\n");
                    }
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("Ma nhan vien khong hop le!!!\n");
        }
    }

    public static void search() {
        boolean found = false;
        System.out.print("Nhap ma nhan vien muon tim: ");
        String id = inputScanner.input.nextLine();
        for (Staff staff : listOfStaff) {
            if (staff.getID().equalsIgnoreCase(id)) {
                System.out.println("----THONG TIN NHAN VIEN CAN TIM---\n");
                staff.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay nhan vien!!!\n");
        }
    }

    public static void display() {
        System.out.println("\n----DANH SACH NHAN VIEN---\n");
        formatString.toStringStaff(StaffManager.getList());
        System.out.print("Nhan Enter de tiep tuc...");
        inputScanner.input.nextLine();
    }

    public static void countByJobStaff() {
        System.out.println("So luong thu ngan: " + Cashier.countStaff());
        System.out.println("So luong thu thu: " + Librarian.countStaff());
        System.out.println("So luong bao ve: " + Guard.countStaff());
    }

    public static long totalSalary()
    {
        long total = 0;
        for (Staff staff : listOfStaff)
        {
            staff.work();
            total += staff.getSalary();
        }
        return total;
    }

    public static void manage() {
        while (true) {
            System.out.println("\n==== QUAN LY NHAN VIEN ====");
            System.out.println("---------------------------");
            System.out.println("1.Them nhan vien");
            System.out.println("2.Xoa nhan vien");
            System.out.println("3.Chinh sua nhan vien");
            System.out.println("4.Tim kiem nhan vien");
            System.out.println("5.Hien thi danh sach nhan vien");
            System.out.println("6.Thoat");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                String value = inputScanner.input.nextLine();
                int choice = Integer.parseInt(value);

                switch (choice) {
                    case 1:
                        StaffManager.add();
                        break;
                    case 2:
                        StaffManager.delete();
                        break;
                    case 3:
                        StaffManager.modify();
                        break;
                    case 4:
                        StaffManager.search();
                        break;
                    case 5:
                        StaffManager.display();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Lua chon hop le, vui long nhap lai!\n");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Gia tri khong hop le, vui long nhap lai!\n");
            }
        }
    }
}

