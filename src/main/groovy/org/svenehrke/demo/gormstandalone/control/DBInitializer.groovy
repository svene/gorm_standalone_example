package org.svenehrke.demo.gormstandalone.control

import grails.orm.bootstrap.HibernateDatastoreSpringInitializer
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.svenehrke.demo.gormstandalone.entity.Person

import java.sql.Driver

public class DBInitializer {

	static initDB() {

		def datastoreInitializer = new HibernateDatastoreSpringInitializer(Person)
		File f = new File('prodDb.h2.db')
		if (f.exists()) {
			f.delete()
		}
		def dataSource = new DriverManagerDataSource(Driver.name, "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE", 'sa', '')
		datastoreInitializer.configureForDataSource(dataSource)

	}
}
