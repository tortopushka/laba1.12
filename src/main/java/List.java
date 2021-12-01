/**
 * This class allows you to work with data by structuring it into a unidirectional list
 * @param <T> type of val stored in the list
 */

public class List<T> {
    /**
     * The pointer to the beginning of the list field
     */
    private ListElem head;
    /**
     * The pointer to the end of the list field
     */
    private ListElem tail;
    /**
     * The field that stores size of the list
     */
    private int size;

    /**
     * Inner class describing list element
     */
    public class ListElem<T> {
        /**
         * Element value field
         */
        private T data;
        /**
         * The pointer to the next item of the list field
         */
        private ListElem next;
        /**
         * constructor with data
         *
         * @param dataElem data added to head type T
         */
        ListElem(T dataElem) {
            data = dataElem;
            next = null;
        }
    }
    /**
     * default constructor
     */
    public List(){
        head=null;
        tail=head;
        size=0;
    }
    /**
     * check for emptiness
     * @return 1 if empty
     * 0 is not empty
     */
    boolean isEmpty(){
        return(head==null);
    }
    /**
     * get size of list
     * @return size
     */
    int getSize(){
        return size;
    }
    /**
     * add element to List
     * @param elem element type T
     */
    void add(T elem){
        ListElem temp=new ListElem(elem);
        if(tail==null){
            head=temp;
            tail=temp;
        }else{
            tail.next=temp;
            tail=temp;
        }
        size++;
    }
    /**
     * delete element
     * @param index position of deleted element type int
     * @throws Exception when unavailable position
     */
    void delete(int index)throws Exception{
       if(index<0 || index>=size||size==0){
            throw new Exception("Exception! Delete an element with an unavailable position!");
        }
        else
        {
            if (index == 0)
                deleteFromHead();
            else
                deleteFromPosition(index);
        }
    }
    /**
     * delete element from head of list
     */
    private void deleteFromHead(){
        ListElem temp=head;
        if (tail==head){
            tail=null;
        }
        head=head.next;
        temp=null;
        size--;
    }
    /**
     * delete element from position
     * @param pos index of deleted element type int
     */
    private void deleteFromPosition(int pos){
        ListElem temp=head;
        int index=0;
        while (index<size && index!=pos-1){
            index++;
            temp=temp.next;
        }
        ListElem p=temp.next;
        temp.next=p.next;
        p=null;
        size--;
    }
    /**
     * convert list to string
     * @return  string
     */
    @Override
    public String toString() {
        String s = "";
        ListElem p = head;
        while (p != null) {
            if (p.next != null) {
                s += p.data + "->";
            } else {
                s += p.data;
            }
            p = p.next;
        }
        return s;
    }
}
