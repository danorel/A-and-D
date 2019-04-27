import java.util.Stack;

public class TaskContainer {
    /*
        #1
     */
    public int factorial(int number){
        return (number <= 1) ? number : number * factorial(number - 1);
    }
    /*
        #2
     */
    public int bunnyEars(int index){
        if(index == 0){
            return 0;
        } else if(index % 2 == 0){
            return bunnyEars(index - 1) + 3;
        } else {
            return bunnyEars(index - 1) + 2;
        }
    }
    /*
        #3
    */
    public int triangle(int height){
        return height == 0 ? 0 : height + triangle(height - 1);
    }
    /*
        #4
    */
    public int digitsSummary(int number){
        return (number >= 0 && number <= 9) ? number : number % 10 + digitsSummary(number / 10);
    }
    /*
        #5
    */
    public int countSevenDigits(int number){
        if(number <= 1){
            return 0;
        } else {
            if(number % 10 == 7){
                return countSevenDigits(number / 10) + 1;
            } else {
                return countSevenDigits(number / 10);
            }
        }
    }
    /*
        #6
    */
    public int countEightDigits(int number){
        if(number <= 1){
            return 0;
        } else {
            if(number % 10 == 8){
                if((number / 10) % 10 == 8){
                    return 2 + countEightDigits(number / 10);
                } else {
                    return countEightDigits(number / 10) + 1;
                }
            } else {
                return countEightDigits(number / 10);
            }
        }
    }
    /*
        #7
    */
    public int power(int number, int exponent){
        return (exponent == 1) ? number : number * power(number, exponent - 1);
    }
    /*
        #8
    */
    public int getXAmount(String source){
        if(source.length() == 0){
            return 0;
        } else {
            if(source.charAt(source.length() - 1) == 'x'){
                return getXAmount(source.substring(0, source.length() - 1)) + 1;
            } else {
                return getXAmount(source.substring(0, source.length() - 1));
            }
        }
    }
    /*
        #9
    */
    public int getHiFrequency(String source){
        if(source.length() == 1 || source.length() == 0){
            return 0;
        } else {
            if(source.charAt(source.length() - 1) == 'i' && source.charAt(source.length() - 2) == 'h'){
                return getHiFrequency(source.substring(0, source.length() - 1)) + 1;
            } else {
                return getHiFrequency(source.substring(0, source.length() - 1));
            }
        }
    }
    /*
        #10
    */
    public String substituteXtoY(String source){
        return substituteXtoYRecursive(source, 0);
    }

    private String substituteXtoYRecursive(String source, int index){
        if(index < source.length()){
            if(source.charAt(index) == 'x'){
                return substituteXtoYRecursive(
                        source.substring(0, index).concat("y") + source.substring(index + 1)
                        , index + 1);
            } else {
                return substituteXtoYRecursive(source, index + 1);
            }
        } else {
            return source;
        }
    }
    /*
        #11
    */
    public String substitutePI(String source){
        return substitutePIRecursive(source, 0);
    }

    private String substitutePIRecursive(String source, int index){
        if(index < source.length() - 1){
            if(source.charAt(index) == 'p' && source.charAt(index + 1) == 'i'){
                return substitutePIRecursive(
                        source.substring(0, index)
                                .concat("3.14")
                                .concat(source.substring(index + 2))
                        , index + 2
                );
            } else {
                return substitutePIRecursive(source, index + 1);
            }
        } else {
            return source;
        }
    }
    /*
        #12
    */
    public String extractAllX(String source){
        return extractAllXRecursive(source, 0);
    }

    private String extractAllXRecursive(String source, int index){
        if(index < source.length()){
            if(source.charAt(index) == 'x'){
                return extractAllXRecursive(
                        source
                                .substring(0, index)
                                .concat(
                                        source.substring(index + 1)
                                )
                        , index);
            } else {
                return extractAllXRecursive(source, index + 1);
            }
        }
        return source;
    }
    /*
        #13
    */
    public boolean isSixExists(int []source, int from){
        return isSixExistsRecursive(source, from);
    }

    private boolean isSixExistsRecursive(int []source, int index){
        if(index < source.length){
            if(source[index] == 6){
                return true;
            } else {
                return isSixExistsRecursive(source, index + 1);
            }
        } else {
            return false;
        }
    }
    /*
        #14
    */
    public int getElevenAmount(int []source, int from){
        return getElevenAmountRecursive(source, from);
    }

    private int getElevenAmountRecursive(int []source, int index){
        if(index < source.length){
            if(source[index] == 11){
                return getElevenAmountRecursive(source, index + 1) + 1;
            } else {
                return getElevenAmountRecursive(source, index + 1);
            }
        } else {
            return 0;
        }
    }
    /*
        #15
    */
    public boolean isUniqueSequence(int []source, int from){
        return isUniqueSequenceRecursive(source, from);
    }

    private boolean isUniqueSequenceRecursive(int []source, int index){
        if(index < source.length - 1){
            if(10 * source[index] == source[index + 1]){
                return true;
            } else {
                return isUniqueSequenceRecursive(source, index + 1);
            }
        } else {
            return false;
        }
    }
    /*
        #16
    */
    public String borderWithStars(String source){
        return borderWithStarsRecursive(source, 0);
    }

    private String borderWithStarsRecursive(String source, int index){
        if(index < source.length() - 1){
            return borderWithStarsRecursive(
                    source
                            .substring(0, index + 1)
                            .concat("*")
                            .concat(
                                    source.substring(index + 1)
                            )
                    , index + 2);
        } else {
            return source;
        }
    }
    /*
        #17
    */
    public String borderPairsWithStars(String source){
        return borderPairsWithStarsRecursive(source, 0);
    }

