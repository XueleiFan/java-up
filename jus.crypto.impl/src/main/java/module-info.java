module jus.crypto.impl {
    requires jus.crypto;

    provides co.ivi.jus.crypto.DigestManager with co.ivi.jus.impl.DigestManagerImpl;
}