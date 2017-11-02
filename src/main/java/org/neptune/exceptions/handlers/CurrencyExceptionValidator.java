package org.neptune.exceptions.handlers;

import org.neptune.exceptions.InvalidCodeException;
import org.neptune.exceptions.InvalidRateException;
import org.neptune.model.Currency;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CurrencyExceptionValidator
{

	@ExceptionHandler(Exception.class)
	public boolean validateCurrency(Currency currency)
	{
		if (currency.getCode().length() != 3)
		{
			throw new InvalidCodeException();
		}
		if (currency.getRate().doubleValue() <= 0)
		{
			throw new InvalidRateException();
		}
		return true;
	}

}
