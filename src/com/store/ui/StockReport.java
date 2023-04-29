package com.store.ui;

import com.store.dao.GoodsDao;

import com.store.entity.Goods;
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
import java.util.List;
import java.util.ResourceBundle;

/**
 * generate the stocktake report as required
 */
public class StockReport implements Initializable {
    /**
     * The Ui stock.
     */
    @FXML
    private Pane ui_stock;

    /**
     * The Table stock.
     */
    @FXML
    private TableView table_stock;

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

        ui_stock.setStyle(Tools.defaultStyle);

        ObservableList observableList = table_stock.getColumns();
        table_stock.setEditable(true);

//goods_id, description, stock
        TableColumn goods_id = new TableColumn("goods_id");
        goods_id.setCellValueFactory(new PropertyValueFactory<>("goods_id"));
        TableColumn description = new TableColumn("description");
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        TableColumn stock = new TableColumn("stock");
        stock.setCellValueFactory(new PropertyValueFactory<>("stock"));


        observableList.add(goods_id);
        observableList.add(description);
        observableList.add(stock);



        List<Goods> list = GoodsDao.findGoods(null,null);
        ObservableList<Goods> obList = FXCollections.observableArrayList(list);

        for(Goods goods: obList){
            table_stock.getItems().add(goods);
            System.out.println(goods);
        }

    }
}
