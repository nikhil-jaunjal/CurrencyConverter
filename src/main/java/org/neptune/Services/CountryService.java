package org.neptune.Services;

import java.util.List;

import org.neptune.dto.CountryDTO;
import org.neptune.model.CountryEntity;
import org.neptune.repo.CountryRepository;
import org.neptune.repo.CurrencyRepository;
import org.neptune.validation.CountryDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService
{
	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CurrencyRepository currencyRepository;
	
	@Autowired
	private CountryDTOValidator countryDtoValidator;

	public CountryEntity saveCountry(CountryDTO countryDTO)
	{
		countryDtoValidator.validateDto(countryDTO);
		CountryEntity countryEntity = createCountryEntity(countryDTO);
		return countryRepository.save(countryEntity);
	}

	public List<CountryEntity> findAllCountries()
	{
		return (List<CountryEntity>) countryRepository.findAll();

	}

	private CountryEntity createCountryEntity(CountryDTO countryDTO)
	{
		CountryEntity countryEntity = new CountryEntity();
		countryEntity.setCapital(countryDTO.getCapital());
		countryEntity.setCountryId(countryDTO.getCountryId());
		countryEntity.setCurrency(currencyRepository.findOne(countryDTO.getCurrencyId()));
		countryEntity.setName(countryDTO.getName());

		return countryEntity;
	}
}
