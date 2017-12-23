package com.rahul.RPN.operators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Stack;

import org.junit.Test;

public class AdditionTest {

	private Addition addition = Addition.getInstance();

	@Test
	public void additionTest() {
		Stack<Double> stack = new Stack<Double>();
		stack.push(12.0);
		stack.push(11.11);
		addition.operate(stack);
		double res = stack.pop();
		assertEquals(res, 23.11, 0.0);
	}
	
	@Test
	public void additionBoundary(){
		Stack<Double> stack = new Stack<Double>();
		stack.push(-11.22);
		stack.push(11.22);
		addition.operate(stack);
		double res = stack.pop();
		assertEquals(0.0, res,0.0);
		assertFalse(addition.operate(stack));
	}
}
