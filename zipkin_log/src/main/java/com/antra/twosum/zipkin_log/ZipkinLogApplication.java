package com.antra.twosum.zipkin_log;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZipkinLogApplication {

	public static void main(String[] args) {
		System.out.println("Zipkin should be started from docker at 9411");
	}

}
