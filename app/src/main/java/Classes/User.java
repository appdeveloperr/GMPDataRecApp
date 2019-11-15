package Classes;

import java.io.Serializable;

public class User implements Serializable {


    public User(){

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getMsgtokenid() {
        return msgtokenid;
    }

    public void setMsgtokenid(String msgtokenid) {
        this.msgtokenid = msgtokenid;
    }



    String username;
    String password;
    String mobileno;
    String msgtokenid;


}
