import java.util.Scanner;

public class StackViaArray {
    static int top=-1;
    static int [] stack;
    static int size;

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter Size of Array: ");
        size=sc.nextInt();
        stack = new int [size];
        
        while(size!=Integer.MIN_VALUE){
          System.out.println("*****MENU*****");
          System.out.println("0. Exit");
          System.out.println("1. Push");
          System.out.println("2. Pop");
          System.out.println("3. Display");
          System.out.println("4. isEmpty");
          System.out.println("5. isFull");
          System.out.print("Enter Option: ");
          int option = sc.nextInt();
          switch(option){
            case 0 -> System.exit(0);
            case 1 -> {
                System.out.print("Enter Marks: ");
                push(sc.nextInt());
             }
            case 2 -> pop();
            case 3 -> diplay();
            case 4 -> {
                if(isEmpty()) System.out.println("The Queue is Empty");
                else System.out.println("The Queue is not Empty");
            }
            case 5 -> {
                if(isFull()) System.out.println("The Queue is Full");
                else System.out.println("The Queue is not Full");
               }
            }
        }
        sc.close();
    }

    public static void push(int marks){
        if(isFull()) System.out.println("STACK OVERFLOW!!!");
        else{
            top++;
            stack[top]=marks;
        }
    }

    public static void pop(){
        if(isEmpty()) System.out.println("STACK UNDERFLOW!!!");
        else{
            top--;
        }
    }

    public static void diplay(){
        System.out.println("--------------------------");
        for(int i=top;i>=0&&!isEmpty();i--){
            System.out.println(stack[i]);
        }
        System.out.println("--------------------------");
    }

    public static boolean isEmpty(){
        return top==-1;
    }

    public static boolean isFull(){
        return top==size-1;
    }
}
