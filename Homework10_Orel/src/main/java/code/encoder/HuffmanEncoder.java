package code.encoder;

import code.huffman.HuffmanLibrary;
import code.LibraryManager;

public class HuffmanEncoder implements Encoder, LibraryManager {
    private HuffmanLibrary lib;

    public HuffmanEncoder(){
        lib = new HuffmanLibrary();
    }

    @Override
    public void setupLibrary(HuffmanLibrary lib){
        this.lib = lib;
    }

    @Override
    public String encode(String msg){
        StringBuilder encipheredMsg = new StringBuilder();
        char []characters = msg.toCharArray();
        for(int index = 0; index < characters.length; index++){
            encipheredMsg
                    .append(
                            this.lib
                                    .getPrefix(
                                            characters[index]
                                    )
                    );
        }
        return encipheredMsg.toString();
    }
}
