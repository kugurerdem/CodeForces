import java.util.Scanner;


public class B839 {
	public static void main (String[] args) {
		
		int n; // sýra sayýsý
		int k; // asker grubu sayýsý
		
		int _4group = 0; 
		int _2group = 0;
		int _1group = 0;
		
		int _4seat;
		int _2seat;
		
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		k = in.nextInt();
		
		_4seat = n;
		_2seat = 2*n;
		
		// Ayný gruptan olan askerleri 4'lü, 2'li ve 1'li olmak üzere gruplara ayýr.
		for(int i = 0; i < k; i++) {
			float soldierNum = in.nextInt();
			
			if( (soldierNum/4) >= 1) {
				_4group = _4group + (int) (soldierNum/4);
				soldierNum = soldierNum % 4;
			}
			
			if( (soldierNum/2) >= 1) {
				_2group = _2group + (int) (soldierNum/2);
				soldierNum = soldierNum % 2;
			} 
			
			if( soldierNum == 1) {
				_1group = _1group + 1;
				soldierNum = 0; 
			}
		}
		
		
		// Oturtabildiðin tüm dörtlü gruplarý oturt
		
		if(_4seat - _4group >= 0) {
			_4seat = _4seat - _4group;
			_4group = 0;
		} else {
			_4group = _4group - _4seat;
			_4seat = 0;
			
			_2group = _2group + 2*_4group;
			_4group = 0;
		}
		
		// oturtabildiðin tüm ikili gruplarý iki koltuklara oturt
		if(_2seat - _2group >= 0) {
			_2seat = _2seat - _2group;
			_2group = 0;
			
			// oturtabildiðin tüm tekli gruplarý ikili koltuklara oturt
			if(_2seat - _1group >= 0) {
				_2seat = _2seat - _1group;
				_1group = 0;
			} else {
				_1group = _1group - _2seat;
				_2seat = 0;
			}
			
		} else {
			_2group = _2group - _2seat;
			_2seat = 0;
		}
		
		// 4'lü koltuklara (eðer kalmýþsa) ikili gruplarý oturt. 
		// Kalan 4'lü koltuklarý 2'li koltuklara çevir
		if(_4seat - _2group >= 0) {
			_2seat = _2seat + (2*_4seat - _2group);
			_2group = 0;
		} else {
			_2group = _2group - _4seat;
			_2seat = _4seat;
			_4seat = 0;
			
			_1group = _1group + (2*_2group);
			_2group = 0;
		}
		
		// Teklileri oturt
		if(_2seat - _1group >= 0) {
			_1group = 0;
		}
		
		
		if(_4group == 0 && _2group == 0 && _1group == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
