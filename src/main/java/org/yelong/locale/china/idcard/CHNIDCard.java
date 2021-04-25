package org.yelong.locale.china.idcard;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.yelong.commons.util.Dates;
import org.yelong.organism.animal.Gender;

/**
 * 中国人民身份证号码
 * 
 * @date 2021年4月25日 下午3:10:56
 * @since 3.0.0
 */
public class CHNIDCard implements Serializable {

	private static final long serialVersionUID = 6116269591800020184L;

	/** 身份证号码长度 */
	public static final int IDCARD_LENGTH = 18;

	/** 身份证号码 */
	private final String idCard;

	/** 地址码 */
	private final String addressCode;

	/** 出生日期码 */
	private final String birthdateCode;

	/** 出生日期 */
	private final Date birthdate;

	/** 顺序码 */
	private final String sequenceCode;

	/** 性别码 */
	private final String genderCode;

	/** 性别 */
	private final Gender gender;

	/** 校验码 */
	private final String checkCode;

	/**
	 * 排除校验码的身份证号码
	 */
	private final String idCardExcludeCheckCode;

	// ==================================================constructor==================================================

	/**
	 * @param idCard 身份证号码
	 * @throws IllegalArgumentException 不符合规范的身份证号码
	 */
	public CHNIDCard(String idCard) throws IllegalArgumentException {
		if (StringUtils.isBlank(idCard)) {
			throw new IllegalArgumentException("身份证号码不能为空白");
		}
		idCard = idCard.trim();
		if (idCard.length() != IDCARD_LENGTH) {
			throw new IllegalArgumentException("身份证号码长度必须等于" + IDCARD_LENGTH);
		}
		String idCardExcludeCheckCode = idCard.substring(0, 17);
		if (!isNumber(idCardExcludeCheckCode)) {
			throw new IllegalArgumentException("身份证号码前17位必须为数字");
		}
		String checkCode = idCard.substring(17, 18);
		if (!"x".equalsIgnoreCase(checkCode) && !isNumber(checkCode)) {
			throw new IllegalArgumentException("身份证号码第18位必须为数字或者字母x");
		}
		this.idCard = idCard;
		this.addressCode = idCard.substring(0, 6);
		this.birthdateCode = idCard.substring(6, 14);
		try {
			this.birthdate = DateUtils.parseDate(birthdateCode, Dates.YYYYMMDD);
		} catch (ParseException e) {
			throw new IllegalArgumentException("出生日期" + birthdateCode + "不是一个符合规范的格式");
		}
		this.sequenceCode = idCard.substring(14, 17);
		this.genderCode = idCard.substring(16, 17);
		int genderCodeInt = Integer.valueOf(genderCode);
		this.gender = genderCodeInt % 2 == 0 ? Gender.female : Gender.male;
		this.checkCode = checkCode;
		this.idCardExcludeCheckCode = idCardExcludeCheckCode;
	}

	// ==================================================get==================================================

	/**
	 * @return 身份证号码
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @return 地址码
	 */
	public String getAddressCode() {
		return addressCode;
	}

	/**
	 * @return 出生日期码
	 */
	public String getBirthdateCode() {
		return birthdateCode;
	}

	/**
	 * @return 出生日期
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * @return 顺序码
	 */
	public String getSequenceCode() {
		return sequenceCode;
	}

	/**
	 * @return 性别码
	 */
	public String getGenderCode() {
		return genderCode;
	}

	/**
	 * @return 性别
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @return 校验码
	 */
	public String getCheckCode() {
		return checkCode;
	}

	/**
	 * @return 排除校验码的身份证号码
	 */
	public String getIdCardExcludeCheckCode() {
		return idCardExcludeCheckCode;
	}

	// ==================================================工具方法==================================================

	private static boolean isNumber(String str) {
		try {
			Long.valueOf(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
