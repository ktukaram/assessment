package com.paypal.bfs.test.employeeserv.api.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "Address")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "line1", "line2", "state", "city", "country", "zip_code" })
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonProperty("line1")
	private String line1;

	@JsonProperty("line2")
	private String line2;

	@JsonProperty("state")
	private String state;

	@JsonProperty("city")
	private String city;

	@JsonProperty("zip_code")
	private String zip_code;

	@JsonIgnore
	@Transient
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("line1")
	public String getLine1() {
		return line1;
	}

	@JsonProperty("line1")
	public void setLine1(String line1) {
		this.line1 = line1;
	}

	@JsonProperty("line2")
	public String getLine2() {
		return line2;
	}

	@JsonProperty("line2")
	public void setLine2(String line2) {
		this.line2 = line2;
	}

	@JsonProperty("state")
	public String getState() {
		return state;
	}

	@JsonProperty("state")
	public void setState(String state) {
		this.state = state;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("zip_code")
	public String getZip_code() {
		return zip_code;
	}

	@JsonProperty("zip_code")
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

}
