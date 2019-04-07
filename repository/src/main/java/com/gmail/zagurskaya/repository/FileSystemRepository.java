package com.gmail.zagurskaya.repository;

import java.util.List;

public interface FileSystemRepository {

    List<String> readFromFile(String fileName);

}
