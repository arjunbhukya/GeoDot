package com.accion.geodot.exception;

public class SystemException extends GeoDotServiceException
{
	private static final long serialVersionUID = -9124833711570046804L;

	public SystemException(String message)
	{
		super(message);
	}

	public SystemException(Throwable cause)
	{
		super(cause);
	}

	public SystemException(String message, Throwable cause)
	{
		super(message, cause);
	}
}