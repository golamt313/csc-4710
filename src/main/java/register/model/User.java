package register.model;

import java.io.Serializable;

public class User implements Serializable {
	
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String birthday;
    private Integer streetnumber;
    private String street;
    private String city;
    private String state;
    private Integer zipcode;
    private Integer ppsbalance;
    private Double bankbalance;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getStreetnumber() {
		return streetnumber;
	}

	public void setStreetnumber(Integer streetnumber) {
		this.streetnumber = streetnumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	public Integer getPpsbalance() {
		return ppsbalance;
	}

	public void setPpsbalance(Integer ppsbalance) {
		this.ppsbalance = ppsbalance;
	}

	public Double getBankbalance() {
		return bankbalance;
	}

	public void setBankbalance(Double bankbalance) {
		this.bankbalance = bankbalance;
	}
}