/*
 * Copyright 2015 - 2016 KeepSafe Software, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.getkeepsafe.relinker;

import java.util.Arrays;

public class MissingLibraryException extends RuntimeException {
    private final String library;
    private final String[] wantedABIs;
    private final AbiSupportInfo abiSupportInfo;

    public MissingLibraryException(String library, String[] wantedABIs, AbiSupportInfo abiSupportInfo) {
        this.library = library;
        this.wantedABIs = wantedABIs;
        this.abiSupportInfo = abiSupportInfo;
    }

    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("Could not find '").append(library).append("'. ");
        sb.append("Looked for: ").append(Arrays.toString(wantedABIs)).append(", ");
        sb.append("but only found: ").append(Arrays.toString(abiSupportInfo.getSupportedAbis())).append(".");

        String[] unscannableFileNames = abiSupportInfo.getUnscannableFileNames();
        if (unscannableFileNames.length != 0) {
            sb.append(" Additionally, encountered errors while scanning: ").append(Arrays.toString(unscannableFileNames)).append(".");
        }

        return sb.toString();
    }
}
