package com.store.dao;

import com.store.entity.Goods;
import com.store.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * main functions related to goods
 * include add, delete, update and find function
 */
public class GoodsDao {
    /**
     * The Ps.
     */
    static private PreparedStatement ps = null;
    /**
     * The Result set.
     */
    static private ResultSet resultSet = null;

    /**
     * Add goods int.
     *
     * @param goods the goods
     * @return the int
     */
    public static int addGoods(Goods goods){
        Connection conn = DBUtil.connect();
        String sql = "insert into goods(goods_id, goods_type, price, description, size, code_color,stock) VALUES(?,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, goods.getGoods_id());
            ps.setString(2, goods.getGoods_type());
            ps.setDouble(3, goods.getPrice());
            ps.setString(4, goods.getDescription());
            ps.setInt(5, goods.getSize());
            ps.setInt(6, goods.getCode_color());
            ps.setInt(7, goods.getStock());

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
     * Del goods int.
     *
     * @param goods_id the goods id
     * @return the int
     */
    public static int delGoods(String goods_id){
        Connection conn = DBUtil.connect();
        String sql = "delete from gods where goods_id = ?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, goods_id);
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
     * Update goods int.
     *
     * @param goods the goods
     * @return the int
     */
    public static int updateGoods(Goods goods){
        Connection conn = DBUtil.connect();
        String sql = "update goods set goods_type=?, price=?, description=?, size=?, code_color=?,stock=? where goods_id=?";
        try {
            ps = conn.prepareStatement(sql);

            ps.setString(7, goods.getGoods_id());
            ps.setString(1, goods.getGoods_type());
            ps.setDouble(2, goods.getPrice());
            ps.setString(3, goods.getDescription());
            ps.setInt(4, goods.getSize());
            ps.setInt(5, goods.getCode_color());
            ps.setInt(6, goods.getStock());

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
     * Find goods list.
     *
     * @param goods_id   the goods id
     * @param goods_type the goods type
     * @return the list
     */
    public static List<Goods> findGoods(String goods_id, String goods_type){
        Connection conn = DBUtil.connect();

        List<Goods> list = new ArrayList<Goods>();
        Goods goods;

        String sql = "select * from goods where 1 = 1";
        if(goods_id != null)
            sql += " and goods_id=?";
        if(goods_type != null)
            sql += " and goods_type=?";

        try {
            ps = conn.prepareStatement(sql);


            int n=1;
            if(goods_id != null)
                ps.setString(n++, goods_id);
            if(goods_type != null)
                ps.setString(n++, goods_type);



            resultSet = ps.executeQuery();
            while(resultSet.next()){
                goods = new Goods();
                goods.setGoods_id(resultSet.getString("goods_id"));
                goods.setGoods_type(resultSet.getString("goods_type"));
                goods.setPrice(resultSet.getDouble("price"));
                goods.setDescription(resultSet.getString("description"));
                goods.setSize(resultSet.getInt("size"));
                goods.setCode_color(resultSet.getInt("code_color"));
                goods.setStock(resultSet.getInt("stock"));


                list.add(goods);
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
