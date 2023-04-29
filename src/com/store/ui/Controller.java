package com.store.ui;

import com.store.util.Tools;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javax.xml.bind.annotation.XmlElementDecl;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * main page
 */
public class Controller implements Initializable {

    /**
     * The Btn browse items.
     */
    @FXML
    private Button btn_browse_items;
    /**
     * The Btn enter order.
     */
    @FXML
    private Button btn_enter_order;
    /**
     * The Btn display random.
     */
    @FXML
    private Button btn_display_random;
    /**
     * The Btn stock report.
     */
    @FXML
    private Button  btn_stock_report;
    /**
     * The Btn quarterly report.
     */
    @FXML
    private Button btn_quarterly_report;
    /**
     * The Btn customer report.
     */
    @FXML
    private Button   btn_customer_report;
    /**
     * The Btn monthly report.
     */
    @FXML
    private Button  btn_monthly_report;

    /**
     * The Ui sample.
     */
    @FXML
    private Pane ui_sample;

    /**
     * Click.
     *
     * @param actionEvent the action event
     * @param fxml_name   the fxml name
     * @throws Exception the exception
     */
    @FXML
    protected void click(ActionEvent actionEvent, String fxml_name) throws Exception {
        Pane other = FXMLLoader.load(getClass().getResource("/com/store/ui/"+fxml_name));
        ui_sample.getChildren().clear();
        ui_sample.getChildren().setAll(other.getChildren());
    }


    /**
     * Initialize.
     *
     * @param location  the location
     * @param resources the resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ui_sample.setStyle(Tools.defaultStyle);

        btn_browse_items.setOnAction((ActionEvent e) -> {
            try {
                click(e, "browse_items.fxml");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        btn_enter_order.setOnAction((ActionEvent e) -> {
            try {
                click(e, "add_order.fxml");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        btn_display_random.setOnAction((ActionEvent e) -> {
            try {
                click(e, "display_random.fxml");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        btn_stock_report.setOnAction((ActionEvent e) -> {
            try {
                click(e, "stock_report.fxml");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        btn_quarterly_report.setOnAction((ActionEvent e) -> {
            try {
                click(e, "quarterly_report.fxml");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        btn_customer_report.setOnAction((ActionEvent e) -> {
            try {
                click(e, "demographic_report.fxml");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        btn_monthly_report.setOnAction((ActionEvent e) -> {
            try {
                click(e, "top10_report.fxml");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

    }
}
