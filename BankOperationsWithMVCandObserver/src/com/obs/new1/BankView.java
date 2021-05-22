package com.obs.new1;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class BankView extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;
	private BankModel model;
	private BankController controller;
	private static JButton showBlanceBtn, addAccountBtn, depositMoneyBtn, quitBtn, drawMoneyBtn;
	private static JLabel secondLabel = new JLabel("0");
	private static JLabel minuteLabel = new JLabel("       2");
	private static JLabel lblNewLabel_1;
	private static JFrame frame;
	private static JTable table;
	private static DefaultTableModel model1;
	private static JScrollPane pane;
	
	
	public BankView(BankModel model) throws HeadlessException {
		this.model = model;
		
		//addEventListeners();
	}
	
	
	
	
	
	public void showMenuScreen() {
		
		
	
		setFrame();
		
		setTableView();
		
		showBalanceOnMessage();
		
		addAccountToTableView();
		
		depositMoneyToSelectedAccount();
		
		removeView();
		
		drawMoneyFromSelectedAccount();
		
		startTimerToView();
		
		
		frame.setVisible(true);
		
		
		
	}


	public static JFrame getFrame() {
		return frame;
	}
	
	public void setTableView() {
		table = new JTable();
		
		model1 = new DefaultTableModel();
		
		Object[] columns = {"Account ID", "Account Name", "Account Type"};
		
		model1.setColumnIdentifiers(columns);
		table.setModel(model1);
		
		Object[] row = new Object[3];
		
		Object[] row1Data = {Accounts.getDefaultAccountList().get(0).getAccountID(), Accounts.getDefaultAccountList().get(0).getAccountName(),Accounts.getDefaultAccountList().get(0).getAccountType()};
		Object[] row2Data = {Accounts.getDefaultAccountList().get(1).getAccountID(), Accounts.getDefaultAccountList().get(1).getAccountName(),Accounts.getDefaultAccountList().get(1).getAccountType()};
		Object[] row3Data = {Accounts.getDefaultAccountList().get(2).getAccountID(), Accounts.getDefaultAccountList().get(2).getAccountName(),Accounts.getDefaultAccountList().get(2).getAccountType()};
		
		
		
		model1.addRow(row1Data);
		model1.addRow(row2Data);
		model1.addRow(row3Data);
		
		table.setBackground(Color.white);
		table.setForeground(Color.black);
		table.setSelectionBackground(Color.red);
		table.setGridColor(Color.red);
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);
		
		pane = new JScrollPane(table);
		pane.setForeground(Color.RED);
		pane.setBackground(Color.WHITE);
		pane.setBounds(10, 11, 564, 358);
		frame.getContentPane().add(pane);
	}
	
	public void setFrame() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		frame = new JFrame("Menu");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 757, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
	}
	
	public void showBalanceOnMessage() {
		
	
	showBlanceBtn = new JButton("Show Balance");
	
	showBlanceBtn.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			
			
			int row =  table.getSelectedRow();
			if(row == -1) {
				if(table.getRowCount() == 0) {
					JOptionPane.showMessageDialog(frame, "Please add an account to commit any operation.");
				}
				else {
					JOptionPane.showMessageDialog(frame, "Please select account which you would like to see its balance");
				}
			}
			else {
				int id = (int) table.getValueAt(row, 0);
				
				controller.showingBalanceOfAccount(id);
				
				
			}
			
			
		}
	});
	showBlanceBtn.setBounds(615, 8, 104, 43);
	frame.getContentPane().add(showBlanceBtn);
	
	}
	
	public void addAccountToTableView() {
		
		addAccountBtn = new JButton("Add Account");
		addAccountBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				
				
			}
			
		});
		addAccountBtn.setBounds(615, 302, 104, 45);
		frame.getContentPane().add(addAccountBtn);
		
	}
	
	public void depositMoneyToSelectedAccount() {
		
		depositMoneyBtn = new JButton("Deposit Money");
		depositMoneyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				int row =  table.getSelectedRow();
				if(row == -1) {
					if(table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(frame, "Please add an account to commit any operation.");
					}
					else {
						JOptionPane.showMessageDialog(frame, "Please select account which you would like to see its balance");
					}
				}
				else {
					double money = Double.parseDouble(JOptionPane.showInputDialog("Please enter amount of money with dot if it has double value:"));
					int id = (int) table.getValueAt(row, 0);
					System.out.println(id);
					controller.depositingCash(id, money);
					
				}
			}
		});
		depositMoneyBtn.setBounds(615, 104, 104, 43);
		frame.getContentPane().add(depositMoneyBtn);
		
	}
	
	public void removeView() {
		
		quitBtn = new JButton("Quit");
		quitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread t = new Thread() {
					public void run() {
						try {
							sleep(2000);
							frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
						}
						catch(Exception e) {
							
						}
					}
				};
				t.start();
				JOptionPane.showMessageDialog(frame, "Exiting from system...");
				
			}
		});
		quitBtn.setBounds(615, 404, 104, 43);
		frame.getContentPane().add(quitBtn);
		
	}
	
	public void drawMoneyFromSelectedAccount() {
		
		drawMoneyBtn = new JButton("Draw Money");
		drawMoneyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				int row =  table.getSelectedRow();
				if(row == -1) {
					if(table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(frame, "Please add an account to commit any operation.");
					}
					else {
						JOptionPane.showMessageDialog(frame, "Please select account which you would like to see its balance");
					}
				}
				else {
					double money = Double.parseDouble(JOptionPane.showInputDialog("Please enter amount of money with dot if it has double value:"));
					int id = (int) table.getValueAt(row, 0);
					System.out.println(id);
					controller.drawingCash(id, money);
					
				}
			}
		});
		drawMoneyBtn.setBounds(615, 205, 104, 43);
		frame.getContentPane().add(drawMoneyBtn);
		
	}
	
	public void startTimerToView() {
		
		
		minuteLabel.setBackground(Color.WHITE);
		minuteLabel.setForeground(Color.BLACK);
		minuteLabel.setBounds(10, 404, 53, 14);
		frame.getContentPane().add(minuteLabel);
		
		lblNewLabel_1 = new JLabel(":");
		lblNewLabel_1.setBounds(65, 404, 12, 14);
		frame.getContentPane().add(lblNewLabel_1);
		

		secondLabel.setBounds(76, 404, 65, 14);
		frame.getContentPane().add(secondLabel);
		
		model.startTimer(secondLabel, minuteLabel);
		
		
	}
	
	
	
	
	public static JLabel getSecondLabel() {
		return secondLabel;
	}





	public static JLabel getMinuteLabel() {
		return minuteLabel;
	}





	@Override
	public void update(Observable observable) {
		
		BankModel bank = (BankModel) observable;
		
		
		
		JOptionPane.showMessageDialog(null, "Time is out so your system should be turned off for your safety.");
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

	}
	
	

}
