package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== Test 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n=== Test 2: seller findByDepartment ===");
		Department d = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(d);
		for (Seller s : list) {
			System.out.println(s);
		}

		System.out.println("\n=== Test 3: seller findAll ===");
		list = sellerDao.findAll();
		for (Seller s : list) {
			System.out.println(s);
		}

		boolean testar = false;
		if (testar) {
			System.out.println("\n=== Test 4: seller INSERT ===");
			Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, d);
			sellerDao.insert(newSeller);
			System.out.println("id inserido: " + newSeller.getId());
		}

		testar = false;
		if (testar) {
			System.out.println("\n=== Test 5: seller UPDATE ===");
			Seller upSeller = sellerDao.findById(3);
			upSeller.setName("Rodrigo Burgos");
			upSeller.setEmail("rodrigoburgos2@gmail.com");
			upSeller.setBaseSalary(5000.0);
			sellerDao.update(upSeller);
			System.out.println("Update Completo!");
		}
	}

}
