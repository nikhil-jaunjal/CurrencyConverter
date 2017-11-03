package org.neptune.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
public class CurrencyEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "currency_id")
	private Integer currencyId;

	@Column(unique = true)
	private String code;

	public Integer getCurrencyId()
	{
		return currencyId;
	}

	public void setCurrencyId(Integer currencyId)
	{
		this.currencyId = currencyId;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public Double getRate()
	{
		return rate;
	}

	public void setRate(Double rate)
	{
		this.rate = rate;
	}

	private Double rate;

	public CurrencyEntity()
	{

	}
}