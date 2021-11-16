package fhi0.DIDR.response;

/*created by Hector Developers
06-08-2019
*/
public class ApiResponse<T> {

    private int status;
    private String message;
    private T result;
    private long id;
    private String userType;
    private String email;
    private String firstname;
    private String lastname;
    private String states;
    private String password;


    public ApiResponse(int status, String message, T result, long id, String userType, String email, String firstname, String lastname, String states, String password) {
        this.status = status;
        this.message = message;
        this.result = result;
        this.userType = userType;
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.states = states;
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public long getId() {
        return id;
    }

    public String getUserType() {
        return userType;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getStates() {
        return states;
    }

    public String getPassword() {
        return password;
    }
}