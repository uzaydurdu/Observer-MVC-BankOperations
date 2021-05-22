package com.obs.new1;

import java.awt.Color;

import javax.swing.JLabel;

public class BankModel extends Observable {
	
	private static int  second = 0;
	private static int minute = 2;
	private static boolean state = true;
	
	public void startTimer(JLabel secondLabel, JLabel minuteLabel) {
		
		state = true;
		
		
		Thread t = new Thread() {
			
			public void run() {
				
				for(;;)
					
				if(state == true) {
					try {
						sleep(1000);
						
						
						if(second==0){
							second = 59;
							minute--;
						}
					
						if(minute==0){
							secondLabel.setForeground(Color.red);
							minuteLabel.setForeground(Color.red);
						}
						if(minute <0) {
							timeIsOut();
							minute = 0;
							second = 0;
							break;
						}
						else {
							second--;
							if(second<10) {
								secondLabel.setText("0" + second);
							}
							
						}
						secondLabel.setText(" " + second);
						minuteLabel.setText(" " + minute);
					}
					catch(Exception e) {
						
					}
					
				}
				else {
					break;
				}
				
			}
			
		};
		t.start();
		
	}
	
	public static void resetTimer(JLabel secondLabel, JLabel minuteLabel) {
		state = true;
	
		minute=2;
		second=0;
	
		minuteLabel.setText(" 2");
		secondLabel.setText(" 0");
}
	public void timeIsOut() {
		giveInfo();
	}

	public static int getSecond() {
		return second;
	}

	public static void setSecond(int second) {
		BankModel.second = second;
	}

	public static int getMinute() {
		return minute;
	}

	public static void setMinute(int minute) {
		BankModel.minute = minute;
	}

	public static boolean isState() {
		return state;
	}

	public static void setState(boolean state) {
		BankModel.state = state;
	}
	
	

}
