package com.example.question2_friendapplication;

public class Friend_JavaClass {
    private String friendName;
    private String friendHandphone;
    private String friendHomeAddress;

    public Friend_JavaClass(int anInt, String friendName, String friendHandphone, String friendHomeAddress) {
        this.friendName = friendName;
        this.friendHandphone = friendHandphone;
        this.friendHomeAddress = friendHomeAddress;
    }
    public Friend_JavaClass() {
        this.friendName = null;
        this.friendHandphone = null;
        this.friendHomeAddress = null;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getFriendHandphone() {
        return friendHandphone;
    }

    public void setFriendHandphone(String friendHandphone) {
        this.friendHandphone = friendHandphone;
    }

    public String getFriendHomeAddress() {
        return friendHomeAddress;
    }

    public void setFriendHomeAddress(String friendHomeAddress) {
        this.friendHomeAddress = friendHomeAddress;
    }
}
