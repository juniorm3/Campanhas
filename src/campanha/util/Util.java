package campanha.util;

public class Util {

	/**
	 * Verifica se a String é um Número
	 * @param String
	 * @return true - caso se um número
	 */
	public static boolean isNumber(String str) {
	    try {
	        Double.parseDouble(str);
	        return true;
	    } catch (NumberFormatException nfe) {}
	    return false;
	}
	
}
