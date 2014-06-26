package org.svenehrke.demo.gormstandalone.entity

import grails.persistence.*

@Entity
class Person2 {
	String name

	Address2 address2

	static constraints = {
		name blank:false
	}
}