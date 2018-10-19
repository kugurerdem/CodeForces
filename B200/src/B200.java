import java.util.Arrays;
import java.util.Scanner;

public class B200 {
	
	public static void main(String[] args) {
		int len;
		float sum;
		
		Scanner in = new Scanner(System.in);
		
		// Getting the inputs
		len = in.nextInt();
		sum = 0;
		
		for(int i = 0; i < len; i++) {
			float a = in.nextFloat();
			sum = sum + a;
		}
		
		System.out.println(sum/len);
	}
}
