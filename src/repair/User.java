package repair;

public class User {

    public int user_id;
    public String name;
    public String email;
    private String password;
    private String phone;
    private String role;
    private int pkod;
    private String city;
    private String status;
    private String egn;
    private int is_firm;
    private String firm_name;
    private String firm_eik;
    private String firm_mol;
    private String firm_dds;
    private String firm_address;

    // Constructor
    public User(int user_id, String name, String email, String password, String phone, String role,
            int pkod, String city, String status, String egn, int is_firm, String firm_name,
            String firm_eik, String firm_mol, String firm_dds, String firm_address) {

        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.pkod = pkod;
        this.city = city;
        this.status = status;
        this.egn = egn;
        this.is_firm = is_firm;
        this.firm_name = firm_name;
        this.firm_eik = firm_eik;
        this.firm_mol = firm_mol;
        this.firm_dds = firm_dds;
        this.firm_address = firm_address;
    }

    public int getUserId() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getRole() {
        return role;
    }
    
    public int getPKOD(){
        return pkod;
    }

    public String getCity() {
        return city;
    }

    public String getStatus() {
        return status;
    }

    public String getEGN() {
        return egn;
    }
    
    public int getIsFirm() {
        return is_firm;
    }
    
    public String getFirmName() {
        return firm_name;
    }
   
    public String getFirmEIK() {
        return firm_eik;
    }
    
    public String getFirmMOL(){
        return firm_mol;
    }
    
    public String getFirmDDS() {
        return firm_dds;
    }
    
    public String getFirmAddress() {
        return firm_address;
    }
    
    
    @Override
   public String toString() {
        return name;
    }
   
     // функция за връщане свойствата на обекта под формата на масив
    public Object[] toArray() {

        String isFirm;
        if (getIsFirm() == 1) {
            isFirm = "Да";
        } else {
            isFirm = "Не";
        }

        String role;
        if (getRole().equals("admin")) {
            role = "Администратор";
        } else {
            role = "Клиент";
        }

        String status;
        if (getStatus().equals("active")) {
            status = "Активен";
        } else {
            status = "Неактивен";
        }

        return new Object[]{
            getUserId(),
            getName(),
            getEmail(),
            getPhone(),
            getCity(),
            status,
            getEGN(),
            getPKOD(),
            role,
            isFirm,
            getFirmName(),
            getFirmEIK(),
            getFirmMOL(),
            getFirmDDS(),
            getFirmAddress()
        };
    }
}
