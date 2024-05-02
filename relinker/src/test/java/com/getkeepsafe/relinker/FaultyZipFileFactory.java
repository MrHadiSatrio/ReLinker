package com.getkeepsafe.relinker;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipFile;

public class FaultyZipFileFactory implements ZipFileFactory {
    @Override
    public ZipFile create(File file, int openMode) throws IOException {
        throw new IOException("Could not create zip file.");
    }
}
