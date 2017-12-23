package com.rahul.RPN.operators;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class MultiplicationTest {
	
	private Multiplication multiplication = Multiplication.getInstance();
	
	@Test
	public void testMultiplication(){
		Stack<Double> stack = new Stack<Double>();
		stack.push(2.4);
		stack.push(2.0);
		multiplication.operate(stack);
		double res = stack.pop();
		assertEquals(res,4.80,0.0);
		
	}

}
