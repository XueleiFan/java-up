/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.crypto;

import java.util.ServiceLoader;

public interface Digest {
    byte[] digest(byte[] message);

    static Returned<Digest> of(String algorithm) {
        ServiceLoader<DigestManager> serviceLoader =
                ServiceLoader.load(DigestManager.class);
        for (DigestManager cryptoManager : serviceLoader) {
            Returned<Digest> rt = cryptoManager.create(algorithm);
            switch (rt) {
                case Returned.ReturnValue rv -> {
                    return rv;
                }
                case Returned.ErrorCode ec -> {
                    continue;
                }
            }
        }

        return Returned.UNDEFINED;
    }
}
