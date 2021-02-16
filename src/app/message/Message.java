package app.message;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public abstract class Message implements Serializable {

    private String uniqueID;
    private Date date;

    public Message(){
        this.uniqueID = UUID.randomUUID().toString();
        this.date = new Date();
        System.out.println(this.date);
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public Date getDate() {
        return date;
    }
}