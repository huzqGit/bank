package com.bank.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.common.bean.BaseEntity;

public class Farmer extends BaseEntity<Long>{

    private String farmername;

    private String farmeridnum;

    private Integer sex;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;

    private String age;

    private String marrystatus;

    private Integer politicstatus;

    private Integer education;

    private String phone;

    private String bank;

    private String account;

    private Integer familynum;

    private Integer labornum;

    private Integer postcode;

    private String idtype;

    private String occupation;

    private String villages;

    private String address;

    private Integer farmertype;

    private Integer poortype;

    private Integer poorreason;

    private Double plougharea;

    private Double wateringarea;

    private Double forestarea;

    private Double forestarea1;

    private Double fruitarea;

    private Double meadowarea;

    private Double waterarea;

    private Integer drinkinghard;

    private Integer drinkingsafe;

    private Integer usingelectric;

    private Integer usingtoilet;

    private Integer fueltype;

    private Integer usingartel;

    private Double netincome;

    private Double wagesincome;

    private Double operateincome;

    private Double subsidyincome;

    private Integer usingtelevision;

    private Double roaddistance;

    private Integer roadtype;

    private Double housearea;

    private Integer unsafehouse;

    private Double lowinsure;

    private Double agedinsure;

    private Double ecoamount;

    private String runitid;

    private String runitname;

    private String recorder;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recordtime;

    private Integer standard;

    private String sourcecode;

    private String sourcename;

    public String getFarmername() {
        return farmername;
    }

    public void setFarmername(String farmername) {
        this.farmername = farmername == null ? null : farmername.trim();
    }

    public String getFarmeridnum() {
        return farmeridnum;
    }

