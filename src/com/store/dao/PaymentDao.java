package com.store.dao;

import com.store.entity.Payment;
import com.store.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * main functions related to payment
 * include add, delete, update and find function
 */
public class PaymentDao {
    /**
     * The Ps.
     */
    static private PreparedStatement ps = null;
    /**
     * The Result set.
     */
    static private ResultSet resultSet = null;


    /**
     * Add payment int.
     *
     * @param payment the payment
     * @return the int
     */
    public static int addPayment(Payment payment){
        Connection conn = DBUtil.connect();
        String sql = "insert into payment(customer_id, name, address, phone, email,order_id) VALUES(?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, payment.getCustomer_id());
            ps.setString(2, payment.getName());
            ps.setString(3, payment.getAddress());
            ps.setString(4, payment.getPhone());
            ps.setString(5, payment.getEmail());
            ps.setString(6, payment.getOrder_id());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }finally {
            DBUtil.close();
        }
        return 0;
    }

    /**
     * Del payment int.
     *
     * @param customer_id the customer id
     * @param order_id    the order id
     * @return the int
     */
    public static int delPayment(String customer_id, String order_id){
        Connection conn = DBUtil.connect();
        String sql = "delete from payment where customer_id = ? and order_id = ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, customer_id);
            ps.setString(2, order_id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }finally {
            DBUtil.close();
        }
        return 0;
    }

    /**
     * Update payment int.
     *
     * @param payment the payment
     * @return the int
     */
    private static int updatePayment(Payment payment){
        return 0;
    }

    /**
     * Find payment list.
     *
     * @param customer_id the customer id
     * @param order_id    the order id
     * @return the list
     */
    public static List<Payment> findPayment(String customer_id, String order_id){
        Connection conn = DBUtil.connect();

        List<Payment> list = new ArrayList<Payment>();
        Payment payment;

        String sql = "select * from payment where 1 = 1";
        if(customer_id != null)
            sql += " and customer_id=?";
        if(order_id != null)
            sql += " and order_id=?";


        try {
            ps = conn.prepareStatement(sql);


            int n=1;
            if(customer_id != null)
                ps.setString(n++, customer_id);
            if(order_id != null)
                ps.setString(n++, order_id);



            resultSet = ps.executeQuery();

            while(resultSet.next()){
                payment = new Payment();
                //, name, address, , email,order_id
                payment.setCustomer_id(resultSet.getString("customer_id"));
                payment.setName(resultSet.getString("name"));
                payment.setAddress(resultSet.getString("address"));
                payment.setPhone(resultSet.getString("phone"));
                payment.setEmail(resultSet.getString("email"));
                payment.setOrder_id(resultSet.getString("order_id"));

                list.add(payment);
            }


            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return list;
    }


}
