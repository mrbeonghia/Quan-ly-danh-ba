import java.io.*;
import java.util.ArrayList;

public class FileIO {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static File file = null;
    private static FileWriter fileWriter = null;
    private static FileReader fileReader = null;
    private static BufferedReader bufferedReader = null;

    public static void writePhoneBookToFile(ArrayList<PhoneBook> phoneBooks) {
        file = new File("PhoneBook.csv");
        try {
            file.createNewFile();
            fileWriter = new FileWriter(file);
            for (PhoneBook phoneBook : phoneBooks) {
                fileWriter.append(phoneBook.toString());
                fileWriter.write(NEW_LINE_SEPARATOR);
                fileWriter.flush();
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
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
