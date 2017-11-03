package org.neptune.Services;

import java.util.List;

import org.neptune.exceptions.InvalidCodeException;
import org.neptune.exceptions.InvalidCurrencyIdException;
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
		validator.validateCurrencyForPost(currency);
		return currencyRepository.save(currency);
	}

	public Currency findByCode(String code)
	{
		Currency outObject = currencyRepository.findByCode(code);
		if (outObject == null)
		{
			throw new InvalidCodeException();
		}
		return outObject;
	}

	public Currency findById(Integer id)
	{
		return currencyRepository.findOne(id);
	}

	public Currency putCurrency(Currency currency)
	{
		validator.validateCurrencyForPut(currency);
		if (findById(currency.getCurrencyId()) == null)
		{
			throw new InvalidCurrencyIdException();
		}
		return currencyRepository.save(currency);

	}

	public void deleteCurrency(Integer id)
	{
		currencyRepository.delete(id);
	}

	public Double convertCurrency(String code, Double amount)
	{
		validator.checkCodeLength(code);
		validator.checkAmount(amount);
		Currency outObject = currencyRepository.findByCode(code);
		return outObject.getRate() * amount;
	}
}
