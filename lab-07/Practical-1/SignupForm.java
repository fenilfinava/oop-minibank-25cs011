// Practical: lab-07 - Practical-1 (SignupForm.java)
// Student Name: Fenil Jagdishbhai Finava | Student ID: 25CS011
// Subject: Object Oriented Programming (CEUE203)
public class SignupForm {
    @NotBlank
    private String username;
    // private data field encapsulation mate

    @MaxLength(10)
    private String password;
    // private data field encapsulation mate

    public SignupForm(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
