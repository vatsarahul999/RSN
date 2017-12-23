package com.rahul.RPN.identifier;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataIdentifierTest {

	private DataIdentifer dataIdentiifer = new DataIdentifer();

	@Test
	public void testDataIdentifier() {
		Token result = dataIdentiifer.getData("1.22");
		Token expected = new Token(DataTypes.OPERAND, 1.22);
		assertEquals(result, expected);
		result = dataIdentiifer.getData("!");
		Token actual = new Token(DataTypes.OPERATOR, '!');
		assertEquals(result, actual);
		result = dataIdentiifer.getData("+");
		actual = new Token(DataTypes.OPERATOR, '+');
		assertEquals(result, actual);
		result = dataIdentiifer.getData("-");
		actual = new Token(DataTypes.OPERATOR, '-');
		assertEquals(result, actual);
		result = dataIdentiifer.getData("*");
		actual = new Token(DataTypes.OPERATOR, '*');
		assertEquals(result, actual);
		result = dataIdentiifer.getData("/");
		actual = new Token(DataTypes.OPERATOR, '/');
		assertEquals(result, actual);
	}

	@Test
	public void testData() {
		try {
			dataIdentiifer.getData("a");
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
}
