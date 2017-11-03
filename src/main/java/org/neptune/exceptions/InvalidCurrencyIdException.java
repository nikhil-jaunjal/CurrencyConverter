package org.neptune.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "CurrencyId must be available/positive/non-zero")

public class InvalidCurrencyIdException extends Exceptions
{
	private static final long serialVersionUID = 2743702592207820348L;

	public InvalidCurrencyIdException()
	{
		super();
	}
}
