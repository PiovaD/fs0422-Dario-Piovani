package com.manuelsenatore.security.security.Security;

import javax.persistence.AttributeConverter;

public class WordConverter implements AttributeConverter<String, String> {

	@Override
	public String convertToDatabaseColumn(String attribute) {
		String res = "EPICODE";
		String val = "aeiou";
		for (int i = 0; i < attribute.length(); i++) {
			if (val.contains((attribute.charAt(i) + "").toLowerCase())) {
				res += (char) (attribute.charAt(i) + 3) + "";
			}else {
				res += (char) (attribute.charAt(i) - 3) + "";
			}
		}

		return res;
	}

	@Override
	public String convertToEntityAttribute(String attribute) {
		String res = "", s2 ="EPICODE";
		String val = "aeiou";
		for (int i = s2.length(); i < attribute.length(); i++) {
			if (val.contains((attribute.charAt(i) - 3 + "").toLowerCase())) {
				res += (char) (attribute.charAt(i) - 3) + "";
			}else {
				res += (char) (attribute.charAt(i) + 3) + "";
			}
		}

		return res.replace(s2, "");
	}

}
