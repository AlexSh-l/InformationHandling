package com.alex.informationhandling.reader.impl;

import com.alex.informationhandling.exception.FileReaderException;
import com.alex.informationhandling.reader.CustomFileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Optional;

public class CustomFileReaderImpl implements CustomFileReader {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Optional<String> readFile() throws FileReaderException {
        Optional<String> optionalFileContentList;
        try {
            String fileContent = Files.readString(Path.of(DEFAULT_FILE_PATH));
            optionalFileContentList = Optional.of(fileContent);
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new FileReaderException("Unable to read from file", e);
        }
        return optionalFileContentList;
    }

    @Override
    public Optional<String> readFile(String filePath) throws FileReaderException {
        Optional<String> optionalFileContentList;
        try {
            String fileContent = Files.readString(Path.of(filePath));
            optionalFileContentList = Optional.of(fileContent);
        } catch (IOException | InvalidPathException e) {
            logger.error(e.getMessage());
            throw new FileReaderException("Unable to read from file", e);
        }
        return optionalFileContentList;
    }
}
