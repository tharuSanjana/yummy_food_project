package lk.ijse.yummy_food_project.dto.tm;

public class userTm {
    private String name;
    private String email;
    private String jobRoll;
    private String address;

    public userTm(){}
     public userTm(String name,String email,String jobRoll,String address){
        this.name=name;
        this.email=email;
        this.jobRoll=jobRoll;
        this.address=address;
     }

    @Override
    public String toString() {
        return "userTm{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobRoll='" + jobRoll + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobRoll() {
        return jobRoll;
    }

    public void setJobRoll(String jobRoll) {
        this.jobRoll = jobRoll;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
