package lk.ijse.yummy_food_project.dto;

public class UserDto {
    private String user_id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "UserDto{" +
                "user_id='" + user_id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserDto(String user_id,String username) {
        this.user_id = user_id;
        this.username = username;
        //this.password = password;
    }


    public String getUser_id() {
        return user_id;
    }
}
