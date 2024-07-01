public class StackMain {
    public static void main(String[] args) {

        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(25);
        s.push(30);

        s.display();

        s.pop();
        s.pop();

        s.display();

    }
}
