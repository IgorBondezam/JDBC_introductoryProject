package application;

import Entities.Department;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainDepart {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();


        System.out.println("=== Test 1: department findById ===");
        Department department = departmentDao.findById(3);
        System.out.println(department);


        List<Department> list = new ArrayList<>();


        System.out.println();
        System.out.println("=== Test 2: department findByAll ===");
        list = departmentDao.findAll();
        list.forEach(System.out::println);


        System.out.println();
        System.out.println("=== Test 3: department Insert ===");
        Department newSDep = new Department(null, "Music");
        departmentDao.insert(newSDep);
        System.out.println("Inserted! " + newSDep.getId());

        System.out.println();
        System.out.println("=== Test 4: department Update ===");
        department = departmentDao.findById(1);
        department.setName("Martha Waine");
        departmentDao.update(department);
        System.out.println("Update completed!");

        System.out.println();
        System.out.println("=== Test 5: department Delete ===");
        departmentDao.deleteById(3);
        System.out.println("Delete completed!");
    }
}
