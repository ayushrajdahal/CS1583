public class HugeIntegerTest {
    public static void main(String[] args) {
        HugeInteger A = new HugeInteger("12345678901234567890123456789");
        HugeInteger B = HugeInteger.parse("987654321098765432109876543");

        System.out.println("\nInitializing HugeInteger A and B:\n");
        System.out.printf("A = %s\n", A);
        System.out.printf("B = %s\n", B);

        System.out.println("\nTesting methods:\n");

        A.add(B);
        System.out.printf("A + B = %s\n", A);

        A.subtract(B);
        System.out.printf("A - B = %s\n", A);

        System.out.printf("A == B: %b\n", A.isEqualTo(B));
        System.out.printf("A > B: %b\n", A.isGreaterThan(B));
        System.out.printf("A >= B: %b\n", A.isGreaterThanOrEqualTo(B));
        System.out.printf("A < B: %b\n", A.isLessThan(B));
        System.out.printf("A <= B: %b\n", A.isLessThanOrEqualTo(B));

    }
}
