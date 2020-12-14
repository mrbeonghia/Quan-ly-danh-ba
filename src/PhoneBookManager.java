import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBookManager {
    public static Scanner scanner = new Scanner(System.in);
    private ArrayList<PhoneBook> phoneList;
    private FileIO fileIO;

    public PhoneBookManager() {
        phoneList = FileIO.readPhoneBookFromFile();
    }

    public void add() {
        String phone = inputPhoneNumber();
        String group = inputGroup();
        String name = inputName();
        String gender = inputGender();
        String address = inputAddress();
        String dateOfBirth = inputDateOfBirth();
        String email = inputEmail();
        PhoneBook phoneBook = new PhoneBook(phone,group,name,gender,address,dateOfBirth,email);
        phoneList.add(phoneBook);
        FileIO.writePhoneBookToFile(phoneList);
    }

    public void edit(String name) {
        boolean isExisted = false;
        int size = phoneList.size();
        for (int i = 0; i < size; i++) {
            if (phoneList.get(i).getName().equals(name)) {
                isExisted = true;
                phoneList.get(i).setGroup(inputGroup());
                phoneList.get(i).setName(inputName());
                phoneList.get(i).setGender(inputGender());
                phoneList.get(i).setAddress(inputAddress());
                phoneList.get(i).setDateOfBirth(inputDateOfBirth());
                phoneList.get(i).setEmail(inputEmail());
                break;
            }
        }
        if (!isExisted) {
            System.out.println("Name not existed");
        } else {
            FileIO.writePhoneBookToFile(phoneList);
        }
    }

    public void delete(String phoneNumber) {
        PhoneBook phoneBook = null;
        int size = phoneList.size();
        for (int i = 0; i < size; i++) {
            if (phoneList.get(i).getPhone().equals(phoneNumber)) {
                phoneBook = phoneList.get(i);
                break;
            }
        }
        if (phoneBook != null) {
            phoneList.remove(phoneBook);
            FileIO.writePhoneBookToFile(phoneList);
        } else {
            System.out.println("Phone number not existed");
        }
    }

    public void show() {
        for (PhoneBook phoneBook : phoneList) {
            System.out.print("Phone number: " + phoneBook.getPhone()+",  ");
            System.out.print("Group: " + phoneBook.getGroup()+",  ");
            System.out.print("Name: " + phoneBook.getName()+",  ");
            System.out.print("Gender: " + phoneBook.getGender()+",  ");
            System.out.print("Address: " + phoneBook.getAddress()+",  ");
            System.out.print("Date of birth: " + phoneBook.getDateOfBirth()+",  ");
            System.out.print("Email: "+ phoneBook.getEmail()+"\n");
        }
    }

    public void search(List<PhoneBook> phoneBookList) {
        System.out.println("Nhập tên cần tìm kiếm trong danh bạ: ");
        boolean check = false;
        int index = 0;
        String inputValue = scanner.nextLine();
        for (int i = 0; i < phoneBookList.size(); i++) {
            if (phoneBookList.get(i).getName().toLowerCase().contains(inputValue.toLowerCase())

            ) {
                index = i;
                check = true;
                break;
            } else {
                check = false;
            }
        }
        if (check) {
            System.out.println(phoneBookList.get(index).toString());
        } else {
            System.out.println("Thông tin bạn nhập ko tồn tại");
        }
    }
    public String inputPhoneNumber() {
        System.out.println("Input phonenumber: ");
        return scanner.nextLine();
    }

    private String inputName() {
        System.out.println("Input name: ");
        return scanner.nextLine();
    }

    private String inputAddress() {
        System.out.println("Input address: ");
        return scanner.nextLine();
    }

    private String inputGroup() {
        System.out.println("Input group: ");
        return scanner.nextLine();
    }

    private String inputGender() {
        System.out.println("Input gender: ");
        return scanner.nextLine();
    }

    private String inputDateOfBirth() {
        System.out.println("Input date of birth: ");
        return scanner.nextLine();
    }

    private String inputEmail() {
        System.out.println("Input email: ");
        return scanner.nextLine();
    }

    public List<PhoneBook> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(ArrayList<PhoneBook> phoneList) {
        this.phoneList = phoneList;
    }
}