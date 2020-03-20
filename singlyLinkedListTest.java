package eg.edu.alexu.csd.datastructure.linkedList.cs;

import static org.junit.Assert.*;

import org.junit.Test;

public class singlyLinkedListTest {

	@Test
	public void test() {
		singlyLinkedList obj=new singlyLinkedList();
		assertEquals(obj.isEmpty(),true);  //Empty List
		obj.add(1);
		assertEquals(obj.size(),1);
		obj.add(5);
		obj.add(9);
		obj.add(1,8 );  //1859
		assertEquals(obj.contains(6),false);
		obj.add(3, 7);  //18579
		assertEquals(obj.size(),5);
		assertEquals(obj.contains(9),true);
		obj.add(5, 6); //185796
		assertEquals(obj.contains(5),true);
		assertEquals(obj.contains(100),false);
		assertEquals(obj.get(0),1);
		assertEquals(obj.get(1),8);
		assertEquals(obj.get(2),5);
		assertEquals(obj.get(3),7);
		assertEquals(obj.get(4),9);
		assertEquals(obj.get(5),6);
		
		assertEquals(obj.get(50),null); // out of bounds
		
		singlyLinkedList sub=new singlyLinkedList();
		sub=(singlyLinkedList) obj.sublist(2, 4);		//testing sub list
		assertEquals(sub.get(0),5);
		assertEquals(sub.get(1),7);
		assertEquals(sub.get(2),9);
		
		obj.remove(0);			//85796
		assertEquals(obj.get(0),8);
		obj.remove(0); //5796
		
		assertEquals(obj.get(2),9);
		assertEquals(obj.size(),4);
		
		assertEquals(obj.isEmpty(),false);
		obj.clear();
		assertEquals(obj.isEmpty(),true);
		obj.clear();
		obj.add('a');
		obj.add('n');
		obj.add('b');
		assertEquals(obj.get(0),'a');
		assertEquals(obj.get(1),'n');
		assertEquals(obj.get(2),'b');
		obj.clear();
		
		obj.add(7);
		obj.add('n'); //mixed 
		obj.add('b');
		assertEquals(obj.get(0),7);
		assertEquals(obj.get(1),'n');
		assertEquals(obj.get(2),'b');
		obj.clear();
		obj.add('a');
		obj.add('n');
		obj.add('b');
		obj.remove(2);
		assertEquals(obj.get(0),'a');
		assertEquals(obj.get(1),'n');
		assertEquals(obj.get(2),null);
		
		
	}

}
