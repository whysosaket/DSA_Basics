import java.util.Scanner;

class QueueViaArray{
    static int head=-1;
    static int tail=-1;
    static int [] queue;
    static int size;
    static int elements = 0;

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter Size of Array: ");
        size=sc.nextInt();
        queue = new int [size];
        
        while(size!=Integer.MIN_VALUE){
          System.out.println("*****MENU*****");
          System.out.println("0. Exit");
          System.out.println("1. Enqueue");
          System.out.println("2. Dequeue");
          System.out.println("3. Display");
          System.out.println("4. isEmpty");
          System.out.println("5. isFull");
          System.out.print("Enter Option: ");
          int option = sc.nextInt();
          switch(option){
            case 0 -> System.exit(0);
            case 1 -> {
                System.out.print("Enter Marks: ");
                enqueue(sc.nextInt());
             }
            case 2 -> dequeue();
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

    public static void enqueue(int input){
        if(head==-1&&tail==-1){
            head = 0;
        }
        if(isFull()) System.out.println("QUEUE OVERFLOW!!");
        else{
            tail=(tail+1)%size;
            queue[tail] = input;
            elements++;
        }
    }

    public static void dequeue(){
        if(isEmpty()) System.out.println("QUEUE UNDERFLOW");
        else{
            System.out.println("The Dequeued Element is "+queue[head]);
            head=(head+1)%size;
            elements--;
        }
    }

    public static void diplay(){
        System.out.println("-----------------------------");
        for(int i=0;i<elements;i++){
            System.out.print(queue[(head+i)%size]+" -> ");
        }
        System.out.println("\n-----------------------------");
    }

    public static boolean isEmpty(){
        return elements==0;
    }

    public static boolean isFull(){
        return elements==size;
    }
}