package com.rodrigo.barbosa.curso.springboot.mongodb.recursos.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {

	public static String decodeParam(String valor) {
		try {
			return URLDecoder.decode(valor, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static Date converteData(String data, Date defaultValue) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		try {
			return sdf.parse(data);
		} catch (ParseException e) {
			return defaultValue;
		}
	}
}
