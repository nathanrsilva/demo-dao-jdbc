package program;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.entities.Department;
import model.entities.Seller;

public class Main {
	public static void main(String[]args) {
		Department department = new Department(23, "Books");
		Seller seller = new Seller(12, "Joao", "joao@gmail.com", 
				LocalDate.parse("12/03/1883", DateTimeFormatter.ofPattern("dd/MM/yyyy")),
				1239.0, department);
		
		
		System.out.println(department);
		System.out.println(seller);
	}
}
