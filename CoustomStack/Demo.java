package CoustomStack;

public class Demo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("hello");
        stack.push("HI");
        stack.push("YO");
        stack.push("Bro");
    
        System.out.println(stack.peek());
        System.out.println(stack.pop());

        Stack<Integer> numStack = new Stack<>();

        Runnable pusher=()->{
            for(int i=0;i<5;i++){
                numStack.push(i);
                System.out.println(Thread.currentThread().getName()+ "pushed"+ i);
            }
        };
        
        Runnable popper = () -> {
            for (int i = 0; i < 5; i++) {
                if (!numStack.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " popped " + numStack.pop());
                }
            }
        };

        Thread t1= new Thread(pusher,"Producer -1");
        Thread t2 = new Thread(popper,"consumer-2");

        t1.start();
        t2.start();
    }

}
