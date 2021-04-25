package test.org.yelong.locale.china.idcard;

import org.junit.jupiter.api.Test;
import org.yelong.locale.china.idcard.CHNIDCardUtils;

/**
 * @date 2021年4月25日 下午4:38:01
 * @since 3.0.0
 */
public class CHNIDCardUtilsTest {

	@Test
	public void calculateCheckCode() {
		System.out.println(CHNIDCardUtils.calculateCheckCode("131125200102162457"));
	}

	@Test
	public void isStandardIDCard() {
		System.out.println(CHNIDCardUtils.isStandardIDCard("131125200102162457"));
	}

}
