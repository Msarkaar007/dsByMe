import java.util.Scanner;

class Node {
    private int data;
    private Node next;
    
    public Node() {
        data = 0;
        next = null;
    }
    
    public Node(int d,Node n) {
        data = d;
        next = n;
    }
    
    public void setData(int d) {
        data = d;
    }
    
    public void setNext(Node n) {
        next = n;
    }
    
    public int getData() {
        return (data);
    }
    
    public Node getNext() {
        return (next);
    }
}

class LinkedList {
    private int size;
    private Node start;
    
    public LinkedList() {
        size = 0;
        start = null;
    }
    
    public void insertAtFirst(int val) {
        Node n;
        // Node.n = new Node();
        n = new Node();
        n.setData(val);
        n.setNext(start);
        start = n;
        size++;
    }
    public void insertAtLast (int val) {
        Node n, t;
        n = new Node();
        n.setData(val);
        t = start;
        if (t == null) {
            start = n;
        } else {
            while (t.getNext() != null) {
                t = t.getNext();
            }
            t.setNext(n);
            size++;
        }
    }
public void insertAtPos(int val,int pos){
    if(pos==1){
        insertAtFirst(val);
    }
    else if(pos==size+1)
    {
        insertAtLast(val);
    }
    else if(pos>1&&pos<=size){
        Node n,t;
        n = new Node(val,null);
        t=start;
        for(int i=1;i<pos-1;i++){
            t=t.getNext();
        }
        n.setNext(t.getNext());
        t.setNext(n);
        size++;
    }
    else{
        System.out.print("Insertion not possible at position" + pos);
    }
}
public boolean isEmpty() {
    if (start == null) {
        return (true);
    } else {
        return (false);
    }
}

    public int getListSize() {
        return (size);
    }

    public void viewList() {
        Node t;
        if (isEmpty()) {
            System.out.println(" " + start.getData());
        }
        else {
            t = start;
            for (int i = 1; i <= size; i++){
                System.out.print(" " + t.getData());
                t = t.getNext();
            }
        }
    }


    public void deleteLast() {
        if (start == null) {
            System.out.print("list is already empty");
        } else if (size == 1) {
            start = null;
            size--;
        } else {
            Node t;
            t = start;
            for (int i = 1; i < size - 1; i++) {
                t = t.getNext();
            }
            t.setNext(null);
            size--;
        }
    }

    public void deleteFirst() {
        if (start == null) {
            System.out.print("list is already empty");
        } else {
            start = start.getNext();
            size--;
        }
    }

    public void deleteAtPos(int pos){
        if(start==null){
            System.out.println("List is  already Empty");
        }
        else if(pos<1||pos>size){
            System.out.println("invalid Postion");
        }
        else if(pos==1)
        {
            deleteFirst();
        }
        else if(pos==size)
        {
            deleteLast();
        }
        else{
            Node t,t1;
            t = start;
            for(int i=1;i<pos-1;i++){
                t=t.getNext();    
            }
            t1=t.getNext();
            t.setNext(t1.getNext());
            size--;
        }
    }

public class test {
    public void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        boolean flag=true;
        while(true)
        {
            System.out.println("01.ADD Item To The List At Start");
            System.out.println("02.ADD Item To The List At Last");
            System.out.println("03.ADD Item To The List At Position");
            System.out.println("04.Delete Item To The List At Start");
            System.out.println("05.Delete Item To The List At Last");
            System.out.println("06.Delete Item To The List At Position");
            System.out.println("07.View List");
            System.out.println("Enter Your Choice");
            int choice = sc.nextInt();
            // LinkedList list = new LinkedList();
            int val,position;
            switch(choice){
                case 1:
                    System.out.println("Enter Position");
                    val = sc.nextInt();
                    list.insertAtFirst(val);
                    break;
                case 2:
                    System.out.println("Enter Position");
                    val = sc.nextInt();
                    list.insertAtLast(val);
                    break;
                case 3:
                    System.out.println("Enter Position");
                    position = sc.nextInt();
                    System.out.println("Enter Value of list item");
                    val = sc.nextInt();
                    list.insertAtPos(val,position);
                    break;
                case 4:
                    list.deleteFirst();
                break;
                case 5:
                    list.deleteLast();
                break;
                case 6:
                    System.out.println("Enter Position");
                    position = sc.nextInt();
                    list.deleteAtPos(position);
                    break;
                case 7:
                    list.viewList();
                    break;
                default:
                    System.out.println("invalid Choice");
            }
        }
    }
}
}