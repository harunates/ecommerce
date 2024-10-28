package tr.com.atessoft.productsrv.exception;

import tr.com.atessoft.productsrv.constants.ErrorCodes;

public class AppExceptionNotFound extends AppException {
	public AppExceptionNotFound() {
		super(ErrorCodes.NOT_FOUND);
	}

	public AppExceptionNotFound(ErrorCodes errorCodes) {
		super(errorCodes);
	}

	public AppExceptionNotFound(ErrorCodes errorCodes, Throwable e) {
		super(errorCodes, e);
	}

	public AppExceptionNotFound(String message) {
		super(ErrorCodes.NOT_FOUND);
		this.message = message;
	}

}
