package repair;

public class Machine {

    private int product_id;
    private String product_name;
    private int category_id;
    private int brand_id;

    private String category_name;
    private String brand_name;

    private double price;
    private int qty;

    public Machine(int product_id, String product_name, int category_id,String category_name, int brand_id, String brand_name, double price, int qty) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.category_id = category_id;
         this.category_name = category_name;
        this.brand_id = brand_id;
        this.brand_name=brand_name;
        this.price = price;
        this.qty = qty;
    }

    public int getMachineId() {
        return product_id;
    }

    public String getMachineName() {
        return product_name;
    }

    public int getMachineCategory() {
        return category_id;
    }

    public String getMachineCategoryName() {
        return category_name;
    }

    public int getMachineBrand() {
        return brand_id;
    }

    public String getMachineBrandName() {
        return brand_name;
    }

    public double getMachinePrice() {
        return price;
    }

    public int getMachineQty() {
        return qty;
    }

    public String toString() {
        return product_name;
    }

    public Object[] toArray() {
        return new Object[]{
            getMachineId(),
            getMachineName(),
            getMachineCategoryName(),
            getMachineBrandName(),
            getMachinePrice(),
            getMachineQty()
        };
    }
}
