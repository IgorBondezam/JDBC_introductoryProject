package application;

import Entities.Department;
import Entities.Seller;
import model.dao.DaoFactory;
import model.dao.SellerDao;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== Test 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);


        System.out.println();
        System.out.println("=== Test 2: seller findByDepartment ===");
        Department departmente = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(departmente);
        list.forEach(System.out::println);

        System.out.println();
        System.out.println("=== Test 3: seller findByAll ===");
        list = sellerDao.findAll();
        list.forEach(System.out::println);


        System.out.println();
        System.out.println("=== Test 4: seller Insert ===");
        Seller newSeleer = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000d, departmente);
        sellerDao.insert(newSeleer);
        System.out.println("Inserted! " + newSeleer.getId());

        System.out.println();
        System.out.println("=== Test 5: seller Update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed!");






    }
}