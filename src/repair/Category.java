package repair;


public class Category {

    private int cat_id;
    private String category_name;

    public Category(int cat_id, String category_name) {
        this.cat_id = cat_id;
        this.category_name = category_name;
    }

    public int getCatId() {
        return cat_id;
    }

    public String getCatName() {
        return category_name;
    }

    public String toString() {
        return category_name;
    }

    public Object[] toArray() {
        return new Object[]{
            getCatId(),
            getCatName()
        };
    }
    
     @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Category category = (Category) obj;
        return cat_id == category.cat_id;
    }
}
