package com.rodrigo.barbosa.curso.springboot.mongodb.recursos.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

	public static String decodeParam(String valor) {
		try {
			return URLDecoder.decode(valor, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
