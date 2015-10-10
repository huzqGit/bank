package com.bank.beans;

import java.util.List;

public class FarmerTotal {
	private List<Farmer> farmers;
	private List<FarmerMember> members;
	private List<FarmerLoan> loans;
	private List<FarmerPrivateLending> privatelendings;
	private List<FarmerHouse> houses;
	private List<FarmerForest> forests;
	private List<FarmerBreed> breeds;
	private List<FarmerDevice> devices;
	private List<FarmerPay> balances;
	private List<FarmerCompunish> compunishs;
	private List<FarmerInsured> insureds;
	private List<FarmerEvaluate> evaluates;
	public List<Farmer> getFarmers() {
		return farmers;
	}
	public void setFarmers(List<Farmer> farmers) {
		this.farmers = farmers;
	}
	public List<FarmerMember> getMembers() {
		return members;
	}
	public void setMembers(List<FarmerMember> members) {
		this.members = members;
	}
	public List<FarmerLoan> getLoans() {
		return loans;
	}
	public void setLoans(List<FarmerLoan> loans) {
		this.loans = loans;
	}
	public List<FarmerPrivateLending> getPrivatelendings() {
		return privatelendings;
	}
	public void setPrivatelendings(List<FarmerPrivateLending> privatelendings) {
		this.privatelendings = privatelendings;
	}
	public List<FarmerHouse> getHouses() {
		return houses;
	}
	public void setHouses(List<FarmerHouse> houses) {
		this.houses = houses;
	}
	public List<FarmerForest> getForests() {
		return forests;
	}
	public void setForests(List<FarmerForest> forests) {
		this.forests = forests;
	}
	public List<FarmerBreed> getBreeds() {
		return breeds;
	}
	public void setBreeds(List<FarmerBreed> breeds) {
		this.breeds = breeds;
	}
	public List<FarmerDevice> getDevices() {
		return devices;
	}
	public void setDevices(List<FarmerDevice> devices) {
		this.devices = devices;
	}
	public List<FarmerPay> getBalances() {
		return balances;
	}
	public void setBalances(List<FarmerPay> balances) {
		this.balances = balances;
	}
	public List<FarmerCompunish> getCompunishs() {
		return compunishs;
	}
	public void setCompunishs(List<FarmerCompunish> compunishs) {
		this.compunishs = compunishs;
	}
	public List<FarmerInsured> getInsureds() {
		return insureds;
	}
	public void setInsureds(List<FarmerInsured> insureds) {
		this.insureds = insureds;
	}
	public List<FarmerEvaluate> getEvaluates() {
		return evaluates;
	}
	public void setEvaluates(List<FarmerEvaluate> evaluates) {
		this.evaluates = evaluates;
	}

}
