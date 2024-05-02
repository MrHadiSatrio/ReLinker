package com.getkeepsafe.relinker;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipFile;

public class ActualZipFileFactory implements ZipFileFactory {
    @Override
    public ZipFile create(File file, int openMode) throws IOException {
        return new ZipFile(file, openMode);
    }
}
