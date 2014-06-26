package org.svenehrke.demo.gormstandalone.entity

import grails.persistence.*

@Entity
class Person {
	String name
	static constraints = {
		name blank:false
	}
}