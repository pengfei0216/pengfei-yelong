package org.yelong.locale.china.idcard;

import org.apache.commons.lang3.StringUtils;
import org.yelong.commons.util.BothwayMap;

/**
 * 中国身份证号码地址码
 * 
 * @date 2021年4月25日 下午2:51:16
 * @since 3.0.0
 */
public final class CHNIDCardAddressCode {

	private static final BothwayMap<String, String> addressCodeMap = new BothwayMap<>();

	static {
		addressCodeMap.add("11", "北京");
		addressCodeMap.add("12", "天津");
		addressCodeMap.add("13", "河北");
		addressCodeMap.add("14", "山西");
		addressCodeMap.add("15", "内蒙古");

		addressCodeMap.add("21", "辽宁");
		addressCodeMap.add("22", "吉林");
		addressCodeMap.add("23", "黑龙江");

		addressCodeMap.add("31", "上海");
		addressCodeMap.add("32", "江苏");
		addressCodeMap.add("33", "浙江");
		addressCodeMap.add("34", "安徽");
		addressCodeMap.add("35", "福建");
		addressCodeMap.add("36", "江西");

		addressCodeMap.add("37", "山东");

		addressCodeMap.add("41", "河南");
		addressCodeMap.add("42", "湖北");
		addressCodeMap.add("43", "湖南");
		addressCodeMap.add("44", "广东");
		addressCodeMap.add("45", "广西");
		addressCodeMap.add("46", "海南");

		addressCodeMap.add("50", "重庆");
		addressCodeMap.add("51", "四川");
		addressCodeMap.add("52", "贵州");
		addressCodeMap.add("53", "云南");
		addressCodeMap.add("54", "西藏");

		addressCodeMap.add("61", "陕西");
		addressCodeMap.add("62", "甘肃");
		addressCodeMap.add("63", "青海");
		addressCodeMap.add("64", "宁夏");
		addressCodeMap.add("65", "新疆");

		addressCodeMap.add("71", "台湾");
		addressCodeMap.add("81", "香港");
		addressCodeMap.add("82", "澳门");
		addressCodeMap.add("91", "国外");
	}

	private CHNIDCardAddressCode() {
	}

	/**
	 * 判断地址编码是否是正规的编码
	 * 
	 * @param addressCode 地址编码
	 * @return <code>true</code> 地址编码是正规的编码
	 */
	public static boolean isAddressCode(String addressCode) {
		return getAddressCodeCity(addressCode) != null;
	}

	/**
	 * 获取地址编码对应的地区
	 * 
	 * @param addressCode 地址编码
	 * @return 地址编码对应的地区
	 */
	public static String getAddressCodeCity(String addressCode) {
		if (StringUtils.isBlank(addressCode)) {
			return null;
		}
		addressCode = addressCode.trim();
		if (addressCode.length() < 2) {
			return null;
		}
		return addressCodeMap.getRight(addressCode.substring(0, 2));
	}

}
