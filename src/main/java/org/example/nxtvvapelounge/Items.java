package org.example.nxtvvapelounge;

public class Items {
    private String ItemID;
    private String ItemBrand;
    private String ItemName;
    private String Categories;
    private String Description;
    private String SRP;
    private String ClearancePrice;
    private String Quantity;

    public Items(String itemID, String itemBrand, String itemName, String categories, String description, String SRP, String clearancePrice, String quantity) {
        ItemID = itemID;
        ItemBrand = itemBrand;
        ItemName = itemName;
        Categories = categories;
        Description = description;
        this.SRP = SRP;
        ClearancePrice = clearancePrice;
        Quantity = quantity;
    }
}
