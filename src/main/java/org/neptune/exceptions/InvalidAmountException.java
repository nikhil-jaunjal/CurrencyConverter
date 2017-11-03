package org.neptune.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "amount must be positive and non-zero")
public class InvalidAmountException extends Exceptions
{
	private static final long serialVersionUID = 3662391296424075854L;

	public InvalidAmountException()
	{
		super();
	}
}
