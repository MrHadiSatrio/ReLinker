package com.getkeepsafe.relinker;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipFile;

public interface ZipFileFactory {
    ZipFile create(File file, int openMode) throws IOException;
}
