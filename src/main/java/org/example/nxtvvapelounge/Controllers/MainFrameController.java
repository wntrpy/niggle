package org.example.nxtvvapelounge.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.example.nxtvvapelounge.DBImageHandler;
import org.example.nxtvvapelounge.NXTVMain;
import org.example.nxtvvapelounge.sceneSwitch;
import java.io.IOException;



public class MainFrameController{
    @FXML private BorderPane borderPane;
    @FXML private Button dashboardBtn;
    @FXML private AnchorPane detailsCard;
    @FXML private Button employeesBtn;
    @FXML private Button imgBtn;
    @FXML private ImageView imgPic; //para sa image sa mainframe
    @FXML private Button inventoryBtn;
    @FXML private Button membersBtn;
    @FXML private Button posBtn;
    @FXML private Button pricesBtn;
    @FXML private Button reportsBtn;
    @FXML private Button settingsBtn;
    @FXML private Button syncBtn;
    @FXML private Button changePassBtn;
    @FXML private Button logoutBtn;
    @FXML private VBox centerPart; //center part ng border pane

    @FXML private ImageView cardUserPic; //pic ng user sa deets card

    //para sa detailsCard
    @FXML private Label userName;
    @FXML private Label fullNameLbl;
    @FXML private Label userTypeLbl;

    private boolean cardVisible = true;

    @FXML
    private void handleButtonAction(ActionEvent e) throws Exception{
        if (e.getSource() == imgBtn) {

            System.out.println("Visibility: " + cardVisible);
            cardVisible = !cardVisible;
            detailsCard.setVisible(cardVisible);
            detailsCard.toFront();
            //detailsCard.

            if (!borderPane.getChildren().contains(detailsCard)) {
                borderPane.getChildren().add(detailsCard);
            }

        }
        else if(e.getSource()  == changePassBtn){  //load lang change pass fxml
            System.out.println("CHANGE PASS HERE");
            sceneSwitch sw = new sceneSwitch();
            sw.setFxmlFile("/org/example/nxtvvapelounge/fxml/ChangePassword.fxml");
            sw.switchScenes();
        }
        else if(e.getSource()  == logoutBtn){ //balik sa logout
            sceneSwitch sw = new sceneSwitch();
            sw.setFxmlFile("/org/example/nxtvvapelounge/fxml/LoginPage.fxml");
            sw.switchScenes();
        }

    }


    @FXML //ito naman pag cinlick yung btnDashboard saka palang to tatawagin kaya iba to sa isang same method
    void btnDashboard(ActionEvent event) throws IOException {
        setCenterScenes("/org/example/nxtvvapelounge/fxml/Dashboard.fxml");
        System.out.println("Dashboard");
    }

    @FXML //ito yung unang niloload as in default
    void btnDashboardDefault(ActionEvent event) throws IOException {
        setCenterScenes("/org/example/nxtvvapelounge/fxml/Dashboard.fxml");

        DBImageHandler.setUserPhoto(NXTVMain.localLog.getUserID(), "D:\\javaFXProjects\\NXTVVapeLounge\\src\\main\\resources\\org\\example\\nxtvvapelounge\\images\\hanni.png");

        try { //try catch in case na magkaproblem sa pagseset ng data sa labels
            System.out.println(NXTVMain.localLog.getFirstName());
            System.out.println(NXTVMain.localLog.getFirstName() + " " + NXTVMain.localLog.getMiddleName().charAt(0) + ". " + NXTVMain.localLog.getLastName());
            System.out.println(NXTVMain.localLog.getUserType());

            userName.setText(NXTVMain.localLog.getFirstName());
            fullNameLbl.setWrapText(true);
            fullNameLbl.setText(NXTVMain.localLog.getFirstName() + " " + NXTVMain.localLog.getMiddleName().charAt(0) + ". " + NXTVMain.localLog.getLastName());
            userTypeLbl.setText(NXTVMain.localLog.getUserType());
            imgPic.setImage(DBImageHandler.getUserPhoto(NXTVMain.localLog.getUserID()));
            cardUserPic.setImage(DBImageHandler.getUserPhoto(NXTVMain.localLog.getUserID()));

            dashboardBtn.getStyleClass().add("bold-button");
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    //TODO: ipasok mo nalang sa initialize method to lahat!




    @FXML
    void btnPOS(ActionEvent event) throws IOException {
        System.out.println("POS");
        setCenterScenes("/org/example/nxtvvapelounge/fxml/POS.fxml");
    }

    @FXML
    void btnReport(ActionEvent event) throws IOException{
        setCenterScenes("/org/example/nxtvvapelounge/fxml/Reports.fxml");
    }

    public void setCenterScenes(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent centerContent = loader.load();
            borderPane.setCenter(centerContent);
            detailsCard.toFront();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}//end of class
//TODO: pano ung sa summary, need ma load un sa center ng border pane hahaha
