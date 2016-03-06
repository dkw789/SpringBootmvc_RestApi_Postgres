package messaging;


import javax.persistence.*;

@Entity
@Table(name = "MESSAGE")
class Message {



    @Id
    @GeneratedValue
    private long id;


    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_NAME2")
    private String userName2;


    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Calendar createdAt;
    //private Date createdAt;

    @Column(name = "MESSAGE_ID")
    @Basic(optional = false)
    public String messageID;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "LATITUDE")
    private String latitude;

    @Column(name = "LONGITUDE")
    private String longitude;

    @Column(name = "TEMPERATURE")
    private String temperature;

    @Column(name = "MESSAGECONTENT")
    private String MessageContent;


    public long getId() {
        return id;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName2() {
        return userName2;
    }

    public void setUserName2(String userName2) {
        this.userName2 = userName2;
    }

    public String getMessageContent() {
        return MessageContent;
    }

    public void setMessageContent(String messageContent) {
        MessageContent = messageContent;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /*public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }*/

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }


}

