package junittest.com;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import classtotest.FindMaxInArray;


public class TestLogicFindMax {
	@Test
	public void findMaxElement()
	{
		assertEquals(4, FindMaxInArray.findMaxElement(new int[]{1,2,3,4}));
		assertEquals(-1, FindMaxInArray.findMaxElement(new int[] {-1,-2,-3,-5}));
	}

}
