package com.bank.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evaluate {
	private List<Date> birthDates;
	private List<Integer> educates;
	private List<Integer> laborNums;
	private List<String> marryStatuies;
	private List<Double> totalIncomes;
	private List<Double> totalPays;
	private List<String> loanStatus;
	private List<Integer> commandStatus;
	private List<String> evaluateStatus;
	private List<String> creditStatus;
	
	private List<String> msgs = new ArrayList<String>();
	
	public Evaluate(List<Date> birthDates,List<Integer> educates,List<Integer> laborNums,List<String> marryStatuies,
			List<Double> totalIncomes,List<Double> totalPays,List<String> loanStatus,
			List<Integer> commandStatus,List<String> evaluateStatus,List<String> creditStatus){
		this.birthDates = birthDates;
		this.educates = educates;
		this.laborNums = laborNums;
		this.marryStatuies = marryStatuies; 
		this.totalIncomes = totalIncomes;
		this.totalPays = totalPays;
		this.loanStatus = loanStatus;
		this.commandStatus = commandStatus;
		this.evaluateStatus = evaluateStatus;
		this.creditStatus = creditStatus;
		
	}

	private int cacluateByAge(){
		Date birthDate = null;
		int score = 0;
		for(Date date:birthDates){
			if(date == null){
				continue;
			}else {
				if(birthDate== null){
					birthDate =date;
				}else if(date.compareTo(birthDate)>0){
					if(!msgs.contains("出生日期存在不一致")){
						msgs.add("出生日期存在不一致");
					}
				}
			}
		}
		if(birthDate != null){
			Date date = new Date();
			long mills = date.getTime()-birthDate.getTime();
			long age = mills/1000/60/60/24/365;
			if(age >=18 && age <=24){
				score = 3;
			}else if(age>=25 && age<=34){
				score = 4;
			}else if(age >=35 && age <=50){
				score = 5;
			}else if(age >50){
				score = 3;
			}
		}
		return score;
	}
	private int cacluateByEducate(){
		Integer educate = null;
		int score =3;
		for(Integer temp:educates){
			if(temp == null){
				continue;
			}else{
				if(educate == null){
					educate = temp;
				}else if(!temp.equals(educate)){
					if(!msgs.contains("学历不一致")){
						msgs.add("学历不一致");
					}
				}
			}
		}
		if(educate == null){
			return score;
		}else{
			if(educate == 6 || educate == 7 || educate == 9 ){
				score = 3;
			}else if(educate == 5 || educate == 4){
				score = 4;
			}else if(educate == 3 || educate == 2 || educate ==1){
				score = 5;
			}
			return score;
		}
	}
	private int cacluateByLaborNum(){
		Integer labornum = null;
		int score = 0;
		for(Integer temp:laborNums){
			if(temp == null){
				continue;
			}else{
				if(labornum == null){
					labornum = temp;
				}else if(!temp.equals(labornum)){
					if(!msgs.contains("劳动力人数不一致")){
						msgs.add("劳动力人数不一致");
					}
				}
			}
		}
		if(labornum == null){
			return score;
		}else{
			if(labornum >=4){
				score = 3;
			}else if(labornum == 3){
				score = 2;
			}else if(labornum == 2){
				score = 1;
			}
			return score;
		}
	}
	private int cacluateByMarryStatus(){
		String marryStatus = null;
		int score = 0;
		for(String temp:marryStatuies){
			if(temp == null){
				continue;
			}else{
				if(marryStatus == null){
					marryStatus = temp;
				}else if(temp.equals(marryStatus)){
					if(!msgs.contains("婚姻状况不一致")){
						msgs.add("婚姻状况不一致");
					}
				}
			}
		}
		if(marryStatus == null){
			return score;
		}else {
			if(marryStatus.equals("1")){
				score = 2;
			}
			return score;
		}
	}
	private int cacluateByTotalIncome(){
		Double totalIncome = null;
		int score =0;
		for(Double temp:totalIncomes){
			if(temp == null){
				continue;
			}else{
				if(totalIncome == null){
					totalIncome = temp;
				}else if(!temp.equals(totalIncome)){
					if(!msgs.contains("年度收入情况不一致")){
						msgs.add("年度收入情况不一致");
					}
				}
			}
		}
		if(totalIncome == null){
			return score;
		}else{
			score =10;
			Double num = (totalIncome - 100000)/10000;
			score = score+num.intValue();
			if(score >= 20){
				score =20;
			}else if (score <=0){
					score =0;
			}else{
				score=10+num.intValue();
			}
			return score;
		}
	}

	private int calculateByIncomeAndPay(){
		Double totalIncome = null;
		Double totalPay = null;
		int score = 0;
		for(Double temp:totalIncomes){
			if(temp == null){
				continue;
			}else{
				if(totalIncome == null){
					totalIncome = temp;
				}
			}
		}
		for(Double temp:totalPays){
			if(temp == null){
				continue;
			}else{
				if(totalPay == null){
					totalPay = temp;
				}else if(!temp.equals(totalPay)){
					if(!msgs.contains("年度支出情况不一致")){
						msgs.add("年度支出情况不一致");
					}
				}
			}
		}
		if(totalIncome == null){
			score = 0;
			return score;
		}else if(totalPay == null ){
			score = 0;
			return score;
		}else{
			int num = (int)(totalIncome /totalPay);
			if (num >=5){
				score = 10;
			}else if(num >=3 && num<5){
				score = 8;
			}else if(num >=1 && num<3){
				score = 4;
			}else {
				score = 0;
			}
			return score;
		}
		
	}
	private int calculateByLoanStatus(){
		int coal = 0;
		if(loanStatus.contains("损失")||loanStatus.contains("次级")){
			coal =-20;
		}else if(loanStatus.contains("关注")){
			coal = -5;
		}else if(loanStatus.contains("正常")){
			coal =20;
		}
		return coal;
	}
	private int calculateByCommand(){
		int coal = 0;
		if(commandStatus.contains("1")){
			coal = 10;
		}else if(commandStatus.contains("2")){
			coal = 6;
		}else if(commandStatus.contains("3")){
			coal = 4;
		}else if(commandStatus.contains("4")){
			coal = 2;
		}else if(commandStatus.contains("5")){
			coal = 1;
		}else {
			coal = 0;
		}
		return coal;
	}
	private int calculateByEvaluate(){
		int coal = 0;
		if("1".equals(evaluateStatus)){
			coal = 5;
		}else if("2".equals(evaluateStatus)){
			coal = 4;
		}else if("3".equals(evaluateStatus)){
			coal  = 2;
		}else if("4".equals(evaluateStatus)){
			coal = 1;
		}else if("5".equals(evaluateStatus)){
			coal = 0;
		}
		return coal;
	}
	private int calculateByCreditStatus(){
		int coal = 0;
		if(creditStatus.contains("1")){
			coal = 20;
		}else if(creditStatus.contains("2")){
			coal = 15;
		}else if(creditStatus.contains("3")){
			coal = 10;
		}else if(creditStatus.contains("9")){
			coal = 5;
		}
		return coal;
	}
	public int cacluate(){
		int coal = this.cacluateByAge()+this.cacluateByEducate()
			+this.cacluateByLaborNum()+this.cacluateByMarryStatus()
			+this.cacluateByTotalIncome()+this.calculateByIncomeAndPay()
			+this.calculateByLoanStatus()+this.calculateByCommand()
			+this.calculateByEvaluate()+this.calculateByCreditStatus();
		return coal;
	}
	public String cacluate1(){
		int coal = this.cacluateByAge()+this.cacluateByEducate()
			+this.cacluateByLaborNum()+this.cacluateByMarryStatus()
			+this.cacluateByTotalIncome()+this.calculateByIncomeAndPay()
			+this.calculateByLoanStatus()+this.calculateByCommand()
			+this.calculateByEvaluate()+this.calculateByCreditStatus();
			if(coal>=95){
				return "AAA";
			}else if(coal>=90 && coal<=94){
				return "AA";
			}else if(coal >=85 && coal<=89){
				return "A";
			}else if(coal >=80 && coal<=84){
				return "BBB";
			}else if(coal >=75 && coal <=79){
				return "BB";
			}else if(coal >=70 && coal<=74){
				return "B";
			}else if(coal >=65 && coal <=69){
				return "C";
			}else {
				return  "";
			}
	}
	public static void main(String[] args){
		List<String> test = new ArrayList<String>();
		test.add("测试");
		test.add("确实");
		if(test.contains("确实")){
			System.out.println("ok");
		}
	}
}
