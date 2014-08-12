package hackerrank;

import java.util.Scanner;

public class InsertionSort {
	
//	https://www.hackerrank.com/challenges/insertionsort2
	
	public static void	sort_function(int[] array){
		for (int i = 0; i < array.length; i++) {
			int value = array[i];
		    int j = i - 1;
		    while(j >= 0 && array[j] > value){
		      array[j + 1] = array[j];
		      j = j - 1;
		    }
		    array[j + 1] = value;
		    if(i!=0){
	            printArray(array);    
	            }
		}
	}
	public static void swap_funcion(int a,int b){
		int temp=a;
		a=b;
		b=temp;
	}
	private static void printArray(int[] array) {
	      for(int n: array){
	         System.out.print(n+" ");
	      }
	        System.out.println("");
	}
	public static void main(String[] args) {
	    System.out.println("Input here :");
	    @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
	    int s = scanner.nextInt();
	    int[] ar = new int[s];
	    for(int i=0;i<s;i++){
	       ar[i]=scanner.nextInt(); 
	    }
	    sort_function(ar);    
	                    
	}    
}
