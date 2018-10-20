import java.util.Scanner;


public class B839 {
	public static void main (String[] args) {
		
		int n; // s�ra say�s�
		int k; // asker grubu say�s�
		
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
		
		// Ayn� gruptan olan askerleri 4'l�, 2'li ve 1'li olmak �zere gruplara ay�r.
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
		
		
		// Oturtabildi�in t�m d�rtl� gruplar� oturt
		
		if(_4seat - _4group >= 0) {
			_4seat = _4seat - _4group;
			_4group = 0;
		} else {
			_4group = _4group - _4seat;
			_4seat = 0;
			
			_2group = _2group + 2*_4group;
			_4group = 0;
		}
		
		// oturtabildi�in t�m ikili gruplar� iki koltuklara oturt
		if(_2seat - _2group >= 0) {
			_2seat = _2seat - _2group;
			_2group = 0;
			
			// oturtabildi�in t�m tekli gruplar� ikili koltuklara oturt
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
		
		// 4'l� koltuklara (e�er kalm��sa) ikili gruplar� oturt. 
		// Kalan 4'l� koltuklar� 2'li koltuklara �evir
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
