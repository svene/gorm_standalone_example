package org.svenehrke.demo.gormstandalone

import org.svenehrke.demo.gormstandalone.control.DBInitializer
import org.svenehrke.demo.gormstandalone.entity.Address2
import org.svenehrke.demo.gormstandalone.entity.Person2
//import grails.gorm.tests.GormDatastoreSpec
import spock.lang.Specification

//class Person2Spec extends GormDatastoreSpec {
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
		p = Person2.findByName(NAME, [fetch:  [address2: "eager"] ] ) // note: eager required, otherwise: rg.hibernate.LazyInitializationException: could not initialize proxy - no Session
		Address2 address2 = p.getAddress2()

		then:
		address2 != null
		STREET_NAME == address2.street

	}
}
