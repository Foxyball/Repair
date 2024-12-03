package repair;

public class Order {

    private int repair_id;
    private int user_id;
    private int product_id;
    private int shelf_id;
    private String fault_desc;
    private String work_carried_out_desc;
    private String created_at;
    private String status;
    private int is_warranty;
    private int warranty_denied;
    private double labor_cost;
    private double parts_cost;
    private double total_price;

    private String user_name;
    private String product_name;
    private String shelf_name;
    private String category_name;
    private String brand_name;

    public Order(int repair_id, int user_id, int product_id, int shelf_id, String fault_desc, String work_carried_out_desc, String created_at, String status, int is_warranty, int warranty_denied, double labor_cost, double parts_cost, double total_price, String user_name, String product_name, String shelf_name, String category_name, String brand_name) {
        this.repair_id = repair_id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.shelf_id = shelf_id;
        this.fault_desc = fault_desc;
        this.work_carried_out_desc = work_carried_out_desc;
        this.created_at = created_at;
        this.status = status;
        this.is_warranty = is_warranty;
        this.warranty_denied = warranty_denied;
        this.labor_cost = labor_cost;
        this.parts_cost = parts_cost;
        this.total_price = total_price;

        this.user_name = user_name;
        this.product_name = product_name;
        this.shelf_name = shelf_name;
        this.category_name = category_name;
        this.brand_name = brand_name;
    }

    public String getUserName() {
        return user_name;
    }

    public String getProductName() {
        return product_name;
    }

    public String getShelfName() {
        return shelf_name;
    }

    public String getCategoryName() {
        return category_name;
    }

    public String getBrandName() {
        return brand_name;
    }

    public int getRepairId() {
        return repair_id;
    }

    public int getUserId() {
        return user_id;
    }

    public int getProductId() {
        return product_id;
    }

    public int getShelfId() {
        return shelf_id;
    }


    public String getFaultDesc() {
        return fault_desc;
    }

    public String getWorkCarriedOutDesc() {
        return work_carried_out_desc;
    }

    public String getCreatedAt() {
        return created_at;
    }


    public String getStatus() {
        return status;
    }

    public int getIsWarranty() {
        return is_warranty;
    }

    public int getWarrantyDenied() {
        return warranty_denied;
    }

    public double getLaborCost() {
        return labor_cost;
    }

    public double getPartsCost() {
        return parts_cost;
    }

    public double getTotalPrice() {
        return total_price;
    }

    public void calculateTotalPrice() {
        if (is_warranty == 1 && warranty_denied == 0) {
            this.total_price = 0;
        } else {
            this.total_price = this.labor_cost + this.parts_cost;
        }
    }

    @Override
    public String toString() {
        return "Order{"
                + "repair_id=" + repair_id
                + ", user_id=" + user_id
                + ", product_id=" + product_id
                + ", shelf_id=" + shelf_id
                + ", fault_desc='" + fault_desc + '\''
                + ", work_carried_out_desc='" + work_carried_out_desc + '\''
                + ", created_at='" + created_at + '\''
                + ", status='" + status + '\''
                + ", is_warranty=" + is_warranty
                + ", warranty_denied=" + warranty_denied
                + ", labor_cost=" + labor_cost
                + ", parts_cost=" + parts_cost
                + ", total_price=" + total_price
                + ", user_name='" + user_name + '\''
                + ", product_name='" + product_name + '\''
                + ", shelf_name='" + shelf_name + '\''
                + ", category_name='" + category_name + '\''
                + ", brand_name='" + brand_name + '\''
                + '}';
    }

    public Object[] toArray() {
        return new Object[]{
                getRepairId(),
                getUserName(),
                getProductName(),
                getShelfName(),
                getCategoryName(),
                getBrandName(),
                getFaultDesc(),
                getWorkCarriedOutDesc(),
                getCreatedAt(),
                getStatus(),
                getIsWarranty(),
                getWarrantyDenied(),
                getLaborCost(),
                getPartsCost(),
                getTotalPrice()
        };
    }
}
