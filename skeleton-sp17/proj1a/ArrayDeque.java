public class ArrayDeque<Item> {

    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int space;

    //create an empty list
    @SuppressWarnings("unchecked")
    public ArrayDeque(){
        space =8;
        items=(Item[]) new Object[space];
        size=0;
        nextFirst= space /2;
        nextLast= space /2+1;
    }

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

    public Item removeFirst(){
        Item i= items[nextFirst+1];
        items[nextFirst+1]=null;
        size--;
        return i;

    }
    public Item removeLast(){
        Item i=items[nextLast-1];
        items[nextLast-1]=null;
        size--;
        return i;

    }
    public Item get(int index){
        return items[space/2+index];
    }
}
