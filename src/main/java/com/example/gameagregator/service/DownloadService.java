package com.example.gameagregator.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class DownloadService {

    private static final String FILE_DIRECTORY = "";

    public InputStream downloadFile(String fileName) throws IOException {
        return new FileInputStream(FILE_DIRECTORY + fileName);
    }

    public boolean deleteFile(String fileName) {
        File file = new File(FILE_DIRECTORY + fileName);
        return file.exists() && file.delete();
    }
}