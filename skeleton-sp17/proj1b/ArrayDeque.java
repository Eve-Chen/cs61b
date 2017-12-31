public class ArrayDeque<Item> implements Deque<Item> {

    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int space;

    //create an empty list
    public ArrayDeque(){
        space =8;
        items=(Item[]) new Object[space];
        size=0;
        nextFirst= space /2;
        nextLast= space /2+1;
    }

    @Override
    public void addFirst(Item i){
        items[nextFirst]=i;
        size++;
        if(nextLast==0){
            nextFirst= space-1;
        }
        else{
            nextFirst--;
        }
    }

    @Override
    public void addLast(Item i){
        items[nextLast]=i;
        size++;
        if (nextLast== space -1){
            nextLast=0;
        }
        else{
            nextLast++;
        }
    }

    @Override
    public boolean isEmpty(){
        if (size==0){
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        if (nextFirst>space/2||nextLast<space/2+1){
            for (int index=nextFirst+1;index<space;index++){
                System.out.print(items[index]+" ");
            }
            for (int index=0;index<nextLast;index++){
                System.out.print(items[index]+" ");
            }
        }
        else{
            for (int index=nextFirst+1;index<nextLast;index++){
                System.out.print(items[index]+" ");
            }
        }
        System.out.println();
    }

    @Override
    public Item removeFirst(){
        Item i= items[nextFirst+1];
        items[nextFirst+1]=null;
        size--;
        return i;

    }

    @Override
    public Item removeLast(){
        Item i=items[nextLast-1];
        items[nextLast-1]=null;
        size--;
        return i;

    }

    @Override
    public Item get(int index){
        return items[space/2+index];
    }
}
