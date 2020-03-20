package eg.edu.alexu.csd.datastructure.linkedList.cs;

import static org.junit.Assert.assertArrayEquals;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	singlyLinkedList obj=new singlyLinkedList();
		singlyLinkedList obj1=new singlyLinkedList();
		obj.printLinkekList();
		obj.size();
		obj.add(0, 'a');
		obj.add('m');
		obj.add(1, 'c');
		obj.add('b');
		//obj.remove(0);
		obj.sublist(0,0);
		System.out.println();
		obj.size();
	//	boolean f=obj.contains('o');
		//System.out.println(f);
		obj.printLinkekList();
		obj.get(1);*/
	/*	doubleLinkedList obj=new doubleLinkedList();
		obj.printLinkekList();
		obj.size();
		obj.add(0, 'a');
		obj.add('m');
		//obj.add(1, 'c');
		obj.add('b');
		//obj.remove(0);
		obj.sublist(1,2);
		System.out.println();
		//obj.size();
	//	boolean f=obj.contains('o');
		//System.out.println(f);
		obj.printLinkekList();
		*/
		int [][] terms =
				{
						{5, 2},
						{5, 2},
						{3, 3},
						{4, 7},
						};
		int [][] terms1 =
			{
					{7, 3},
					{8, 6},
					{9, 1},
					
					
			};
		polynomialImplementation m =new polynomialImplementation();
		m.setPolynomial('A',terms);
		m.setPolynomial('B',terms1);
		m.print('A');
		m.print('B');
		//m.evaluatePolynomial('A',1);
		m.add('A', 'B');
		//m.multiply('A', 'B');
		//m.subtract('A', 'B');
/*
		int [][] terms1 =
			{
					{4, 2},
					{4, 3},
					{4, 2},
					{4, 2},
					{4, 3},
					{4, 3},
					{4, 3},
					{4, 3},
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
		obj.setPolynomial('A', terms1);
		obj.setPolynomial('B', terms2);
		singlyLinkedList mm=new singlyLinkedList();
		singlyLinkedList mm1=new singlyLinkedList();
		mm=obj.getPolynomial('A');
		mm1=obj.getPolynomial('B');
		obj.proberties(mm, mm1);*/
		
	}

}
