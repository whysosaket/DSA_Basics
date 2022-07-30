import java.util.Scanner;

public class MANUALDoublyLinkedList {
	
	static Scanner sc= new Scanner(System.in);
	static NodeDouble start;
	static NodeDouble end;
	
	
	//Creating the NodeDouble
	public static void create(NodeDouble NodeDouble) {
		
		NodeDouble=inputNodeDouble();
		
		if(MANUALDoublyLinkedList.start==null) {
			start=NodeDouble;
			start.prev=null;
			end=NodeDouble;
		}
		else{
			NodeDouble temp=MANUALDoublyLinkedList.end;
			MANUALDoublyLinkedList.end.next=NodeDouble;
			MANUALDoublyLinkedList.end=NodeDouble;
			MANUALDoublyLinkedList.end.prev=temp;
		}
		System.out.println("NodeDouble Added Successfully");
		
	}
	
	//Taking input and return NodeDouble;
	public static NodeDouble inputNodeDouble() {
		NodeDouble NodeDouble= new NodeDouble();
		
		System.out.print("Enter Regd. No. & Marks: ");
		NodeDouble.regd_no=sc.nextInt();
		NodeDouble.mark=sc.nextFloat();
		
		return NodeDouble;
	}
	
	
	//display all the NodeDoubles
	public static void display(NodeDouble n) {
		System.out.println("---------------------");
        if (n != null) {
            System.out.println("Reg No: " + n.regd_no);
            System.out.println("Marks: " + n.mark);
            display(n.next);
        }	
	}
	
	//start display
	public static void display() {
		
		System.out.println("All the NodeDoubles Are: ");
        if (start != null) {
            System.out.println("Reg No: " + start.regd_no);
            System.out.println("Marks: " + start.mark);
            display(start.next);
        } else emptyList();
		
	}
	
	//search a NodeDouble
	public static int searchNodeDouble(int n) {
		int count=0;
		if(MANUALDoublyLinkedList.start==null) {
			emptyList();
			return -1;
		}
		
		NodeDouble start=MANUALDoublyLinkedList.start;
		
		while(start.next!=null) {
			
			if(start.regd_no==n) {
				System.out.println("The NodeDouble is present at Index "+count);
				return count;
			}
			else start=start.next;
			count++;
			
		}
		if(MANUALDoublyLinkedList.end.regd_no==n) {
			count++;
			System.out.println("The NodeDouble is present at Index "+count);
			return count;
		}
		System.out.println("NodeDouble Not Found!!!");
		return -1;
	}
	
	//*****NodeDouble INSERTION METHODS*****//
	//Insert NodeDouble at the Beginning
	public static void insBeg() {
		NodeDouble ins= inputNodeDouble();
		NodeDouble tmp=MANUALDoublyLinkedList.start;
		
		MANUALDoublyLinkedList.start.prev=ins;
		MANUALDoublyLinkedList.start=ins;
		MANUALDoublyLinkedList.start.next=tmp;
		
	}
	
	//Insert NodeDouble at the End
	public static void insEnd() {
		NodeDouble NodeDouble= new NodeDouble();
		create(NodeDouble);
	}
	
	//Insert NodeDouble at any Point
	public static void insAny(int n) {
		int count=0;
        NodeDouble current=start;
        while(count<n&&current!=null){
            current=current.next;
            count++;
        }
        if(current!=null) {
            NodeDouble create = inputNodeDouble();
            current.prev.next=create;
            create.prev=current.prev;
            create.next=current;
            current.prev=create;
            System.out.println("INSERTION SUCCESSFUL");
        }
        else System.out.println("ERROR: END OF LIST!!!");
	}
	
	//*****NodeDouble DELETION METHODS*****//
	//Delete NodeDouble From the Beginning
	public static void delBeg() {
		if(MANUALDoublyLinkedList.start==null) {
			emptyList();
			return;
		}
		NodeDouble temp=MANUALDoublyLinkedList.start;
		MANUALDoublyLinkedList.start=MANUALDoublyLinkedList.start.next;
		temp=null;
        System.out.println("DELETION SUCCESSFUL");
	}
	
