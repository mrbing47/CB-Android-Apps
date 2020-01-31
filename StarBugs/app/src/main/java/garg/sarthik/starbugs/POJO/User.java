package garg.sarthik.starbugs.POJO;

public class User {

    String userName;
    String userEmail;
    String userNumber;
    String userAuthId;
    String userBranch;
    String userToken;

    public User() {
    }

    public User(String userName, String userEmail, String userNumber, String userAuthId, String userBranch, String userToken) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userNumber = userNumber;
        this.userAuthId = userAuthId;
        this.userBranch = userBranch;
        this.userToken = userToken;
    }

    public String getUserToken() {
        return userToken;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserAuthId() {
        return userAuthId;
    }

    public String getUserBranch() {
        return userBranch;
    }
}
