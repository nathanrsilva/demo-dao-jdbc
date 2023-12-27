package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{

	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		//SELECT FROM seller WHERE (Id = ?)
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?"
					);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				Department department = instantiateDepartment(resultSet);
				Seller seller = instantiateSeller(resultSet, department);
				
				return seller;
			}
			return null;					
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(statement);
			DB.closeResultSet(resultSet);
		}
	}

	private Seller instantiateSeller(ResultSet resultSet, Department department) throws SQLException {
		Seller seller = new Seller();
		seller.setId(resultSet.getInt("Id"));
		seller.setName(resultSet.getString("Name"));
		seller.setEmail(resultSet.getString("Email"));
		seller.setBirthDate(LocalDate.parse(String.valueOf(resultSet.getDate("BirthDate"))));
		seller.setBaseSalary(resultSet.getDouble("BaseSalary"));
		seller.setDepartment(department);
		
		return seller;
	}

	private Department instantiateDepartment(ResultSet resultSet) throws SQLException {
		Department department = new Department();
		department.setId(resultSet.getInt("DepartmentId"));
		department.setName(resultSet.getString("DepName"));
		return department;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
