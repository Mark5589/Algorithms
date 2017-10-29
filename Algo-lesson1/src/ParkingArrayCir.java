import java.util.Arrays;

public class ParkingArrayCir {

	public static void main(String[] args) {
		int[] arr = new int[346334];
		//RandomNumArray(arr);
		//System.out.println(Arrays.toString(arr));
		System.out.println(ParkingProblemArray(arr));
		
	}
	
	public static int ParkingProblemArray(int[] a){
		int n = a.length;
		int b = 2;
		int v = 10;
		int counter = 0;
		int randomPlace = (int)(Math.random()*100);
		int start  = randomPlace;
		a[randomPlace] = v;
		randomPlace = (randomPlace+1)%n;
		counter++;
		boolean flag = true;
		while(flag){
			if(a[randomPlace] == v){
				a[randomPlace] = b;
				counter++;
				if(a[start] == b)flag = false;
				else{
					flag = true;
					randomPlace = (randomPlace+1)%n;
					
				}
			}
			else {
				counter++;
				randomPlace = (randomPlace+1)%n;
			}
			
		}
		return counter-1;
	}
	
	
	/* 
	 *  Fell the Array with random numbers 
	 */
	public static void RandomNumArray(int[] a){
		
		for (int i = 0; i < a.length; i++) {
			a[i] = (int)(Math.random()*100);
		}
	}

}
