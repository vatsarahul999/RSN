package com.rahul.RPN.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Factorial implements Operator {

	private final char operatorSymbol = '!';

	private final Logger log = LoggerFactory.getLogger(Multiplication.class);

	private static final Factorial INSTANCE = new Factorial();

	private List<Double> mem;

	private Factorial() {
		mem = new ArrayList<Double>();
		mem.add(1.0);
		mem.add(1.0);
		log.debug("Intialized the Factorial Operator");
	}

	public boolean operate(Stack<Double> stack) {
		log.info("The operation performed is {}", operatorSymbol);
		if (stack.size() < 1)
			return false;
		double operand1 = stack.pop();
		if (operand1 < 0 || Double.toString(operand1).matches("\\d*\\.[1-9]\\d*")) {
			log.error("The factorial operator can not be applied to this argument : {}", operand1);
			return false;
		}
		double result = fact(operand1);
		stack.push(result);
		log.debug("The result of {} for {}  is {}", operatorSymbol, operand1, result);
		return true;
	}

	private double fact(double operand1) {
		int idx = (int) operand1;
		if (mem.size() >= idx)
			return mem.get(idx);
		int sz = mem.size();
		for (int i = sz; i <= idx; i++) {
			mem.add(mem.get(i - 1) * i);
		}
		return mem.get(idx);
	}

	public static Factorial getInstance() {
		return INSTANCE;
	}

	public char getOperatorCharecter() {
		return operatorSymbol;
	}

	public String getMessage() {
		return MESSAGE + this.operatorSymbol;
	}

}
