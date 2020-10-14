package junittest.com;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import classtotest.Airthmetic;

public class TestAirthmetic {

	@Test(expected =ArithmeticException.class)
	public void testDivision() {
		System.out.print("Inside test division method");
		Airthmetic airthmetic = new Airthmetic();
		assertEquals(1, airthmetic.division(1, 0));
	}

}
