package com.gmail.zagurskaya.service;

import java.util.List;

public interface StringNumbersService {

    List<Integer> readIntegersFromFile(String fileName);

    int add(String s);
}
