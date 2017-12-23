package com.rahul.RPN.operators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Stack;

import org.junit.Test;

public class SubtractionTest {
	
	private Subtraction subtraction = Subtraction.getInstance();
	
	@Test
	public void testSubtraction(){
		Stack<Double> stack = new Stack<Double>();
		stack.push(20.00);
		stack.push(120.00);
		subtraction.operate(stack);
		double res = stack.pop();
		assertEquals(res,-100.00,0.0);
 	}
	
	public void boundaryTest(){
		Stack<Double> stack = new Stack<Double>();
		stack.push(20.00);
		assertFalse(subtraction.operate(stack));
		
	}

}
