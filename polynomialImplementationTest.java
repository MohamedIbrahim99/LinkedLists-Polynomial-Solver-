package eg.edu.alexu.csd.datastructure.linkedList.cs;

import static org.junit.Assert.*;

import org.junit.Test;

public class polynomialImplementationTest {

	@Test
	public void test() {
		polynomialImplementation polynomial = new polynomialImplementation();
        int [][] terms1 =
			{
					{5, 2},
					{5, 2},
					{3, 3},
					{4, 7},  		//test add function
					};
        int [][] terms2 =
			{
					{7, 3},
					{8, 6},
					{9, 1},
					};
        polynomial.setPolynomial('A',terms1);
        polynomial.setPolynomial('B',terms2);
        int[][] result = polynomial.add('A','B');
        int [][] arr1 =
			{
					{4, 7},
					{8, 6},
					{10, 3},
					{10, 2},
					{9, 1},
					};
        assertArrayEquals(arr1,result);
	}
	
	@Test
	public void test1() {
		polynomialImplementation polynomial = new polynomialImplementation();
        int [][] terms1 =
			{
					{4, 2},
					{4, 3},
					{4, 2},
					{4, 2},
					{4, 3},
					{4, 3},
					{4, 3},			//test add function
					{4, 3},			//very important test
					};
        int [][] terms2 =
			{
					{4, 2},
					{3, 3},
					{4, 2},
					{4, 2},
					{4, 2},
					{4, 2},
					{4, 2},
					};
        polynomial.setPolynomial('A',terms1);
        polynomial.setPolynomial('B',terms2);
        int[][] result = polynomial.add('A','B');
        int [][] arr1 =
			{
					{23, 3},
					{36, 2},
					};
        assertArrayEquals(arr1,result);
	}
	
	 
	@Test
	public void test2() {
		polynomialImplementation polynomial = new polynomialImplementation();
        int [][] terms1 =
			{
					{4, 2},
					{4, 3},
					{4, 2},
					{4, 2},
					{4, 3},
					{4, 3},
					{4, 3},
					{4, 3},			//test add function
					};
        int [][] terms2 =
			{
					{4, 2},
					{3, 3},
					{4, 2},
					{4, 2},
					{4, 2},
					{4, 2},
					{4, 2},
					};
        polynomial.setPolynomial('A',terms1);
        polynomial.setPolynomial('B',terms2);
        int[][] result = polynomial.add('A','B');
        int [][] arr1 =
			{
					{23, 3},
					{36, 2},
					};
        assertArrayEquals(arr1,result);
	}
	@Test
	public void test3() {
		polynomialImplementation polynomial = new polynomialImplementation();
       
        int [][] terms1 =
			{
				{5,6}, {-10,8}, {3,5}			//test multiplication function
					};
        int [][] terms2 =
			{
				{6,4}
					};
        polynomial.setPolynomial('A',terms1);
        polynomial.setPolynomial('B',terms2);
        int[][] result = polynomial.multiply('A','B');
        int [][] arr1 =
			{
					{-60, 12},
					{30, 10},
					{18, 9},
					};
        assertArrayEquals(arr1,result);
	}
	@Test
	public void test4() {
		polynomialImplementation polynomial = new polynomialImplementation();
       
        int [][] terms1 =
			{
				{5,6}, {-10,8}, {3,5}			//test multiplication function
					};
        int [][] terms2 =
			{
				{0,4}
					};
        polynomial.setPolynomial('A',terms1);
        polynomial.setPolynomial('B',terms2);
        int[][] result = polynomial.multiply('A','B');
        int [][] arr1 =
			{
					{0, 12},
					{0, 10},
					{0, 9},
					};
        assertArrayEquals(arr1,result);
	}
	@Test
	public void test5() {
		polynomialImplementation polynomial = new polynomialImplementation();
       
        int [][] terms1 =
			{
				{9,7},{8,8},{5,4},{4,2}		//test evaluatePolynomial function
					};
        
        polynomial.setPolynomial('A',terms1);
        float result =  polynomial.evaluatePolynomial('A',3);
        float expected =  72612f ;
        assertEquals(expected, result, 0);
        
	}
	@Test
	public void test7() {
		polynomialImplementation polynomial = new polynomialImplementation();
       
        int [][] terms1 =
			{
				{10,3},{9,4},{6,4},{3,5},{2,2},		//test evaluatePolynomial function
					};
        
        polynomial.setPolynomial('A',terms1);
        float result =  polynomial.evaluatePolynomial('A',5);
        float expected =  20050f ;
        assertEquals(expected, result, 0);
        
	}
	
	@Test
	public void test8() {
		polynomialImplementation polynomial = new polynomialImplementation();
        int [][] terms1 =
			{
				{1,6},{1, 7},{1,8}
					};
        int [][] terms2 =
			{
				{1,9},{1, 6},{1,7}
					};
        polynomial.setPolynomial('A',terms1);
        polynomial.setPolynomial('B',terms2);
        int[][] result = polynomial.subtract('A','B');
        int [][] arr1 =
			{
				{-1,9},{1,8},{0, 7},{0, 6},
					};
        assertArrayEquals(arr1,result);
	}
	
	@Test
	public void test9() {
		polynomialImplementation polynomial = new polynomialImplementation();
        int [][] terms1 =
			{
				{0,0},{0, 0},{0,0}
					};
        int [][] terms2 =
			{
				{0,0},{0, 0},{0,0}
					};
        polynomial.setPolynomial('A',terms1);
        polynomial.setPolynomial('B',terms2);  //test subtract function
        int[][] result = polynomial.subtract('A','B');
        int [][] arr1 =
			{
				{0,0},
					};
        assertArrayEquals(arr1,result);
	}
	
	@Test
	public void test10() {
		polynomialImplementation polynomial = new polynomialImplementation();
        int [][] terms1 =
			{
				{7,4},{5, 5},{3,1}
					};
        int [][] terms2 =				//test subtract function
			{
				{5,3},{6, 6},{2,4}
					};
        polynomial.setPolynomial('A',terms1);
        polynomial.setPolynomial('B',terms2);
        int[][] result = polynomial.subtract('A','B');
        int [][] arr1 =
			{
				{-6,6},{5,5},{5,4},{-5,3},{3,1},
					};
        assertArrayEquals(arr1,result);
	}
	
	
	
	 

}
