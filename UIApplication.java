package eg.edu.alexu.csd.datastructure.linkedList.cs;

import java.util.Scanner;

public class UIApplication {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
			//enter only ','between each coeff and exponent
			//if polynomial 5x^2-4x Enter it as 5,2,-4,1
		polynomialImplementation poly=new polynomialImplementation();
		String string="";
		String sub="";
		char var1,var2;
		singlyLinkedList tempSingleList=new singlyLinkedList();
		while(true) {
		char choosenCharForArray;
		Scanner input = new Scanner(System.in);
		System.out.println("Please choose an action\n");
		System.out.println("-----------------------\n");
		System.out.println("1- Set a polynomial variable");
		System.out.println("2- Print the value of a polynomial variable");
		System.out.println("3- Add two polynomials");
		System.out.println("4- Subtract two polynomials");
		System.out.println("5- Multiply two polynomials");
		System.out.println("6- Evaluate a polynomial at some point");
		System.out.println("7- Clear a polynomial variable");
		System.out.println("====================================================================");
		int choosen=input.nextInt();
		switch(choosen) {
		case 1:
			System.out.println("Insert the variable name: A, B or C");
			choosenCharForArray=input.next().charAt(0);
			while(choosenCharForArray!='A'&&choosenCharForArray!='B'&&choosenCharForArray!='C') {
				System.out.println("Enter correct Char Name \n");
				choosenCharForArray=input.next().charAt(0);
			}
			System.out.println("Insert the polynomial terms in the form:\r\n" + 
					"(coeff1, exponent1), (coeff2, exponent2), ..\r\n" );
			System.out.println("Enter a ',' between each coeff and exponent");
			System.out.println("if polynomial 5x^2-4x Enter it as 5,2,-4,1");
			input.nextLine();
			string=input.nextLine();
			char checker;
			for(int i=0; i<string.length();i++) {
				checker=string.charAt(i);
				if(Character.isDigit(checker)) {
					sub+=string.charAt(i);
					while ((i+1<string.length())&&Character.isDigit(string.charAt(i)) && Character.isDigit(string.charAt(i+1))) {
						i++;
						
						sub+=string.charAt(i); 
					}
					tempSingleList.add(Integer.parseInt(sub));
					sub="";
				}
				else if(checker=='-') {
					checker=string.charAt(++i);
					if(Character.isDigit(checker)) {
						sub+=string.charAt(i);
						while ((i+1<string.length())&&Character.isDigit(string.charAt(i)) && Character.isDigit(string.charAt(i+1))) {
							i++;
							
							sub+=string.charAt(i); 
						}
						tempSingleList.add(-1*Integer.parseInt(sub));
						sub="";
					}
					
				}
				else if(checker==',') { 
					
				}else {
					throw new RuntimeException("WRONG CHARACHTER");
				}
				
			}
			int arrSize=tempSingleList.size()/2;
			int arr[][]=new int[arrSize][2];
			int counter=0;
			for(int i=0; i<arrSize;i++) {
				for(int j=0; j<2;j++) {
					arr[i][j]=(int) tempSingleList.get(counter++);
				}
			}
			poly.setPolynomial(choosenCharForArray, arr);
			System.out.println("Polynomial "+choosenCharForArray+" is set\n");
			tempSingleList.clear();
			break;
		case 2:
			try {
			char var;
			System.out.println("Enter the Polynomial name: A, B, C or R ");
			var=input.next().charAt(0);
			
			System.out.println("polyinomail"+var+":"+poly.print(var));
			
			}catch(Exception e) {
				System.out.println("You must set polynmial before evaluating it ");
			}
			break;
		case 3:
			try {
			System.out.println("Enter the first Polynomial name: A, B, C or R ");
			var1=input.next().charAt(0);
			System.out.println("Enter the Second Polynomial name: A, B, C or R ");
			var2=input.next().charAt(0);
			poly.add(var1, var2);
			
			System.out.println("the result of Adding :"+poly.print('R'));
			}catch(Exception e) {
				System.out.println("You must set two polynmial before evaluating it ");
			}
			break;
		case 4:
			try {
			System.out.println("Enter the first Polynomial name: A, B, C or R ");
			var1=input.next().charAt(0);
			System.out.println("Enter the Second Polynomial name: A, B, C or R ");
			var2=input.next().charAt(0);
			poly.subtract(var1, var2);
			
			System.out.println("the result of Subtraction :"+poly.print('R'));
			}catch(Exception e) {
				System.out.println("You must set two polynmial before evaluating it ");
			}
			break;
		case 5:
			try {
			System.out.println("Enter the first Polynomial name: A, B, C or R ");
			var1=input.next().charAt(0);
			System.out.println("Enter the Second Polynomial name: A, B, C or R ");
			var2=input.next().charAt(0);
			poly.multiply(var1, var2);
			
			System.out.println("the result of Multiplication :"+poly.print('R'));
			}catch(Exception e) {
				System.out.println("You must set two polynmial before evaluating it ");
			}
			break;
		case 6:
			try {
			System.out.println("Enter the first Polynomial name: A, B, C or R ");
			var1=input.next().charAt(0);
			System.out.println("Enter your value to Evaluate Polynomial at it :");
			float value = input.nextFloat();
			System.out.println("Value of Polunomial "+var1+" when Value = "+ value + " is : "+poly.evaluatePolynomial(var1,value));
			}catch(Exception e) {
				System.out.println("You must set polynmial before evaluating it ");
			}
			break;
		case 7:
			System.out.println("Enter the Polynomial name: A, B, C or R ");
			try {
			var1=input.next().charAt(0);
			poly.clearPolynomial(var1);
			}catch(Exception e) {
				System.out.println("You must set polynmial before  that ");
			}
			break;
		default :
			System.out.println("Please Insert a Correct Number From(1:7)");
			
		   }
		}
	}

}