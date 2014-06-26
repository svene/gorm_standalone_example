package org.svenehrke.demo.gormstandalone

import org.svenehrke.demo.gormstandalone.control.DBInitializer
import org.svenehrke.demo.gormstandalone.entity.Address2
import org.svenehrke.demo.gormstandalone.entity.Person2
import spock.lang.Specification

class Person2Spec extends Specification {

	public static final String NAME = 'Sven'
	public static final String STREET_NAME = 'my street'

	void setupSpec() {

		DBInitializer.initDB()
	}

	void "no person at beginning"() {

		expect:
		0 == Person2.count()
	}
	void "create person"() {

		when:
		new Person2(name: NAME, address2: new Address2(street: STREET_NAME) ).save(flush: true, failOnError: true)

		then:
		1 == Person2.count()

		when:
		Person2 p = Person2.findByName(NAME)

		then:
		assert NAME == p.name



		when:
		Address2 address2
		Person2.withTransaction { // needs to be wrapped in a, otherwise 'p.getAdress2() call' complains with: rg.hibernate.LazyInitializationException: could not initialize proxy - no Session
			p = Person2.findByName(NAME)
			address2 = p.getAddress2()
		}
		// note: now address2 and p are in detached state

		then:
		address2 != null
		STREET_NAME == address2.street

	}
}
