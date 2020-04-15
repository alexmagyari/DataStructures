public class sample{
    public static void main(String[] args){
        Stack<Integer> I = new ArrayStack<>(10);
        I.push(5);
        I.push(6);
        I.push(7);
        System.out.println(I.size());
        System.out.println(I.pop());
        System.out.println(I.pop());
        System.out.println(I.pop());
        System.out.println(I.size());
    }
}