import java.io.*;
import java.util.ArrayList;

public class FileIO {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    public static void writePhoneBookToFile(String path, PhoneBook phoneBook) {
        File file = new File(path);
        FileWriter fileWriter = null;
        try {
            if (!file.exists()) {
                System.out.println("File not exists");
                file.createNewFile();
            }
            fileWriter = new FileWriter(file, true);
            fileWriter.append(phoneBook.getPhone() + "");
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(phoneBook.getGroup());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(phoneBook.getName());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(phoneBook.getGender());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(phoneBook.getAddress());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(phoneBook.getDateOfBirth() + "");
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(phoneBook.getEmail() + "");
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.flush();

        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    System.out.println("Write success!");
                    fileWriter.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }


    public static ArrayList<PhoneBook> readPhoneBookFromFile() {
        ArrayList<PhoneBook> listPhoneBooks = new ArrayList<>();
        String fileIn = "PhoneBook.csv";
        String line = null;
        FileReader fileReader = null;

        if (fileIn == null) {
            return null;
        } else {
            try {
                fileReader = new FileReader(fileIn);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while (true) {
                try {
                    if (!((line = bufferedReader.readLine()) != null)) break;
                } catch (IOException exception) {
                    System.out.println(exception);
                }
                String[] p = line.split(COMMA_DELIMITER);
                String phone = p[0];
                String group = p[1];
                String name = p[2];
                String gender = p[3];
                String address = p[4];
                String dateOfBirth = p[5];
                String email = p[6];

                listPhoneBooks.add(new PhoneBook(phone,group,name,gender,address,dateOfBirth,email));
            }
            try {
                bufferedReader.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            return listPhoneBooks;
        }

    }
}
