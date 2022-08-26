package com.mehrshad;

import com.mehrshad.domain.Admin;
import com.mehrshad.domain.Books;
import com.mehrshad.domain.Status;
import com.mehrshad.domain.User;
import com.mehrshad.util.ApplicationContext;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppLibraryManagement {
    public static void main(String[] args)
            throws SQLException, ClassNotFoundException {
//        Status status = Status.
        ApplicationContext context = new ApplicationContext();
        Scanner scanner = new Scanner(System.in);
//        List<User> listUser =List.of(new User(1 , "mehrshadsamaei" , "m", "123") ,
//                new User(2 , "Mehran" , "asd" , "456"))
//                .stream().filter(x-> Boolean.parseBoolean(x.getFullName())).collect(Collectors.toList());
        context.getMenu().welcomeToLibrary();
        try {
            context.getMenu().guidPerson();
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    adminLogin(context);
                    break;
                case 2:+++
                    userLogin(context);
                    break;
                case 3:
                    registerUser(context);
                default:
                    throw new RuntimeException();
            }
        } catch (InputMismatchException ex) {
            ex.printStackTrace();
            ex.getMessage();
            context.getMenu().incorrctNum();
        }
        context.getMenu().signUpOrLogin();
    }

    private static void registerUser(ApplicationContext context) throws SQLException {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        context.getMenu().enterFullName();
        String fullName = scanner.nextLine();
        user.setFullName(fullName);
        context.getMenu().enterUsername();
        String username = scanner.next();
        user.setUsername(username);
        context.getMenu().enterPass();
        String pass = scanner.next();
        user.setPassword(pass);
        context.getUserRepository().insertIntoUserTable(user);
    }

    private static void userLogin(ApplicationContext context) throws SQLException {
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        User user = new User();
        context.getMenu().enterUsername();
        String username = scStr.next();
        context.getMenu().enterPass();
        String pass = scStr.next();
        User byUsernameAndPassword = context.getUserRepository().findByUsernameAndPassword(username, pass);
        if(byUsernameAndPassword == null)
            throw new InputMismatchException("not found user");
        else{
            boolean flag = true;
            while (flag){
                context.getMenu().guidUser();
                int num = scInt.nextInt();
                switch (num){
                    case 1:
                        showAllListUser(context);
                        break;
                    case 2:
                        chooseBook();
                        break;
                    case 3:
                        returnBook();
                    case 4:
                        exit();
                        flag = false;
                    default:
                        throw new RuntimeException();
                }
            }
        }
    }

    private static void returnBook() {

    }

    private static void chooseBook() {

    }

    private static void adminLogin(ApplicationContext context) throws SQLException {
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        Admin admin = new Admin();
        context.getMenu().enterUsername();
        String username = scStr.next();
        context.getMenu().enterPass();
        String pass = scStr.next();
        Admin byUsernameAndPassword = context.getAdminRepository().findByUsernameAndPassword(username, pass);
        if (byUsernameAndPassword == null) {
            System.out.println("not found user");
            throw new InputMismatchException("nnn");
        }
        context.getMenu().welcomeToPv();
        boolean flag = true;
        while (flag) {
            context.getMenu().guidAdmin();
            int num = scInt.nextInt();
            switch (num) {
                case 1:
                    addUser(context);
                    break;
                case 2:
                    removeUser(context);
                    break;
                case 3:
                    addBook(context);
                    break;
                case 4:
                    removeBook(context);
                    break;
                case 5:
                    showAllListUser(context);
                    break;
                case 6:
                    showAllListBooks(context);
                    break;
                case 7:
                    exit();
                    flag = false;
                default:
                    throw new RuntimeException();
            }

        }

    }

    private static void exit() {
        System.out.println("finished");
    }

    private static void showAllListBooks(ApplicationContext context) throws SQLException {
        context.getBooksRepository().findAll();

    }

    private static void showAllListUser(ApplicationContext context) throws SQLException {
       context.getUserRepository().findAll();
    }

    private static void removeBook(ApplicationContext context) throws SQLException {
        showAllListBooks(context);
        Scanner scanner = new Scanner(System.in);
        context.getMenu().enterId();
        int id = scanner.nextInt();
        context.getBooksRepository().deleteBooks(id);


    }

    private static void addBook(ApplicationContext context) throws SQLException {
        Books book = new Books();
        Scanner scanner = new Scanner(System.in);
        context.getMenu().enterBookName();
        String bookName = scanner.nextLine();
        book.setName(bookName);
        context.getMenu().status();
        String status = scanner.next();
        book.setStatus(Boolean.valueOf(status));
        context.getBooksRepository().insertIntoBooks(book);

    }

    private static void removeUser(ApplicationContext context) throws SQLException {
        context.getUserRepository().removeUser();
    }

    private static void addUser(ApplicationContext context) throws SQLException {
        registerUser(context);

    }
}
