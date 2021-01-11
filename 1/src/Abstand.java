public class Abstand {
	
	public static int abstand(int[] ns, int[] ms) {
		
		int[] nsFull;
		int[] msFull;
		
		int nsL = ns.length;
		int msL = ms.length;
		if(nsL == 0 && msL == 0) {
			return 0;
		}
		
		if(nsL< msL) {
			nsFull = new int[msL];
			msFull = new int[msL];
		} else {
			nsFull = new int[nsL];
			msFull = new int[nsL];
		}
		
		for(int i = 0; i < nsL; i++) {
			nsFull[i] = ns[i];
		} 
		for(int j = 0; j < msL; j++) {
			msFull[j] = ms[j];
		}
		
		int ans = 0;
		
		for(int i = 0; i < nsFull.length; i++) {
			ans += Math.abs(nsFull[i]-msFull[i]);
		}
		
		
		return ans;
	}
}
