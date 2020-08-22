package ui;
import model.*;
import exceptions.*;
import java.util.*;


public class Main {
	

	
	public static void main(String args[]) {
		
		
		 Market minimarket = new Market();
		 Scanner sc = new Scanner(System.in);
		 boolean exit = false;
		
		System.out.println("MENU DE OPCIONES");
		System.out.println("1.Registrarse");
		System.out.println("");
		System.out.println("2.Mostrar total de entradas");
		System.out.println("");
		System.out.println("3.Salir de la aplicacion");
		System.out.println("");
		int option = sc.nextInt();
		
		while(!exit) {
		
		switch(option) {
		
		case 1:
			
			System.out.println("Ingrese su tipo de documento: 1 Si es TI, 2 si es cedula, 3 si es PP, 4 si es Ce");
			int documento = sc.nextInt();
			sc.nextLine();
	        boolean condicion1 = minimarket.checkId(documento);
	        System.out.println("Ingrese su numero de documento");
	        String numerodocumento = sc.nextLine();
	        sc.nextLine();
	        boolean condicion2 = minimarket.checkCedula(numerodocumento);
	        
	        if(condicion1 == true || condicion2 == true) {
	        	
	        	
	        	Client client1 = new Client(documento, numerodocumento);
	        	
	        	
	        	
	        	
	        	
	        	
	        	
	        	
	        }
	        
	        
	        
		case 2:
			
			System.out.println("");
			System.out.println("total de entradas= " + minimarket.getEntries() );
			
			
			
		case 3:
			
			ArrayList<Client> clients = minimarket.getClients();
			for(int i= 0; i<clients.size();i++) {
				
				clients.remove(clients.get(i));
				
			}
			
			
			exit = true;
			
		}
			
		  
			
		
		
		
		
		
		
		
		
		
		}
		
	
		
		
		
		
	}
	
	
}
