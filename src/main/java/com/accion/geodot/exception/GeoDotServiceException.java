package com.accion.geodot.exception;

public class GeoDotServiceException extends Exception
{
	private static final long serialVersionUID = 8246505674090944831L;

	public GeoDotServiceException(String message)
	{
		super(message);
	}

	public GeoDotServiceException(Throwable cause)
	{
		super(cause);
	}

	public GeoDotServiceException(String message, Throwable cause)
	{
		super(message, cause);
	}
}