package org.neptune.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "invalid code lenght, code length must be 3")
public class InvalidCodeException extends Exceptions
{
	private static final long serialVersionUID = -8907935638865226580L;

	public InvalidCodeException()
	{
		super();
	}
}
