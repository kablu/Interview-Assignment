package com.assignment.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import com.assignment.custom.CustomArrayList;
import com.assignment.exception.UnableToAddDataException;
/**
 * 
 * @author Kablu
 *
 */
public class TestCase {

	CustomArrayList<String> cl = CustomArrayList.getInstance();

	@Test
	public void testAdd() {
		cl.add("Mumbai");
		cl.add("Delhi");
		cl.add("Kolkata");
		cl.add("Ranchi");
		cl.add("Bokaro");
		cl.add("Patna");
		cl.add("Chandigrah");
		cl.add("Shimla");
		assertEquals("Adding 8 city to list", 5, cl.getSize());
	}

	@Test
	public void testNullNotallowed() {

		assertThrows(UnableToAddDataException.class, () -> {
			cl.add(null);
			cl.add("Delhi");
			cl.add("Kolkata");
			cl.add("Ranchi");
		});
	}

	@Test
	public void testDuplicateValuesNotAllowed() {

		assertThrows(UnableToAddDataException.class, () -> {
			cl.add("Lonavala");
			cl.add("Delhi");
			cl.add("Delhi");
			cl.add("Ranchi");
		});
	}

}
