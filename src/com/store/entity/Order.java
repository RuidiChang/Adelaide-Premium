package com.store.entity;
import java.util.Date;

/**
 * Entity shows every order information
 */
public class Order {
    /**
     * The Order id.
     */
    String order_id;
    /**
     * The Date.
     */
    Date date;
    /**
     * The Catalog id.
     */
    String catalog_id;
    /**
     * The Total price.
     */
    double total_price;
    /**
     * The Payment id.
     */
    String payment_id;
    /**
     * The Csr id.
     */
    String CSR_id;
    /**
     * The Status.
     */
    String status;

    /**
     * The Catalog.
     */
    Catalog _catalog;
    /**
     * The Payment.
     */
    Payment _payment;
    /**
     * The Csr.
     */
    CSR _csr;


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
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
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
     * Gets total price.
     *
     * @return the total price
     */
    public double getTotal_price() {
        return total_price;
    }

    /**
     * Sets total price.
     *
     * @param total_price the total price
     */
    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    /**
     * Gets payment id.
     *
     * @return the payment id
     */
    public String getPayment_id() {
        return payment_id;
    }

    /**
     * Sets payment id.
     *
     * @param payment_id the payment id
     */
    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    /**
     * Gets csr id.
     *
     * @return the csr id
     */
    public String getCSR_id() {
        return CSR_id;
    }

    /**
     * Sets csr id.
     *
     * @param CSR_id the csr id
     */
    public void setCSR_id(String CSR_id) {
        this.CSR_id = CSR_id;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets catalog.
     *
     * @return the catalog
     */
    public Catalog get_catalog() {
        return _catalog;
    }

    /**
     * Sets catalog.
     *
     * @param _catalog the catalog
     */
    public void set_catalog(Catalog _catalog) {
        this._catalog = _catalog;
    }

    /**
     * Gets payment.
     *
     * @return the payment
     */
    public Payment get_payment() {
        return _payment;
    }

    /**
     * Sets payment.
     *
     * @param _payment the payment
     */
    public void set_payment(Payment _payment) {
        this._payment = _payment;
    }

    /**
     * Gets csr.
     *
     * @return the csr
     */
    public CSR get_csr() {
        return _csr;
    }

    /**
     * Sets csr.
     *
     * @param _csr the csr
     */
    public void set_csr(CSR _csr) {
        this._csr = _csr;
    }


    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", date=" + date +
                ", catalog_id='" + catalog_id + '\'' +
                ", total_price=" + total_price +
                ", payment_id='" + payment_id + '\'' +
                ", CSR_id='" + CSR_id + '\'' +
                ", status='" + status + '\'' +
                ", _catalog=" + _catalog +
                ", _payment=" + _payment +
                ", _csr=" + _csr +
                '}';
    }
}

