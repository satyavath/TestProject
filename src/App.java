
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ReadXl rl = new ReadXl();
		List Names = rl.excelData();
		for (int i = 0; i < Names.size(); i++) {
			System.out.println(Names.get(i));
		}
	
		
		int a = 0;
		System.out.println(rl);
	}
 
}
