
package com.paypal.bfs.test.employeeserv.api.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Employee resource
 * <p>
 * Employee resource object
 * 
 */
@Entity
@Table(name = "Employee")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "first_name", "last_name", "address", "dob" })
public class Employee {

	/**
	 * employee id
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	@JsonPropertyDescription("employee id")
	private Integer id;
	/**
	 * first name (Required)
	 * 
	 */
	@JsonProperty("first_name")
	@JsonPropertyDescription("first name")
	private String firstName;
	/**
	 * last name (Required)
	 * 
	 */
	@JsonProperty("last_name")
	@JsonPropertyDescription("last name")
	private String lastName;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonProperty("address")
	@JsonPropertyDescription("last address")
	private Address address;

	@JsonProperty("dob")
	@JsonPropertyDescription("dob address")
	private Date dob;

	@JsonIgnore
	@Transient
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * employee id
	 * 
	 */
	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	/**
	 * employee id
	 * 
	 */
	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * first name (Required)
	 * 
	 */
	@JsonProperty("first_name")
	public String getFirstName() {
		return firstName;
	}

	/**
	 * first name (Required)
	 * 
	 */
	@JsonProperty("first_name")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * last name (Required)
	 * 
	 */
	@JsonProperty("last_name")
	public String getLastName() {
		return lastName;
	}

	/**
	 * last name (Required)
	 * 
	 */
	@JsonProperty("last_name")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@JsonProperty("address")
	public Address getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(Address address) {
		this.address = address;
	}

	@JsonProperty("dob")
	public Date getDob() {
		return dob;
	}

	@JsonProperty("dob")
	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Employee.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("firstName");
		sb.append('=');
		sb.append(((this.firstName == null) ? "<null>" : this.firstName));
		sb.append(',');
		sb.append("lastName");
		sb.append('=');
		sb.append(((this.lastName == null) ? "<null>" : this.lastName));
		sb.append(',');
		sb.append("additionalProperties");
		sb.append('=');
		sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
