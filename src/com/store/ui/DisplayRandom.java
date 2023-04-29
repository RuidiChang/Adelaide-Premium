package com.store.ui;

import com.store.dao.GoodsDao;
import com.store.dao.OrderDao;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * generate a random catalog
 */
public class DisplayRandom implements Initializable {
    /**
     * The Ui catalog.
     */
    @FXML
    private Pane ui_catalog;

    /**
     * The Table catalog.
     */
    @FXML
    private TableView table_catalog;

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

        ui_catalog.setStyle(Tools.defaultStyle);

        ObservableList observableList = table_catalog.getColumns();
        table_catalog.setEditable(true);

        TableColumn goods_id = new TableColumn("goods_id");
        goods_id.setCellValueFactory(new PropertyValueFactory<>("goods_id"));
        TableColumn goods_type = new TableColumn("goods_type");
        goods_type.setCellValueFactory(new PropertyValueFactory<>("goods_type"));
        TableColumn price = new TableColumn("price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn description = new TableColumn("description");
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        TableColumn size = new TableColumn("size");
        size.setCellValueFactory(new PropertyValueFactory<>("size"));
        TableColumn code_color = new TableColumn("code_color");
        code_color.setCellValueFactory(new PropertyValueFactory<>("code_color"));


        observableList.add(goods_id);
        observableList.add(goods_type);
        observableList.add(price);
        observableList.add(description);
        observableList.add(size);
        observableList.add(code_color);



        List<Goods> list = GoodsDao.findGoods(null,null);
        ObservableList<Goods> obList = FXCollections.observableArrayList(list);

        for(Goods goods: obList){
            if(Math.random()<0.2){
                goods.setPrice(goods.getPrice()*0.85);//15% discount
                table_catalog.getItems().add(goods);
                System.out.println(goods);
            }
        }

    }
}
