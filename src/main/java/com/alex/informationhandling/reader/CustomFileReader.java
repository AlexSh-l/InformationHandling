package com.alex.informationhandling.reader;

import com.alex.informationhandling.exception.FileReaderException;

import java.util.Optional;

public interface CustomFileReader {

    String DEFAULT_FILE_PATH = "./data/inputFile.txt";

    Optional<String> readFile() throws FileReaderException;

    Optional<String> readFile(String filePath) throws FileReaderException;
}
