package com.store.ui;

import com.store.dao.CustomerDao;
import com.store.entity.Customer;
import com.store.util.Tools;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * generate customer demographic report as required
 */
public class DemographicReport implements Initializable {
    /**
     * The Ui demographic.
     */
    @FXML
    private Pane ui_demographic;

    /**
     * The Table demographic.
     */
    @FXML
    private TableView table_demographic;

    /**
     * Click return menu.
     *
     * @param actionEvent the action event
     * @throws Exception the exception
     */
    @FXML
    protected void click_return_menu(MouseEvent actionEvent) throws Exception {
        Pane other = FXMLLoader.load(getClass().getResource("/com/store/ui/sample.fxml"));
        ((Button) actionEvent.getSource()).getScene().setRoot(other);
    }

    /**
     * Initialize.
     *
     * @param location  the location
     * @param resources the resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ui_demographic.setStyle(Tools.defaultStyle);

        ObservableList observableList = table_demographic.getColumns();
        table_demographic.setEditable(true);

        TableColumn customer_id = new TableColumn("customer_id");
        customer_id.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        TableColumn name = new TableColumn("name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn address = new TableColumn("address");
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        TableColumn email = new TableColumn("email");
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn order_id = new TableColumn("order_id");
        order_id.setCellValueFactory(new PropertyValueFactory<>("order_id"));


        observableList.add(customer_id);
        observableList.add(name);
        observableList.add(address);
        observableList.add(email);
        observableList.add(order_id);



        List<Customer> list = CustomerDao.findCustomer(null,null);
        ObservableList<Customer> obList = FXCollections.observableArrayList(list);

        for(Customer customers: obList){
            table_demographic.getItems().add(customers);
            System.out.println(customers);
        }

    }
}
