package org.svenehrke.demo.gormstandalone.service

import org.svenehrke.demo.gormstandalone.entity.Person2

public class AddressService {

	public String getStreetNameForPerson(String personName) {

		String result;
		Person2.withTransaction {
			Person2 p = Person2.findByName(personName)
			def address2 = p.address2
			result = address2.street
		}

		result

	}

}
