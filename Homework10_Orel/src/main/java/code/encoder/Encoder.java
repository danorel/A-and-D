package code.encoder;

import code.encoder.exceptions.EncoderLibraryInitException;

public interface Encoder {
    String encode(String message) throws EncoderLibraryInitException;
}
