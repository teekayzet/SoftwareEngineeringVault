class User {
    private String fullName;
    private int pin;

    // Constructor for creating a user object
    public User(String fullName, int pin) {
        this.fullName = fullName;
        this.pin = pin;
    }

    // Getter and setter methods for fullName
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Getter and setter methods for pin
    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    // Other methods specific to the user
}