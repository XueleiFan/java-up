/*
 * Copyright (c) 2021, songor. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.record.review.songor;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

record SocialSecurityNumber(byte[] ssn) {
    public SocialSecurityNumber {
        if (ssn == null || ssn.length <= 0) {
            throw new IllegalArgumentException("The ssn should not be empty");
        }
    }

    @Override
    public byte[] ssn() {
        String str = new String(ssn, StandardCharsets.UTF_8);
        String regex = String.format("(?<=\\w{%d})\\w(?=\\w{%d})", 6, 4);
        return str.replaceAll(regex, "*").getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SocialSecurityNumber other = (SocialSecurityNumber) o;
        return Arrays.equals(ssn, other.ssn);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(ssn);
    }
}