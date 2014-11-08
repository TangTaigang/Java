import java.util.Scanner;


public class Vigenere {
	
	private String key;
	private Scanner sc;

	/**
	 * Constructor
	 * @param key
	 */
	public Vigenere(){
	 	System.out.println("Please input the plain text :");
		sc = new Scanner(System.in);
	 	String textVigenere=sc.nextLine().trim();
	 	System.out.println("Please input the keyword for Vigenere :");
		String keyVigenere=sc.nextLine().trim();
		setKey(keyVigenere);
		String ciphertext=encrypt(textVigenere);
		System.out.println("-------------------------Result Vigenere-----------------------------------");
//		System.out.println("Plain text :"+textVigenere);
//		System.out.println("Key :"+keyVigenere);
		System.out.println("This is cipher text :"+ciphertext);
		System.out.println("This is decrypt text :"+decrypt(ciphertext));
		System.out.println();
	}
	
	/**
	 * Setter method
	 * @param key
	 */
	public void setKey(String key){
		this.key=key.toUpperCase();
	}
	
	/**
	 * Vigenere Cipher Encrypt Message
	 * @param text
	 * @return cipherText
	 */
	public String encrypt(String text){
		int i;
		int j;
		String cipherText="";
		text=text.toUpperCase();
		int textLength=text.length();
		for(i=0,j=0; i<textLength; i++ ){
			char c=text.charAt(i);
			if(c < 'A' || c > 'Z') continue;
			cipherText+=(char) ((c+key.charAt(j)-2*'A')% 26 +'A');
			j=++j% key.length();
		}
		return cipherText;
	}
	
	/**
	 * Vigenere Cipher Decrypt Message
	 * @param ciphertext
	 * @return plainText
	 */
	public String decrypt(String ciphertext) {
		int i;
		int j;
		String plainText="";
		ciphertext=ciphertext.toUpperCase();
		int cipherLength=ciphertext.length();
		for(i=0,j=0; i<cipherLength; i++){
			char c=ciphertext.charAt(i);
			if(c < 'A' || c > 'Z') continue;
			plainText+=(char) ((c-key.charAt(j)+26)%26+'A');
			j=++j% key.length();
		}
		return plainText;
	}


}
