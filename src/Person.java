public abstract class Person {
    private int id;
    private static int count =100;
    private String email, name, password, address, phoneNumber;

    private char gender;

    public Person(){
        count++;
        id = count;
    }

    // Setters
//    public void setID(int id){
//
//        this.id = id;
//    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getters
    public int getID() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    // Abstract Function will override in Customer and Coach Classes
    public abstract void displayInfo();
}
