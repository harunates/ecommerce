package tr.com.atessoft.productsrv.exception;

import tr.com.atessoft.productsrv.constants.ErrorCodes;

public abstract class AppException extends Exception {
	public ErrorCodes errorCode;
	public String message;

	public AppException(ErrorCodes errorCode) {
		this.errorCode = errorCode;
	}

	public AppException(ErrorCodes errorCode, String message) {
		super(message);
		this.message = message;
		this.errorCode = errorCode;
	}

	public AppException(ErrorCodes errorCode, Throwable e) {
		this(errorCode);
		initCause(e);
	}
}
