package com.rahul.RPN.operators;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class ExponentialTest {

	private Exponential exponential = Exponential.getInstance();

	@Test
	public void expontialTest() {
		Stack<Double> stack = new Stack<Double>();
		stack.push(2.0);
		stack.push(3.0);
		exponential.operate(stack);
		double res = stack.pop();
		assertEquals(res, 8.0, 0.0);
		stack.push(4.0);
		stack.push(0.5);
		exponential.operate(stack);
		res = stack.pop();
		assertEquals(res, 2.0, 0.0);
		stack.push(8.0);
		stack.push((double) 1 / 3);
		exponential.operate(stack);
		res = stack.pop();
		assertEquals(res, 2.0, 0.0);
	}
	
	@Test
	public void testBoundary(){
		Stack<Double> stack = new Stack<Double>();
		stack.push(1.0);
		assertFalse(exponential.operate(stack));
	}
}
