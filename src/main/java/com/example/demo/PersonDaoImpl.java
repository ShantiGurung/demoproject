package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

@Service
public class PersonDaoImpl implements PersonDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Person> getAll() {
		List<Person> p = new ArrayList<Person>();
		try {
			Connection connection = DatabaseConnection.getConnetion();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from persons where country_id='United States' ");
			PreparedStatement statement = connection.prepareStatement(sql.toString());
			ResultSet rs = statement.executeQuery();
			Person pp = null;
			while (rs.next()) {
				pp = new Person();
				pp.setEventName(rs.getString("event_name"));
				pp.setScannedDate(rs.getString("scanned_date"));
				pp.setScannedTime(rs.getString("scanned_time"));
				pp.setFirstName(rs.getString("first_name"));
				pp.setLastName(rs.getString("last_name"));
				pp.setMiddleInitial(rs.getString("middle_initial"));
				pp.setEmail(rs.getString("email"));
				pp.setEmail2(rs.getString("email2"));
				pp.setCompany(rs.getString("company"));
				pp.setJobTitle(rs.getString("job_title"));
				pp.setAddress1(rs.getString("address1"));
				pp.setAddress2(rs.getString("address2"));
				pp.setAddress3(rs.getString("address3"));
				pp.setCity(rs.getString("city"));
				pp.setStateId(rs.getString("state_id"));
				pp.setZip(rs.getString("zip"));
				pp.setCountryId(rs.getString("country_id"));
				pp.setPhoneNumber(rs.getString("phone_number"));
				pp.setPhoneNumber2(rs.getString("phone_number2"));
				pp.setFaxNumber(rs.getString("fax_number"));
				pp.setQuestions(rs.getString("questions"));
				pp.setResponse(rs.getString("response"));
				pp.setNote(rs.getString("note"));
				pp.setCollateral(rs.getString("collateral"));
				pp.setQualifiedOrDisqualified(rs.getString("qualified_or_disqualified"));
				pp.setScannedBy(rs.getString("scannned_by"));
				p.add(pp);
				System.out.println("p......" + p);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return p;
	}

}
