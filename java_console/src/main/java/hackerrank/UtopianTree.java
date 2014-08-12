package hackerrank;

import java.util.Scanner;

public class UtopianTree {
	
//	https://www.hackerrank.com/challenges/utopian-tree
	
	public static void getTreeHeightAfterCycles(int[] array){
		for(int i = 0; i < array.length; i++) {
			int height=1;
			if(array[i]!=0){
				for(int j=1;j<=array[i];j++){
					if(j%2==0){
						 height+=1;
					}else{
						 height*=2;
					}
				}
			}
			System.out.println(height);
		}
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
		 getTreeHeightAfterCycles(ar);
	}
}
