package datastructure;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class SelectionSort {
	
	public static void Sort(int[] a,int n){
		int min,i,j;
		for(i=0;i<n-1;i++){
			min=i;
			for(j=i+1;j<n;j++){
				if(a[j]<a[min]){
					min=j;
					swap(a, i, j);
				}
			}
		}
		for (int entry : a) {
			System.out.print(entry+" ");
		}
	}
	public static void swap(int[] a, int i, int j) {
	      int t = a[i];
	      a[i] = a[j];
	      a[j] = t;
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
		Sort(ar, ar.length);
	}

}
