package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdft = new SimpleDateFormat("dd/MM/yyyy");

		Locale.setDefault(Locale.US);

		System.out.print("Enter the deparment name");
		String departName = sc.nextLine();

		System.out.print("Type the worker data");
		String workerName = sc.nextLine();

		System.out.print("Type the worker level");
		String workerLevel = sc.nextLine();

		System.out.print("Type the worker salary");
		double workerSalary = sc.nextDouble();

		Worker worker = new Worker(new Department(departName), workerName, WorkerLevel.valueOf(workerLevel),
				workerSalary);

		System.out.println("How many contracts this worker will have ");
		Integer contratos = sc.nextInt();

		for (int i = 1; i < contratos; i++) {
			System.out.println("Contract number: " + "#" + i + " data");
			System.out.print("Date DD-MM-YYYY :");
			Date contractDate = sdft.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours) ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContracts(contract); 
		}
		
		

	}

}
