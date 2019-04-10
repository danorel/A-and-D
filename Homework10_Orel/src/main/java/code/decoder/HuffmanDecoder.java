package code.decoder;

import code.decoder.exceptions.DecoderLibraryInitException;
import code.huffman.HuffmanLibrary;
import code.LibraryManager;

public class HuffmanDecoder implements Decoder, LibraryManager {
    private HuffmanLibrary lib;

    @Override
    public void setupLibrary(HuffmanLibrary lib){
        this.lib = lib;
    }

    @Override
    public String decode(String msg) throws DecoderLibraryInitException {
        if(lib == null){
            throw new DecoderLibraryInitException();
        } else {
            StringBuilder decodedMsg = new StringBuilder();
            StringBuilder prefix = new StringBuilder();
            char []characters = msg.toCharArray();
            int shift = 0;
            for(int index = 0; index < characters.length; index++){
                prefix
                        .append(characters[index]);
                shift++;
                if(this.lib.isValidPrefix(prefix.toString())){
                    decodedMsg
                            .append(
                                    this.lib.getCharacterByPrefix(
                                            prefix.toString()
                                    )
                            );
                    msg = msg
                            .substring(shift);
                    prefix = new StringBuilder();
                    shift = 0;
                }
            }
            return decodedMsg.toString();
        }
    }
}
