package org.yelong.locale.china.city;

import java.io.Serializable;

import org.yelong.commons.lang.Strings;

/**
 * 中国的城市
 * 
 * @date 2021年4月25日 下午2:24:50
 * @since 3.0.0
 */
public class CHNCity implements Serializable {

	private static final long serialVersionUID = 5485446865211765727L;

	private final String name;

	public CHNCity(String name) {
		this.name = Strings.requireNonBlank(name, "name cannot be blank");
	}

	public String getName() {
		return name;
	}

}
