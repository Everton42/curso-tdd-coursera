package com.coursera.exercises;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class CamelCaseToStringTest {

    @Test
    public void convertCamelCase_wordLowerCase_returnsSameWord() {
        List<String> expected = Arrays.asList("nome");
        List<String> result = CamelCaseToString.convertCamelCase("nome");
        assertEquals(expected, result);
    }

    @Test
    public void convertCamelCase_firstLetterUpperCase_returnsWordLowerCase() {
        List<String> expected = Arrays.asList("nome");
        List<String> result = CamelCaseToString.convertCamelCase("Nome");
        assertEquals(expected, result);
    }

    @Test
    public void convertCamelCase_wordCamelCase_returnsWordsSeparateLowerCase() {
        String input1 = "nomeComposto";
        String input2 = "NomeComposto";
        List<String> expected = Arrays.asList("nome", "composto");

        List<String> output1 = CamelCaseToString.convertCamelCase(input1);
        List<String> output2 = CamelCaseToString.convertCamelCase(input2);

        assertEquals(expected, output1);
        assertEquals(expected, output2);
    }

    @Test
    public void convertCamelCase_wordUpperCase_returnsSameWord() {
        String input = "CPF";
        List<String> expected = Arrays.asList("CPF");

        List<String> output = CamelCaseToString.convertCamelCase(input);

        assertEquals(expected, output);
    }

    @Test
    public void convertCamelCase_wordsWithCapitalizeWord_returnsWordsLowerCaseExpectCapitalizeWord() {
        String input1 = "numeroCPF";
        String input2 = "numeroCPFContribuinte";
        List<String> expected = Arrays.asList("numero", "CPF");
        List<String> expected2 = Arrays.asList("numero", "CPF", "contribuinte");
        
        List<String> result1 = CamelCaseToString.convertCamelCase(input1);
        List<String> result2 = CamelCaseToString.convertCamelCase(input2);

        assertEquals(expected, result1);
        assertEquals(expected2, result2);
    }

    @Test
    public void convertCamelCase_wordWithNumber_returnsWordsAndNumber() {
        String input = "recupera10Primeiros";
        List<String> expected = Arrays.asList("recupera", "10", "primeiros");
        
        List<String> output = CamelCaseToString.convertCamelCase(input);

        assertEquals(expected, output);
    }

    @Test(expected = InvalidWordStartException.class)
    public void convertCamelCase_wordStartNumber_invalidWordStartExceptionThrown() {
        String input = "10Primeiros";
        CamelCaseToString.convertCamelCase(input);
    }

    @Test(expected = SpecialCharacterException.class)
    public void convertCamelCase_wordWithSpecialCharacter_specialCharacterExceptionThrown() {
        String input = "nome#Composto";
        CamelCaseToString.convertCamelCase(input);
    }
}
