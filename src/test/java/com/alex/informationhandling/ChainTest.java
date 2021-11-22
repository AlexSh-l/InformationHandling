package com.alex.informationhandling;

import com.alex.informationhandling.chain.TextProcessor;
import com.alex.informationhandling.composite.CustomComponentType;
import com.alex.informationhandling.composite.CustomComposite;
import com.alex.informationhandling.exception.FileReaderException;
import com.alex.informationhandling.reader.impl.CustomFileReaderImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ChainTest {

    private static CustomComposite composite;

    private static String fileContent;

    @BeforeClass
    public static void compositeInitialize() {
        CustomFileReaderImpl fileReader = new CustomFileReaderImpl();
        try {
            fileContent = fileReader.readFile().get();
            TextProcessor textProcessor = new TextProcessor();
            composite = new CustomComposite(CustomComponentType.TEXT);
            textProcessor.processText(fileContent, composite);
        } catch (FileReaderException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void processorTest() {
        String expected = fileContent;
        String actual = composite.toString();
        Assert.assertEquals(expected, actual);
    }
}
