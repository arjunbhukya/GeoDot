package com.accion.geodot.exception;

public class NotFoundException extends GeoDotServiceException
{
	private static final long serialVersionUID = 2089496881163082962L;

	public NotFoundException(String message)
	{
		super(message);
	}

	public NotFoundException(Throwable cause)
	{
		super(cause);
	}

	public NotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
