package com.mcsjavaprojects.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;

/**
* @author M. C. S.
*/

@Entity
@Table(name="CUSTOMER")
public class Customer {	
	
			
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
			
	@Size(min=3, max=50)
	@Column(name="NAME", nullable=false)
	private String name;
    
	@NotEmpty(message = "Address can not be blank.")	
	@Column(name="ADDRESS", nullable=false)
	private String address;

	@NotNull(message = "Postal code can not be blank.")	  
	@Column(name="POSTAL_CODE", length = 5, nullable=false)
	private Integer zip;
	
	@NotEmpty(message = "Contact person can not be blank.")
	@Column(name="CONTACT_PERSON", nullable=false)
	private String contactPerson;
	
	@NotEmpty(message = "Position can not be blank.")
	@Column(name="POSITION", nullable=false)
	private String position;
	
	@NotEmpty(message = "Phone can not be blank.")
	@Column(name="PHONE", nullable=false)
	private String phone;
	
	@NotEmpty(message = "Email can not be blank.")
	@Email(message = "Invalid email.")
	@Column(name="EMAIL", unique=true, nullable=false)
	private String email;	
	
	
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	@Past(message = "Last contact must be a date in the past.")
	@Column(name="LAST_CONTACT", nullable=true)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate lastContact;
	
	@DateTimeFormat(pattern="dd/MM/yyyy") 
    @Future(message = "Next contact must be a date in the future.")
	@Column(name="NEXT_CONTACT", nullable=true)	
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate nextContact;
	
	@NotEmpty(message = "Please select one lead status.")
	@Column(name="LEAD_STATUS", nullable=false)
	private String leadStatus;
		
	@Column(name="NOTES", nullable=true)
	private String notes;	
	        			
	
	public Integer getId() {
		return id;
	}	
	

	public void setId(Integer id) {
		this.id = id;
	}
	
			
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
		
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}
	
	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public LocalDate getLastContact() {
		return lastContact;
	}

	public void setLastContact(LocalDate lastContact) {
		this.lastContact = lastContact;
	}
	
	public LocalDate getNextContact() {
		return nextContact;
	}

	public void setNextContact(LocalDate nextContact) {
		this.nextContact = nextContact;
	}
	
	public String getLeadStatus() {
		return leadStatus;
	}

	public void setLeadStatus(String leadStatus) {
		this.leadStatus = leadStatus;
	}
	
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}  
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Customer))
			return false;
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}     	
	
					
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address
				+ ", zip=" + zip + ", contactPerson=" + contactPerson
				+ ", position=" + position + ", phone=" + phone
				+ ", email=" + email + ", lastContact=" + lastContact
				+ ", nextContact=" + nextContact + ", leadStatus=" + leadStatus
				+ ", notes=" + notes + "]";
	}

	


}
