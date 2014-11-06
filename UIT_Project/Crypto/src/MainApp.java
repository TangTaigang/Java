import java.util.Scanner;


public class MainApp {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 @SuppressWarnings("resource")
		 Scanner sc = new Scanner(System.in);
		 int choice=0;
		 do{
			 System.out.println("--------------------An Toan Mang --------------------");
			 System.out.println("1 - Vigenere  || 2 - Playfair  || 0 - Exit");
			 System.out.println("Choice ?");
			 choice=sc.nextInt();
			 if(choice==1){
					/*
					 * Vigenere
					 */
				 	@SuppressWarnings("unused")
					Vigenere vigenere=new Vigenere();
					
			 }else if(choice==2){
					/*
					 * Play fair
					 */
				 	@SuppressWarnings("unused")
					Playfair playfair=new Playfair();
				 	
			 }
		 }while (choice > 0 && choice <= 2);
		 System.out.println("Exit");
	}

}
