package org.neptune.controller;

import java.util.List;

import org.neptune.Services.CurrencyService;
import org.neptune.model.CurrencyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currencies")
public class CurrencyController
{
	@Autowired
	private CurrencyService currencyService;

	@GetMapping()
	public List<?> findAll()
	{
		return (List<?>) currencyService.findAll();
	}

	@GetMapping(value = "/{code}")
	public CurrencyEntity findByCode(@PathVariable String code)
	{
		return currencyService.findByCode(code);
	}

	@PostMapping()
	public CurrencyEntity save(@RequestBody CurrencyEntity currency)
	{
		currencyService.save(currency);
		return currency;
	}

	@PutMapping()
	public CurrencyEntity putCurrency(@RequestBody CurrencyEntity currency)
	{
		return currencyService.putCurrency(currency);
	}

	@DeleteMapping(value = "/{id}")
	public String deleteCurrency(@PathVariable Integer id)
	{
		currencyService.deleteCurrency(id);
		return "deleted";
	}

	// convert currency
	// after UI, uri will change to /{amount}/{code}
	@GetMapping(value = "/INR/{amount}/into/{code}")
	public String convertCurrency(@PathVariable String code, @PathVariable Double amount)
	{
		Double convertedAmount = currencyService.convertCurrency(code, amount);
		return amount + " INR = " + convertedAmount + " " + code;
	}

}
