package com.rahul.RPN.identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataIdentiifer {

	private final Logger log = LoggerFactory.getLogger(DataIdentiifer.class);

	public Token getData(String data) throws IllegalArgumentException {
		DataTypes dataTypes = null;
		if (data.matches("\\d+"))
			dataTypes = DataTypes.OPERAND;
		else if (data.matches("\\d*.\\d+"))
			dataTypes = DataTypes.OPERAND;
		else
			dataTypes = DataTypes.OPERATOR;
		switch (dataTypes) {
		case OPERAND:
			return new Token(dataTypes, Double.parseDouble(data));
		case OPERATOR:
			char[] operator = data.toCharArray();
			if (isOperator(operator[0]))
				return new Token(dataTypes, operator[0]);
			else {
				throw new IllegalArgumentException("The data type can not be identifed");
			}
		default:
			log.error("The datatype {} can NOT be identifed", data);
			throw new IllegalArgumentException("The data type can not be identifed");

		}
	}

	private boolean isOperator(char c) {
		switch (c) {
		case '+':
		case '-':
		case '*':
		case '/':
		case '^':
		case '!':
			log.info("The operator identified is {}", c);
			return true;
		default:
			log.error("The operator {} can not be identified", c);
			return false;
		}
	}

}
