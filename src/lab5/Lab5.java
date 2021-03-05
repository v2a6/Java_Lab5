package Lab5;
public class Lab5<E> {
    private Node<E> head = null ;
    private Node<E> tail = null ;
    private int size = 0;
    
    private boolean isEmpty()
    {
        return size==0;
    }
    public int returnSize()
    {
        return size;
    }
    public E first()
    {
        if (isEmpty()) return null ;
        return head.getElement();
    }
    public E Last()
    {
        if (isEmpty()) return null ;
        return tail.getElement();
    }
    public void addFirst(E element)
    {
        head = new Node<E>(element,head);
        if(size==0)
        tail=head;
        size++;
    }
    public void addLast(E element)
    {
        Node<E> newest = new Node<E>(element,null);
        if(isEmpty())
            head=newest;
        else
            tail.setNext(newest);
        tail=newest;
        size++;
    }
    public E RemoveFirst()
    {
        if(isEmpty())
            return null ;
        E deleted = head.getElement();
        head = head.getNext();
        size--;
        if(size==0)
            tail= null ;
        return deleted ;
    }
    public Node<E> returnHead()
    {
        return head ;
    }
    public String Print()
    {
        Node<E> h = head ;
        String all ="  ";
        while (h!=null)
        {
            all = all+h.getElement().toString()+"   ";
            h=h.getNext();
        }
        return all ;
    }
    public E SecondtoLast_s1()
    {
        Node<E> n = head ;
        while (n.getNext()!=tail)
        {
            n=n.getNext();
        }
        return (E) n.getElement();
    }
    public int Size_s2()
    {
    Node<E> elem = head ;
    int Size = 0 ;
    if(head==null)
        return Size ;
    else
     {
      Size++ ;
      while(elem.next!=null)
    {
      Size++;
      elem =elem.next ;
    }}
        return Size ;
    }
    public void Rotate_s3() {
    if(head!= null) {
     Node ro = head;
    while (ro.getNext()!= null) {
    tail = ro;
    ro = ro.getNext();}
    if (tail != null) {
    tail.setNext(null);
    ro.setNext(head);
    head = ro;
        }
      }
    }
    public Node<E> concatenating_s4(Node<E> head_l , Node<E> head_m)
    {
        Node<E> con = null ;
        if(head_l==null)
            return  head_m;
        if(head_m==null)
            return  head_l;
        con=head_l.getNext();
        while (con.getNext()!=null)
            con=con.next;
        con.next=head_m.getNext() ;
        return head_l ;
    }
    public Node<E> Reversing_s5()
    {
        if (head==null)
        {
            return head;
        }
        Node<E> cur = head ;
        Node<E> p = null ;
        Node<E> next = cur.next ;


        while (cur!=null)
        {
            next = cur.next ;
            cur.next=p ;
            p = cur ;
            cur= next ;
        }

        head = p ;
        return p ;
    }
    public class Node<E> extends Lab5<E> {
        private E Element ;
        private Node<E>next ;

        public Node(E Element , Node<E> next)
        {
            this.Element=Element;
            this.next=next;
        }

        public E getElement() {
            return Element;
        }

        public void setElement(E element) {
            Element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
    
      public static void main(String[] args) {
        Lab5<Integer> list =new Lab5<>();
        list.addLast(11);
        list.addLast(12);
        list.addLast(13);
        System.out.println(list.Print());
       //First solution  //System.out.println(list.SecondtoLast_s1());
      //second solution  //System.out.println(list.Size_s2());
     //Third solution  //list.Rotate_s3();
    //Fourth solution list.concatenating_s4(list.returnHead(),list.returnHead());
   //Fifth solution list.Reversing_s5();
    }
}