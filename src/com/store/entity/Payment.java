package com.store.entity;

/**
 * Entity shows every payment information
 */
public class Payment {
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
     * The Phone.
     */
    String phone;
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
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
