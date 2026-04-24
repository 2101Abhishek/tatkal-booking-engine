package com.tatkal.main;

import java.util.Scanner;

import com.tatkal.model.User;
import com.tatkal.dao.UserDAO;
import com.tatkal.dao.TrainDAO;
import com.tatkal.dao.SeatDAO;
import com.tatkal.model.Train;
import com.tatkal.model.Seat;
import java.util.List;

public class ConsoleMenu
{
    private Scanner scanner = new Scanner(System.in);

    public void showMainMenu()
    {
       while(true)
       {
         System.out.println("===TATKAL BOOKING SYSTEM===");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.println("Enter choice");

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch(choice)
        {
            case 1:
                System.out.println("Enter Name : ");
                String name = scanner.nextLine();
                System.out.println("Enter Email : ");
                String email = scanner.nextLine();
                System.out.println("Enter Password : ");
                String password = scanner.nextLine();
                System.out.println("Enter Phone Number : ");
                String phoneNumber = scanner.nextLine();

                User newUser = new User(0,name,email,password,phoneNumber);

                UserDAO userDAO = new UserDAO();
                userDAO.registerUser(newUser);
                System.out.println("Register Successfully");
            break;

            case 2:
                System.out.println("Enter Email : ");
                String loginEmail = scanner.nextLine();
                System.out.println("Enter Password : ");
                String loginPass = scanner.nextLine();

                UserDAO userDAO2 = new UserDAO();
                User loggedIn = userDAO2.loginUser(loginEmail,loginPass);
                
                if(loggedIn != null)
                {
                    System.out.println("Welcome "+loggedIn.getName());
                    showUserMenu(loggedIn);
                }
                else
                {
                    System.out.println("Invalid Credentails!");
                }
            break;
            
            case 3:
                System.exit(0);
            break;
        }
       }
    }
    public void showUserMenu(User loggedIn)
    {
        while(true)
        {
            System.out.println("===WELCOME "+loggedIn.getName()+" ===");
            System.out.println("1. View Trains");
            System.out.println("2. View Available Seats");
            System.out.println("3. Book a Seat");
            System.out.println("4. Logout");
            System.out.println("Enter choice");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice)
            {
                case 1:
                    TrainDAO trainDAO = new TrainDAO();
                    List <Train> trains = trainDAO.getAllTrains();
                    for(Train t : trains)
                    {
                        System.out.println(t.getTrainId()+" | "+t.getName());
                    }
                    
                break;
                case 2 :
                    System.out.println("Enter Train ID : ");
                    int trainId = scanner.nextInt();
                    scanner.nextLine();
                    SeatDAO seatDAO2 = new SeatDAO();
                    List<Seat> seats = seatDAO2.getAvailableSeats(trainId);
                    for(Seat s : seats)
                    {
                        System.out.println(s.getSeatId()+" | Seat NO: "+s.getSeatNumber());
                    }
                   
                break;
                case 3:
                    System.out.println("Enter Seat ID : ");
                    int seatId = scanner.nextInt();

                    SeatDAO seatDAO3 = new SeatDAO();
                    boolean result = seatDAO3.bookSeat(seatId,loggedIn.getUserId());
                    if(result)
                    {
                        System.out.println("Booking Success!");
                    }
                    else
                    {
                        System.out.println("Booking Failed!");
                    }
                break;
                case 4:
                    System.out.println("Logged out!");
                    return;

            }
        }
    }
}