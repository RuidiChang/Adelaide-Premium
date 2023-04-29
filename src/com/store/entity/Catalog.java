package com.store.entity;
import java.util.List;

/**
 * Entity shows every purchase record
 */
public class Catalog {
    /**
     * The Catalog id.
     */
    String catalog_id;  //it is not unique in the database
    /**
     * The Goods id.
     */
    String goods_id;

    /**
     * The Goods list.
     */
    List<Goods> goodsList;

    /**
     * Instantiates a new Catalog.
     */
    public Catalog(){}

    /**
     * Instantiates a new Catalog.
     *
     * @param catalog_id the catalog id
     * @param goods_id   the goods id
     */
    public Catalog(String catalog_id, String goods_id) {
        this.catalog_id = catalog_id;
        this.goods_id = goods_id;
    }

    /**
     * Gets catalog id.
     *
     * @return the catalog id
     */
    public String getCatalog_id() {
        return catalog_id;
    }

    /**
     * Sets catalog id.
     *
     * @param catalog_id the catalog id
     */
    public void setCatalog_id(String catalog_id) {
        this.catalog_id = catalog_id;
    }

    /**
     * Gets goods id.
     *
     * @return the goods id
     */
    public String getGoods_id() {
        return goods_id;
    }

    /**
     * Sets goods id.
     *
     * @param shirt_id the shirt id
     */
    public void setGoods_id(String shirt_id) {
        this.goods_id = shirt_id;
    }

    /**
     * Gets goods list.
     *
     * @return the goods list
     */
    public List<Goods> getGoodsList() {
        return goodsList;
    }

    /**
     * Sets goods list.
     *
     * @param goodsList the goods list
     */
    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Catalog{" +
                "catalog_id='" + catalog_id + '\'' +
                ", goods_id='" + goods_id + '\'' +
                ", goodsList=" + goodsList +
                '}';
    }
}
