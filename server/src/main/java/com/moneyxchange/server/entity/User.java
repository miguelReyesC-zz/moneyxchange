package com.moneyxchange.server.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;
}
