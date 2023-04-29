package com.store.dao;

import com.store.entity.CSR;
import com.store.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * main functions related to CSR
 * include add, delete, update and find function
 */
public class CSRDao {
    /**
     * The Ps.
     */
    static private PreparedStatement ps = null;
    /**
     * The Result set.
     */
    static private ResultSet resultSet = null;

    /**
     * Add csr int.
     *
     * @param csr the csr
     * @return the int
     */
    public static int addCSR(CSR csr){
        Connection conn = DBUtil.connect();
        String sql = "insert into csr(order_id, name,extension) VALUES(?,?,?)";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, csr.getOrder_id());
            ps.setString(2, csr.getName());
            ps.setString(3, csr.getExtension());

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
     * Del csr int.
     *
     * @param order_id the order id
     * @return the int
     */
    public static int delCSR(String order_id){
        Connection conn = DBUtil.connect();
        String sql = "delete from csr where order_id = ?";
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
     * Update csr int.
     *
     * @param csr the csr
     * @return the int
     */
    private static int updateCSR(CSR csr){
        Connection conn = DBUtil.connect();
        String sql = "update csr set name=?, extension=?, where CSR_id=?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1,csr.getName() );
            ps.setString(2, csr.getExtension());
            ps.setString(3, csr.getOrder_id());


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
     * Find csr list.
     *
     * @param order_id the order id
     * @return the list
     */
    public static List<CSR> findCSR(String order_id){
        Connection conn = DBUtil.connect();

        List<CSR> list = new ArrayList<CSR>();
        CSR csr;

        String sql = "select * from csr where 1 = 1";
        if(order_id != null)
            sql += " and catalog_id=?";


        try {
            ps = conn.prepareStatement(sql);


            int n=1;
            if(order_id != null)
                ps.setString(n++, order_id);



            resultSet = ps.executeQuery();
            while(resultSet.next()){
                csr = new CSR();
                csr.setOrder_id(resultSet.getString("order_id"));
                csr.setName(resultSet.getString("name"));
                csr.setExtension(resultSet.getString("extension"));


                list.add(csr);
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
