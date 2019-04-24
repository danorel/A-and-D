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
    
}
