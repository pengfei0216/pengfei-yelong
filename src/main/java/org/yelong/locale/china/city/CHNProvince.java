package org.yelong.locale.china.city;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 中国省份、自治区、直辖市
 * 
 * @date 2021年4月25日 下午2:25:36
 * @since 3.0.0
 */
public class CHNProvince extends CHNCity {

	private static final long serialVersionUID = 8519818444919496656L;

	/** 简称 */
	private final String[] shortNames;

	public CHNProvince(String name, String shortName) {
		this(shortName, null == shortName ? null : new String[] { shortName });
	}

	public CHNProvince(String name, String[] shortNames) {
		super(name);
		this.shortNames = shortNames;
	}

	public String getShortName() {
		if (ArrayUtils.isEmpty(shortNames)) {
			return null;
		}
		return shortNames[0];
	}

	public String[] getShortNames() {
		return shortNames;
	}

}
