package application;

import Entities.Department;
import Entities.Seller;
import model.dao.DaoFactory;
import model.dao.SellerDao;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Department obj = new Department(1, "Books");

        System.out.println(obj);

        Seller seller = new Seller(21, "Bob", "Bob@gmail.com", new Date(), 3000d, obj);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(seller);


    }
}