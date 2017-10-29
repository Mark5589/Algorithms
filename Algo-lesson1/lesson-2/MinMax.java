
public class MinMax {
	
	/*
	 * At this class we'll look at some methods in the min-max finding Algorithms, 
	 * at the Running time of O(2n) O(3n/2) O() O()
	 */
	public static void main(String[] args) {
		int[] arr= RandomArray(90);
		PrintArray(arr);
		//int countNum = MinMax2N(arr);
		//System.out.println("");
		System.out.printf("\n The number of checks at the MinMax2n is %d and its should be around ~ %d \n" , MinMax2N(arr), (int)(arr.length*2));
		System.out.printf("\n The number of checks at the MinMax(3n/2) is %d and its should be around ~ %d \n" , MinMax3nDiv2(arr), (int)((arr.length*3)/2));


	

	}
	
	
	/*
	 * Generate Random Array at the lenght of 100
	 */
	public static int[] RandomArray(int n){
		int[] tmp = new int[n];
		
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = (int)(Math.random()*100);
		}
		return tmp;
	}
	
	public static void PrintArray(int[] a){
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " , ");
		}
		
	}


	/*
	 *end of Pre-work functions.
	 */
	
	
	/*
	 * Min-Max in O(2n)
	 */
	
	public static int MinMax2N(int[] a){
		int max1;
		int max2;
		int i = 1;
		while(i < a.length && a[i-1] == a[i]) i++;
		
		
		if(a[i-1]>a[i]){
			max1 = a[i-1];
			max2 = a[i];
		}else{
			max1 = a[i];
			max2 = a[i-1];
		}
		
		int count =0;
		for (int j = i+1; j < a.length; j++) {
			count++;
			if(a[j] > max1){
				max2 = max1;
				max1 = a[j];
			}
			else{
				count++;
				if(a[j]>max2){
					max2=a[j];
				}
			}
		}
		return count;
	}

	/*
	 * Min-Max in O(3n/2)
	 * Moving through the array with pares. 
	 * the starting point is like the previous method that max1> max2.
	 * 
	 *Ai = Points to some member at the array, 
	 *
	 *1. (	Ai > Ai+1 )  && ( Ai > max1 ) && (max1 > max2) -> so Ai is the biggest element we need to find the biggest element for max2 = max(max1, Ai+1) and set the max1 = Ai.
	 * 
	 *2. ( Ai > Ai+1 )  &&  ( max1 > Ai)  && (max1 > max2) -> so max1 is the biggest element and he stays in that position, lets set the max2 = max(max2, Ai).  // max1 = max1
	 *
	 *3.  ( Ai < Ai+1 ) && ( Ai+1 > max1 ) && (max1 > max2) -> Ai+1 is the biggest number so lets find the max between max2 = max(Ai, Max1)
	 *
	 *4.  ( Ai < Ai+1 ) && (  Ai+1 < max1 ) && (max1 > max2) ->  max1 is the biggest element, max2 = max(max2, Ai+1)
	 */
	
	public static int MinMax3nDiv2(int[] a){
		int max1;
		int max2;
		int i = 1;
		while(i < a.length && a[i-1] == a[i]) i++;
		
		
		if(a[i-1]>a[i]){
			max1 = a[i-1];
			max2 = a[i];
		}else{
			max1 = a[i];
			max2 = a[i-1];
		}
		int count = 0;
		for (int j = i; j < a.length-1; j = j+2) {
			count++;
			if(a[j] >= a[j+1]){
				count++;
				if(a[j]>max1){
					count++;
					if(max1 > a[j+1]) max2 = max1;
					else max2= a[j+1];
					max1 = a[j];
				}
				else{
					count++; // -Missing- line at the Elizabeth's papers.
					if(a[j] > max2) max2 = a[j]; 
				}
			}
			else{
				count++;
				if(a[j+1] > max1){
					count++;
					if(max1 > a[j])max2 = max1;
					else max2 = a[j];
					max1 = a[j+1];
				}
				else{
					count++; // -Missing- line at the Elizabeth's papers.
					if(a[j+1] > max2) max2 = a[j+1];
				}
			}
		}
		return count;
	}

}
