/*
 * Copyright (c) 2021, Ling Xu. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.record.review.xuling;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * record class work
 *
 * @author jack
 * @since 2021/11/24
 **/
public record SocialSecurityNumber(byte[] ssn) {

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if(this.ssn == null) {
            return false;
        }

        if (o instanceof SocialSecurityNumber that) {
            return MessageDigest.isEqual(ssn, that.ssn());
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(ssn);
    }

    @Override
    public String toString() {
        return "SocialSecurityNumber{" +
                "ssn hash" + this.hashCode() +
                '}';
    }
}
