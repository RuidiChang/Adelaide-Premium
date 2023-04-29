package com.store.dao;

import com.store.entity.Customer;
import com.store.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * main functions related to customers
 * include add, delete, update and find function
 */
public class CustomerDao {
    /**
     * The Ps.
     */
    static private PreparedStatement ps = null;
    /**
     * The Result set.
     */
    static private ResultSet resultSet = null;

    /**
     * Add custom int.
     *
     * @param customer the customer
     * @return the int
     */
    public static int addCustom(Customer customer){
        Connection conn = DBUtil.connect();
        String sql = "insert into customer(customer_id, name, address, email, order_id) VALUES(?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, customer.getCustomer_id());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getAddress());
            ps.setString(4, customer.getEmail());
            ps.setString(5, customer.getOrder_id());


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
     * Del customer int.
     *
     * @param customer_id the customer id
     * @return the int
     */
    public static int delCustomer(String customer_id){
        Connection conn = DBUtil.connect();
        String sql = "delete from customer where customer_id = ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, customer_id);
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
     * Update customer int.
     *
     * @param customer the customer
     * @return the int
     */
    public static int updateCustomer(Customer customer){
        Connection conn = DBUtil.connect();
        //String sql = "insert into customer(customer_id, name, address, email, Customer_id) VALUES(?,?,?,?,?)";
        String sql = "update customer set name=?, address=?, email=?, order_id=? where customer_id=?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getAddress());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getOrder_id());
            ps.setString(5, customer.getCustomer_id());

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
     * Find customer list.
     *
     * @param customer_id the customer id
     * @param order_id    the order id
     * @return the list
     */
    public static List<Customer> findCustomer(String customer_id, String order_id){
        Connection conn = DBUtil.connect();

        List<Customer> list = new ArrayList<Customer>();
        Customer Customer;

        String sql = "select * from customer where 1 = 1";
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
            //, , , , ,status
            while(resultSet.next()){
                Customer = new Customer();
                Customer.setCustomer_id(resultSet.getString("Customer_id"));
                Customer.setName(resultSet.getString("name"));
                Customer.setAddress(resultSet.getString("address"));
                Customer.setEmail(resultSet.getString("email"));
                Customer.setOrder_id(resultSet.getString("order_id"));


                list.add(Customer);
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
