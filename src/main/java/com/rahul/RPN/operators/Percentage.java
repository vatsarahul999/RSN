package com.rahul.RPN.operators;

import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Percentage implements Operator{
	
private final char operatorSymbol = '%';
	
	private final Logger log = LoggerFactory.getLogger(Percentage.class);

	private static final Percentage INSTANCE = new Percentage();

	private Percentage() {
		log.debug("Intialized the Percentage Operator");
	}

	public boolean operate(Stack<Double> stack) {
		log.info("The operation performed is {}", operatorSymbol);
		if (stack.size() < 1)
			return false;
		double operand1 = stack.pop();
		double result = operand1 /100;
		stack.push(result);
		log.debug("The result of {} for {}  is {}", operatorSymbol, operand1,  result);
		return true;
	}
	
	public static Percentage getInstance(){
		return INSTANCE;
	}

	public char getOperatorCharecter() {
		return operatorSymbol;
	}

	public String getMessage() {
		return MESSAGE + this.operatorSymbol;
	}

}
