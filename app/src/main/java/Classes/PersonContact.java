package Classes;

import java.io.Serializable;

public class PersonContact implements Serializable {


    public static int NUM_OF_CONTACT = 0;


    public PersonContact(){

        NUM_OF_CONTACT++;
    }

    String contactname;
    String contactnnumber;


    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getContactnnumber() {
        return contactnnumber;
    }

    public void setContactnnumber(String contactnnumber) {
        this.contactnnumber = contactnnumber;
    }



}
