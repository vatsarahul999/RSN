package com.rahul.RPN.identifier;

public class Token {

	private DataTypes dataType;

	private double operand;

	private char operator;

	public Token(DataTypes dataType, double operand) {
		this.dataType = dataType;
		this.operand = operand;
	}

	public Token(DataTypes dataType, char operator) {
		this.dataType = dataType;
		this.operator = operator;
	}

	public DataTypes getDataType() {
		return dataType;
	}

	public double getOperand() {
		return operand;
	}

	public char getOperator() {
		return operator;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataType == null) ? 0 : dataType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(operand);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + operator;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Token other = (Token) obj;
		if (dataType != other.dataType)
			return false;
		if (Double.doubleToLongBits(operand) != Double.doubleToLongBits(other.operand))
			return false;
		if (operator != other.operator)
			return false;
		return true;
	}
	

}
