package com.devsuperior.calculoSalario;

import com.devsuperior.calculoSalario.entities.Employee;
import com.devsuperior.calculoSalario.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.Locale;

@SpringBootApplication
public class CalculoSalarioApplication implements CommandLineRunner {



	@Autowired
	SalaryService salaryService = new SalaryService();
	Employee employee = new Employee("Juliano", 4000);


	public static void main(String[] args) {

		SpringApplication.run(CalculoSalarioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Locale brasil = new Locale("pt", "BR");
		NumberFormat moedaFormat = NumberFormat.getCurrencyInstance(brasil);
		String salarioFormatado = moedaFormat.format(salaryService.netSalary(employee));


		System.out.println("\nSalário base: " + salarioFormatado);


	}
}
