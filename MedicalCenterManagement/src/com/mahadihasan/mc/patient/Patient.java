package com.mahadihasan.mc.patient;

import java.util.Date;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class Patient {
    //---------------Fields--------

    private String id;
    private String name;
    private String bloodGroup;
    private String sex;
    private String height;
    private String email;
    private String mobileNo;
    private String weight;
    private String age;
    private String dateOfBirth;

    //---------------------
    public Patient(String id, String name, String age, String sex,
            String bloodGrp,String height, String weight, String dateOfBirth,
              String mob, String email) {

        setID(id);
        setName(name);
        setAge(age);
        setSex(sex);
        setBloodGroup(bloodGrp);
        setHeight(height);
        setWeight(weight);
        setdateOfBirth(dateOfBirth);
        setMobileNo(mob);
        setEmail(email);
    }
    
    private void setID(String id) {
        this.id = id;
    }
    public String getID() {
        return id;
    }

    private String calcuateAge(Date dateOfBirth) {

        return null;
    }

    private void setName(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    private void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    private void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    private void setHeight(String height) {
        this.height = height;
    }

    public String getHeight() {
        return height;
    }

    private void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeight() {
        return weight;
    }

    private void setdateOfBirth(String dOfBirth) {
        dateOfBirth = dOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    private void setBloodGroup(String bloodGrp) {
        bloodGroup = bloodGrp;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    private void setMobileNo(String mob) {
        mobileNo = mob;
    }

    public String getMobileNo() {
        return mobileNo;
    }
}
