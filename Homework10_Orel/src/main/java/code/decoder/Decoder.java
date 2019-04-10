package code.decoder;

import code.decoder.exceptions.DecoderLibraryInitException;

public interface Decoder {
    String decode(String message) throws DecoderLibraryInitException;
}
