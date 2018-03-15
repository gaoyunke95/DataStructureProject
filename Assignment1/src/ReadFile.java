import java.io.FileInputStream;
import java.io.IOException;
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
	
	/**use for store the value from pop method*/
	private String b;
	
	/** LeakyStack object */
	private LeakyStack<String> a= new LeakyStack<String>() ;
	
	/**
	 * openFile method
	 * will handle to open the text file
	 * and throw exception if no file found.
	 */
	public void openFile(){
		try{
			fstream= new FileInputStream("assignment1.txt");
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

				if(input.equalsIgnoreCase("pop")){
					 b=a.pop();
					if(b==null)
						System.out.println("command "+input+": TheLeakyStack is empty");
					else 
						System.out.println("command "+input+": "+b);
				}
			
				else if(input.equalsIgnoreCase("push")||input.equalsIgnoreCase("insert")){
					a.push(x.next());
				}
			
				else if(input.equalsIgnoreCase("is_empty")){
					if(a.isEmpty()==true)
						System.out.println("command "+input+": TheLeakyStack is empty");
					else
						System.out.println("command "+input+": TheLeakyStack is not empty");
				}
			
				else if(input.equalsIgnoreCase("size")){
					System.out.println("command "+input+": "+a.size());
				}
			
				else if(input.equalsIgnoreCase("top")){
					if(a.top()==null)
						System.out.println("command "+input+": TheLeakyStack is empty");
					else
						System.out.println("command "+input+": "+a.top());
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
