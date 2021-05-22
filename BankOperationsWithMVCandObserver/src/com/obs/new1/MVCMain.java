package com.obs.new1;



public class MVCMain {
	public static void main(String[] args) {
	
	
		
		BankModel model = new BankModel();
		
		BankView view = new BankView(model);
		
		BankController controller = new BankController(model, view);
		
		controller.start();
	
		
		
		
		
		
	}
}
