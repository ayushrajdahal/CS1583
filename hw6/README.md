# Homework 6

## How to run

```zsh
javac HugeIntegerTest.java
java HugeIntegerTest
```

Example Output:

```
Initializing HugeInteger A and B:

HugeInteger A = 12345678901234567890123456789
HugeInteger B = 987654321098765432109876543
int C = 123

Testing methods:

A.toString() = 12345678901234567890123456789
A + B = 13333333222333333322233333332
A + C = 12345678901234567890123456912
A - B = 11358024580135802458013580246
A - C = 12345678901234567890123456666
A == B: false
A == C: false
A > B: true
A > C: true
A >= B: true
A >= C: true
A < B: false
A < C: false
A <= B: false
A <= C: false
A * B = 12193263113702179522618503270769699763964487123185200427
A * C = 1518518504851851850485185185047
A / B = 12
A / C = 100371373180768844635150055
A % B = 493827048049382704804938273
A % C = 24
```
