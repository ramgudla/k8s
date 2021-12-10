package com.k8s;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IpController {

	@GetMapping(path = "/ip")
	public ResponseModel getIp() throws UnknownHostException {
		InetAddress inetAddress = InetAddress.getLocalHost();
		return new ResponseModel(inetAddress.getHostAddress(), inetAddress.getHostName());
	}

	private class ResponseModel {
		private final String ip;
		private final String hostname;

		public ResponseModel(final String ip, final String hostname) {
			this.ip = ip;
			this.hostname = hostname;
		}

		public String getIp() {
			return ip;
		}

		public String getHostname() {
			return hostname;
		}
	}
	
}
