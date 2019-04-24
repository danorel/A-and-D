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
    public int bunnyEars(int position){
        if(position == 0){
            return 0;
        } else if(position % 2 == 0){
            return bunnyEars(position - 1) + 3;
        } else {
            return bunnyEars(position - 1) + 2;
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
    public int countXChars(String input){
        if(input.length() == 0){
            return 0;
        } else {
            if(input.charAt(input.length() - 1) == 'x'){
                return countXChars(input.substring(0, input.length() - 1)) + 1;
            } else {
                return countXChars(input.substring(0, input.length() - 1));
            }
        }
    }
    /*
        #9
    */
    public int countHiSubstrings(String input){
        if(input.length() == 1 || input.length() == 0){
            return 0;
        } else {
            if(input.charAt(input.length() - 1) == 'i' && input.charAt(input.length() - 2) == 'h'){
                return countHiSubstrings(input.substring(0, input.length() - 1)) + 1;
            } else {
                return countHiSubstrings(input.substring(0, input.length() - 1));
            }
        }
    }
    /*
        #10
    */
    public int changeXtoY(String input){
        if(input.length() == 0){
            return 0;
        } else {
            if(input.charAt(input.length() - 1) == 'x'){
                return countHiSubstrings(input.substring(0, input.length() - 2)) + 1;
            } else {
                return countHiSubstrings(input.substring(0, input.length() - 1));
            }
        }
    }
}
