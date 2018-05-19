package com.example.soundloneteamcomp.chitchat;

import com.google.android.gms.maps.model.LatLng;

import java.util.Map;

/**
 * Created by dath on 4/20/18.
 */

public class Conversation { //SOMETHING to merge here: userid -> getdata, store trunk data -> not effectively, waste memory
    private String userIdCreated; // << DAT>>
    private Long timeCreated;
    private String conversationName;


    public Conversation(String userIdCreated, String nameOfMeeting, String date, String time, Double longtitude, Double latitude) {
        this.userIdCreated = userIdCreated;
        this.nameOfMeeting = nameOfMeeting;
        this.date = date;
        this.time = time;
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    private String nameOfMeeting;
    private String date;
    private String time;
    private Map<String, String> listMember;
    private Map<Messages, Object> listMessage;
    private Double longtitude;
    private Double latitude;
    private String type;
    //private User[] listmember;

    public Conversation() {
    }

//    private Meeting[] listMeeting;


    public Conversation(String userIdCreated, Long timeCreated, String conversationName, Map<String, String> listMember, Map<Messages, Object> listMessage) {
        this.userIdCreated = userIdCreated;
        this.timeCreated = timeCreated;
        this.conversationName = conversationName;
        this.listMember = listMember;
        this.listMessage = listMessage;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /*

        public Conversation(String userIdCreated, Long timeCreated, String conversationName, Map<String, String> listMember, Double longtitude, Double latitude) {

            this.userIdCreated = userIdCreated;
            this.timeCreated = timeCreated;
            this.conversationName = conversationName;
            this.listMember = listMember;
            this.longtitude = longtitude;
            this.latitude = latitude;
        }
    */

    public Conversation(String conversationName, String type) {
        this.conversationName = conversationName;
        this.type = type;
    }


    public void setLocation(Double longtitude, Double latitude) {
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    public String getConversationName() {
        return conversationName;
    }

    public String getUserIdCreated() {
        return userIdCreated;
    }

    public String getNameOfMeeting() {
        return nameOfMeeting;
    }

    public void setNameOfMeeting(String nameOfMeeting) {
        this.nameOfMeeting = nameOfMeeting;
    }

    public void setUserIdCreated(String userIdCreated) {
        this.userIdCreated = userIdCreated;
    }

    public Long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Long timeCreated) {
        this.timeCreated = timeCreated;
    }


    public void setConversationName(String conversationName) {
        this.conversationName = conversationName;
    }

    public Map<String, String> getListMember() {
        return listMember;
    }

    public void setListMember(Map<String, String> listMember) {
        this.listMember = listMember;
    }

    public Map<Messages, Object> getListMessage() {
        return listMessage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public User[] getListmember() {
//        return listmember;
//    }

    public void setListMessage(Map<Messages, Object> listMessage) {
        this.listMessage = listMessage;
    }

    public LatLng getLatLng() {
        if (this.longtitude != null && this.latitude != null)
            return new LatLng(this.latitude, this.longtitude);
        return null;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}