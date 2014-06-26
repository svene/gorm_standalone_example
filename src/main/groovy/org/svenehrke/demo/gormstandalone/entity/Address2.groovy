package org.svenehrke.demo.gormstandalone.entity

import grails.persistence.*

@Entity
class Address2 {
	String street

	static belongsTo = [person2: Person2]
}
