package com.obs.new1;



public class MVCMain {
	public static void main(String[] args) {
	
		/*MyTimerController timer = new MyTimerController(0,2);//MODEL
		MenuGUI menu = new MenuGUI(timer);//VÝEW
		//Operations operation = new Operations(menu,timer); //CONTROLLER
		Operations operation = new Operations(); //CONTROLLER
		
		//timer.add(customer);
		timer.add(operation);*/
		
		BankModel model = new BankModel();
		
		BankView view = new BankView(model);
		
		BankController controller = new BankController(model, view);
		
		controller.start();
	
		
		
		
		
		
	}
}
