import java.util.Scanner;

public class ControlString {
	private String controlledString;
	
	public ControlString() {
		Scanner sc = new Scanner(System.in);
		this.controlledString = sc.nextLine();
		sc.close();
	}
	
	public String getString() {
		return this.controlledString;
	}
}
