package com.alex.informationhandling.reader;

import com.alex.informationhandling.exception.FileReaderException;

import java.util.List;
import java.util.Optional;

public interface CustomFileReader {

    String DEFAULT_FILE_PATH = "./data/inputFile.txt";

    Optional<List<String>> readFile() throws FileReaderException;

    Optional<List<String>> readFile(String filePath) throws FileReaderException;
}
