public class HugeIntegerTest {
    public static void main(String[] args) {

        HugeInteger A = new HugeInteger("12345678901234567890123456789");
        String A_temp = A.toString(); // a copy of variable A as a String

        HugeInteger B = HugeInteger.parse("abc987654321098765432109876543");
        int C = 123;

        System.out.println("\nInitializing HugeInteger A and B:\n");
        System.out.printf("HugeInteger A = %s\n", A);
        System.out.printf("HugeInteger B = %s\n", B);
        System.out.printf("int C = %s\n", C);

        System.out.println("\nTesting methods:\n");

        System.out.printf("A.toString() = %s\n", A.toString());
        A.add(B);
        System.out.printf("A + B = %s\n", A);
        A = new HugeInteger(A_temp);
        A.add(C);
        System.out.printf("A + C = %s\n", A);
        A = new HugeInteger(A_temp);

        A.subtract(B);
        System.out.printf("A - B = %s\n", A);
        A = new HugeInteger(A_temp);
        A.subtract(C);
        System.out.printf("A - C = %s\n", A);
        A = new HugeInteger(A_temp);

        System.out.printf("A == B: %b\n", A.isEqualTo(B));
        System.out.printf("A == C: %b\n", A.isEqualTo(C));

        System.out.printf("A > B: %b\n", A.isGreaterThan(B));
        System.out.printf("A > C: %b\n", A.isGreaterThan(C));

        System.out.printf("A >= B: %b\n", A.isGreaterThanOrEqualTo(B));
        System.out.printf("A >= C: %b\n", A.isGreaterThanOrEqualTo(C));

        System.out.printf("A < B: %b\n", A.isLessThan(B));
        System.out.printf("A < C: %b\n", A.isLessThan(C));

        System.out.printf("A <= B: %b\n", A.isLessThanOrEqualTo(B));
        System.out.printf("A <= C: %b\n", A.isLessThanOrEqualTo(C));

        A.multiply(B);
        System.out.printf("A * B = %s\n", A);
        A = new HugeInteger(A_temp);
        A.multiply(C);
        System.out.printf("A * C = %s\n", A);
        A = new HugeInteger(A_temp);

        A.divide(B);
        System.out.printf("A / B = %s\n", A);
        A = new HugeInteger(A_temp);
        A.divide(C);
        System.out.printf("A / C = %s\n", A);
        A = new HugeInteger(A_temp);

        A.remainder(B);
        System.out.printf("A %% B = %s\n", A);
        A = new HugeInteger(A_temp);
        A.remainder(C);
        System.out.printf("A %% C = %s\n", A);
        A = new HugeInteger(A_temp);

    }
}
