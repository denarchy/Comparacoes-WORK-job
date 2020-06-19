package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private double baseSalary;
	
	private Department department;
	private List<HourContract> contracts = new ArrayList<HourContract>();
	
	public Worker() {
		
	}

	public Worker(Department department, String name, WorkerLevel level, double baseSalary) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public void addContracts(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public double Income(int year, int month) {
		double sum = baseSalary;
		Calendar calendar = Calendar.getInstance();
		for(HourContract c : contracts) {
			calendar.setTime(c.getDate());
			int cal_year = calendar.get(Calendar.YEAR);
			int cal_month = calendar.get(Calendar.MONDAY);
			if(year == cal_year && month == cal_month ) {
				sum+= c.TotalValue();
			}
		}
		return sum;
	}
	
	
	
}
