public class HugeInteger {
    private int[] digitsArray;

    public HugeInteger(String num) {
        digitsArray = new int[60];
        for (int i = 0; i < num.length(); i++) {
            digitsArray[60 - num.length() + i] = Character.getNumericValue(num.charAt(i));
        }
    }

    public static HugeInteger parse(String num) {
        String numericString = num.replaceAll("[^0-9]", "");
        return new HugeInteger(numericString);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (int i = 0; i < digitsArray.length; i++) {
            if (digitsArray[i] != 0) {
                leadingZero = false;
            }
            if (!leadingZero) {
                sb.append(digitsArray[i]);
            }
        }
        if (sb.length() == 0) {
            sb.append(0);
        }
        return sb.toString();
    }

    public void add(int number) {
        add(new HugeInteger(String.valueOf(number)));
    }

    public void add(HugeInteger number) {
        int carry = 0;
        for (int i = digitsArray.length - 1; i >= 0; i--) {
            int sum = digitsArray[i] + number.digitsArray[i] + carry;
            digitsArray[i] = sum % 10;
            carry = sum / 10;
        }
    }

    public void subtract(int number) {
        subtract(new HugeInteger(String.valueOf(number)));
    }

    public void subtract(HugeInteger number) {
        int borrow = 0;
        for (int i = digitsArray.length - 1; i >= 0; i--) {
            int diff = digitsArray[i] - number.digitsArray[i] - borrow;
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
        return isEqualTo(new HugeInteger(String.valueOf(number)));
    }

    public boolean isEqualTo(HugeInteger number) {
        for (int i = 0; i < digitsArray.length; i++) {
            if (digitsArray[i] != number.digitsArray[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isGreaterThan(int number) {
        return isGreaterThan(new HugeInteger(String.valueOf(number)));
    }

    public boolean isGreaterThan(HugeInteger number) {
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
        return isGreaterThanOrEqualTo(new HugeInteger(String.valueOf(number)));
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger number) {
        return isEqualTo(number) || isGreaterThan(number);
    }

    public boolean isLessThan(int number) {
        return isLessThan(new HugeInteger(String.valueOf(number)));
    }

    public boolean isLessThan(HugeInteger number) {
        return !isGreaterThanOrEqualTo(number);
    }

    public boolean isLessThanOrEqualTo(int number) {
        return isLessThanOrEqualTo(new HugeInteger(String.valueOf(number)));
    }

    public boolean isLessThanOrEqualTo(HugeInteger number) {
        return isEqualTo(number) || isLessThan(number);
    }

    public boolean isZero() {
        for (int i = 0; i < digitsArray.length; i++) {
            if (digitsArray[i] != 0) {
                return false;
            }
        }
        return true;
    }

}