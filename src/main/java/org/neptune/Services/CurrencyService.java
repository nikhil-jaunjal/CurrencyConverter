package org.neptune.Services;

import java.util.List;

import org.neptune.exceptions.handlers.CurrencyExceptionValidator;
import org.neptune.model.Currency;
import org.neptune.repo.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService
{
	@Autowired
	private CurrencyRepository currencyRepository;

	CurrencyExceptionValidator validator = new CurrencyExceptionValidator();

	public List<?> findAll()
	{
		return (List<?>) currencyRepository.findAll();
	}

	public Currency save(Currency currency)
	{
		validator.validateCurrency(currency);
		return currencyRepository.save(currency);
	}

	public Currency findById(Integer id)
	{
		return currencyRepository.findOne(id);
	}

	public Currency putCurrency(Currency currency, Integer id)
	{
		return currencyRepository.save(currency);
	}

	public void deleteCurrency(Integer id)
	{
		currencyRepository.delete(id);
	}

	public Double convertCurrency(String code, Double amount)
	{
		Currency outObject = currencyRepository.findByCode(code);
		return outObject.getRate() * amount;
	}
}
