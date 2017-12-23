package com.rahul.RPN.engine;

import static org.junit.Assert.*;

import org.junit.Test;

public class EngineTest {

	private Engine engine;

	@Test
	public void testEngine() {
		engine = new Engine();
		try {
			double result = engine.evaluteExpression("1 2 3 + -");
			assertEquals(result, -4.00, 0.0);
			result = engine.evaluteExpression("6 2 * 3 /");
			assertEquals(result, 4.00, 0.0);
			result = engine.evaluteExpression("2 3 ^ 4 5 + +");
			assertEquals(result, 17.00, 0.0);
			result = engine.evaluteExpression("50 % 2 *");
			assertEquals(result, 1.00, 0.0);
			result = engine.evaluteExpression("3 ! 4 5 * +");
			assertEquals(result, 26.00, 0.0);
			result = engine.evaluteExpression("12 3 / !");
			assertEquals(result, 24.00, 0.0);
			result = engine.evaluteExpression("5 1 2 + 4 * + 3 -");
			assertEquals(result, 14.00, 0.0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
