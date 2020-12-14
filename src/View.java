import java.util.List;
import java.util.Scanner;

public class View {
    public static Scanner scanner = new Scanner(System.in);
    static List<PhoneBook> phoneBookList;
    public static void main(String[] args) {
        PhoneBookManager phoneBookManager = new PhoneBookManager();
        PhoneBook phoneBook = new PhoneBook();

        String phoneNum;
        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ----");
            System.out.println("________XIN MỜI CHỌN MỘT CHỨC NĂNG________");
            System.out.println("1. Xem danh bạ");
            System.out.println("2. Thêm mới ");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("0. Thoát");
            System.out.println("Bạn chọn:");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println(e);
                System.err.println("Nhập sai định dạng, vui lòng nhập lại");
            }

            switch (choice) {
                case 0:
                    System.out.println("____________Thoát khỏi chương trình____________");
                    System.out.println("Cảm ơn quý vị đã sử dụng dịch vụ của chúng tôi!");
                    break;

                case 1:
                    try {
                        phoneBookManager.show();
                        break;
                    } catch (Exception e) {
                        System.err.println(e);
                        System.err.println("Nhập sai định dạng, vui lòng nhập lại");
                    }
                case 2:
                    phoneBookManager.add();
                    System.out.println("Add completed!");
                    break;

                case 3:
                    System.out.println("Nhập tên cần chỉnh sửa: ");
                    String name = scanner.nextLine();
                    phoneBookManager.edit(name);
                    System.out.println("Edit completed!");
                    break;
                case 4:
                    System.out.println("Nhập số điện thoại cần xóa: ");
                    phoneNum = scanner.nextLine();
                    phoneBookManager.delete(phoneNum);
                    System.out.println("Deleted!");
                    break;

                case 5:
                    phoneBookManager.search(phoneBookList);
                    break;

                case 6:
                    FileIO.readPhoneBookFromFile();
                    phoneBookManager.show();
                    break;
                case 7:
//                    FileIO.writePhoneBookToFile("PhoneBook.csv",phoneBookList);
                case 8:
                default:
                    System.out.println("Not found!");
            }
        } while (choice != 0);
//        while (true) {
//            choice = scanner.nextLine();
//            switch (choice) {
//                case "1":
//                    phoneBookManager.show();
//                    break;
//                case "2":
//                    phoneBookManager.add();
//                    System.out.println("Add completed!");
//                    break;
//                case "3":
//                    System.out.println("Nhập tên cần chỉnh sửa: ");
//                    String name = scanner.nextLine();
//                    phoneBookManager.edit(name);
//                    System.out.println("Edit completed!");
//                    break;
//                case "4":
//                    System.out.println("Nhập số điện thoại cần xóa: ");
//                    phoneNum = scanner.nextLine();
//                    phoneBookManager.delete(phoneNum);
//                    System.out.println("Deleted!");
//                    break;
//            }
//        }

    }



}
