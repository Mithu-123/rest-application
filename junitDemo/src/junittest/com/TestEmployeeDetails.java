package junittest.com;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import classtotest.EmpBusinessLogic;
import classtotest.EmployeeDetails;

public class TestEmployeeDetails {

	@Test
	public void testCalculateYearlySalary() {
		EmployeeDetails empDetails = new EmployeeDetails();
		empDetails.setAge(24);
		empDetails.setMonthlySalary(120);
		empDetails.setName("kumar");
		EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
		assertEquals(1440, empBusinessLogic.calculateYearlySalary(empDetails));

	}

	@Test
	public void testCalculateAppraisal() {
		EmployeeDetails empDetails = new EmployeeDetails();
		empDetails.setAge(22);
		empDetails.setMonthlySalary(1200);
		empDetails.setName("kumar22");
		EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
		assertEquals(50, empBusinessLogic.calculateAppraisal(empDetails));

	}

	@Test
	@Ignore
	public void testIngoreDemoAnnotation() {
		EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
		assertEquals("kumar", empBusinessLogic.demoIngoreAnnotation());
	}

}
