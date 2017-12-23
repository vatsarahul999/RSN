package com.rahul.RPN.operators;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class DivisionTest {

	private Division division = Division.getInstance();
	
	@Test
	public void divisionTest(){
		Stack<Double> stack = new Stack<Double>();
		stack.push(12.00);
		stack.push(3.00);
		division.operate(stack);
		double res = stack.pop();
		assertEquals(res,4.00,0.0);
	}
	
	@Test
	public void boundaryTest(){
		Stack<Double> stack = new Stack<Double>();
		stack.push(10.00);
		stack.push(0.00);
		assertFalse(division.operate(stack));
		assertFalse(division.operate(stack));
		
	}
}
