package com.rahul.RPN.operators;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class FactorialTest {

	Factorial factorial = Factorial.getInstance();

	@Test
	public void testFact() {
		Stack<Double> stack = new Stack<Double>();
		stack.push(5.0);
		factorial.operate(stack);
		double res = stack.pop();
		assertEquals(res, 120.0, 0.0);
		stack.push(1.0);
		factorial.operate(stack);
		res = stack.pop();
		assertEquals(res, 1.0, 0.0);
		stack.push(-1.0);
		assertFalse(factorial.operate(stack));
	}

}
