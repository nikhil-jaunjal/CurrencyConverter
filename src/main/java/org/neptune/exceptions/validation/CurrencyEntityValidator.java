package org.neptune.exceptions.validation;

import org.neptune.exceptions.InvalidAmountException;
import org.neptune.exceptions.InvalidCodeException;
import org.neptune.exceptions.InvalidCurrencyIdException;
import org.neptune.exceptions.InvalidRateException;
import org.neptune.model.CurrencyEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CurrencyEntityValidator
{
	@ExceptionHandler(Exception.class)
	public boolean validateCurrencyForPost(CurrencyEntity currency)
	{
		checkCodeLength(currency.getCode());
		checkRate(currency.getRate());
		return true;
	}

	public boolean validateCurrencyForPut(CurrencyEntity currency)
	{
		checkCurrencyId(currency.getCurrencyId());
		checkCodeLength(currency.getCode());
		checkRate(currency.getRate());
		return true;
	}

	public void checkCurrencyId(Integer id)
	{
		if (id.intValue() <= 0 || id == null)
		{
			throw new InvalidCurrencyIdException();
		}
	}

	public void checkCodeLength(String code)
	{
		if (code.length() != 3)
		{
			throw new InvalidCodeException();
		}
	}

	public void checkRate(Double value)
	{
		if (value.doubleValue() <= 0)
		{
			throw new InvalidRateException();
		}
	}

	public void checkAmount(Double value)
	{
		if (value.doubleValue() <= 0)
		{
			throw new InvalidAmountException();
		}
	}
}
