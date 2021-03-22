import java.io.File;
import java.io.IOException;
import java.io.FileWriter; 
import java.io.FileNotFoundException;
import java.util.Scanner;


class FileOpsExample{

	public static void main(String[] args){

		// Create a file.
		try{
			File myObj = new File("example.txt");

			if(myObj.createNewFile()){
				System.out.println("File created: " + myObj.getName());
			}else{
				System.out.println("File already exists.");
			}
		}catch(IOException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}


		// Write to a file. 
		try{
			FileWriter writerObj = new FileWriter("example.txt");
			writerObj.write("These data are written to a file!");
			writerObj.close();
			System.out.println("Files written to file.");
		} catch (IOException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    	}


    	// Read from a file.
    	try{
    		File fileObj = new File("example.txt");
    		Scanner readerObj = new Scanner(fileObj);
    		while(readerObj.hasNextLine()){
    			String data = readerObj.nextLine();
    			System.out.println(data);
    		}
    		readerObj.close();    	
    	} catch(FileNotFoundException e){
    		System.out.println("File Not found.");
    		e.printStackTrace();
    	}


    	// Delete a file.
    	try{
    		File fileObj = new File("example.txt");
    		if(fileObj.delete()){
    			System.out.println("File deleted");
    		}else{
    			System.out.println("Failed to delete the file");
    		}
    	}


	}

} 