package com.gmail.zagurskaya.repository.impl;

import com.gmail.zagurskaya.repository.FileSystemRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileSystemRepositoryImpl implements FileSystemRepository {

    private static final Logger logger = LogManager.getLogger(FileSystemRepositoryImpl.class);

    private final static FileSystemRepository fileSystemRepository = new FileSystemRepositoryImpl();

    private FileSystemRepositoryImpl() {
    }

    public static FileSystemRepository getInstance() {
        return fileSystemRepository;
    }

    @Override
    public List<String> readFromFile(String fileName) {
        String filePath = getStringPath(fileName);

        return readFileAsStringList(filePath);
    }

    private List<String> readFileAsStringList(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<String> stringList = new ArrayList<>();
            for (String value = br.readLine(); value != null; value = br.readLine()) {
                stringList.add(value);
            }
            return stringList;
        } catch (IOException e) {
            logger.error("Happened something unexpected " + e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    private String getStringPath(String filename) {
        return this.getClass().getResource("/" + filename).getPath();
    }
}
