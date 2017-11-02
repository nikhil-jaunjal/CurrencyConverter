package org.neptune.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "rate must be positive")

public class InvalidRateException extends Exceptions
{
	private static final long serialVersionUID = -3746222032820701080L;

	public InvalidRateException()
	{
		super();
	}
}
