package Classes;

import java.io.Serializable;

public class smsData implements Serializable {


    public static int numofsms =0;

    String number;
    String body;
    String id;
    String date;

    public smsData(){

        numofsms++;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public static int getNumofsms() {
        return numofsms;
    }

    public static void setNumofsms(int numofsms) {
        smsData.numofsms = numofsms;
    }

}
