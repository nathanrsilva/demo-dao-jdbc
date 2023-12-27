package program;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Main {
	public static void main(String[]args) {
		DaoFactory daoFactory = new DaoFactory();
		SellerDao sellerDao = daoFactory.createSellerDao();
		
		System.out.println("======= TEST 1: seller findById ========");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
	}
}
