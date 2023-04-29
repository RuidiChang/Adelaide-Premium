package com.store.ui;

import com.store.dao.*;
import com.store.entity.*;
import com.store.util.Tools;
import com.sun.tools.corba.se.idl.constExpr.Or;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

/**
 * realize 3 functions as required: enter order, check availability of an item, simulate payment
 */
public class AddOrderUi implements Initializable {

    /**
     * The Btn add goods.
     */
    @FXML
    public Button btn_add_goods;
    /**
     * The List pane.
     */
    @FXML
    public Pane list_pane;
    /**
     * The Btn finish.
     */
    @FXML
    public Button btn_finish;
    /**
     * The Input goods id.
     */
    @FXML
    public TextField input_goods_id;
    /**
     * The Ui add order.
     */
    @FXML
    private Pane ui_add_order;


    /**
     * The Input customer.
     */
    public TextField[] input_customer;

    /**
     * The List.
     */
    List<Goods> list = new ArrayList<>();

    /**
     * Click return menu.
     *
     * @param actionEvent the action event
     * @throws Exception the exception
     */
    @FXML
    protected void click_return_menu(MouseEvent actionEvent) throws Exception {
        Pane other = FXMLLoader.load(getClass().getResource("/com/store/ui/sample.fxml"));
        ((Button)actionEvent.getSource()).getScene().setRoot(other);


    }

    /**
     * Initialize.
     *
     * @param location  the location
     * @param resources the resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ui_add_order.setStyle(Tools.defaultStyle);
        updateGoods();
    }

    /**
     * Update goods.
     */
    protected  void updateGoods(){
        int i=0;
        list_pane.getChildren().clear();

        btn_finish.setText("next");


        String[] title ={"goods_id","type","price","size","color"};
        list_pane.getChildren().clear();

        for(i=0;i<5;i++) {
            input_customer = new TextField[5];
            Label label = new Label(title[i]);
            label.setLayoutX(10.0 + 100*i);
            label.setLayoutY(10);
            list_pane.getChildren().add(label);
        }

        Label id = new Label("goods_id");

        Label type;
        Label price;
        Label size;
        Label color;

        i=1;

        for(Goods goods: list){
            id = new Label(goods.getGoods_id());
            id.setLayoutX(10.0);
            id.setLayoutY(5.0 + 30*i);
            list_pane.getChildren().add(id);

            type = new Label(goods.getGoods_type());
            type.setLayoutX(110.0);
            type.setLayoutY(5.0 + 30*i);
            list_pane.getChildren().add(type);

            price = new Label(String.valueOf(goods.getPrice()));
            price.setLayoutX(210.0);
            price.setLayoutY(5.0 + 30*i);
            list_pane.getChildren().add(price);

            size = new Label(String.valueOf(goods.getSize()));
            size.setLayoutX(310.0);
            size.setLayoutY(5.0 + 30*i);
            list_pane.getChildren().add(size);

            String c = Integer.toHexString(goods.getCode_color());
            while (c.length() >= 6){
                c = "0" + c;
            }
            c = "0x" +c;
            color = new Label(c);
            color.setLayoutX(410.0);
            color.setLayoutY(5.0 + 30*i);
            list_pane.getChildren().add(color);

            i++;
        }
    }

    /**
     * Click add goods.
     *
     * @param actionEvent the action event
     * @throws Exception the exception
     */
    @FXML
    protected void click_add_goods(MouseEvent actionEvent) throws Exception {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning");
        String goods_id = input_goods_id.getText();
        List<Goods> goods = GoodsDao.findGoods(goods_id, null);
        if(goods.size() != 0 ){
            if(goods.get(0).getStock() <=0){
                alert.setHeaderText("Fail to add");
                alert.setContentText("Not available");
                alert.showAndWait();
            }else {
                list.add(goods.get(0));
                updateGoods();
            }
        }else{
            alert.setHeaderText("Fail to add");
            alert.setContentText("No such good");
            alert.showAndWait();
        }
    }

    /**
     * Init customer ui.
     */
    void initCustomerUi(){
        String[] title ={"name","address","phone","email","Card","Others"};
        list_pane.getChildren().clear();

        input_customer = new TextField[title.length];
        for(int i=0;i<title.length;i++) {
            Label label = new Label(title[i]);
            label.setLayoutX(10.0);
            label.setLayoutY(8.0 + 30 * i);
            list_pane.getChildren().add(label);

            input_customer[i] = new TextField();
            input_customer[i].setLayoutX(100.0);
            input_customer[i].setLayoutY(5.0 + 30 * i);
            list_pane.getChildren().add(input_customer[i]);
        }


        btn_finish.setText("finish");

    }

    /**
     * Add order.
     */
    void addOrder(){
        double total = 0;
        for(Goods i: list)
            total += i.getPrice();

        Order order = new Order();
        order.setOrder_id(Tools.getRandString(10)+Tools.getDateString(new Date()) + Tools.getRandString(4));
        order.setCatalog_id(order.getOrder_id() + "_catalog_id");
        order.setCSR_id(order.getOrder_id() + "_csr_id");
        order.setDate(new Date());
        order.setTotal_price(total);
        order.setPayment_id(order.getOrder_id() + "_payment_id");
        order.setStatus("Wait delivery");

        try {
            OrderDao.addOrder(order);
        }catch (Exception e)
        {
            addOrder();
            return;
        }


        for(Goods i: list) {
            CatalogDao.addCatalog(new Catalog(order.getCatalog_id(),i.getGoods_id()));
            i.setStock(i.getStock() - 1);
            GoodsDao.updateGoods(i);
        }

        CSR csr = new CSR();
        csr.setExtension(input_customer[4].getText());
        csr.setName(input_customer[0].getText());
        csr.setOrder_id(order.getCSR_id());
        CSRDao.addCSR(csr);

        Payment pay = new Payment();
        pay.setCustomer_id(order.getPayment_id());
        pay.setName(input_customer[0].getText());
        pay.setAddress(input_customer[1].getText());
        pay.setPhone(input_customer[2].getText());
        pay.setEmail(input_customer[3].getText());
        pay.setOrder_id(order.getOrder_id());


        PaymentDao.addPayment(pay);

        Customer customer = new Customer();
        customer.setCustomer_id(order.getPayment_id());
        customer.setName(input_customer[0].getText());
        customer.setAddress(input_customer[1].getText());
        customer.setEmail(input_customer[3].getText());
        customer.setOrder_id(order.getOrder_id());


        CustomerDao.addCustom(customer);

        list.clear();
    }

    /**
     * Click finish.
     *
     * @param actionEvent the action event
     * @throws Exception the exception
     */
    @FXML
    protected void click_finish(MouseEvent actionEvent) throws Exception {
        if("finish".equals(btn_finish.getText())){
            addOrder();
            updateGoods();
        }else{
            initCustomerUi();
        }
    }


}
