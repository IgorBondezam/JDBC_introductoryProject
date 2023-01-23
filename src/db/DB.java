package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection conn = null;
    public  static  Connection getConnection(String path){
        if(conn == null){
            try {
                Properties props = loadProperties(path);
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            }catch (SQLException e){
                throw  new DbException(e.getMessage());
            }
        }
        return conn;
    }

    private  static Properties loadProperties(String path){
        try(FileInputStream fs = new FileInputStream(path + ".properties")){
            Properties props = new Properties();
            props.load(fs);
            return  props;
        }catch (IOException e){
            throw new DbException(e.getMessage());
        }
    }

    public static void closeConnection(){
        if(conn != null){
            try {
                conn.close();
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeSatementResultSet(Statement st, ResultSet rs){
        if (st != null) {
            try {
                st.close();
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }

        if (rs != null) {
            try {
                rs.close();
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeSatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

}
