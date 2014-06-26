package org.svenehrke.demo.gormstandalone.entity

class Address {
	String street

	static belongsTo = [person: Person]
}