    private String borderPairsWithStarsRecursive(String source, int index){
        if(index < source.length() - 1){
            if(source.charAt(index) == source.charAt(index + 1)){
                return borderPairsWithStarsRecursive(
                        source
                                .substring(0, index + 1)
                                .concat("*")
                                .concat(
                                        source.substring(index + 1)
                                )
                        , index + 2);
            } else {
                return borderPairsWithStarsRecursive(
                        source, index + 1);
            }
        } else {
            return source;
        }
    }
    /*
        #18
    */
    public String appendAllX(String source){
        return appendAllXRecursive(source, 0, 0);
    }

    private String appendAllXRecursive(String source, int index, int times){
        if(times < source.length()){
            if(source.charAt(index) == 'x'){
                return appendAllXRecursive(
                        source
                                .substring(0, index)
                                .concat(
                                        source.substring(index + 1)
                                )
                                .concat("x")
                        , index, times + 1
                );
            } else {
                return appendAllXRecursive(source, index + 1, times + 1);
            }
        } else {
            return source;
        }
    }
    /*
        #19
    */
    public int getAmountOfPairs(String source){
        return getAmountOfPairsRecursive(source, 0);
    }

    private int getAmountOfPairsRecursive(String source, int index){
        if(index < source.length() - 2){
            if(source.charAt(index) == source.charAt(index + 2)){
                return getAmountOfPairsRecursive(source, index + 1) + 1;
            } else {
                return getAmountOfPairsRecursive(source, index + 1);
            }
        } else {
            return 0;
        }
    }
    /*
        #20
    */
    public int countABCSequences(String source){
        return countABCSequencesRecursive(source, 0);
    }

    private int countABCSequencesRecursive(String source, int index){
        if(index < source.length() - 2){
            if(source.charAt(index) == 'a' && source.charAt(index + 1) == 'b' && (source.charAt(index + 2) == 'c' || source.charAt(index + 2) == 'a' )){
                return countABCSequencesRecursive(source, index + 2) + 1;
            } else {
                return countABCSequencesRecursive(source, index + 1);
            }
        } else {
            return 0;
        }
    }
    /*
        #21
    */
    public int getAmountOfEleven(String source){
        return getAmountOfElevenRecursive(source, 0);
    }

    private int getAmountOfElevenRecursive(String source, int index){
        if(index < source.length() - 1){
            if(source.charAt(index) == '1' && source.charAt(index + 1) == '1'){
                return getAmountOfElevenRecursive(source, index + 2) + 1;
            } else {
                return getAmountOfElevenRecursive(source, index + 1);
            }
        } else {
            return 0;
        }
    }
    /*
        #22
    */
    public String cleaner(String source){
        return cleanerRecursive(source, 0);
    }

    private String cleanerRecursive(String source, int index){
        if(index < source.length() - 1){
            if(source.charAt(index) == source.charAt(index + 1)){
                return cleanerRecursive(
                        source
                                .substring(0, index)
                                .concat(
                                        source.substring(index + 1)
                                )
                        , index);
            } else {
                return cleanerRecursive(source, index + 1);
            }
        } else {
            return source;
        }
    }
    /*
        #23
    */
    public int getHiFrequencyModified(String source){
        return getAmountOfHiModifiedRecursive(source, 0);
    }

    private int getAmountOfHiModifiedRecursive(String source, int index){
        if(index < source.length() - 1){
            if(index - 1 >= 0 && source.charAt(index - 1) == 'x'){
                return getAmountOfHiModifiedRecursive(source, index + 1);
            } else {
                if(source.charAt(index) == 'h' && source.charAt(index + 1) == 'i'){
                    return getAmountOfHiModifiedRecursive(source, index + 2) + 1;
                } else {
                    return getAmountOfHiModifiedRecursive(source, index + 1);
                }
            }
        } else {
            return 0;
        }
    }
    /*
        #24
    */
    public String getParenthesisContent(String source){
        return getParenthesisContentRecursive(source, 0);
    }

    private String getParenthesisContentRecursive(String source, int index){
        if(index < source.length()){
            if(source.charAt(index) == '('){
                return getParenthesisContentRecursive(source.substring(index), index + 1);
            } else if(source.charAt(index) == ')'){
                return getParenthesisContentRecursive(source.substring(0, index + 1), index + 1);
            } else {
                return getParenthesisContentRecursive(source, index + 1);
            }
        } else {
            return source;
        }
    }
    /*
        #25
    */
    public boolean checkIfNestedParenthesis(String source){
        return checkIfNestedParenthesisRecursive(source, 0, source.length() - 1);
    }

    private boolean checkIfNestedParenthesisRecursive(String source, int left, int right){
        if(left <= right){
            if(source.charAt(left) == '(' && source.charAt(right) == ')'){
                return checkIfNestedParenthesisRecursive(source, left + 1, right - 1);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
    /*
        #26
    */
    public int substringCounter(String source, String substring){
        return substringCounterRecursive(source, 0, substring, 0);
    }

    private int substringCounterRecursive(String source, int index, String substring, int start){
        if(index < source.length()){

            if(source.charAt(index) == substring.charAt(start)){
                return substringCounterRecursive(source, index + 1, substring, start + 1) + 1;
            } else {
                return substringCounterRecursive(source, index + 1, substring, start + 1);
            }
        } else {
            return 0;
        }
    }
}
