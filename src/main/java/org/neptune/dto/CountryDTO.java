package org.neptune.dto;

public class CountryDTO
{
	private Integer countryId;
	private String name;
	private String capital;
	private Integer currencyId;

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

	public Integer getCurrencyId()
	{
		return currencyId;
	}

	public void setCurrencyId(Integer currencyId)
	{
		this.currencyId = currencyId;
	}

}
