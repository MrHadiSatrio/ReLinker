package com.getkeepsafe.relinker;

import java.io.File;
import java.util.Collections;
import java.util.Set;

public class AbiSupportInfo {
    private final Set<String> supportedAbis;
    private final Set<File> unScannableFiles;

    public AbiSupportInfo(Set<String> supportedAbis) {
        this(supportedAbis, Collections.emptySet());
    }

    public AbiSupportInfo(Set<String> supportedAbis, Set<File> unscannableFiles) {
        this.supportedAbis = supportedAbis;
        this.unScannableFiles = unscannableFiles;
    }

    public String[] getSupportedAbis() {
        String[] arr = new String[supportedAbis.size()];
        supportedAbis.toArray(arr);
        return arr;
    }

    public String[] getUnscannableFileNames() {
        String[] arr = new String[unScannableFiles.size()];
        int i = 0;
        for (File file : unScannableFiles) {
            arr[i++] = file.getName();
        }
        return arr;
    }
}
