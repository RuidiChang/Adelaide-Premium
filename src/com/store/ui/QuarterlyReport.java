package com.store.ui;

import com.store.dao.OrderDao;
import com.store.entity.Order;
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

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * generate the quarterly sales report as required
 */
public class QuarterlyReport implements Initializable {
    /**
     * The Ui quarterly.
     */
    @FXML
    private Pane ui_quarterly;

    /**
     * The Table quarterly.
     */
    @FXML
    private TableView table_quarterly;

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
    public void initialize(URL location, ResourceBundle resources){

        ui_quarterly.setStyle(Tools.defaultStyle);

        ObservableList observableList = table_quarterly.getColumns();
        table_quarterly.setEditable(true);

//order_id，date，goods_id, total_price, payment_id, CSR_id, status
        TableColumn order_id = new TableColumn("order_id");
        order_id.setCellValueFactory(new PropertyValueFactory<>("order_id"));
        TableColumn date = new TableColumn("date");
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        TableColumn record_id = new TableColumn("record_id");
        record_id.setCellValueFactory(new PropertyValueFactory<>("catalog_id"));
        TableColumn total_price = new TableColumn("total_price");
        total_price.setCellValueFactory(new PropertyValueFactory<>("total_price"));
        TableColumn payment_id = new TableColumn("payment_id");
        payment_id.setCellValueFactory(new PropertyValueFactory<>("payment_id"));
        TableColumn CSR_id = new TableColumn("CSR_id");
        CSR_id.setCellValueFactory(new PropertyValueFactory<>("CSR_id"));
        TableColumn status = new TableColumn("status");
        status.setCellValueFactory(new PropertyValueFactory<>("status"));



        observableList.add(order_id);
        observableList.add(date);
        observableList.add(record_id);
        observableList.add(total_price);
        observableList.add(payment_id);
        observableList.add(CSR_id);
        observableList.add(status);




        List<Order> list = OrderDao.findOrder(null,null,null,null);
        ObservableList<Order> obList = FXCollections.observableArrayList(list);
        LocalDate now = LocalDate.now().minus(3, ChronoUnit.MONTHS);//last 3 months
        Date date1 = Date.from(now.atStartOfDay(ZoneOffset.ofHours(8)).toInstant());
        for(Order orders: obList){
            if(orders.getDate().compareTo(date1) > 0){
                table_quarterly.getItems().add(orders);
                System.out.println(orders);
            }
        }

    }
}
