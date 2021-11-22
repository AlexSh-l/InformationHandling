package com.alex.informationhandling;

import com.alex.informationhandling.exception.FileReaderException;
import com.alex.informationhandling.reader.impl.CustomFileReaderImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileReaderTest {

    private static String expected;

    @BeforeClass
    public static void fileContentInitialize() {
        expected = "\tIt has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!\r\n" +
                "\tIt is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?\r\n" +
                "\tIt is a established fact that a reader will be of a page when looking at its layout...\r\n" +
                "\tBye бандерлоги.";
    }

    @Test
    public void readFileTest() {
        CustomFileReaderImpl fileReader = new CustomFileReaderImpl();
        try {
            String actual = fileReader.readFile().get();
            Assert.assertEquals(expected, actual);
        } catch (FileReaderException e) {
            Assert.fail(e.getMessage());
        }
    }
}
