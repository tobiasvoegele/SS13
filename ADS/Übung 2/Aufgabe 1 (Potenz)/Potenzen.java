public class Potenzen {

	public static void main(String[] args) {
		System.out.println(rekursivePotenz(3, 5));
	}

	public static int rekursivePotenz(int basis, int exponent) {
		if (exponent == 0) {
			return 1;
		} else {
			return basis * rekursivePotenz(basis, exponent - 1);
		}

	}

}
