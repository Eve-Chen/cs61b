public class LinkedListDeque<Item> {

    private class StuffNode{
        public StuffNode prev;
        public Item item;
        public StuffNode next;

        public StuffNode(StuffNode p, Item i, StuffNode n){
            prev=p;
            item=i;
            next=n;
        }
    }

    private StuffNode sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel=new StuffNode(null,null,null);
        sentinel.prev=sentinel;
        sentinel.next=sentinel;
        size=0;
    }

    //passed
    public void addFirst(Item i){
        sentinel.next=new StuffNode(sentinel,i,sentinel.next);
        size++;
    }

    public void addLast(Item i){
        size++;
        sentinel.prev.next=new StuffNode(sentinel.prev,i,sentinel);
    }

    public boolean isEmpty(){
        if (size==0){
            return true;
        }
        else{
            return false;
        }

    }

    public int size(){
        return size;

    }

    public void printDeque(){
        StuffNode p=sentinel;
        while (p.next!=sentinel){
            System.out.print(p.next.item);
            p=p.next;
        }

    }

    public Item removeFirst(){
        sentinel.next=sentinel.next.next;
        size--;
        return sentinel.next.item;
    }

    public Item removeLast(){
        StuffNode x = sentinel.prev;
        sentinel.prev=sentinel.prev.prev;
        size--;
        return x.item;
    }

    public Item get(int index){
        if (index>=size){
            return null;
        }
        int i=0;
        StuffNode p=sentinel.next;
        while(i!=index){
            p=p.next;
            i++;
        }
        return p.item;
    }


    public Item getRecursive(int index){
        if (index>=size){
            return null;
        }
        int i=0;
        StuffNode p=sentinel.next;
        if (i==index){
            return p.item;
        }
        else{
            p=p.next;
            index--;
            return getRecursive(index);
        }

    }





}
