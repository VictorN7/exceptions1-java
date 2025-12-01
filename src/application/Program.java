package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		
		Scanner scan = new Scanner(System.in);
		
		SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number:");
		Integer roomNumber = scan.nextInt();
		
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(scan.next());
		
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(scan.next());
		
		if (!checkout.after(checkin)) { // after testa uma data após a outra
			System.out.println("Erros in reservation: Check-out date must be after check-in ");
		} else {
			Reservation res = new Reservation(roomNumber, checkin, checkout);
			System.out.println(res);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date updateCheckin = sdf.parse(scan.next());
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date updateCheckout = sdf.parse(scan.next());
						
			String error = res.updateDates(updateCheckin, updateCheckout);
			
			if (error != null) {
				System.out.println("Error in Reservation: "+ error);
			}else {
				System.out.println("Reservation: "+res);
			}
			
			
			
			
		}

		
		
		scan.close();
		
		
	}

}
