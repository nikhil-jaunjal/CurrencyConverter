package org.neptune.Services;

import java.util.List;

import org.neptune.dto.CountryDTO;
import org.neptune.exceptions.handlers.CountryExceptionValidator;
import org.neptune.model.Country;
import org.neptune.repo.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService
{
	@Autowired
	private CountryRepository countryRepository;

	CountryExceptionValidator exceptionHandler = new CountryExceptionValidator();

	public Country saveCountry(CountryDTO countryDto)
	{
		if (exceptionHandler.validateCountryDTO(countryDto))
		{
			Country inCountry = exceptionHandler.setCountryDTO(countryDto);
			return countryRepository.save(inCountry);
		}
		return null;
	}

	public List<Country> findAllCountries()
	{
		return (List<Country>) countryRepository.findAll();

	}

}
