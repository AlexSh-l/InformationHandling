package com.alex.informationhandling;

import com.alex.informationhandling.chain.TextProcessor;
import com.alex.informationhandling.composite.CustomComponentType;
import com.alex.informationhandling.composite.CustomComposite;
import com.alex.informationhandling.exception.FileReaderException;
import com.alex.informationhandling.reader.impl.CustomFileReaderImpl;
import com.alex.informationhandling.service.LongestWordSentencesFinder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LongestWordSentencesFinderTest {

    private static Set<String> expectedValues;

    private static CustomComposite composite;

    @BeforeClass
    public static void compositeInitialize() {
        expectedValues = new HashSet<>();
        expectedValues.add("It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged.");
        expectedValues.add("It was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!");
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
    public void findSentenceTest() {
        Set<String> expected = expectedValues;
        Set<String> actual = LongestWordSentencesFinder.findSentence(composite);
        Assert.assertEquals(expected, actual);
    }
}
