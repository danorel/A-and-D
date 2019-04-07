package code.decoder;

import code.huffman.HuffmanLibrary;
import code.LibraryManager;

public class HuffmanDecoder implements Decoder, LibraryManager {
    private HuffmanLibrary library;

    public HuffmanDecoder(){
        library = new HuffmanLibrary();
    }

    @Override
    public void setupLibrary(HuffmanLibrary library){
        this.library = library;
    }

    @Override
    public String decode(String message){
        StringBuilder decodedMessage = new StringBuilder();
        StringBuilder prefix = new StringBuilder();
        char []characters = message.toCharArray();
        int letter = 0;
        for(int index = 0; index < characters.length; index++){
            prefix
                    .append(characters[index]);
            letter++;
            if(this.library.isValid(prefix.toString())){
                decodedMessage
                        .append(
                                this.library.getKeyByPrefix(
                                        prefix.toString()
                                )
                        );
                message = message.substring(letter);
                prefix = new StringBuilder();
                letter = 0;
            }
        }
        return decodedMessage.toString();
    }
}
