package org.svenehrke.demo.gormstandalone.control

import grails.orm.bootstrap.HibernateDatastoreSpringInitializer
import org.springframework.jdbc.datasource.DriverManagerDataSource

import java.sql.Driver

public class DBInitializer {

	static initDB() {

		HibernateDatastoreSpringInitializer datastoreInitializer = new HibernateDatastoreSpringInitializer('org.svenehrke.demo.gormstandalone.entity')
		File f = new File('prodDb.h2.db')
		if (f.exists()) {
			f.delete()
		}
		def dataSource = new DriverManagerDataSource(Driver.name, "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE", 'sa', '')
//		def dataSource = new DriverManagerDataSource(Driver.name, "jdbc:h2:mem:memDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE", 'sa', '')
		datastoreInitializer.configureForDataSource(dataSource)

	}
}
