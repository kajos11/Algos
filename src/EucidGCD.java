
public class EucidGCD {

	public static void main(String[] args) {
		
		if(args.length < 2) {
			throw new IllegalArgumentException("pass two arguments to calculate GCD");
		}
		
		System.out.println(eucid(Integer.parseInt(args[0]), Integer.parseInt(args[1])));

	}
	
	public static int eucid(int a, int b) {
		
		if(b == 0) {
			return a;
		}
		
		return eucid(b, a%b);
		
	}

}
