package com.store.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * connect to the database
 */
public class DBUtil {
    /**
     * The Database name.
     */
    static String databaseName = "store";
    /**
     * The User name.
     */
    static String user_name = "root";
    /**
     * The User password.
     */
    static String user_password = "rootroot";
    /**
     * The Drive.
     */
    static String drive = "jdbc:mysql://localhost:3306/"+databaseName+"?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
    /**
     * The Connect.
     */
    static Connection connect = null;

    /**
     * Connect connection.
     *
     * @return the connection
     */
    public static Connection connect(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = conn = DriverManager.getConnection(drive, user_name, user_password);
        }catch (Exception e){
            System.out.println("Fail to open database");
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return  conn;
    }

    /**
     * Close.
     */
    public static void close(){
        try{
            if(connect != null) {
                connect.close();
            }
            connect = null;
        }catch(Exception ignored) {

        }
    }


}
