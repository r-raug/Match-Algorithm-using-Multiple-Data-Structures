package QueueNode;

/**
 * This class represents a node that is used in a linked list
 */
public class NodeGeneric <T> {
    private T data;
    private NodeGeneric<T> next;


    /**
     * Sets the data of the node.
     * @param data the data to be set
     */
    public void setData(T data) {
        this.data = data;
    }


    /**
     * Sets the reference to the next node.
     * @param next the next node
     */
    public void setNext(NodeGeneric next) {
        this.next = next;
    }

    /**
     * Retrieves the data stored in the node.
     * @return the data stored in the node
     */
    public T getData() {
        return data;
    }

    /**
     * Retrieves the reference to the next node.
     * @return the reference to the next node
     */
    public NodeGeneric getNext() {
        return next;
    }

    /**
     * Constructs a node with the given data and sets the next node reference to null.
     * @param data the data to be stored in the node
     */
    public NodeGeneric(T data){
        this.data  = data;
        this.next = null;
    }


    /**
     * Returns a string representation of the node.
     * @return a string representation of the node
     */
    public String toString() {
        return "Node{" + "data=" + data +", next=" + next +'}';
    }
}
