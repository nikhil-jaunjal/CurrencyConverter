package org.neptune.exceptions.handlers;

import org.neptune.dto.CountryDTO;
import org.neptune.model.Country;
import org.neptune.model.Currency;
import org.neptune.repo.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryExceptionValidator
{
	@Autowired
	private CurrencyRepository currencyRepository;

	public Country setCountryDTO(CountryDTO countryDto)
	{
		Country inCountry = new Country();
		inCountry.setCountryId(countryDto.getCountryId());
		inCountry.setName(countryDto.getName());
		inCountry.setCapital(countryDto.getCapital());
		Currency currency = new Currency();
		currency = currencyRepository.findByCurrencyId(countryDto.getCurrencyId());
		inCountry.setCurrency(currency);

		return inCountry;
	}

	public boolean validateCountryDTO(CountryDTO countryDto)
	{

		return true;
	}
}
