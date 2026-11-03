package model;


// MiniBank Project: Console-Based Banking Application
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
import java.io.Serializable;
import model.annotation.Id;

public class Customer implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    public static class Address implements Serializable {
        private static final long serialVersionUID = 1L;

        private String line;
        private String city;
        private String pincode;

        public Address(String line, String city, String pincode) {
            this.line = line;
            this.city = city;
            this.pincode = pincode;
        }

        public String getLine() {
            return line;
        }

        public String getCity() {
            return city;
        }

        public String getPincode() {
            return pincode;
        }

        public String toString() {
            return line + ", " + city + " - " + pincode;
        }
    }

    private String name;
    private String email;
    private String mobile;

    @Id
    private final String customerId;
    private Address address;
    private static long customerCounter = 100;

    private static String generateCustomerId() {
        return "CUST" + (++customerCounter);
    }

    public Customer(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.customerId = generateCustomerId();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Customer clone() {
        try {
            Customer copy = (Customer) super.clone();
            if (this.address != null) {
                copy.address = new Address(this.address.line, this.address.city, this.address.pincode);
            }
            return copy;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return customerId + " | " + name + " | " + email + " | " + mobile;
    }
}
