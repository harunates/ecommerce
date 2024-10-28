package tr.com.atessoft.productsrv.utils;

import jakarta.servlet.http.HttpServletRequest;

public class IPUtils {

	public static String getRemoteIP(HttpServletRequest request) {
		String xForwarded = request.getHeader("X-Forwarded-For"); // google load balancer
		try {
			if (xForwarded != null)
				return xForwarded.split(",")[0];
		} catch (Exception e) {
		}

		String realIP = request.getHeader("X-Real-IP");
		return realIP != null ? realIP : request.getRemoteAddr();
	}
}
