package tr.com.atessoft.productsrv.exception;

import java.util.List;

import tr.com.atessoft.productsrv.constants.ErrorCodes;

public class AppExceptionBadRequest extends AppException {

	private List<String> params;

	public AppExceptionBadRequest() {
		super(ErrorCodes.BAD_REQUEST);
	}

	public AppExceptionBadRequest(ErrorCodes errorCodes) {
		super(errorCodes);
	}

	public AppExceptionBadRequest(ErrorCodes errorCodes, List<String> params) {
		super(errorCodes);
		this.params = params;
	}

	public AppExceptionBadRequest(ErrorCodes errorCodes, Throwable e) {
		super(errorCodes, e);
	}

	public AppExceptionBadRequest(String message) {
		super(ErrorCodes.BAD_REQUEST, message);
	}

	public List<String> getParams() {
		return params;
	}
}