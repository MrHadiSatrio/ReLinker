package com.getkeepsafe.relinker;

import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class AbiSupportInfo {
    private final Set<String> supportedAbis;
    private final Map<File, Exception> unScannableFileAndReasons;

    public AbiSupportInfo(Set<String> supportedAbis) {
        this(supportedAbis, Collections.emptyMap());
    }

    public AbiSupportInfo(Set<String> supportedAbis, Map<File, Exception> unscannableFilesAndReasons) {
        this.supportedAbis = supportedAbis;
        this.unScannableFileAndReasons = unscannableFilesAndReasons;
    }

    public String[] getSupportedAbis() {
        String[] arr = new String[supportedAbis.size()];
        supportedAbis.toArray(arr);
        return arr;
    }

    public String[] getUnscannableFileNameAndReasons() {
        String[] arr = new String[unScannableFileAndReasons.size()];
        int i = 0;
        for (Map.Entry<File, Exception> entry : unScannableFileAndReasons.entrySet()) {
            arr[i++] = entry.getKey().getName() + " => " + entry.getValue();
        }
        return arr;
    }
}
