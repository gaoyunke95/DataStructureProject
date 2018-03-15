/**
 *	A class called LeakyStack which implements from 
 *	the Stack interface, have the default constructor. 
 *	The class also includes size method isEmpty method, 
 *	push method, top method, pop method.
 * @author yunkegao
 *
 */

public class LeakyStack<AnyType> implements Stack<AnyType>
{
  private static final int DEFAULT_CAPACITY = 16;
  private AnyType[] data;
  private int topOfStack;
  private int theSize=0;
  
  public LeakyStack() { this(DEFAULT_CAPACITY); }

  /**
   * The default constructor
   * set the topOfStack equal to 1, 
   * and let create the array data with the capacity
   * 
   * @param capacity  the capacity will be the length of the array data
   */
  public LeakyStack(int capacity)
  {
	  topOfStack=-1;
	  data = (AnyType[]) new Object[capacity];  
  }// default constructor 
  
/**
 * return the size of the stack;
 */
  public int size()
  {
	  return theSize;
  }//method size()

/**
 * check if the stack is empty or not, 
 * return true for empty, 
 * false for not empty.
 */
  public boolean isEmpty()
  {	
	  if(theSize==0)
		 return true;
	  else return false;
  }// method isEmpty()

/**
 * increment the topOfStack,
 * check if the topOfstack is equal to 16 which is the data length
 * if equals the data.length, reset the topOfStack to 0;
 * and then store the new value to the Stack
 * When the size reaches the max which is 16 , the size will not change
 * 
 * @param newValue get the value which will be store in the topOfStack
 */
  public void push(AnyType newValue)
  {	
  	topOfStack++;	
  	if(topOfStack==(data.length))
  		topOfStack=0;
  	
  	data[topOfStack]=newValue;
  	theSize++;
  	if(theSize>=data.length){
  		theSize=16;
  	}
  }//method push(newValue)

/**
 * the top method 
 * check the Stack is empty or not 
 * if empty return null, else return 
 * the value at the topOfStack;
 */
  public AnyType top()
  {	if(isEmpty())
	  	return null;
  	else if(topOfStack==-1)
  		topOfStack=15;
  		return data[topOfStack];
  }//method top()

 /**
  * the pop method
  * Will pop the value at the topOfStack, 
  * and return the value of the one which was poped;
  */
  public AnyType pop()
  {	AnyType temp;
	if(isEmpty())
		return null;
	else if(!isEmpty()&&topOfStack==-1)
		topOfStack=15;
  		
	temp= data[topOfStack];
  	data[topOfStack]=null;
  	topOfStack--;
  	theSize--;
  	return temp;
  }//method pop()


}