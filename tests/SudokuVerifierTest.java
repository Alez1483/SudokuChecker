import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
final String validSudoku = 
		  "123456789"
		+ "456789123"
		+ "789123456"
		+ "912345678"
		+ "345678912"
		+ "678912345"
		+ "891234567"
		+ "234567891"
		+ "567891234";
//correct but with the first values of the first two rows swapped
final String rowDublicate = 
		  "423456789"
		+ "156789123"
		+ "789123456"
		+ "912345678"
		+ "345678912"
		+ "678912345"
		+ "891234567"
		+ "234567891"
		+ "567891234";
//correct but with the first two values swapped
final String columnDublicate = 
		  "213456789"
		+ "456789123"
		+ "789123456"
		+ "912345678"
		+ "345678912"
		+ "678912345"
		+ "891234567"
		+ "234567891"
		+ "567891234";
final String latinSquare = 
	      "123456789"
		+ "912345678"
		+ "891234567"
		+ "789123456"
		+ "678912345"
		+ "567891234"
		+ "456789123"
		+ "345678912"
		+ "234567891";
//correct but last is special Unicode character
final String unicodeSudoku = 
		  "123456789"
		+ "456789123"
		+ "789123456"
		+ "912345678"
		+ "345678912"
		+ "678912345"
		+ "891234567"
		+ "234567891"
		+ "56789123鷗";
final String shortSquare = latinSquare.substring(0, 80);
final String longSquare = latinSquare + "1";

SudokuVerifier v = new SudokuVerifier();

	@Test
	public void testValidString() {
		int a = v.verify(validSudoku);
		assertEquals("correct string", 0, a);
	}
	@Test
	public void testShortString() {
		int a = v.verify(shortSquare);
		assertEquals("short string", -1, a);
	}
	@Test
	public void testLatinSquareString() {
		int a = v.verify(latinSquare);
		assertEquals("latin square", -2, a);
	}
	@Test
	public void testLongString() {
		int a = v.verify(longSquare);
		assertEquals("long string", -1, a);
	}
	@Test
	public void testRowDublicateString() {
		int a = v.verify(rowDublicate);
		assertEquals("row dublicate", -3, a);
	}
	@Test
	public void testColumnDublicateString() {
		int a = v.verify(columnDublicate);
		assertEquals("column dublicate", -4, a);
	}
	@Test
	public void testUnicodeString() {
		int a = v.verify(unicodeSudoku);
		assertEquals("unicode string", 1, a);
	}
}
