package com.osherove;

import java.util.stream.Stream;

// source: https://osherove.com/tdd-kata-1/
public class StringCalculator {

	public int add(String numberString) {
		if ("".equals(numberString))
			return 0;
		String delimiter = findDelimiter(numberString);
		String[] numbers = null;
		if (numberString.startsWith("//"))
			numbers = numberString.substring(2).split(delimiter);
		else
			numbers = numberString.split(delimiter);
		
		return Stream.of(numbers)
			.filter(number -> !number.isEmpty())
			.map(Integer::valueOf)
			.reduce(0, Integer::sum);
	}

	public String findDelimiter(String delimitedString) {
		String regExChars = ",|n";
		char[] delimiters = new char[10];
		int i = 0;
		if (delimitedString.contains(","))
			delimiters[i++] = ',';
		if (delimitedString.contains("\n"))
			delimiters[i++] = 'n';
		if (delimitedString.startsWith("//"))
			delimiters[i++] = extractDelimiter(delimitedString);
		StringBuilder result = new StringBuilder();
		for (int j = 0; j < i; j++) {
			String delimiter = String.valueOf(delimiters[j]);
			if (regExChars.contains(delimiter))
				result.append("\\");
			result.append(delimiter);
			if (delimiters[j + 1] != '\000')
				result.append("|");
		}
		return result.toString();
	}

	/**
	 * delimiter can be customized based on the format agreed upon as follows
	 * “//[delimiter]\n[numbers…]” e.g. //;\n1;3;4
	 * 
	 * @param string
	 * @return
	 */
	public boolean validateFormat(String string) {
		String backSlash = string.substring(0, 2);
		String delimiter = string.substring(2, 3);
		String newLine = string.substring(3, 4);
		return "//".equals(backSlash) && delimiter != null && delimiter != "" && "\n".equals(newLine);
	}

	public char extractDelimiter(String string) {
		if (!validateFormat(string))
			throw new InvalidDelimiterFormat();
		return string.charAt(2);
	}

}
