class Organization implements Cloneable {
    private int organizationCode;
    private String organizationName;
    private String organizationAddress;

    public Organization(int code, String name, String address) {
        this.organizationCode = code;
        this.organizationName = name;
        this.organizationAddress = address;
    }


    public int getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(int organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }

    
    public void printDetails() {
        System.out.println("Organization Code: " + organizationCode);
        System.out.println("Organization Name: " + organizationName);
        System.out.println("Organization Addr: " + organizationAddress);
    }

    
    @Override
    public Organization clone() {
        try {
            return (Organization) super.clone();
        } catch (CloneNotSupportedException e) {
            // This should never happen since Organization implements Cloneable
            throw new AssertionError();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Organization org1 = new Organization(1, "ABC Corp", "123 Main");
        Organization org2 = org1.clone(); 

    
        System.out.println("Original Organization:");
        org1.printDetails();
        System.out.println("\nCloned Organization:");
        org2.printDetails();

        org2.setOrganizationName("XYZ Corp");
        org2.setOrganizationAddress("123 D no");

        
        System.out.println("\nDetails after modifying cloned Organization (org2):");
        System.out.println("Original Organization:");
        org1.printDetails();
        System.out.println("\nCloned Organization:");
        org2.printDetails();
    }
}
