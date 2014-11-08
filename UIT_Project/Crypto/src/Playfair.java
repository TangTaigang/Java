import java.awt.Point;
import java.util.Scanner;


public class Playfair {
	
	  // length of digraph array
	  private int length = 0;
	  
	  // table for Playfair cipher
	  private String [][] table;
	  
	  /**
	   * Constructor
	   */
	  public Playfair(){
		    System.out.println("Please input the plain text :");
		    Scanner sc = new Scanner(System.in);
		    String input = parseString(sc);
		    while(input.equals(""))
		      input = parseString(sc);
		    System.out.println();
		    System.out.println("Please input the keyword for Playfair :");
		    String keyword = parseString(sc);
		    while(keyword.equals(""))   keyword = parseString(sc);
		    System.out.println();
		    table = this.cipherTable(keyword);
		    // prompts user for message to be encoded
		  
		    // encodes and then decodes the encoded message
		    String output = cipher(input);
		    String decodedOutput = decrypt(output);
		    // output the results to user
		    this.printTable(table);
		    this.printResults(output,decodedOutput);
	  }
	 
	  /**
	   * Parse String 
	   * replaces any J's with I's, and makes string all caps
	   * parses any input string to remove numbers, punctuation,
	   * @param s
	   * @return parse
	   */ 
	  private String parseString(Scanner s){
	    String parse = s.nextLine();
	    parse = parse.toUpperCase();
	    parse = parse.replaceAll("[^A-Z]", "");
	    parse = parse.replace("J", "I");
	    return parse;
	  }
	  
	  /**
	   * creates the cipher table based on some input string (already parsed)
	   * @param key
	   * @return playfairTable
	   */
	  private String[][] cipherTable(String key){
	    String[][] playfairTable = new String[5][5];
	    String keyString = key + "ABCDEFGHIKLMNOPQRSTUVWXYZ";
	    
	    // fill string array with empty string
	    for(int i = 0; i < 5; i++){
	      for(int j = 0; j < 5; j++){
	        playfairTable[i][j] = "";
	      }
	    }
	    for(int k = 0; k < keyString.length(); k++){
	      boolean repeat = false;
	      boolean used = false;
	      for(int i = 0; i < 5; i++){
	        for(int j = 0; j < 5; j++){
	          if(playfairTable[i][j].equals("" + keyString.charAt(k))){
	            repeat = true;
	          }else if(playfairTable[i][j].equals("") && !repeat && !used){
	            playfairTable[i][j] = "" + keyString.charAt(k);
	            used = true;
	          }
	        }
	      }
	    }
	    return playfairTable;
	  }
	  
	  /**
	   * cipher: takes input (all upper-case), encodes it, and returns output
	   * @param in
	   * @return
	   */
	  private String cipher(String in){
	    length = (int) in.length() / 2 + in.length() % 2;
	    
	    // insert x between double-letter digraphs & redefines "length"
	    for(int i = 0; i < (length - 1); i++){
	      if(in.charAt(2 * i) == in.charAt(2 * i + 1)){
	        in = new StringBuffer(in).insert(2 * i + 1, 'X').toString();
	        length = (int) in.length() / 2 + in.length() % 2;
	      }
	    }
	    
	    // adds an x to the last digraph, if necessary
	    String[] digraph = new String[length];
	    for(int j = 0; j < length ; j++){
	      if(j == (length - 1) && in.length() / 2 == (length - 1))
	        in = in + "X";
	      digraph[j] = in.charAt(2 * j) +""+ in.charAt(2 * j + 1);
	    }
	    
	    // encodes the digraphs and returns the output
	    String out = "";
	    String[] encDigraphs = new String[length];
	    encDigraphs = encrypt(digraph);
	    for(int k = 0; k < length; k++)
	      out = out + encDigraphs[k];
	    return out;
	  }
	  
	  /**
	   * Playfair cipher encodes the digraph input.
	   * @param di
	   * @return
	   */
	  private String[] encrypt(String di[]){
	    String[] enc = new String[length];
	    for(int i = 0; i < length; i++){
	      char a = di[i].charAt(0);
	      char b = di[i].charAt(1);
	      int r1 = (int) getPoint(a).getX();
	      int r2 = (int) getPoint(b).getX();
	      int c1 = (int) getPoint(a).getY();
	      int c2 = (int) getPoint(b).getY();
	      
	      // case 1: letters in digraph are of same row, shift columns to right
	      if(r1 == r2){
	        c1 = (c1 + 1) % 5;
	        c2 = (c2 + 1) % 5;
	        
	      // case 2: letters in digraph are of same column, shift rows down
	      }else if(c1 == c2){
	        r1 = (r1 + 1) % 5;
	        r2 = (r2 + 1) % 5;
	      
	      // case 3: letters in digraph form rectangle, swap first column # with second column #
	      }else{
	        int temp = c1;
	        c1 = c2;
	        c2 = temp;
	      }
	      
	      //performs the table look-up and puts those values into the encoded array
	      enc[i] = table[r1][c1] + "" + table[r2][c2];
	    }
	    return enc;
	  }
	  
	  /**
	   * Playfair cipher decrypt message
	   * @param out
	   * @return plain text
	   */
	  private String decrypt(String out){
	    String decrypt = "";
	    for(int i = 0; i < out.length() / 2; i++){
	      char a = out.charAt(2*i);
	      char b = out.charAt(2*i+1);
	      int r1 = (int) getPoint(a).getX();
	      int r2 = (int) getPoint(b).getX();
	      int c1 = (int) getPoint(a).getY();
	      int c2 = (int) getPoint(b).getY();
	      if(r1 == r2){
	        c1 = (c1 + 4) % 5;
	        c2 = (c2 + 4) % 5;
	      }else if(c1 == c2){
	        r1 = (r1 + 4) % 5;
	        r2 = (r2 + 4) % 5;
	      }else{
	        int temp = c1;
	        c1 = c2;
	        c2 = temp;
	      }
	      decrypt = decrypt + table[r1][c1] + table[r2][c2];
	    }
	    return decrypt;
	  }
	  
	  /**
	   * returns a point containing the row and column of the letter
	   * @param c
	   * @return
	   */
	  private Point getPoint(char c){
	    Point pt = new Point(0,0);
	    for(int i = 0; i < 5; i++)
	      for(int j = 0; j < 5; j++)
	        if(c == table[i][j].charAt(0))
	          pt = new Point(i,j);
	    return pt;
	  }
	  
	  /**
	   * prints the cipher table out for the user
	   * @param printedTable
	   */
	  private void printTable(String[][] printedTable){
	    System.out.println("This is the cipher table from the given keyword.");
	    for(int i = 0; i < 5; i++){
	      for(int j = 0; j < 5; j++){
	        System.out.print(printedTable[i][j]+" ");
	      }
	      System.out.println();
	    }
	    System.out.println();
	  }
	  
	  /**
	   *  prints results (encrypt and decrypt)
	   * @param enc
	   * @param dec
	   */
	  private void printResults(String enc, String dec){
	    System.out.println("This is the cipher text :");
	    System.out.println(enc);
	    System.out.println("This is the decrypt text:");
	    System.out.println(dec);
	  }

}
