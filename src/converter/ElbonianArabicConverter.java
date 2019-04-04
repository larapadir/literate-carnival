package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Elbonian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/18/17
 */
public class ElbonianArabicConverter {

    // A string that holds the number (Elbonian or Arabic) you would like to convert
    private final String number;
    private boolean isNumbers;


    /**
     * Constructor for the ElbonianArabic class that takes a string. The string should contain a valid
     * Elbonian or Arabic numeral. The String can have leading or trailing spaces. But there should be no
     * spaces within the actual number (ie. "9 9" is not ok, but " 99 " is ok). If the String is an Arabic
     * number it should be checked to make sure it is within the Elbonian number systems bounds. If the
     * number is Elbonian, it must be a valid Elbonian representation of a number.
     *
     * @param number A string that represents either a Elbonian or Arabic number.
     * @throws MalformedNumberException Thrown if the value is an Elbonian number that does not conform
     * to the rules of the Elbonian number system. Leading and trailing spaces should not throw an error.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic number that cannot be represented
     * in the Elbonian number system.
     */
    public ElbonianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {

        // TODO check to see if the number is valid, then set it equal to the string
        if (number.length() < 1) throw new ValueOutOfBoundsException(number);
        number = number.trim();
        this.number = number;

        this.isNumbers =true;
        for( char c : number.toCharArray()){
            if(! Character.isDigit(c) ){
                this.isNumbers = false;
                break;
            }
        }
        if(this.isNumbers == false) {
            for (char c : number.toCharArray()) {
                if (!((c == 'M') || (c == 'C') || (c == 'X') || (c == 'I') || (c == 'N') || (c == 'D') || (c == 'Y') || (c == 'J'))) {
                    throw new MalformedNumberException(number);
                }

            }

            int count_N = number.chars().filer(c -> c == 'N').count();
            int count_M = number.chars().filer(c -> c == 'M').count();
            int count_D = number.chars().filer(c -> c == 'D').count();
            int count_C = number.chars().filer(c -> c == 'C').count();
            int count_Y = number.chars().filer(c -> c == 'Y').count();
            int count_X = number.chars().filer(c -> c == 'X').count();
            int count_J = number.chars().filer(c -> c == 'J').count();
            int count_I = number.chars().filer(c -> c == 'I').count();

            if((count_M > 2) || (count_C > 2) ||
                    (count_X > 2) || (count_I > 2)
                || (count_N > 3) || (count_D > 3)
                || (count_Y > 3) || (count_J > 3)) {
                throw new MalformedNumberException(number);
            }

            if ((count_N >= 3 && count_M > 0)
                || (count_D >= 3 && count_C > 0)
                || (count_Y >= 3 && count_X > 0)
                || (count_J >= 3 && count_I > 0)) {
                throw new MalformedNumberException(number);
            }



            // N M N


            // we will have problems, because if the character is not in the string, it returns -1

            // PROBLEM SOLVED


            int min_position_M = this.number.indexOf('M');
            int min_position_D = this.number.indexOf('D');
            int min_position_C = this.number.indexOf('C');
            int min_position_Y = this.number.indexOf('Y');
            int min_position_X = this.number.indexOf('X');
            int min_position_J = this.number.indexOf('J');
            int min_position_I = this.number.indexOf('I');
            int max_position_N = this.number.lastIndexOf('N');
            int max_position_M = this.number.lastIndexOf('M');
            int max_position_D = this.number.lastIndexOf('D');
            int max_position_C = this.number.lastIndexOf('C');
            int max_position_Y = this.number.lastIndexOf('Y');
            int max_position_X = this.number.lastIndexOf('X');
            int max_position_J = this.number.lastIndexOf('J');

            if (min_position_M == -1) {
                min_position_M = this.number.length() + 1;
            }
            if (min_position_D == -1) {
                min_position_D = this.number.length() + 1;
            }
            if (min_position_C == -1) {
                min_position_C = this.number.length() + 1;
            }
            if (min_position_Y == -1) {
                min_position_Y = this.number.length() + 1;
            }
            if (min_position_X == -1) {
                min_position_X = this.number.length() + 1;
            }
            if (min_position_J == -1) {
                min_position_J = this.number.length() + 1;
            }
            if (min_position_I == -1) {
                min_position_I = this.number.length() + 1;
            }

            if (min_position_M < max_position_N || min_position_D < max_position_N || min_position_C < max_position_N
                    || min_position_Y < max_position_N || min_position_X < max_position_N || min_position_J < max_position_N
                    || min_position_I < max_position_N) throw new MalformedNumberException(number);
            if (min_position_D < max_position_M || min_position_C < max_position_M
                    || min_position_Y < max_position_M || min_position_X < max_position_M || min_position_J < max_position_M
                    || min_position_I < max_position_M) throw new MalformedNumberException(number);
            if (min_position_C < max_position_D
                    || min_position_Y < max_position_D || min_position_X < max_position_D || min_position_J < max_position_D
                    || min_position_I < max_position_D) throw new MalformedNumberException(number);
            if (min_position_Y < max_position_C || min_position_X < max_position_C || min_position_J < max_position_C
                    || min_position_I < max_position_C) throw new MalformedNumberException(number);
            if (min_position_X < max_position_Y || min_position_J < max_position_Y
                    || min_position_I < max_position_Y) throw new MalformedNumberException(number);
            if (min_position_J < max_position_X || min_position_I < max_position_X) throw new MalformedNumberException(number);
            if (min_position_I < max_position_J) throw new MalformedNumberException(number);


            // if N appears 3 times, M cannot be used
            // ...





        }


        if (this.toArabic() <= 0 || this.toArabic() > 9999) throw new ValueOutOfBoundsException(number);




    }

    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        if (this.isNumbers) {
            return Integer.parseInt(this.number);
        } else {
            // do stuff
            // divide things by numbers and get remainders
            int result = 0;

            int count_N = number.chars().filer(c -> c == 'N').count();
            int count_M = number.chars().filer(c -> c == 'M').count();
            int count_D = number.chars().filer(c -> c == 'D').count();
            int count_C = number.chars().filer(c -> c == 'C').count();
            int count_Y = number.chars().filer(c -> c == 'Y').count();
            int count_X = number.chars().filer(c -> c == 'X').count();
            int count_J = number.chars().filer(c -> c == 'J').count();
            int count_I = number.chars().filer(c -> c == 'I').count();

            result += count_N * 3000;
            result += count_M * 1000;
            result += count_D * 300;
            result += count_C * 100;
            result += count_Y * 30;
            result += count_X * 10;
            result += count_J * 3;
            result += count_I * 1;

            return result;
        }
    }

    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian() {
        // TODO Fill in the method's body
        if (!this.isNumbers) {
            return this.number;
        } else {
            StringBuilder result = new StringBuilder();

            int countN = Integer.parseInt(this.number) / 3000;
            int remainder = Integer.parseInt(this.number) % 3000;
            for(int i = 0; i < countN; i++){
                result.append("N");
            }

            int countM = remainder / 1000;
            remainder = remainder % 1000;
            for(int i = 0; i < countM; i++){
                result.append("M");
            }

            int countD = remainder / 300;
            remainder = remainder % 300;
            for(int i = 0; i < countD; i++){
                result.append("D");
            }

            int countC = remainder / 100;
            remainder = remainder % 100;
            for(int i = 0; i < countC; i++){
                result.append("C");
            }

            int countY = remainder / 30;
            remainder = remainder % 30;
            for(int i = 0; i < countY; i++){
                result.append("Y");
            }

            int countX = remainder / 10;
            remainder = remainder % 10;
            for(int i = 0; i < countX; i++){
                result.append("X");
            }

            int countJ = remainder / 3;
            remainder = remainder % 3;
            for(int i = 0; i < countJ; i++){
                result.append("J");
            }

            int countI = remainder / 1;
            remainder = remainder % 1;
            for(int i = 0; i < countI; i++){
                result.append("I");
            }

         return result.toString();
        }

    }

}
