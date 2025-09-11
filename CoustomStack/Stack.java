package CoustomStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

public class Stack<T> {
    private final Deque<T> stack = new ArrayDeque<>();
    private final ReentrantLock lock = new ReentrantLock();

    //push
    public void push(T value){
        lock.lock();
        try {
            stack.push(value);
        } finally{
            lock.unlock();
        }
    }
    //pop
    public T pop(){
        lock.lock();
        try {
            if(stack.isEmpty()){
                throw new NoSuchElementException("Stack is empty");
            }
            return stack.pop();
        } finally{
            lock.unlock();
        }
    }
    //peek
    public T peek(){
        lock.lock();
        try{
            if(stack.isEmpty()){
                throw new NoSuchElementException("Stack is empty");
            }
            return stack.peek();
        }finally{
            lock.unlock();
        }
    }
    //isEmpty
    public int size(){
        lock.lock();
        try{
            return stack.size();
        }finally{
            lock.unlock();
        }
    }
    public boolean isEmpty(){
        lock.lock();
        try{
            return stack.isEmpty();
        }finally{
            lock.unlock();
        }
    }
}
