package com.rahul.RPN.operators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Stack;

import org.junit.Test;

public class PercentageTest {
	
	Percentage percentage = Percentage.getInstance();
	
	@Test
	public void testPercent(){
		Stack<Double> stack = new Stack<Double>();
		stack.push(20.0);
		percentage.operate(stack);
		double res = stack.pop();
		assertEquals(res,0.20,0.0);
		stack.push(-120.0);
		percentage.operate(stack);
		res = stack.pop();
		assertEquals(res,-1.20,0.0);
		assertFalse(percentage.operate(stack));
	}
}
