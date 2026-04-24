package com.tatkal.main;

import com.tatkal.db.DBConnection;
import com.tatkal.dao.TrainDAO;
import com.tatkal.model.Train;
import java.util.List;
import com.tatkal.dao.UserDAO;
import com.tatkal.model.User;
import com.tatkal.dao.SeatDAO;
import com.tatkal.model.Seat;

public class Main 
{
	public static void main(String[]args)
	{

	   ConsoleMenu menu = new ConsoleMenu();
	   menu.showMainMenu();
	}

}
