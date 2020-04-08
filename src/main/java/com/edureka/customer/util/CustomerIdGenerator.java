package com.edureka.customer.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerIdGenerator implements IdentifierGenerator {
	private static final Logger logger = LoggerFactory.getLogger(CustomerIdGenerator.class);

	public Serializable generate(SharedSessionContractImplementor arg0, Object object) {
		Connection connection = arg0.connection();
		try (Statement statement = connection.createStatement()) {
			try (ResultSet rs = statement.executeQuery("select 'CUST'||lpad(nextval('customerid_seq')::text,7,'0')")) {
				if (rs.next()) {
					return rs.getString(1);
				}
			}
		} catch (SQLException e) {
			logger.error("Exception during sequence id generation");
		}
		return null;
	}
}
