package Poco;

public class User implements Poco {
    public long id;
    public String username;
    public String password;
    public String email;
    public int userRole;
    public String imgUrl= "\\resources\\UserImg\\def_user";

    public User(long id, String username, String password, String email, int userRole, String url) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
        if(!(url == null))
            this.imgUrl = url;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
