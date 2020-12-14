import java.io.Serializable;

public class PhoneBook implements Serializable {
    String phone;
    String group;
    String name;
    String gender;
    String address;
    String dateOfBirth;
    String email;

    public PhoneBook(){}
    public PhoneBook(String phone, String group, String name, String gender, String address, String dateOfBirth, String email) {
        this.phone = phone;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "Phone='" + phone + '\'' +
                ", Group='" + group + '\'' +
                ", Name='" + name + '\'' +
                ", Gender=" + gender +
                ", Address='" + address + '\'' +
                ", DateOfBirth=" + dateOfBirth +
                ", Email='" + email + '\'' +
                '}';
    }

}
