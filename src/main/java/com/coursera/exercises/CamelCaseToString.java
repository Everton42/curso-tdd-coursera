package com.coursera.exercises;

import java.util.Arrays;
import java.util.List;

public class CamelCaseToString {

	private static final String START_WITH_NUMBER = "^[0-9].*";
	private static final String HAS_SPECIAL_CHARACTER = "(\\w)*";
	private static final String SEPARATE_WORDS = "(?<!(^|[A-Z0-9]))(?=[A-Z0-9])|(?<!(^|[^A-Z]))(?=[0-9])|(?<!(^|[^0-9]))(?=[A-Za-z])|(?<!^)(?=[A-Z][a-z])";
	private static final String INVALID_START_MESSAGE = "Palavra nao pode comecar com numeros";
	private static final String INVALID_CHARACTER_MESSAGE = "Palavra nao pode conter caractere especial";

	public static List<String> convertCamelCase(String original) {
		if (original.matches(START_WITH_NUMBER))
			throw new InvalidWordStartException(INVALID_START_MESSAGE);

		if (!original.matches(HAS_SPECIAL_CHARACTER))
			throw new SpecialCharacterException(INVALID_CHARACTER_MESSAGE);

		if (isUpperWord(original) || isLowerWord(original))
			return Arrays.asList(original);

		List<String> wordsList = splitWords(original);
		return makeAllWordsLowerCase(wordsList);
	}

	private static List<String> splitWords(String original) {
		String words[] = original.split(SEPARATE_WORDS);
		return Arrays.asList(words);
	}

	private static List<String> makeAllWordsLowerCase(List<String> words) {
		words.replaceAll(word -> isUpperWord(word) ? word : word.toLowerCase());
		return words;
	}

	private static boolean isLowerWord(String original) {
		return original.toLowerCase() == original;
	}

	private static boolean isUpperWord(String original) {
		return original.toUpperCase() == original;
	}
}
