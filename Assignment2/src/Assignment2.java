import java.io.IOException;

/**
 * the main driver only has the main method 
 * to run the open, read, close file.
 * @author yunkegao
 */
public class Assignment2 {
	public static void main(String[] args) throws IOException{
		ReadFile a= new ReadFile();
		a.openFile();
		a.readFile();
		a.closeFile();
	}
}
