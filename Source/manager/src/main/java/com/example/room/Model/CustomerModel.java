package com.example.room.Model;

public class CustomerModel {
    private String idCustomer;
    private String nameCustomer;
    private String cCCD;
    private String phoneNumber;
    private String Email;
    
    public CustomerModel(){}
 
    public CustomerModel(String _idCustomer, String _nameCustomer, String _cCCD, String _phoneNumber, String _email) {
        this.idCustomer = _idCustomer;
        this.nameCustomer = _nameCustomer;
        this.cCCD = _cCCD;
        this.phoneNumber = _phoneNumber;
        this.Email = _email;

    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIDCustomer(String _idCustomer) {
        this.idCustomer = _idCustomer;
    }

    public String getName() {
        return nameCustomer;
    }

    public void setName(String _name) {
        this.nameCustomer = _name;
    }
    
    public String getCCCD() {
        return cCCD;
    }

    public void setCCCD(String _cccd) {
        this.cCCD = _cccd;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String _phoneNumber) {
        this.phoneNumber = _phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String _email) {
        this.Email = _email;
    }

}
