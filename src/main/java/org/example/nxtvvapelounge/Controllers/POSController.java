package org.example.nxtvvapelounge.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.example.nxtvvapelounge.AddToCartItems;
import org.example.nxtvvapelounge.Items;
import org.example.nxtvvapelounge.NXTVMain;
import org.example.nxtvvapelounge.sceneSwitch;


public class POSController implements Initializable {
    @FXML private TextField searchBar;
    @FXML private Button searchBtn;
    @FXML private Button checkoutBTn;


    @FXML private TableColumn<Items, String> CategoriesCol;
    @FXML private TableColumn<Items, String> ClearancePriceCol;
    @FXML private TableColumn<Items, String> DescriptionCol;
    @FXML private TableColumn<Items, String> ItemBrandCol;
    @FXML private TableColumn<Items, String> ItemIDCol;
    @FXML private TableColumn<Items, String> ItemNameCol;
    @FXML private TableColumn<Items, String> QuantityCol;
    @FXML private TableColumn<Items, String> SRPCol;
    @FXML private TableView<Items> SearchItemTV;



    public static List<AddToCartItems> listOfItems;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            PreparedStatement loadItem = NXTVMain.local.getConnection()
                    .prepareStatement(
                            "SELECT ItemID, ItemBrand, ItemName, Categories, "
                                    + "DescriptionAndValues, SuggestedRetailPrice, ClearancePrice, Quantity "
                                    + "FROM Retail_Inventory_ALL "
                                    + "WHERE BranchID = ?");

            loadItem.setString(1, NXTVMain.branchID);

            ResultSet type = loadItem.executeQuery();
            FXMLLoader itemLoader = new FXMLLoader(getClass().getResource("/GUIfxml/ItemNode.fxml"));
            while (type.next()) {

                System.out.println("\nItemID: " + type.getString("ItemID"));
                System.out.println("ItemBrand: " + type.getString("ItemBrand"));
                System.out.println("ItemName: " + type.getString("ItemName"));
                System.out.println("SuggestedRetailPrice: " + type.getString("SuggestedRetailPrice"));
                System.out.println("Quantity: " + type.getString("Quantity"));
                System.out.println("Description: " + type.getString("DescriptionAndValues"));
                System.out.println("Categories: " + type.getString("Categories"));

                ItemIDCol.setCellValueFactory(new PropertyValueFactory<Items, String>("ItemID"));
                ItemBrandCol.setCellValueFactory(new PropertyValueFactory<Items, String>("ItemBrand"));
                ItemNameCol.setCellValueFactory(new PropertyValueFactory<Items, String>("ItemName"));
                CategoriesCol.setCellValueFactory(new PropertyValueFactory<Items, String>("Categories"));
                DescriptionCol.setCellValueFactory(new PropertyValueFactory<Items, String>("Description"));
                SRPCol.setCellValueFactory(new PropertyValueFactory<Items, String>("SRP"));
                ClearancePriceCol.setCellValueFactory(new PropertyValueFactory<Items, String>("ClearancePrice"));
                QuantityCol.setCellValueFactory(new PropertyValueFactory<Items, String>("Quantity"));


            } //end of type.next
        }

        catch (Exception e){
            e.printStackTrace();
    }
    }


@FXML
    private void onButtonAction(ActionEvent e) throws IOException {
    if (e.getSource() == searchBtn) {
        System.out.println("SEARCH!");
    } else if (e.getSource() == checkoutBTn) {
        System.out.println("CHECKOUT CLICKED");

        add(); //finalized


    }
}

    public static void add(){
        listOfItems = new ArrayList<>(ItemController.clickedItems); //kinukuha lang ung list sa itemController
        // ItemController.clickedItems.clear();

        for(int i =0; i < listOfItems.size(); i++){
            System.out.print(listOfItems.get(i) + "\n");
        }

    }


}


//scrollable receipt
//scrollable items


//summary = after ng cheeckout btn
//membership 1st
//discount sa cashier 2nd