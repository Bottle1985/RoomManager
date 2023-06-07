package com.example.room.Model;

public class BookRoomModel {
    private String idBook;
    private String name;
    private String cccd;
    private String idRoom;
    private String checkInDate;
    private String checkOutDate;
    private int number;
    private String status;
    
    public BookRoomModel(){}
 
    public BookRoomModel(String idbook, String name, String cccd, String idroom, String checkindate, String checkoutdate, int number, String status) {
        this.idBook = idbook;
        this.name = name;
        this.cccd = cccd;
        this.idRoom = idroom;
        this.checkInDate = checkindate;
        this.checkOutDate = checkoutdate;
        this.number = number;
        this.status = status;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idbook) {
        this.idBook = idbook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getCCCD() {
        return cccd;
    }

    public void setCCCD(String cccd) {
        this.cccd = cccd;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idroom) {
        this.idRoom = idroom;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkindate) {
        this.checkInDate = checkindate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkoutdate) {
        this.checkOutDate = checkoutdate;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
