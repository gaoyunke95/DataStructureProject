import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * the ReadFile class includes openFile method,
 * readFile method, closeFile method
 * this class will open the text file by 
 * using FileInputStream and use the 
 * Scanner to read the input from text file
 * if no file is found will throw the exception
 * 
 * @author yunkegao
 *
 */
public class ReadFile {
	
	private Scanner x;
	private FileInputStream fstream;
	
	/**the String input to store the String from file*/
	private String input;
	
	private String b;

	/** BinarySearchTree object */
	BinarySearchTree<Integer> a= new BinarySearchTree<Integer>();
	
	/**
	 * openFile method
	 * will handle to open the text file
	 * and throw exception if no file found.
	 */
	public void openFile(){
		try{
			fstream= new FileInputStream("assignment2.txt");
			x= new Scanner(fstream);
		}//try
		catch(Exception e){
			System.out.println("no file found");
		}//catch
	}// method openFile()
	
	/**
	 * readFile method
	 * use hasNext to find the determine the file 
	 * is empty or not and next to get the string.
	 * and use different if and else if to access 
	 * different commands
	 */
	public void readFile(){
		while(x.hasNext()){
			input=x.next();
			if(input.equalsIgnoreCase("insert")){
				
				int numb=Integer.parseInt(x.next());
				a.insert(numb);
			}
			
			else if(input.equalsIgnoreCase("remove")){
				
				int numbers=Integer.parseInt(x.next());
				a.remove(numbers);

			}
			
			else if(input.equalsIgnoreCase("print_tree")){
				System.out.println("tree");
				a.printTree();
			}
			
			else if(input.equalsIgnoreCase("inorder_list")){
				Iterator itr=a.iterator();
				System.out.print("iterator:");
				while(itr.hasNext()){
					System.out.print(itr.next()+" ");
				}
				System.out.println();
			}
			
		}//while
		
	}// method readFile()
	
	/**
	 * use to close the file
	 * @throws IOException when no file or no string found
	 */
	public void closeFile() throws IOException {
		x.close();
		fstream.close();
	}// method close()
}