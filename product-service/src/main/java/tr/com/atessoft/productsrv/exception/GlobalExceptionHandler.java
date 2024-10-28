package tr.com.atessoft.productsrv.exception;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tr.com.atessoft.productsrv.constants.ErrorCodes;

@ControllerAdvice
public class GlobalExceptionHandler {
	private Logger LOG = Logger.getLogger(getClass().getName());

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private LocaleResolver localeResolver;

	@ExceptionHandler(AppExceptionInternalError.class)
	public @ResponseBody AppExceptionInfo handleExceptionInternalError(HttpServletResponse response, Exception ex,
			HttpServletRequest request) {
		AppException appException = (AppException) ex;
		AppExceptionInfo appExceptionInfo = getAppExceptionInfo(appException, null, request);
		response.setStatus(500);
		return appExceptionInfo;
	}

	@ExceptionHandler(AppExceptionBadRequest.class)
	public @ResponseBody AppExceptionInfo handleAppExceptionBadRequest(HttpServletResponse response, Exception ex,
			HttpServletRequest request) {
		AppExceptionBadRequest appException = (AppExceptionBadRequest) ex;
		AppExceptionInfo appExceptionInfo = getAppExceptionInfo(appException,
				appException.getParams() != null ? appException.getParams().toArray() : null, request);
		response.setStatus(400);
		return appExceptionInfo;
	}

	@ExceptionHandler(AppExceptionNotFound.class)
	public @ResponseBody AppExceptionInfo handleAppExceptionNotFound(HttpServletResponse response, Exception ex,
			HttpServletRequest request) {
		AppException appException = (AppException) ex;
		AppExceptionInfo appExceptionInfo = getAppExceptionInfo(appException, null, request);
		response.setStatus(404);
		return appExceptionInfo;
	}

	@ExceptionHandler(Throwable.class)
	public @ResponseBody AppExceptionInfo handleThrowableError(HttpServletResponse response, Exception ex,
			HttpServletRequest request) {
		if (isRestrictedLogs(ex))
			return null; // (2) socket is closed, cannot return any response

		String rootCauseMessage = ExceptionUtils.getRootCauseMessage(ex);

		Logger.getLogger(getClass().getName()).log(Level.SEVERE,
				"INTERNAL_ERROR catched! Path: " + request.getRequestURI() + " rootCauseMessage: " + rootCauseMessage
						+ " exc_message: " + ex.getMessage(),
				ex);
		AppExceptionInfo appExceptionInfo = getAppExceptionInfo(
				new AppExceptionInternalError(ErrorCodes.INTERNAL_ERROR), null, request);
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		return appExceptionInfo;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle(NoHandlerFoundException ex) {

		return "404";
	}

	private boolean isRestrictedLogs(Exception ex) {
		List<String> errors = Arrays.asList("Broken pipe", "Unexpected EOF read on the socket");
		for (String err : errors) {
			if (StringUtils.containsIgnoreCase(ExceptionUtils.getRootCauseMessage(ex), err)
					|| StringUtils.containsIgnoreCase(ex.getMessage(), err))
				return true;
		}
		return false;
	}

	private AppExceptionInfo getAppExceptionInfo(AppException appException, Object[] params,
			HttpServletRequest request) {
		AppExceptionInfo appExceptionInfo = new AppExceptionInfo(appException);
		try {
			if (appException.message != null)
				appExceptionInfo.message = appException.message;
			else
				appExceptionInfo.message = messageSource.getMessage(appExceptionInfo.errorCode, params,
						localeResolver.resolveLocale(request));
		} catch (NoSuchMessageException e) {
			appExceptionInfo.message = appExceptionInfo.errorCode;
		}
		return appExceptionInfo;
	}
}
