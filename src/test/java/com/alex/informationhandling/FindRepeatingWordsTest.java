package com.alex.informationhandling;

import com.alex.informationhandling.chain.TextProcessor;
import com.alex.informationhandling.composite.CustomComponentType;
import com.alex.informationhandling.composite.CustomComposite;
import com.alex.informationhandling.exception.FileReaderException;
import com.alex.informationhandling.reader.impl.CustomFileReaderImpl;
import com.alex.informationhandling.service.FindRepeatingWords;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FindRepeatingWordsTest {

    private static HashMap<String, Integer> expectedValues;

    private static CustomComposite composite;

    @BeforeClass
    public static void fileContentInitialize() {
        expectedValues = new HashMap<>();
        expectedValues.put("fact", 2);
        expectedValues.put("be", 2);
        expectedValues.put("reader", 2);
        expectedValues.put("It", 4);
        expectedValues.put("when", 2);
        expectedValues.put("content", 2);
        expectedValues.put("that", 3);
        expectedValues.put("of", 5);
        expectedValues.put("has", 2);
        expectedValues.put("Ipsum", 2);
        expectedValues.put("readable", 2);
        expectedValues.put("established", 2);
        expectedValues.put("a", 7);
        expectedValues.put("using", 2);
        expectedValues.put("like", 2);
        expectedValues.put("will", 2);
        expectedValues.put("its", 2);
        expectedValues.put("is", 3);
        expectedValues.put("it", 2);
        expectedValues.put("the", 4);
        expectedValues.put("with", 2);
        expectedValues.put("at", 2);
        expectedValues.put("Lorem", 2);
        expectedValues.put("looking", 2);
        expectedValues.put("page", 2);
        CustomFileReaderImpl fileReader = new CustomFileReaderImpl();
        try {
            String fileContent = fileReader.readFile().get();
            TextProcessor textProcessor = new TextProcessor();
            composite = new CustomComposite(CustomComponentType.TEXT);
            textProcessor.processText(fileContent, composite);
        } catch (FileReaderException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void findWordsTest() {
        String expected = expectedValues.toString();
        Map<String, Integer> actualValues = FindRepeatingWords.findWords(composite);
        String actual = actualValues.toString();
        Assert.assertEquals(expected, actual);
    }
}
