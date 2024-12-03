package repair;

/**
 *
 * @author thefo
 */
public class Shelf {

    private int shelf_id;
    private String shelf_name;
    private int max_capacity;
    private int current_load;

    public Shelf(int shelf_id, String shelf_name, int max_capacity, int current_load) {
        this.shelf_id = shelf_id;
        this.shelf_name = shelf_name;
        this.max_capacity=max_capacity;
        this.current_load=current_load;
    }

    public int getShelfId() {
        return shelf_id;
    }

    public String getShelfName() {
        return shelf_name;
    }
    
    public int getShelfMaxCapacity(){
        return max_capacity;
    }
    
    public int getShelfCurrentLoad(){
        return current_load;
    }

    public String toString() {
        return shelf_name;
    }

    public Object[] toArray() {
        return new Object[]{
            getShelfId(),
            getShelfName(),
            getShelfMaxCapacity(),
            getShelfCurrentLoad()
        };
    }
    
    
     @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Shelf shelf = (Shelf) obj;
        return shelf_id == shelf.shelf_id;
    }
}
