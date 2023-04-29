package com.store.dao;

import com.store.entity.Order;
import com.store.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * main functions related to order
 * include add, delete, update and find function
 */
public class OrderDao {
    /**
     * The Ps.
     */
    static private PreparedStatement ps = null;
    /**
     * The Result set.
     */
    static private ResultSet resultSet = null;

    /**
     * Add order int.
     *
     * @param order the order
     * @return the int
     */
    public static int addOrder(Order order){
        Connection conn = DBUtil.connect();
        String sql = "insert into store_order(order_id, date, catalog_id, total_price, payment_id, CSR_id,status) VALUES(?,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, order.getOrder_id());
            ps.setDate(2, new java.sql.Date(order.getDate().getTime()));
            ps.setString(3, order.getCatalog_id());
            ps.setDouble(4, order.getTotal_price());
            ps.setString(5, order.getPayment_id());
            ps.setString(6, order.getCSR_id());
            ps.setString(7, order.getStatus());

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
     * Del order int.
     *
     * @param order_id the order id
     * @return the int
     */
    public static int delOrder(String order_id){
        Connection conn = DBUtil.connect();
        String sql = "delete from store_order where order_id = ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, order_id);
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
     * Update order int.
     *
     * @param order the order
     * @return the int
     */
    public static int updateOrder(Order order){
        Connection conn = DBUtil.connect();
        String sql = "update store_order set date=?, catalog_id=?, total_price=?, payment_id=?, CSR_id=?,status=? where order_id=?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setDate(1, new java.sql.Date(order.getDate().getTime()));
            ps.setString(2, order.getCatalog_id());
            ps.setDouble(3, order.getTotal_price());
            ps.setString(4, order.getPayment_id());
            ps.setString(5, order.getCSR_id());
            ps.setString(6, order.getStatus());
            ps.setString(7, order.getOrder_id());

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
     * Find order list.
     *
     * @param order_id the order id
     * @param catalog  the catalog
     * @param payment  the payment
     * @param csr      the csr
     * @return the list
     */
    public static List<Order> findOrder(String order_id, String catalog, String payment, String csr){
        Connection conn = DBUtil.connect();

        List<Order> list = new ArrayList<Order>();
        Order order;

        String sql = "select * from store_order where 1 = 1";
        if(order_id != null)
            sql += " and order_id=?";
        if(catalog != null)
            sql += " and catalog_id=?";
        if(payment != null)
            sql += " and payment_id=?";
        if(csr != null)
            sql += " and CSR_id=?";
        try {
            ps = conn.prepareStatement(sql);


            int n=1;
            if(order_id != null)
                ps.setString(n++, order_id);
            if(catalog != null)
                ps.setString(n++, catalog);
            if(payment != null)
                ps.setString(n++, payment);
            if(csr != null)
                ps.setString(n, csr);


            resultSet = ps.executeQuery();
            //, , , , ,status
            while(resultSet.next()){
                order = new Order();
                order.setOrder_id(resultSet.getString("order_id"));
                order.setDate(resultSet.getDate("date"));
                order.setCatalog_id(resultSet.getString("catalog_id"));
                order.setOrder_id(resultSet.getString("order_id"));
                order.setTotal_price(resultSet.getDouble("total_price"));
                order.setPayment_id(resultSet.getString("payment_id"));
                order.setCSR_id(resultSet.getString("CSR_id"));
                order.setStatus(resultSet.getString("status"));

                list.add(order);
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
