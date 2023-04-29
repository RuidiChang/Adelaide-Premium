package com.store.dao;

import com.store.entity.Catalog;
import com.store.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * main functions related to purchase record
 * include add, delete, update and find function
 */
public class CatalogDao {
    /**
     * The Ps.
     */
    static private PreparedStatement ps = null;
    /**
     * The Result set.
     */
    static private ResultSet resultSet = null;

    /**
     * Add catalog int.
     *
     * @param catalog the catalog
     * @return the int
     */
    public static int addCatalog(Catalog catalog){
        Connection conn = DBUtil.connect();
        String sql = "insert into catalog(catalog_id, goods_id) VALUES(?,?)";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, catalog.getCatalog_id());
            ps.setString(2, catalog.getGoods_id());

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
     * Del catalog int.
     *
     * @param catalog_id the catalog id
     * @param goods_id   the goods id
     * @return the int
     */
    public static int delCatalog(String catalog_id, String goods_id){
        Connection conn = DBUtil.connect();
        String sql = "delete from catalog where catalog_id = ? and goods_id=?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, catalog_id);
            ps.setString(2, goods_id);
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
     * Update catalog int.
     *
     * @param catalog the catalog
     * @return the int
     */
    private static int updateCatalog(Catalog catalog){
        return 0;
    }


    /**
     * Find catalog list.
     *
     * @param catalog_id the catalog id
     * @param goods_id   the goods id
     * @return the list
     */
    public static List<Catalog> findCatalog(String catalog_id, String goods_id){
        Connection conn = DBUtil.connect();

        List<Catalog> list = new ArrayList<Catalog>();
        Catalog catalog;

        String sql = "select * from catalog where 1 = 1";
        if(catalog_id != null)
            sql += " and catalog_id=?";
        if(goods_id != null)
            sql += " and goods_id=?";

        try {
            ps = conn.prepareStatement(sql);


            int n=1;
            if(catalog_id != null)
                ps.setString(n++, catalog_id);
            if(goods_id != null)
                ps.setString(n++, goods_id);


            resultSet = ps.executeQuery();
            while(resultSet.next()){
                catalog = new Catalog();
                catalog.setCatalog_id(resultSet.getString("catalog_id"));
                catalog.setGoods_id(resultSet.getString("goods_id"));

                list.add(catalog);
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
