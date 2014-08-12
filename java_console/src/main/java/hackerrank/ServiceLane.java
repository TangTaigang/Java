package hackerrank;

public class ServiceLane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		for(char c = 'a'; c <= 'z'; c++) {
//		    System.out.print(c);
//		}
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		int count=1;
		for (char c : alphabet) {
			System.out.println(c +" " +count);
			count++;
		}
	}

}
