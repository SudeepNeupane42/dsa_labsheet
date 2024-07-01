public class RecursionExamples {

    public static void main(String[] args) {
        System.out.println("Factorial of 5 is: " + factorial(5));

        int term = 6;
        System.out.print("Fibonacci series up to term " + term + ": ");
        for (int i = 0; i < term; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();

        towerOfHanoi(3, 'A', 'C', 'B');
    }

    public static int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void towerOfHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod);
            return;
        }
        towerOfHanoi(n - 1, fromRod, auxRod, toRod);
        System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
        towerOfHanoi(n - 1, auxRod, toRod, fromRod);
    }
}