	//Delete NodeDouble From the End
	public static void delEnd() {
		if(MANUALDoublyLinkedList.start==null) {
			emptyList();
			return;
		}
        else if(MANUALDoublyLinkedList.end.prev==null){
            delBeg();
        }
        else {
            NodeDouble temp = MANUALDoublyLinkedList.end.prev;
            MANUALDoublyLinkedList.end.prev.next = null;
            MANUALDoublyLinkedList.end = temp;
        }
        System.out.println("DELETION SUCCESSFUL");
	}
	
	//Delete Any NodeDouble
	public static void delAny(int n) {
		int count=0;
        NodeDouble current=start;

        while(count<n&&current!=null){
            current=current.next;
            count++;
        }
        if(current!=null){
            if(current.next==null) delEnd();
            else if(current.prev==null) delBeg();
            else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            System.out.println("DELETION SUCCESSFUL");
        }
        else System.out.println("ERROR: END OF LIST!!");
	}

    static void reverse(){
        NodeDouble curr = start;
        while (curr!=null){
            NodeDouble tmp = curr.prev;
            curr.prev=curr.next;
            curr.next=tmp;
            curr=curr.prev;
        }
        NodeDouble tmp=start;
        start=end;
        end=tmp;
    }
	
	//Empty List function
	public static void emptyList() {
		System.out.println("Cannot Perform Operation!!!\nList is Empty");
	}
	
	//-----------------------------MAIN METHOD--------------------------------------//

    /* Code for the remaining user defined methods*/
    public static void main(String[] args) {


        // Creating a new NodeDouble
        while (true) {
            NodeDouble n = new NodeDouble();
            
            
            //System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("****MENU*****");
            System.out.println("0:Exit");
            if(start==null) System.out.println("1:Creation");
            else System.out.println("1:Insert at End");
            System.out.println("2:Display");
            System.out.println("3:Insert NodeDouble");
            System.out.println("4:Delete NodeDouble");
            System.out.println("5:Search NodeDouble");
            System.out.println("6:Reverse");
            System.out.print("Enter the choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    create(n);
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    NodeDoubleInsertionOperationsMenu();
                    break;
                case 4:
                    NodeDoubleDeletionOperationsMenu();
                    break;
                case 5:
                    System.out.print("Enter Reg ID. to search NodeDouble: ");
                    searchNodeDouble(sc.nextInt());
                    break;
                case 6:
                    reverse();
                    break;

                default:
                    System.out.println("Wrong choice");
            }
        }
    }


// NodeDouble Operations Menu (Insertion)
    public static void NodeDoubleInsertionOperationsMenu()
    {
        loop:
        while(true){
            NodeDouble n = new NodeDouble();
            System.out.println("****MENU*****");
            System.out.println("0:Back");
            System.out.println("1:Insertion at the Beginning of List");
            System.out.println("2:Insertion at the End of List");
            System.out.println("3:Insertion at at any Position");

            System.out.print("Enter the choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    break loop;
                case 1:
                    insBeg();
                    break;
                case 2:
                    insEnd();
                    break;
                case 3:
                    System.out.print("Enter Position To Insert: ");
                    insAny(sc.nextInt());
                    break;

                default:
                    System.out.println("Wrong choice");
            }

        }
    }

    //NodeDouble Deletion Menu
    public static void NodeDoubleDeletionOperationsMenu()
    {
        loop:
        while(true){
            NodeDouble n = new NodeDouble();
            System.out.println("****MENU*****");
            System.out.println("0:Back");
            System.out.println("1:Delete NodeDouble from the Beginning of List");
            System.out.println("2:Delete NodeDouble from the End of List");
            System.out.println("3:Delete NodeDouble from at any Position");

            System.out.print("Enter the choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    break loop;
                case 1:
                    delBeg();
                    break;
                case 2:
                    delEnd();
                    break;
                case 3:
                    System.out.print("Enter Index to Delete: ");
                    delAny(sc.nextInt());
                    break;
               

                default:
                    System.out.println("Wrong choice");
            }

        }
    }
}


class NodeDouble{
    int regd_no;
    float mark;
    NodeDouble next;
    NodeDouble prev;
}