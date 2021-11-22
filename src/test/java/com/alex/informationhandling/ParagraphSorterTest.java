package com.alex.informationhandling;

import com.alex.informationhandling.chain.TextProcessor;
import com.alex.informationhandling.composite.CustomComponent;
import com.alex.informationhandling.composite.CustomComponentType;
import com.alex.informationhandling.composite.CustomComposite;
import com.alex.informationhandling.exception.FileReaderException;
import com.alex.informationhandling.reader.impl.CustomFileReaderImpl;
import com.alex.informationhandling.service.ParagraphSorter;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class ParagraphSorterTest {

    private static String expectedString;

    private static CustomComposite composite;

    @BeforeClass
    public static void compositeInitialize() {
        expectedString = "[ It is a established fact that a reader will be of a page when looking at its layout...,  Bye бандерлоги.,  It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!,  It is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?]";
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
    public void sortTest() {
        String expected = expectedString;
        ArrayList<CustomComponent> sortedText = ParagraphSorter.sort(composite);
        String actual = sortedText.toString();
        Assert.assertEquals(expected, actual);
    }
}
