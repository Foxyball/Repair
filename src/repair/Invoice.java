package repair;

public class Invoice {

    private int invoice_id;
    private int repair_id;
    private int user_id;
    private double total;
    private String payment_status;
    private String created_at;

    private String user_name;
    private String product_name;

    public Invoice(int invoice_id, int repair_id, int user_id, double total, String payment_status, String created_at) {
        this.invoice_id = invoice_id;
        this.repair_id = repair_id;
        this.user_id = user_id;
        this.total = total;
        this.payment_status = payment_status;
        this.created_at = created_at;
    }

    // Конструктор 2
    public Invoice(int invoice_id, int repair_id, int user_id, double total, String payment_status, String created_at, String user_name, String product_name) {
        this.invoice_id = invoice_id;
        this.repair_id = repair_id;
        this.user_id = user_id;
        this.total = total;
        this.payment_status = payment_status;
        this.created_at = created_at;

        this.user_name = user_name;
        this.product_name = product_name;
    }

    public String getInvoiceUser() {
        return user_name;
    }

    public String getInvoiceMachine() {
        return product_name;
    }

    public int getInvoiceId() {
        return invoice_id;
    }

    public int getRepairId() {
        return repair_id;
    }

    public int getUserId() {
        return user_id;
    }

    public double getTotal() {
        return total;
    }

    public String getPaymentStatus() {
        return payment_status;
    }

    public String getDate() {
        return created_at;
    }

    public Object[] toArray() {
        return new Object[]{
            getInvoiceId(),
            getInvoiceUser(),
            getInvoiceMachine(),
            getPaymentStatus(),
            getTotal(),
        };
    }
}
