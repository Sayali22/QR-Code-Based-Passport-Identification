import java.io.IOException;
import java.util.Scanner;

import com.android.project.webserver.HTTPServer;


public class Main {

	public static void main(String[] args) {

		HTTPServer httpServer = new HTTPServer();
		try {
			httpServer.start();
			System.out.println("Server started");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("press any number to exit");
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		
		int n = reader.nextInt(); // Scans the next token of the input as an int.
	}

}
