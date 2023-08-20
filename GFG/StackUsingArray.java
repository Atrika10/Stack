public class StackUsingArray {

    int arr[] = new int[5];
    int idx =-1;

    public void push(int data){
        idx++;

        // I've to check is my stack is full or not
        if(idx == arr.length){
            idx--;
            System.out.println("Stack is full");
            return; // stack is full 
        }

        arr[idx] = data; 
    }

    public int pop(){
        //I've to check is my stack is empty or not
        if(idx == -1){
            return -1; // stack is empty
        }

        int value = arr[idx];
        idx--;
        return value;   
    }

    public int peek(){

       if(idx == -1){
            return -1; // stack is empty
        }
        return arr[idx];  

    }

    public boolean isEmpty(){
        return idx == -1;

    }

    public static void main(String args[]){
        StackUsingArray s = new StackUsingArray();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
        System.out.println(s.pop());
    }
    
}
