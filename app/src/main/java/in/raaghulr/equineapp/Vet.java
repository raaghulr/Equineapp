package in.raaghulr.equineapp;

public class Vet {

   private String Id;
    private String Name;
    private String CompanyName;
    private String MobileNumber;
    private String LandlineNumber;
    private String Email;
    private String BankDetails;

    public Vet(){}

    public Vet(String id, String name, String companyName, String mobileNumber, String landlineNumber, String email, String bankDetails) {
        Id = id;
        Name = name;
        CompanyName = companyName;
        MobileNumber = mobileNumber;
        LandlineNumber = landlineNumber;
        Email = email;
        BankDetails = bankDetails;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public String getLandlineNumber() {
        return LandlineNumber;
    }

    public String getEmail() {
        return Email;
    }

    public String getBankDetails() {
        return BankDetails;
    }
}
