package model;

import java.util.ArrayList;
import java.time.LocalDate;

public class Market {

	
	private ArrayList<Client> clients;
	private int entries;
	
	
	
	public Market() {
		
		this.clients = new ArrayList<>();
	}
	
	public ArrayList<Client> getClients(){
		
		return clients;
	}
	
	public String addClient(String idNumber, int typeDoc) {
		
		String message =  "";
		Client client = new Client(typeDoc, idNumber);
		
		entries++;
		
		if(checkCedula(idNumber)) {
			
			clients.add(client);
			message = "Ok, you can enter to the market";
			
			
		}
		
		
		return "Operation is complete" 
		
	}
	
	public boolean checkCedula(String idNumber) {
		
		boolean documentstatus = false;
		int dayofMonth = LocalDate.now().getDayOfMonth();
		int number = idNumber.charAt(idNumber.length()-2);
		
		if(number % 2 == 0) {
			if(dayofMonth % 2 != 0) {
				
				documentstatus = true;
				
			}
				
				
			
			
			
		} else if(number % 2 != 0) {
			
			
			if(dayofMonth % 2 == 0) {
				
				documentstatus = true;
			}
		}
		
		return documentstatus;
	}
	
}
