package org.svenehrke.demo.gormstandalone

import org.svenehrke.demo.gormstandalone.control.DBInitializer
import org.svenehrke.demo.gormstandalone.entity.Person
import spock.lang.Specification

class PersonSpec extends Specification {

	public static final String NAME = 'Sven'

	void setupSpec() {

		DBInitializer.initDB()
	}

	void "no person at beginning"() {

		expect:
		0 == Person.count()
	}
	void "create person"() {

		when:
		new Person(name: NAME).save(flush: true, failOnError: true)

		then:
		1 == Person.count()

		and:
		Person p = Person.findByName(NAME)
		NAME == p.name

	}
}
