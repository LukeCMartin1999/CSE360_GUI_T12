import java.io.*;

public class log {
	public static void main(String args[]) {
		try {
			File file = new File("log.txt");
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.println(ToDoList.selectAll());
		} catch (IOException e) {
			e.printStackTrace();
		}
	      
}
}