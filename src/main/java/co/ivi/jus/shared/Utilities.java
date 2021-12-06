/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.shared;

public final class Utilities {
    static final char[] hexDigits = "0123456789ABCDEF".toCharArray();

    public static String toHexString(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder(bytes.length * 3);
        boolean isFirst = true;
        for (byte b : bytes) {
            if (isFirst) {
                isFirst = false;
            } else {
                builder.append(' ');
            }

            builder.append(hexDigits[(b >> 4) & 0x0F]);
            builder.append(hexDigits[b & 0x0F]);
        }
        return builder.toString();
    }
}