    public void setFarmeridnum(String farmeridnum) {
        this.farmeridnum = farmeridnum == null ? null : farmeridnum.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getMarrystatus() {
        return marrystatus;
    }

    public void setMarrystatus(String marrystatus) {
        this.marrystatus = marrystatus == null ? null : marrystatus.trim();
    }

    public Integer getPoliticstatus() {
        return politicstatus;
    }

    public void setPoliticstatus(Integer politicstatus) {
        this.politicstatus = politicstatus;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Integer getFamilynum() {
        return familynum;
    }

    public void setFamilynum(Integer familynum) {
        this.familynum = familynum;
    }

    public Integer getLabornum() {
        return labornum;
    }

    public void setLabornum(Integer labornum) {
        this.labornum = labornum;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype == null ? null : idtype.trim();
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation == null ? null : occupation.trim();
    }

    public String getVillages() {
        return villages;
    }

    public void setVillages(String villages) {
        this.villages = villages == null ? null : villages.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getFarmertype() {
        return farmertype;
    }

    public void setFarmertype(Integer farmertype) {
        this.farmertype = farmertype;
    }

    public Integer getPoortype() {
        return poortype;
    }

    public void setPoortype(Integer poortype) {
        this.poortype = poortype;
    }

    public Integer getPoorreason() {
        return poorreason;
    }

    public void setPoorreason(Integer poorreason) {
        this.poorreason = poorreason;
    }

    public Double getPlougharea() {
        return plougharea;
    }

    public void setPlougharea(Double plougharea) {
        this.plougharea = plougharea;
    }

    public Double getWateringarea() {
        return wateringarea;
    }

    public void setWateringarea(Double wateringarea) {
        this.wateringarea = wateringarea;
    }

    public Double getForestarea() {
        return forestarea;
    }

    public void setForestarea(Double forestarea) {
        this.forestarea = forestarea;
    }

    public Double getForestarea1() {
        return forestarea1;
    }

    public void setForestarea1(Double forestarea1) {
        this.forestarea1 = forestarea1;
    }

    public Double getFruitarea() {
        return fruitarea;
    }

    public void setFruitarea(Double fruitarea) {
        this.fruitarea = fruitarea;
    }

    public Double getMeadowarea() {
        return meadowarea;
    }

    public void setMeadowarea(Double meadowarea) {
        this.meadowarea = meadowarea;
    }

    public Double getWaterarea() {
        return waterarea;
    }

    public void setWaterarea(Double waterarea) {
        this.waterarea = waterarea;
    }

    public Integer getDrinkinghard() {
        return drinkinghard;
    }

    public void setDrinkinghard(Integer drinkinghard) {
        this.drinkinghard = drinkinghard;
    }

    public Integer getDrinkingsafe() {
        return drinkingsafe;
    }

    public void setDrinkingsafe(Integer drinkingsafe) {
        this.drinkingsafe = drinkingsafe;
    }

    public Integer getUsingelectric() {
        return usingelectric;
    }

    public void setUsingelectric(Integer usingelectric) {
        this.usingelectric = usingelectric;
    }

    public Integer getUsingtoilet() {
        return usingtoilet;
    }

    public void setUsingtoilet(Integer usingtoilet) {
        this.usingtoilet = usingtoilet;
    }

    public Integer getFueltype() {
        return fueltype;
    }

    public void setFueltype(Integer fueltype) {
        this.fueltype = fueltype;
    }

    public Integer getUsingartel() {
        return usingartel;
    }

    public void setUsingartel(Integer usingartel) {
        this.usingartel = usingartel;
    }

    public Double getNetincome() {
        return netincome;
    }

    public void setNetincome(Double netincome) {
        this.netincome = netincome;
    }

    public Double getWagesincome() {
        return wagesincome;
    }

    public void setWagesincome(Double wagesincome) {
        this.wagesincome = wagesincome;
    }

    public Double getOperateincome() {
        return operateincome;
    }

    public void setOperateincome(Double operateincome) {
        this.operateincome = operateincome;
    }

    public Double getSubsidyincome() {
        return subsidyincome;
    }

    public void setSubsidyincome(Double subsidyincome) {
        this.subsidyincome = subsidyincome;
    }

    public Integer getUsingtelevision() {
        return usingtelevision;
    }

    public void setUsingtelevision(Integer usingtelevision) {
        this.usingtelevision = usingtelevision;
    }

    public Double getRoaddistance() {
        return roaddistance;
    }

    public void setRoaddistance(Double roaddistance) {
        this.roaddistance = roaddistance;
    }

    public Integer getRoadtype() {
        return roadtype;
    }

    public void setRoadtype(Integer roadtype) {
        this.roadtype = roadtype;
    }

    public Double getHousearea() {
        return housearea;
    }

    public void setHousearea(Double housearea) {
        this.housearea = housearea;
    }

    public Integer getUnsafehouse() {
        return unsafehouse;
    }

    public void setUnsafehouse(Integer unsafehouse) {
        this.unsafehouse = unsafehouse;
    }

    public Double getLowinsure() {
        return lowinsure;
    }

    public void setLowinsure(Double lowinsure) {
        this.lowinsure = lowinsure;
    }

    public Double getAgedinsure() {
        return agedinsure;
    }

    public void setAgedinsure(Double agedinsure) {
        this.agedinsure = agedinsure;
    }

    public Double getEcoamount() {
        return ecoamount;
    }

    public void setEcoamount(Double ecoamount) {
        this.ecoamount = ecoamount;
    }

    public String getRunitid() {
        return runitid;
    }

    public void setRunitid(String runitid) {
        this.runitid = runitid == null ? null : runitid.trim();
    }

    public String getRunitname() {
        return runitname;
    }

    public void setRunitname(String runitname) {
        this.runitname = runitname == null ? null : runitname.trim();
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder == null ? null : recorder.trim();
    }

    public Date getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(Date recordtime) {
        this.recordtime = recordtime;
    }

    public Integer getStandard() {
        return standard;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    public String getSourcecode() {
        return sourcecode;
    }

    public void setSourcecode(String sourcecode) {
        this.sourcecode = sourcecode == null ? null : sourcecode.trim();
    }

    public String getSourcename() {
        return sourcename;
    }

    public void setSourcename(String sourcename) {
        this.sourcename = sourcename == null ? null : sourcename.trim();
    }

	@Override
	public boolean equalsIfIdNull(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCodeIfIdNull() {
		// TODO Auto-generated method stub
		return 0;
	}
}