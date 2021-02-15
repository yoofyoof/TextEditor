/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.InputMismatchException;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i < LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+ i + " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		list1.add(0,65);

		// TODO: Add more tests here
		int b = list1.remove(1);
		assertEquals("Remove: check a is correct ", 21, b);
		assertEquals("Remove: check element 1 is correct ", (Integer)42, list1.get(1));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		list1.add(1,21);

		try {
			list1.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}

		try {
			list1.remove(3);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		 list1.add(0);
		 int a = list1.get(3);
		assertEquals("AddEnd: check if 0 is added to the end of the list: ",0,a);
		assertEquals("AddEnd: check element 2 is correct: ", (Integer)42,list1.get(2));
		assertEquals("AddEnd: check size is correct",4,list1.size);
		list1.remove(3);

	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Check list size: ",3,list1.size);
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		list1.add(0,1);
		int a = list1.get(0);
		assertEquals("AddEnd: check if 1 is added to index 0 of the list: ",1,a);
		assertEquals("AddEnd: check element 1 is correct: ", (Integer)65,list1.get(1));
		assertEquals("AddEnd: check size is correct",4,list1.size);
		list1.remove(0);

		list1.add(1,2);
		int b = list1.get(1);
		assertEquals("AddEnd: check if 2 is added to index 1 of the list: ",2,b);
		assertEquals("AddEnd: check element 2 is correct: ", (Integer)21,list1.get(2));
		assertEquals("AddEnd: check size is correct",4,list1.size);
		list1.remove(1);

		try {
			list1.add(1,null);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		list1.set(0,1);
		assertEquals("Set: Check if index 0 is set to 1: ",(Integer)1,list1.get(0));
		int i = list1.set(1,0);
		assertEquals("Set: check the return statement of set method: ",21,i);
		assertEquals("Set: Check if index 1 is set to 0: ",(Integer)0,list1.get(1));
		try {
			list1.set(-1,0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}

		try {
			list1.set(3,0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
	}

	// TODO: Optionally add more test methods.
	
}
