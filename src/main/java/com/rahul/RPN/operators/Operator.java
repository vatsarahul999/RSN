package com.rahul.RPN.operators;

import java.util.Stack;

public interface Operator {
	
	public static String MESSAGE="The RPN evaluator supports ";
	
	public boolean operate(Stack<Double> stack); 
	
	public char getOperatorCharecter();
	
	public String getMessage();
	
}
