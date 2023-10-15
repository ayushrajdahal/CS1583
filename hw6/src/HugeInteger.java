public class HugeInteger {
    // makes digitsArray variable accessible within the class
    private int[] digitsArray;

    public HugeInteger(String num) {
        // creates an array of 60 integers to store digits
        digitsArray = new int[60];

        // get numeric value of each character of the string
        for (int i = 0; i < num.length(); i++) {
            digitsArray[60 - num.length() + i] = Character.getNumericValue(num.charAt(i));
        }
    }

    public static HugeInteger parse(String num) {
        // uses regular expressions to remove everything except digits in num
        String numericString = num.replaceAll("[^0-9]", "");
        return new HugeInteger(numericString);
    }

    @Override
    public String toString() {
        // initialize the string
        String sb = "";
        // deals with leading zero
        boolean beforeNumber = true;

        for (int i = 0; i < digitsArray.length; i++) {
            // avoids zeros being added to the string before the actual number starts
            if (digitsArray[i] != 0) {
                beforeNumber = false;
            }
            if (!beforeNumber) {
                sb += String.valueOf(digitsArray[i]);
            }
        }
        // deals with empty string, changing it to zero
        if (sb == "") {
            sb += "0";
        }
        return sb;
    }

    public void add(int number) {
        // calls the same module passing number as HugeString
        add(new HugeInteger(String.valueOf(number)));
    }

    public void add(HugeInteger number) {
        // deals with carry overs
        int carry = 0;

        // loops digitsArray.length times
        for (int i = digitsArray.length - 1; i >= 0; i--) {
            // adds previous carry to the individual digit sum
            int sum = digitsArray[i] + number.digitsArray[i] + carry;
            // update carry with new value
            carry = sum / 10;
            // removes preceeding digit since it is used in carry
            digitsArray[i] = sum % 10;
        }
    }

    public void subtract(int number) {
        // calls the same module passing number as HugeString
        subtract(new HugeInteger(String.valueOf(number)));
    }

    public void subtract(HugeInteger number) {
        // stores borrowed values
        int borrow = 0;
        // loops digitsArray.length times
        for (int i = digitsArray.length - 1; i >= 0; i--) {
            // subtracts previous borrow from the individual digit difference
            int diff = digitsArray[i] - number.digitsArray[i] - borrow;
            // borrows 1 if diff becomes less than zero, 0 if more.
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            digitsArray[i] = diff;
        }
    }

    public boolean isEqualTo(int number) {
        // calls the same module passing number as HugeString
        return isEqualTo(new HugeInteger(String.valueOf(number)));
    }

    public boolean isEqualTo(HugeInteger number) {

        // loops over each digit in the digitArray, checks if all of them are equal.
        for (int i = 0; i < digitsArray.length; i++) {
            if (digitsArray[i] != number.digitsArray[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isGreaterThan(int number) {
        // calls the same module passing number as HugeString
        return isGreaterThan(new HugeInteger(String.valueOf(number)));
    }

    public boolean isGreaterThan(HugeInteger number) {
        // starts with the most significant digits, and goes on.
        // if any of the digit is bigger/smaller, we have a greater/smaller value.
        for (int i = 0; i < digitsArray.length; i++) {
            if (digitsArray[i] > number.digitsArray[i]) {
                return true;
            } else if (digitsArray[i] < number.digitsArray[i]) {
                return false;
            }
        }
        return false;
    }

    public boolean isGreaterThanOrEqualTo(int number) {
        // calls the same module passing number as HugeString
        return isGreaterThanOrEqualTo(new HugeInteger(String.valueOf(number)));
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger number) {
        // uses pre-existing modules
        return isEqualTo(number) || isGreaterThan(number);
    }

    public boolean isLessThan(int number) {
        // calls the same module passing number as HugeString
        return isLessThan(new HugeInteger(String.valueOf(number)));
    }

    public boolean isLessThan(HugeInteger number) {
        // negates the output of isGreaterThanOrEqualTo()
        return !isGreaterThanOrEqualTo(number);
    }

    public boolean isLessThanOrEqualTo(int number) {
        // calls the same module passing number as HugeString
        return isLessThanOrEqualTo(new HugeInteger(String.valueOf(number)));
    }

    public boolean isLessThanOrEqualTo(HugeInteger number) {
        return isEqualTo(number) || isLessThan(number);
    }

    public boolean isZero() {

        // returns false if any of the digit is anything other than zero.
        for (int i = 0; i < digitsArray.length; i++) {
            if (digitsArray[i] != 0) {
                return false;
            }
        }

        // if nothing is returned in the for loop above, it is a zero
        return true;
    }

    public void multiply(int number) {
        // calls the same module passing number as HugeString
        multiply(new HugeInteger(String.valueOf(number)));
    }

    // multiplies the current HugeInteger object with the passed HugeInteger object
    public void multiply(HugeInteger number) {
        // initializes an array to store the result of multiplication
        int[] result = new int[120];

        // multiplies the digits of the current HugeInteger object with the digits of
        // the passed HugeInteger object
        for (int i = digitsArray.length - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = number.digitsArray.length - 1; j >= 0; j--) {
                int product = digitsArray[i] * number.digitsArray[j] + carry + result[i + j + 1];
                result[i + j + 1] = product % 10;
                carry = product / 10;
            }
            result[i] += carry;
        }

        // initializes a new array to store the digits of the result
        digitsArray = new int[60];

        // copies the digits from the result array to the digitsArray of the current
        // HugeInteger object
        for (int i = 0; i < digitsArray.length; i++) {
            digitsArray[i] = result[i + 60];
        }
    }

    public void divide(int number) {
        // calls the same module passing number as HugeString
        divide(new HugeInteger(String.valueOf(number)));
    }

    public void divide(HugeInteger number) {
        // initializing quotient and remiander
        HugeInteger quotient = new HugeInteger("0");
        HugeInteger remainder = new HugeInteger("0");

        for (int i = 0; i < digitsArray.length; i++) {

            // equivalent to remainder * 10 + digitsArray[i]
            remainder.multiply(10);
            remainder.add(digitsArray[i]);

            // used for quotient
            int q = 0;

            while (remainder.isGreaterThanOrEqualTo(number)) {
                remainder.subtract(number);
                q++;
            }
            quotient.multiply(10);
            quotient.add(q);
        }
        digitsArray = quotient.digitsArray;
    }

    public void remainder(int number) {
        // calls the same module passing number as HugeString
        remainder(new HugeInteger(String.valueOf(number)));
    }

    public void remainder(HugeInteger number) {
        HugeInteger remainder = new HugeInteger("0");
        HugeInteger quotient = new HugeInteger("0");
        for (int i = 0; i < digitsArray.length; i++) {
            remainder.multiply(10);
            remainder.add(digitsArray[i]);
            int q = 0;
            while (remainder.isGreaterThanOrEqualTo(number)) {
                remainder.subtract(number);
                q++;
            }
            quotient.multiply(10);
            quotient.add(q);
        }
        digitsArray = remainder.digitsArray;
    }
}