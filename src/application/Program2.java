package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		DepartmentDao depDao = DaoFactory.createDepartmentDao();

		System.out.println("=== Test 1: Department findById ===");
		Department dep = depDao.findById(2);
		System.out.println(dep);

		System.out.println("\n=== Test 2: Department findAll ===");
		List<Department> list = depDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}

		boolean testar = true;
		if (testar) {
			System.out.println("\n=== Test 3: Department INSERT ===");
			Department newDep = new Department(null, "Food");
			depDao.insert(newDep);
			System.out.println("id inserido: " + newDep.getId());
		}

		testar = true;
		if (testar) {
			System.out.println("\n=== Test 4: Department UPDATE ===");
			dep = depDao.findById(8);
			dep.setName("Music");			
			depDao.update(dep);
			System.out.println("Update Completo!");
		}
		
		testar = true;
		if (testar) {
			System.out.println("\n=== Test 5: Department DELETE ===");
			depDao.deleteById(7);
			System.out.println("Departamento Removido!");
		}
				
	}

}
