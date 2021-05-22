package com.obs.new1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BankController {
	
	private static BankModel model;
	private static BankView view;
	
	
	public BankController(BankModel model, BankView view){
		
		this.model = model;
		this.view =  view;
		
		this.model.add(view);
	}
	
	/*public void setView(BankView view) {
		this.view = new BankView();
	}*/
	
	public void start() {
		
		view.showMenuScreen();
	}
	
	/*public void tamamDevam(MyTimerController timer) {
		if(model.isState()) {
			view.showMenuScreen();
			return;
		}
		if(model.timeIsOut()) {
			//view1.showTurningOff();
			return;
		}
	}*/
	
	public static void showingBalanceOfAccount(int id) {
		
		
		ArrayList<Accounts> accountList = Accounts.getDefaultAccountList();
		
		model.resetTimer(view.getSecondLabel(), view.getMinuteLabel());
		
		if(accountList.get(0).getAccountID() == id) {
			JOptionPane.showMessageDialog(null, accountList.get(0).getAmountOfMoney() + " $");
		}
		else if (accountList.get(1).getAccountID() == id) {
			JOptionPane.showMessageDialog(null, accountList.get(1).getAmountOfMoney() + " $");
		}
		else if (accountList.get(2).getAccountID() == id) {
			JOptionPane.showMessageDialog(null, accountList.get(2).getAmountOfMoney() + " $");
		}
		else {
			JOptionPane.showMessageDialog(null, "invalid account");
		}

	}
	
	public static void drawingCash(int id, double money) {
		
		ArrayList<Accounts> accountList = Accounts.getDefaultAccountList();
		
		model.resetTimer(view.getSecondLabel(), view.getMinuteLabel());
		
		double total = 0;
		
		if(accountList.get(0).getAccountID() == id) {
			if(accountList.get(0).getAmountOfMoney() > 0) {
				
				total = accountList.get(0).getAmountOfMoney() - money;
				accountList.get(0).setAmountOfMoney(total);
			}
			
		}
		else if (accountList.get(1).getAccountID() == id) {
			if(accountList.get(1).getAmountOfMoney() > 0) {
				
				total = accountList.get(1).getAmountOfMoney() - money;
				accountList.get(1).setAmountOfMoney(total);
			}
			
		}
		else if (accountList.get(2).getAccountID() == id) {
			if(accountList.get(2).getAmountOfMoney() > 0) {
				
				total = accountList.get(2).getAmountOfMoney() - money;
				accountList.get(2).setAmountOfMoney(total);
			}
			
		}
		else {
			JOptionPane.showMessageDialog(null, "invalid account");
		}

		
	}
	
	public static void depositingCash(int id, double money) {
		
		ArrayList<Accounts> accountList = Accounts.getDefaultAccountList();
		
		model.resetTimer(view.getSecondLabel(), view.getMinuteLabel());
		
		double total = 0;
		
		if(accountList.get(0).getAccountID() == id) {
			total = accountList.get(0).getAmountOfMoney() + money;
			accountList.get(0).setAmountOfMoney(total);
		}
		else if (accountList.get(1).getAccountID() == id) {
			total = accountList.get(1).getAmountOfMoney() + money;
			accountList.get(1).setAmountOfMoney(total);
		}
		else if (accountList.get(2).getAccountID() == id) {
			total = accountList.get(2).getAmountOfMoney() + money;
			accountList.get(2).setAmountOfMoney(total);
		}
		else {
			JOptionPane.showMessageDialog(null, "invalid account");
		}

	
	}

	
		
	}
	

