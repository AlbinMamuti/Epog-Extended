public class Kombinationen {
	
	public static String generate(String input) {
		return recursion(input, "", "");
	}

	public static String recursion(String input, String res, String result) {
		if (input.length() == 0) {
			result += "\"" + res + "\" ";
			return result;
		} else {
			result = recursion(input.substring(1), res + input.substring(0, 1), result);
			result = recursion(input.substring(1), res, result);
		}
		return result;
	}
}
 