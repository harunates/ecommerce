package tr.com.atessoft.productsrv.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AppExceptionInfo {
	public String errorCode;
	public String message;
	public String url;
	public String token;

	public AppExceptionInfo(AppException appException) {
		this.errorCode = appException.errorCode.name();
	}
}
