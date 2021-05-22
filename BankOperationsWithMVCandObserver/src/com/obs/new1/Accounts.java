package com.obs.new1;

import java.util.ArrayList;

public class Accounts {
	private int accountID;
	private String accountType;
	private String accountName;
	private double amountOfMoney;
	private static ArrayList<Accounts> accountList;
	private static Accounts account1 = new Accounts(1, "Debit", "Edirne", 100.99);
	private static Accounts account2 = new Accounts(2, "Credit", "Ýstanbul", 300.99);
	private static Accounts account3 = new Accounts(3, "Debit", "Ýzmir", 200.99);
	
	public Accounts(int accountID, String accountType, String accountName, double amountOfMoney) {
		super();
		this.accountID = accountID;
		this.accountType = accountType;
		this.accountName = accountName;
		this.amountOfMoney = amountOfMoney;
		Accounts.accountList = new ArrayList<>();
	}
	
	public static ArrayList<Accounts> getDefaultAccountList() {
		
		
		accountList.add(account1);
		accountList.add(account2);
		accountList.add(account3);
		
		return accountList;
	}
	
	public void add(Accounts account) {
		accountList.add(account);
	}
	
	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getAmountOfMoney() {
		return amountOfMoney;
	}

	public void setAmountOfMoney(double amountOfMoney) {
		this.amountOfMoney = amountOfMoney;
	}
	
	
}
