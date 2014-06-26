package org.svenehrke.demo.gormstandalone.app

import org.svenehrke.demo.gormstandalone.control.DBInitializer
import org.svenehrke.demo.gormstandalone.entity.Person

class Main {


	public static final String NAME = 'Sven'

	public static void main(String[] args) {

		DBInitializer.initDB()

		println "Total people = " + Person.count()


		new Person(name: NAME).save(flush: true, failOnError: true)

		println "Total people = " + Person.count()

		Person p = Person.findByName(NAME)
		println "(found person)'s name: " + p.name
	}

}
