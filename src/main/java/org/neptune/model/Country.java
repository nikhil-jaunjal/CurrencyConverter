package org.neptune.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Country
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "country_id")
	private Integer countryId;
	private String name;
	private String capital;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ref_currency_id", referencedColumnName = "currency_id")
	private Currency currency;

	public Country()
	{

	}

	public Integer getCountryId()
	{
		return countryId;
	}

	public void setCountryId(Integer countryId)
	{
		this.countryId = countryId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCapital()
	{
		return capital;
	}

	public void setCapital(String capital)
	{
		this.capital = capital;
	}

	public Currency getCurrency()
	{
		return currency;
	}

	public void setCurrency(Currency currency)
	{
		this.currency = currency;
	}

}
