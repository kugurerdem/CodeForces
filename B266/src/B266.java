import java.util.Scanner;

public class B266 {
	public static void main (String[] args) {
		
		// Input variables
		int a;
		int b;
		String position;
		
		// Scanner
		Scanner in = new Scanner(System.in);
		
		// Get the values from the user
		a = in.nextInt();
		b = in.nextInt();
		position = in.next();
		
		// Do the calculations
		for(int i = 0; i < b; i++) {
			position = NextPosition(position);
		}
		
		// Output the result
		System.out.println(position);
	}
	
	
	// Function that changes positions for just one time
	public static String NextPosition(String position) {
		int i = 0;
		String pos = position;
		
		
		while(i < pos.length() - 1 ) {
			if( pos.charAt(i) == 'B' && pos.charAt(i+1) == 'G') {
				pos = changeChar(pos, i, 'G');
				pos = changeChar(pos, i+1, 'B');
				i = i + 2;
			} else {
				i++;
			}
		}
		
		return pos;
	}
	
	// Function that changes a character in a string at specific index
	public static String changeChar(String str, int a, char x) {
		char[] Chars = str.toCharArray();
		Chars[a] = x;
		return String.valueOf(Chars);
	}
}
