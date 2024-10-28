package tr.com.atessoft.productsrv.exception;

import tr.com.atessoft.productsrv.constants.ErrorCodes;

public class AppExceptionInternalError extends AppException {
	public AppExceptionInternalError() {
		this(ErrorCodes.INTERNAL_ERROR);
	}

	public AppExceptionInternalError(ErrorCodes errorCodes) {
		super(errorCodes);
	}

	public AppExceptionInternalError(ErrorCodes errorCodes, Throwable e) {
		super(errorCodes, e);
	}
}
