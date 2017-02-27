package com.lohika.bookshelf.utils;

import java.io.File;
import java.net.URISyntaxException;


import java.io.File;
import java.net.URISyntaxException;

public class FileUtils {

    public static File getFile(String filename) throws URISyntaxException {
        File file = new File(filename);
        if (!file.exists()){
            file = new File(FileUtils.class.getClassLoader().getResource(filename).toURI());
        }
        return (file != null && file.exists() ? file : null);
    }
}
