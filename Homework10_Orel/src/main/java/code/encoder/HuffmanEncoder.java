package code.encoder;

import code.encoder.exceptions.EncoderLibraryInitException;
import code.huffman.HuffmanLibrary;
import code.LibraryManager;

public class HuffmanEncoder implements Encoder, LibraryManager {
    private HuffmanLibrary lib;

    @Override
    public void setupLibrary(HuffmanLibrary lib){
        this.lib = lib;
    }

    @Override
    public String encode(String msg) throws EncoderLibraryInitException {
        if(this.lib == null){
            throw new EncoderLibraryInitException();
        } else {
            StringBuilder encipheredMsg = new StringBuilder();
            char []characters = msg.toCharArray();
            for(int index = 0; index < characters.length; index++){
                encipheredMsg
                        .append(
                                this.lib
                                        .getPrefixByCharacter(
                                                characters[index]
                                        )
                        );
            }
            return encipheredMsg.toString();
        }
    }
}
