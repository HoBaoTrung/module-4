package com.codegym.medicaldeclaration;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class MedicalDeclaration {
    private Long id;
    private String fullName;
    private Integer birthYear;
    private String gender;
    private String nationality;
    private String passportNumber;

    private String vehicleType;
    private String vehicleId;
    private String seatNumber;

    // cần gắn @DateTimeFormat(pattern = "yyyy-MM-dd") để định dạng date cùng với html
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private String visitedPlaces;

    private String province;
    private String district;
    private String ward;
    private String address;

    private String phone;
    private String email;

    // Triệu chứng
    private boolean fever;
    private boolean cough;
    private boolean breathDifficulty;
    private boolean soreThroat;
    private boolean nausea;
    private boolean diarrhea;
    private boolean skinBleeding;
    private boolean rash;

    // Lịch sử phơi nhiễm
    private boolean exposureToAnimal;
    private boolean exposureToPatient;

    public MedicalDeclaration() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getVisitedPlaces() {
        return visitedPlaces;
    }

    public void setVisitedPlaces(String visitedPlaces) {
        this.visitedPlaces = visitedPlaces;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isFever() {
        return fever;
    }

    public void setFever(boolean fever) {
        this.fever = fever;
    }

    public boolean isCough() {
        return cough;
    }

    public void setCough(boolean cough) {
        this.cough = cough;
    }

    public boolean isBreathDifficulty() {
        return breathDifficulty;
    }

    public void setBreathDifficulty(boolean breathDifficulty) {
        this.breathDifficulty = breathDifficulty;
    }

    public boolean issoreThroat() {
        return soreThroat;
    }

    public void setsoreThroat(boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public boolean isNausea() {
        return nausea;
    }

    public void setNausea(boolean nausea) {
        this.nausea = nausea;
    }

    public boolean isDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public boolean isSkinBleeding() {
        return skinBleeding;
    }

    public void setSkinBleeding(boolean skinBleeding) {
        this.skinBleeding = skinBleeding;
    }

    public boolean isRash() {
        return rash;
    }

    public void setRash(boolean rash) {
        this.rash = rash;
    }

    public boolean isExposureToAnimal() {
        return exposureToAnimal;
    }

    public void setExposureToAnimal(boolean exposureToAnimal) {
        this.exposureToAnimal = exposureToAnimal;
    }

    public boolean isExposureToPatient() {
        return exposureToPatient;
    }

    public void setExposureToPatient(boolean exposureToPatient) {
        this.exposureToPatient = exposureToPatient;
    }
}
