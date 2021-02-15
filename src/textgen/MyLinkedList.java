package textgen;


import javax.swing.text.html.parser.Element;
import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;
	private Object IndexOutOfBoundsException;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element)
	{
		// TODO: Implement this method
		LLNode<E> newNode = new LLNode<E>(element);
		 if (head != null)
		{
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	 	else if (element == null)
	 		throw new NullPointerException();
		else{
			head = newNode;
			tail = newNode;
		}
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index >= size || index < 0){
			throw new IndexOutOfBoundsException();
		}
		else if (head == null)
		{
			return null;
		}
		else
		{
				if (index == 0)
				return head.data;
				else{
					LLNode<E> current = head;
					for (int i = 0; i < index; i++)
						current = current.next;
					return current.data;
				}
		}
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		LLNode<E> newNode = new LLNode<E>(element);
		if (size == 0 & head ==null)
		{
			head = newNode;
			tail = newNode;
			size++;
		}
		else if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		else if (element == null)
			throw new NullPointerException();
		else if (index == 0 && head != null)
		{
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
			size ++;
		}
		else if(index > 0 && index < size)
		{
			LLNode<E> originalNode = head;
			for (int i = 0; i < index; i++)
				originalNode = originalNode.next;
			originalNode.prev.next = newNode;
			newNode.next = originalNode;
			newNode.prev = originalNode.prev;
			originalNode.prev = newNode;
			size++;
		}
		else
		{
			add(element);
			size++;
		}
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		E data = get(index);
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		else if (index == 0 && size == 1)
		{
			head = null;
			tail = null;
		}
		else if (index == 0 && size > 1)
		{
			head.next.prev = null;
			head = head.next;
		}
		else if (index >= 0 && index < size - 1)
		{
			LLNode<E> node = head;
			for (int i = 0; i < index; i++)
				node = node.next;
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
		else
		{
			tail.prev.next = null;
			tail = tail.prev;
		}
		size--;
		return data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (index < 0 || index >= size )
			throw new IndexOutOfBoundsException();
		else if (element == null)
			throw new NullPointerException();
		else
		{
			LLNode<E> current = head;
			for (int i = 0; i < index; i++)
				current = current.next;
			E originalElement = current.data;
			current.data = element;
			return originalElement;
		}
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

	public void setData(E data) {
		this.data = data;
	}
}
