package org.neptune.validation;

import org.neptune.dto.CountryDTO;
import org.neptune.exceptions.InvalidCurrencyIdException;
import org.neptune.repo.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryDTOValidator
{
	@Autowired
	private CurrencyRepository currencyRepository;

	public void validateDto(CountryDTO countryDTO)
	{
		if (currencyRepository.findOne(countryDTO.getCurrencyId()) == null)
		{
			throw new InvalidCurrencyIdException();
		}

	}

}
