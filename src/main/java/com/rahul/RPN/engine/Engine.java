package com.rahul.RPN.engine;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rahul.RPN.identifier.DataIdentifer;
import com.rahul.RPN.identifier.Token;
import com.rahul.RPN.operators.Addition;
import com.rahul.RPN.operators.Division;
import com.rahul.RPN.operators.Exponential;
import com.rahul.RPN.operators.Factorial;
import com.rahul.RPN.operators.Multiplication;
import com.rahul.RPN.operators.Operator;
import com.rahul.RPN.operators.Percentage;
import com.rahul.RPN.operators.Subtraction;

public class Engine implements Callable<Double>{

	private final Logger log = LoggerFactory.getLogger(Engine.class);

	private final Map<Character, Operator> operatorFactory;

	private Stack<Double> stack;

	private DataIdentifer dataIdentifer;
	
	private final String data; 

	public Engine(String data) {
		this.data = data;
		operatorFactory = new HashMap<Character, Operator>() {
			private static final long serialVersionUID = 1L;
			{
				put('+', Addition.getInstance());
				put('-', Subtraction.getInstance());
				put('*', Multiplication.getInstance());
				put('/', Division.getInstance());
				put('^', Exponential.getInstance());
				put('%', Percentage.getInstance());
				put('!', Factorial.getInstance());

			}
		};
		log.info("Operator factory intialized.");
		stack = new Stack<Double>();
		dataIdentifer = new DataIdentifer();
	}
	public Double call() throws Exception {
		return evaluteExpression();
	}

	public double evaluteExpression() throws Exception {
		String[] information = data.split(" ");

		for (String info : information) {
			Token identifiedData = dataIdentifer.getData(info);
			switch (identifiedData.getDataType()) {
			case OPERAND:
				stack.push(identifiedData.getOperand());
				log.debug("The operand idenified is {}", identifiedData.getOperand());
				break;
			case OPERATOR:
				Operator operator = operatorFactory.get(identifiedData.getOperator());
				operator.operate(stack);
				log.debug("The data opertator identified is {]", operator.getOperatorCharecter());
				break;
			default:
				log.error("data type has not been identified.");
				break;

			}
		}
		if (stack.size() == 1)
			return stack.pop();
		else {
			log.error("The error postfix expression: {} is not valid.", data);
			throw new Exception("The postfix expression is not well formed.");
		}
	}

	

}
