package executors;

public class HebraCalculo extends Thread {
	
	private int lo;
	private int hi;
	private int res;
	
	@Override
	public void run() {
		//int res = CalculoSecuencial.calculo(lo,hi);
		int res = 0;
		
		for(int i = lo; i < hi; i++) {
			res += i*i;
		}
	}
	
	public 
	
	public int getRes() {
		return res;
	}

}
