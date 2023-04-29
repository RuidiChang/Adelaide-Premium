package com.store.entity;

/**
 * Entity shows every good information
 */
public class Goods {
    /**
     * The Goods id.
     */
    String goods_id;
    /**
     * The Goods type.
     */
    String goods_type;
    /**
     * The Price.
     */
    double price;
    /**
     * The Description.
     */
    String description;
    /**
     * The Size.
     */
    int size;
    /**
     * The Code color.
     */
    int code_color;
    /**
     * The Stock.
     */
    int stock;

    /**
     * Instantiates a new Goods.
     *
     * @param goods_id    the goods id
     * @param goods_type  the goods type
     * @param price       the price
     * @param description the description
     * @param size        the size
     * @param code_color  the code color
     * @param stock       the stock
     */
    public Goods(String goods_id, String goods_type, double price, String description, int size, int code_color, int stock) {
        this.goods_id = goods_id;
        this.goods_type = goods_type;
        this.price = price;
        this.description = description;
        this.size = size;
        this.code_color = code_color;
        this.stock = stock;
    }

    /**
     * Instantiates a new Goods.
     */
    public Goods() {

    }

    /**
     * Gets stock.
     *
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Gets goods type.
     *
     * @return the goods type
     */
    public String getGoods_type() {
        return goods_type;
    }

    /**
     * Sets goods type.
     *
     * @param goods_type the goods type
     */
    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }

    /**
     * Sets stock.
     *
     * @param stock the stock
     */
    public void setStock(int stock) {
        this.stock = stock;
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
     * @param goods_id the goods id
     */
    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets size.
     *
     * @param size the size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Gets code color.
     *
     * @return the code color
     */
    public int getCode_color() {
        return code_color;
    }

    /**
     * Sets code color.
     *
     * @param code_color the code color
     */
    public void setCode_color(int code_color) {
        this.code_color = code_color;
    }
}
