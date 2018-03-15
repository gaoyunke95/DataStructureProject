import java.util.Iterator;
import java.util.LinkedList;
/**
 * A binarySearchTree which includes
 * the constructor, insert, remove, print,iterator
 * methods
 * @author yunkegao
 *
 * @param <AnyType> generic data type
 * 
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>
{
  private static class Node<AnyType>
  {
    private AnyType data;
    private Node<AnyType> left;
    private Node<AnyType> right;
   
    /**
     *  default constructor
     * @param d the data to be save in the node
     * @param l	the leftchild pointer
     * @param r	the right child pointer
     */
    public Node(AnyType d, Node<AnyType> l, Node<AnyType> r)
    {
      setData(d);
      setLeft(l);
      setRight(r);
    }

    public AnyType getData() { return data; }
    public Node<AnyType> getLeft() { return left; }
    public Node<AnyType> getRight() { return right; }

    public void setData(AnyType d) { data = d; }
    public void setLeft(Node<AnyType> l) { left = l; }
    public void setRight(Node<AnyType> r) { right = r; }
  }

  private Node<AnyType> root;

  public BinarySearchTree() { makeEmpty(); }

  public void makeEmpty() { root = null; } 

  public boolean isEmpty() { return (root == null); }

  public boolean contains(AnyType v) { return contains(v, root); }
  
/**
 * a method to find the tree has the data or not
 * @param v the data to be searched for
 * @param t the root of the tree
 * @return boolean value
 */
  private boolean contains(AnyType v, Node<AnyType> t)
  {
    if (t == null) return false;

    int compareResult = v.compareTo(t.getData());

    if (compareResult < 0)
      return contains(v, t.getLeft());
    else
      if (compareResult > 0)
        return contains(v, t.getRight());
      else
        return true;
  }
  
/**
 * findMin method to find the Min Value of the tree
 * @return min Value
 * @throws IllegalStateException
 */
  public AnyType findMin() throws IllegalStateException
  {
    if (isEmpty()) throw new IllegalStateException("Search Tree is empty.");

    Node<AnyType> minNode = findMin(root);
    return minNode.getData();
  }
  
/**
 *  the method to find the minNode in a subtree
 * @param t the head or root of the subtree
 * @return minNode
 */
  private Node<AnyType> findMin(Node<AnyType> t)
  {
    if (t == null)
      return null;
    else
      if (t.getLeft() == null)
        return t;

    return findMin(t.getLeft());
  }

  /**
   * findMax method find maxValue of the tree
   * @return MaxValue
   * @throws IllegalStateException
   */
  public AnyType findMax() throws IllegalStateException
  {
    if (isEmpty()) throw new IllegalStateException("Search Tree is empty.");

    Node<AnyType> maxNode = findMax(root);
    return maxNode.getData();
  }
/**
 * private findMax Node of the subtree
 * @param t the subtree
 * @return MaxNode;
 */
  private Node<AnyType> findMax(Node<AnyType> t)
  {
    if (t == null)
      return null;
    else
      if (t.getRight() == null)
        return t;

    return findMax(t.getRight());
  }
  
/**
 * the insert method which will insert the value to the tree
 * @param v the value to be insert into the tree
 */
  public void insert(AnyType v)
  {
    // Write the iterative version of the insert method here.

	  // the new Node which contains the new value to be insert
	  Node<AnyType> a = new Node<AnyType>(v,null,null);
	  Node<AnyType> parent;
	  Node<AnyType> curr;
	  if(root==null){
		  root=a;
		  }
	  else{
		 
		curr=root;
	  	while(curr!=null){
	  		parent=curr;
	  		int compareResult=v.compareTo(curr.getData());
	  			
	  			//when current node value is smaller the new value 
	  			// make current node to its leftchild else set the leftchild
	  			// as the new node;
	  			if(compareResult<0){
	  				if(curr.getLeft()==null){
	  					curr.setLeft(a);
	  					break;
	  					}
	  				else
	  					curr=curr.getLeft();
	  				
	  			}
	  			// when current value is bigger than the new value
	  			// make current move to its right child
	  			// else set right child as the new node;
	  			else if(compareResult>0){
			
	  				//curr=curr.getRight();
	  				if(curr.getRight()==null){
	  					curr.setRight(a);
	  					break;
	  					}
	  				else 
	  					curr=curr.getRight();
	  			}
	  			else// donothing for two equal values;
	  				;
	  	}//while
	  }//else
  }//insert method
 
  /**
   * the remove method which will remove the value from the tree
   * @param v the value to be remove;
   */
  public void remove(AnyType v)
  {
    // Write the iterative version of the remove method here.
	 
	  Node<AnyType> parent=root;
	  Node<AnyType> curr;
	  
	  curr= root;
	  if(curr==null){
		  return;
	  }
	//make the comparsion to with the currnode value and the value to be remove;
	 // if smaller than 0 curr move to left 
	 // if bigger than 0 curr move to the right
	  //if equal do nothing;
	  while(curr.getData()!=v){
		int compareResult = v.compareTo(curr.getData());
	  
		parent = curr;
		
	  	if(compareResult<0){
	  		curr=curr.getLeft();
	  		}
	  	else if(compareResult>0){
	  		curr=curr.getRight();
	  	}
	  	else
	  		return;
	  	 		
	  }//while
	  
	  
	  //when both children are null, no children
	  if(curr.getLeft()==null&& curr.getRight()==null){
		 if(curr==root){
			 root=null;
		 }
		 else if(parent.getLeft()==curr){
			 parent.setLeft(null);}
		 else
			 parent.setRight(null);
		 	
	  }
	  // when leftchild is null, single child
	  else if(curr.getLeft()==null){
		  if(curr==root)
		  		root=curr.getRight();
		  	else if(parent.getLeft()==curr)
		  		parent.setLeft(curr.getRight());
		  	else
		  		parent.setRight(curr.getRight());
	  }
	  
	  // when right child is null, single child
	  else if(curr.getRight()==null){
		  if(curr==root)
		  		root=curr.getLeft();
		  	else if(parent.getLeft()==curr)
		  		parent.setLeft(curr.getLeft());
		 	else
		  		parent.setRight(curr.getLeft());
	  }
	  
	  //when have two children;
	  else if(curr.getLeft()!=null&& curr.getRight()!=null){
		  Node<AnyType> min=findMin(curr.getRight());
		  AnyType minNodeValue=min.getData();
		  remove(minNodeValue);
		  if(curr==root){
			  root.setData(minNodeValue);;
		  }
		  else if(parent.getLeft()==curr){
			  	
			  curr.setData(minNodeValue);
			  }
		  else 
			  curr.setData(minNodeValue);
		  
	  }

		  
  }//remove mthod
 
  // print the tree;
  public void printTree(){
	  printTree(root,0);
  }
  private void printTree(Node root, int level){
	    if(root==null)
	         return;
	    printTree(root.getRight(), level+1);
	    if(level!=0){
	        for(int i=0;i<level-1;i++)
	            System.out.print("    ");
	            System.out.println("    "+root.getData());
	    }
	    else
	        System.out.println(root.getData());
	    printTree(root.left, level+1);
	    
	    
	}
  public Iterator<AnyType> iterator()
  {
    LinkedList<AnyType> snapshot = new LinkedList<>();

    inOrderTraversal(root, snapshot);
    return snapshot.iterator();
  }

  private void inOrderTraversal(Node<AnyType> t, LinkedList<AnyType> l)
  {
    if (t != null)
    {
      inOrderTraversal(t.getLeft(), l);
      l.add(t.getData());
      inOrderTraversal(t.getRight(), l);
    }
  }
}