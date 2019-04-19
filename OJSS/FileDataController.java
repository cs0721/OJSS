import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Class to control file input and output
 * 
 * @auther (Yiming, Moon, Troy, Bryan)
 */
public class FileDataController 
{
	
	public FileDataController()
	{
		
	
	}
	
	/**
	 * write content into local file
	 * 
	 * @param filename name of file
	 * @param output content to write
	 * @return Null
	 */
	public void writeFile(String filename, ArrayList<String> output)
	{
	    try
	    {
	        PrintWriter write = new PrintWriter(filename);
	        for(String out : output)
	        {
	            write.println(out);
	           }
	        write.close();
	       }
	    catch(FileNotFoundException exception) 
		{
			String error = filename + " not found";
            System.out.println(error);
		}
		
		catch(IOException exception) 
        {
            String error = "Unexpected I/O error occured";
            System.out.println(error); 
        }    
	}
	   
	/**
	 * read content from local file
	 * 
	 * @param filename name of file
	 * @return Null
	 */
	public String readFile(String filename)
	{
		StringBuilder texts = new StringBuilder();
		
		try 
		{
			FileReader inputFile = new FileReader(filename);
			Scanner parser = new Scanner(inputFile);
			
			while (parser.hasNextLine())
            {
                String line = parser.nextLine();
                texts.append(line + ";");
            }
            
            inputFile.close();
            parser.close();
            return texts.toString();
			
		}
		
		catch(FileNotFoundException exception) 
		{
			String error = filename + " not found";
            System.out.println(error);
            return error;
		}
		
		catch(IOException exception) 
        {
            String error = "Unexpected I/O error occured";
            System.out.println(error); 
            return error;
        }    
	}
}

