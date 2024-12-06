package repair;

/**
 *
 * @author thefo
 */
public class Brand {

    private int brand_id;
    private String brand_name;

    public Brand(int brand_id, String brand_name) {
        this.brand_id = brand_id;
        this.brand_name = brand_name;
    }

    public int getBrandId() {
        return brand_id;
    }

    public String getBrandName() {
        return brand_name;
    }

    @Override
    public String toString() {
        return brand_name;
    }

    public Object[] toArray() {
        return new Object[]{
            getBrandId(),
            getBrandName()
        };
    }


    // референция от пхп
// <select name="brand_id">
// @foreach($brands as $brand)
// <option {{($brand->brand_id == $repairOrder->brand_id) ? 'selected' : '' }} value={{$brand->brand_id}}>{{$brand->name}}</option> 
// @endforeach
    // </select>
    
        //сравнява два обекта, за да провери дали са равни, иначе хвърля изключение 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Brand brand = (Brand) obj;
        return brand_id == brand.brand_id;
    }
}
