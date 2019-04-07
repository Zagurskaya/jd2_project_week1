package com.gmail.zagurskaya.service.impl;

import com.gmail.zagurskaya.repository.FileSystemRepository;
import com.gmail.zagurskaya.repository.impl.FileSystemRepositoryImpl;
import com.gmail.zagurskaya.service.StringNumbersService;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringNumbersServiceImpl implements StringNumbersService {

    private final static StringNumbersService stringNumbersService = new StringNumbersServiceImpl();

    private StringNumbersServiceImpl() {
    }

    public static StringNumbersService getInstance() {
        return stringNumbersService;
    }

    private final FileSystemRepository fileSystemRepository = FileSystemRepositoryImpl.getInstance();

    @Override
    public List<Integer> readIntegersFromFile(String fileName) {
        List<String> stringList = fileSystemRepository.readFromFile(fileName);

        return stringList.stream().map(s -> add(s)).collect(Collectors.toList());
    }

    @Override
    public int add(String numbers) {
        Pattern pattern = Pattern.compile(",|:|\\|");
        String[] numbersArrays = pattern.split(numbers);
        return Arrays.asList(numbersArrays)
                .stream()
                .map(s -> stringToInt(s))
                .mapToInt(i -> i.intValue())
                .sum();
    }

    private int stringToInt(String str) {
        int result = str.length() == 0 ? 0 : Integer.parseInt(str);
        return result;
    }
}
