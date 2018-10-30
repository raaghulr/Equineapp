package in.raaghulr.equineapp;

import com.google.firebase.database.DatabaseReference;

class Horse {
    private String Id;
    private String Breed;
    private String Distingiushingmarks;
    private String Type;
    private String Age;
    private String Microchipnumber;
    private String Height;
    private String Weight;

    public Horse(){}

    public Horse(String id,String breed, String distingiushingmarks, String type, String age, String microchipnumber, String height, String weight) {
        Id= id;
        Breed = breed;
        Distingiushingmarks = distingiushingmarks;
        Type = type;
        Age = age;
        Microchipnumber = microchipnumber;
        Height = height;
        Weight = weight;
    }

    public String getId() {
        return Id;
    }

    public String getBreed() {
        return Breed;
    }

    public String getDistingiushingmarks() {
        return Distingiushingmarks;
    }

    public String getType() {
        return Type;
    }

    public String getAge() {
        return Age;
    }

    public String getMicrochipnumber() {
        return Microchipnumber;
    }

    public String getHeight() {
        return Height;
    }

    public String getWeight() {
        return Weight;
    }
}
