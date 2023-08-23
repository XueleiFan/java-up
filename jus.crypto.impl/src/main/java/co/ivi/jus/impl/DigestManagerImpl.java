/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.impl;

import co.ivi.jus.crypto.Digest;
import co.ivi.jus.crypto.DigestManager;
import co.ivi.jus.crypto.Returned;

public final class DigestManagerImpl implements DigestManager {
    @Override
    public Returned<Digest> create(String algorithm) {
        return switch (algorithm) {
            case "SHA-256" -> Sha256.returnedSha256;
            case "SHA-512" -> Sha512.returnedSha512;
            default -> Returned.UNDEFINED;
        };
    }
}
