public class tmp {
	public static void main(String[] args) {
		String s = "abcdefg";
		StringBuilder ori = new StringBuilder(s);
		StringBuilder rori = new StringBuilder(s);
		rori.reverse();
		System.out.println(ori);
		System.out.println(rori);
	}
}