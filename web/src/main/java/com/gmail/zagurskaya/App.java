package com.gmail.zagurskaya;

import com.gmail.zagurskaya.service.StringNumbersService;
import com.gmail.zagurskaya.service.impl.StringNumbersServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    private static final StringNumbersService stringNumbersService = StringNumbersServiceImpl.getInstance();

    public static void main(String[] args) {

        List<Integer> integers = stringNumbersService.readIntegersFromFile("file.txt");

        String integersString = integers.stream().map(Objects::toString).collect(Collectors.joining(", "));

        logger.info(integersString);
    }
}
