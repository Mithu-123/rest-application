package classtotest;

public class EmpBusinessLogic {

	public double calculateYearlySalary(EmployeeDetails empDetails) {
		double salary = 0;
		salary = 12 * empDetails.getMonthlySalary();
		return salary;
	}

	public double calculateAppraisal(EmployeeDetails empdetails) {
		double appraisal = 0;

		if (empdetails.getMonthlySalary() > 1000)
			appraisal = 50;
		else
			appraisal = 30;

		return appraisal;

	}

	public String demoIngoreAnnotation() {

		return "mikumar";
	}

}
