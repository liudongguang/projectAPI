package com.ldg.api.util;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties pajaxProperties = new Properties();
	private static String baseJspPath;
	static {
		ClassPathResource pajaxResource = new ClassPathResource("pajax.properties");
		try {
			pajaxProperties.load(pajaxResource.getInputStream());
			baseJspPath = pajaxProperties.getProperty("baseJspPath");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getPajaxBaseJspPath() {
		return baseJspPath;
	}


	public static void main(String[] args) {
		System.out.println(PropertiesUtil.getPajaxBaseJspPath());
	}
}
