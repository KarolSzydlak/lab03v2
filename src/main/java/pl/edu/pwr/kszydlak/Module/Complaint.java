package pl.edu.pwr.kszydlak.Module;

public class Complaint {
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    private int id;

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    private int clientid;

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getClientname() {
        return clientname;
    }

    private String clientname;

    public int getItemid() {
        return itemid;
    }

    private int itemid;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    private String description;
    private String reportdate;
    private String passdate;
    private String replydate;
    private String enddate;

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;
}
