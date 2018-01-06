	package com.rahul.RPN.engine;

import static org.junit.Assert.*;

import org.junit.Test;

public class EngineTest {

	private Engine engine;

	@Test
	public void testEngine() {
		engine = new Engine("1 2 3 + -");
		try {
			double result = engine.evaluteExpression();
			assertEquals(result, -4.00, 0.0);
			engine = new Engine("6 2 * 3 /");
			result = engine.evaluteExpression();
			assertEquals(result, 4.00, 0.0);
			engine = new Engine("2 3 ^ 4 5 + +");
			result = engine.evaluteExpression();
			assertEquals(result, 17.00, 0.0);
			engine = new Engine("50 % 2 *");
			result = engine.evaluteExpression();
			assertEquals(result, 1.00, 0.0);
			engine = new Engine("3 ! 4 5 * +");
			result = engine.evaluteExpression();
			assertEquals(result, 26.00, 0.0);
			engine = new Engine("12 3 / !");
			result = engine.evaluteExpression();
			assertEquals(result, 24.00, 0.0);
			engine = new Engine("5 1 2 + 4 * + 3 -");
			result = engine.evaluteExpression();
			assertEquals(result, 14.00, 0.0);
		} catch (Exception e) {
			e.printStackTrace(); 	
		}

	}

}
