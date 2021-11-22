package com.alex.informationhandling;

import com.alex.informationhandling.chain.TextProcessor;
import com.alex.informationhandling.composite.CustomComponent;
import com.alex.informationhandling.composite.CustomComponentType;
import com.alex.informationhandling.composite.CustomComposite;
import com.alex.informationhandling.exception.FileReaderException;
import com.alex.informationhandling.reader.impl.CustomFileReaderImpl;
import com.alex.informationhandling.service.CountVowelsAndConsonantsInSentence;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CountVowelsAndConsonantsInSentenceTest {

    private static CustomComponent sentence;

    @BeforeClass
    public static void compositeInitialize() {
        CustomFileReaderImpl fileReader = new CustomFileReaderImpl();
        try {
            String fileContent = fileReader.readFile().get();
            TextProcessor textProcessor = new TextProcessor();
            CustomComposite composite = new CustomComposite(CustomComponentType.TEXT);
            textProcessor.processText(fileContent, composite);
            sentence = composite.getChildren().get(0).getChildren().get(0);
        } catch (FileReaderException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void countVowelsAndConsonantsTest() {
        int[] expected = new int[]{42, 59};
        int[] actual = CountVowelsAndConsonantsInSentence.countVowelsAndConsonants(sentence);
        Assert.assertArrayEquals(expected, actual);
    }
}
