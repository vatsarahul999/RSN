package com.rahul.RPN.operators;

import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Division implements Operator {

	private final char operatorSymbol = '/';

	private final Logger log = LoggerFactory.getLogger(Multiplication.class);

	private static final Division INSTANCE = new Division();

	private Division() {
		log.debug("Intialized the Division Operator");
	}

	public boolean operate(Stack<Double> stack) {
		log.info("The operation performed is {}", operatorSymbol);
		if (stack.size() < 2)
			return false;
		double operand1 = stack.pop();
		double operand2 = stack.pop();
		double result = operand1 / operand2;
		stack.push(result);
		log.debug("The result of {} between {} and  is {}", operatorSymbol, operand1, operand2, result);
		return true;
	}

	public static Division getInstance() {
		return INSTANCE;
	}

	public char getOperatorCharecter() {
		return operatorSymbol;
	}

	public String getMessage() {
		return MESSAGE + this.operatorSymbol;
	}

}
