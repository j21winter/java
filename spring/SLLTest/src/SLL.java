
public class SLL {
	public Node head;
	
	public SLL () {
		this.head = null;
	}
	
//METHODS
	
//	ADD NEW NODE
	public void add(Integer value) {
		
		Node newNode = new Node(value);
		
		if(head == null) {
			head = newNode;
			
		} else {
			
			Node runner = head;
			
			if(runner.next != null) {
				runner = runner.next;
			}
			
			runner.next = newNode;
		}
	}
	
//	public void add(int value) {
//        Node newNode = new Node(value);
//        if(head == null) {
//            head = newNode;
//        } else {
//            // [3,23,2,4,5]
//            Node runner = head;
//            while(runner.getNext() != null) {
//                runner = runner.getNext();
//            }
//            
//            runner.getNext() = newNode;
//        }
//    }

//	REMOVE HEAD
	public void removeFront() {
		if(head != null) {
			head = head.next;
		}
	}
//	
//	public void remove(){
//        if(head==null){
//            System.out.println("No nodes exist");
//            return;
//        }
//        Node runner = head;
//        // [3,5,15,7]
//        while(runner.getNext().getNext() != null){
//            runner = runner.getNext();
//        }
//        runner.setNext() = null;
//
//    }

// PRINT ALL VALUES
	public void printValues() {
		System.out.println("PRINTING ALL VALUES");
		
		if(head == null) {
			System.out.println("HEAD IS NULL");
			return;
			
		} else {
			
			Node runner = head;
			
			while(runner != null) {
				
				System.out.println(runner.value);
				
				runner = runner.next;
			}
		}
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
//	public void printValues(){
//        if(head==null){
//            System.out.println("No nodes");
//            return;
//        }
//        Node runner = head;
//        while(runner !=null){
//            System.out.println("________");
//            System.out.print("|value: "+runner.value+"|\n"+"|next: " + (runner.next == null?"null":runner.next.value)+"|\n");
//            System.out.println("________\n");
//
//            runner = runner.next;
//        }
//
//    }


//GETTERS AND SETTERS

	
}
