public class SignupForm {
    @NotBlank
    private String username;

    @MaxLength(10)
    private String password;

    public SignupForm(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
