import java.util.Scanner;

public class B266 {
	public static void main (String[] args) {
		
		// Input variables
		int a;
		int b;
		String str;
		char[] position;
		
		// Scanner
		Scanner in = new Scanner(System.in);
		
		// Get the values from the user
		a = in.nextInt();
		b = in.nextInt();
		str = in.next();
		
		position = str.toCharArray();
		
		// Do the calculations
		for(int i = 0; i < b; i++) {
			while(i < position.length - 1 ) {
				if( position[i] == 'B' && position[i+1] == 'G') {
					position[i] = 'G';
					position[i+1] = 'B';
					i = i + 2;
				} else {
					i++;
				}
			}
		}
		
		// Output the result
		System.out.println( String.valueOf(position) );
	}
}
