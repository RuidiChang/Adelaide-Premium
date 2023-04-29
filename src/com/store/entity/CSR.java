package com.store.entity;

/**
 * Entity shows customer and their related orders
 */
public class CSR {
    /**
     * The Order id.
     */
    String order_id;
    /**
     * The Name.
     */
    String name;
    /**
     * The Extension.
     */
    String extension;


    /**
     * Instantiates a new Csr.
     */
    public CSR() {}


    /**
     * Instantiates a new Csr.
     *
     * @param name      the name
     * @param extension the extension
     */
    public CSR(String name, String extension) {
        this.name = name;
        this.extension = extension;
    }


    /**
     * Gets order id.
     *
     * @return the order id
     */
    public String getOrder_id() {
        return order_id;
    }

    /**
     * Sets order id.
     *
     * @param order_id the order id
     */
    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets extension.
     *
     * @return the extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Sets extension.
     *
     * @param extension the extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "CSR{" +
                "order_id='" + order_id + '\'' +
                ", name='" + name + '\'' +
                ", extension='" + extension + '\'' +
                '}';
    }
}
