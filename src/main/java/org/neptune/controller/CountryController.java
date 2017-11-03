package org.neptune.controller;

import java.util.List;

import org.neptune.Services.CountryService;
import org.neptune.dto.CountryDTO;
import org.neptune.model.CountryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currencies")
public class CountryController
{
	@Autowired
	private CountryService countryService;

	@PostMapping("/countries")
	public CountryEntity saveCountry(@RequestBody CountryDTO countryDto)
	{
		return countryService.saveCountry(countryDto);
	}

	@GetMapping("/countries")
	public List<CountryEntity> findAllCountries()
	{
		return (List<CountryEntity>) countryService.findAllCountries();

	}
}
