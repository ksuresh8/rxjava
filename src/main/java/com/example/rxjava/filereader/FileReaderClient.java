package com.example.rxjava.filereader;

import com.example.rxjava.Util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderClient {
    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderService();
        Path path = Paths.get("src/main/resources/files/bifunction.txt");
        fileReaderService.read(path).subscribe(Util.subscriber());
    }
}
