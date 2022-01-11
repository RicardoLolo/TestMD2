import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class RunningSystem {
    Scanner scanner = new Scanner(System.in);
    ContactsManagement contactsManagement = new ContactsManagement();

    public RunningSystem() {
    }

    public void menuOfSystem() {
        try {
            do {
                System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
                System.out.println("Chọn chức năng theo số (để tiếp tục):");
                System.out.println("1. Xem danh sách");
                System.out.println("2. Thêm mới");
                System.out.println("3. Cập nhật");
                System.out.println("4. Xóa");
                System.out.println("5. Tìm kiếm");
                System.out.println("6. Đọc từ file");
                System.out.println("7. Ghi vào file");
                System.out.println("8. Thoát");
                System.out.println("Chọn chức năng:");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 8) {
                    System.out.println();
                    System.out.println(" Lựa chọn không tồn tại, nhập lại -_-");
                    System.out.println("--------------------");
                }
                switch (choice) {
                    case 1:
                        contactsManagement.displayAll();
                        break;
                    case 2:
                        contactsManagement.addContact();
                        break;
                    case 3:
                        System.out.println(" Nhập số điện thoại cần sửa (+84)-933334444:");
                        String phoneEdit = scanner.nextLine();
                        if (phoneEdit.equals("")) {
                            menuOfSystem();
                        } else {
                            contactsManagement.updateContact(phoneEdit);
                        }
                        break;
                    case 4:
                        System.out.println(" Nhập số điện thoại cần xoá (+84)-933334444:");
                        String phoneDelete = scanner.nextLine();
                        if (phoneDelete.equals("")) {
                            menuOfSystem();
                        } else {
                            contactsManagement.deleteContact(phoneDelete);
                        }
                        break;
                    case 5:
                        System.out.println(" Nhập từ khóa:");
                        String keyword = scanner.nextLine();
                        contactsManagement.searchContactByNameOrPhone(keyword);
                        break;
                    case 6:
                        ArrayList<Contacts> contactArrayList = contactsManagement.readFile(ContactsManagement.PATH_NAME);
                        ((ArrayList<?>) contactArrayList).forEach(System.out::println);
                        System.out.println(" đọc thành công !");
                        System.out.println("--------------------");
                        break;
                    case 7:
                        contactsManagement.writeFile(contactsManagement.getContactsList(), ContactsManagement.PATH_NAME);
                        break;
                    case 8:
                        System.exit(8);
                }
            } while (true);
        } catch (NumberFormatException | DateTimeParseException e) {
            System.out.println();
            System.out.println(" Sai dữ liệu, nhập lại ! ");
            System.out.println("--------------------");
            System.out.println();
            menuOfSystem();
        }
    }
}
