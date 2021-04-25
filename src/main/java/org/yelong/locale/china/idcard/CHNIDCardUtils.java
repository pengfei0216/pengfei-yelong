package org.yelong.locale.china.idcard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 中国身份证号工具类
 * 
 * @date 2021年4月25日 下午3:08:56
 * @since 3.0.0
 */
public final class CHNIDCardUtils {

	private CHNIDCardUtils() {
	}

	// ==================================================判断身份证号是否是规范的==================================================

	/**
	 * 判断身份证号是否是规范的
	 * 
	 * @param idcard 身份证号码
	 * @return <code>true</code> 是规范的身份证号码
	 */
	public static boolean isStandardIDCard(String idcard) {
		try {
			return isStandardIDCard(new CHNIDCard(idcard));
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	/** 身份证号码正则 */
	private static final Pattern idCardPattern = Pattern
			.compile("^(\\d{6})(19|20)(\\d{2})(1[0-2]|0[1-9])(0[1-9]|[1-2][0-9]|3[0-1])(\\d{3})(\\d|X|x)?$");

	/**
	 * 判断身份证号是否是规范的
	 * 
	 * @param idcard 身份证号码
	 * @return <code>true</code> 是规范的身份证号码
	 */
	public static boolean isStandardIDCard(CHNIDCard idCard) {
		Matcher matcher = idCardPattern.matcher(idCard.getIdCard());
		// 判断是否符合正则
		if (!matcher.matches()) {
			return false;
		}
		// 判断地址码
		String addressCode = idCard.getAddressCode();// 地址码6位，判断前两位
		if (!CHNIDCardAddressCode.isAddressCode(addressCode.substring(0, 2))) {
			return false;
		}
		// 判断校验码
		String checkCode = calculateCheckCode(idCard);
		return checkCode.equalsIgnoreCase(idCard.getCheckCode());
	}

	// ==================================================校验码==================================================

	/** 校核码系数，指身份证号每位需要乘的数值 */
	private static final int[] checkCoefficient = new int[] { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };

	private static final int[] checkCodeIntOrder = new int[] { 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

	/**
	 * 计算校核码
	 * 
	 * @param idCard 身份证号码
	 * @return 校核码
	 */
	public static String calculateCheckCode(String idCard) {
		return calculateCheckCode(new CHNIDCard(idCard));
	}

	/**
	 * 计算校核码
	 * 
	 * @param idCard 身份证号码
	 * @return 校核码
	 */
	public static String calculateCheckCode(CHNIDCard idCard) {
		int idCardWiSum = 0; // 用来保存前17位各自乖以加权因子后的总和
		String idCardExcludeCheckCode = idCard.getIdCardExcludeCheckCode();
		String[] codes = idCardExcludeCheckCode.split("");
		for (int i = 0; i < codes.length; i++) {
			idCardWiSum += Integer.valueOf(codes[i]) * checkCoefficient[i];
		}
		int idCardMod = idCardWiSum % 11;// 计算出校验码所在数组的位置
		int checkCodeInt = checkCodeIntOrder[idCardMod];
		return checkCodeInt == 10 ? "x" : checkCodeInt + "";
	}

}
