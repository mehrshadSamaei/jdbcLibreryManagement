package com.mehrshad.util;

import com.mehrshad.repository.impl.AdminRepositoryImpl;
import com.mehrshad.repository.impl.BooksRepositoryImpl;
import com.mehrshad.repository.impl.BorrowRepositoryImpl;
import com.mehrshad.repository.impl.UserRepositoryImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class ApplicationContext {
    public DatabaseUtil databaseUtil;
    private Menu menu;

    public Menu getMenu() {
        if(menu == null){
            menu = new Menu();
        }
        return menu;
    }

    private AdminRepositoryImpl adminRepository;
    private BooksRepositoryImpl booksRepository;
    private BorrowRepositoryImpl borrowRepository;
    private UserRepositoryImpl userRepository;



    public ApplicationContext() throws SQLException, ClassNotFoundException {
        this.databaseUtil = new DatabaseUtil();
    }

    public AdminRepositoryImpl getAdminRepository() {
        if(adminRepository == null){
            adminRepository = new AdminRepositoryImpl(databaseUtil.getConnection()) ;
        }
        return adminRepository;
    }

    public BooksRepositoryImpl getBooksRepository() {
        if(booksRepository == null){
            booksRepository = new BooksRepositoryImpl(databaseUtil.getConnection());
        }
        return booksRepository;
    }

    public BorrowRepositoryImpl getBorrowRepository() {
        if (borrowRepository == null){
            borrowRepository = new BorrowRepositoryImpl(databaseUtil.getConnection());
        }
        return borrowRepository;
    }

    public UserRepositoryImpl getUserRepository() {
        if(userRepository == null){
            userRepository = new UserRepositoryImpl(databaseUtil.getConnection());
        }
        return userRepository;
    }
}
