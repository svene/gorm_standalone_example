package org.svenehrke.demo.gormstandalone

import org.svenehrke.demo.gormstandalone.boundary.AddressService
import org.svenehrke.demo.gormstandalone.control.DBInitializer
import org.svenehrke.demo.gormstandalone.entity.Address2
import org.svenehrke.demo.gormstandalone.entity.Person2
import spock.lang.Specification

class AddressServiceSpec extends Specification {

	public static final String NAME = 'Sven'
	public static final String STREET_NAME = 'my street'

	void setupSpec() {

		DBInitializer.initDB()
	}

	void "create person"() {

		given:
		new Person2(name: NAME, address2: new Address2(street: STREET_NAME) ).save(flush: true, failOnError: true)

		when:
		String streetName = new AddressService().getStreetNameForPerson(NAME);

		then:
		STREET_NAME == streetName
	}
}
