package com.store.entity;

/**
 * Entity shows every customer information
 */
public class Customer {
    /**
     * The Customer id.
     */
    String customer_id;
    /**
     * The Name.
     */
    String name;
    /**
     * The Address.
     */
    String address;
    /**
     * The Email.
     */
    String email;
    /**
     * The Order id.
     */
    String order_id;

    /**
     * The Order.
     */
    Order _order;

    /**
     * Instantiates a new Customer.
     *
     * @param customer_id the customer id
     * @param name        the name
     * @param address     the address
     * @param email       the email
     * @param order_id    the order id
     * @param _order      the order
     */
    public Customer(String customer_id, String name, String address, String email, String order_id, Order _order) {
        this.customer_id = customer_id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.order_id = order_id;
        this._order = _order;
    }

    /**
     * Instantiates a new Customer.
     */
    public Customer() {}

    /**
     * Gets customer id.
     *
     * @return the customer id
     */
    public String getCustomer_id() {
        return customer_id;
    }

    /**
     * Sets customer id.
     *
     * @param customer_id the customer id
     */
    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
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
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
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
     * Gets order.
     *
     * @return the order
     */
    public Order get_order() {
        return _order;
    }

    /**
     * Sets order.
     *
     * @param _order the order
     */
    public void set_order(Order _order) {
        this._order = _order;
    }
}
