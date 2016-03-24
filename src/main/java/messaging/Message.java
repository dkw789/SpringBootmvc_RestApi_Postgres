package messaging;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MESSAGE")
class Message {


    @Column(name = "PARENT_MESSAGE_ID")
    @Basic(optional = false)
    public String ParentMessageID;

    @Id
    @GeneratedValue
    @Column(name = "REC_ID")
    private long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_NAME2")
    private String userName2;

    //private Date createdAt;
    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;


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

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    public String getParentMessageID() {
        return ParentMessageID;
    }

    public void setParentMessageID(String parentMessageID) {
        this.ParentMessageID = parentMessageID;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

