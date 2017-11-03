package org.neptune.Services;

import java.util.List;

import org.neptune.exceptions.InvalidCodeException;
import org.neptune.exceptions.InvalidCurrencyIdException;
import org.neptune.exceptions.validation.CurrencyEntityValidator;
import org.neptune.model.CurrencyEntity;
import org.neptune.repo.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService
{
	@Autowired
	private CurrencyRepository currencyRepository;

	CurrencyEntityValidator validator = new CurrencyEntityValidator();

	public List<?> findAll()
	{
		return (List<?>) currencyRepository.findAll();
	}

	public CurrencyEntity save(CurrencyEntity currency)
	{
		validator.validateCurrencyForPost(currency);
		return currencyRepository.save(currency);
	}

	public CurrencyEntity findByCode(String code)
	{
		CurrencyEntity outObject = currencyRepository.findByCode(code);
		if (outObject == null)
		{
			throw new InvalidCodeException();
		}
		return outObject;
	}

	public CurrencyEntity findById(Integer id)
	{
		return currencyRepository.findOne(id);
	}

	public CurrencyEntity putCurrency(CurrencyEntity currency)
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
		CurrencyEntity outObject = currencyRepository.findByCode(code);
		return outObject.getRate() * amount;
	}
}
