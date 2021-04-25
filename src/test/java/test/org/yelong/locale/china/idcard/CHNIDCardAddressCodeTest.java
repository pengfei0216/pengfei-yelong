package test.org.yelong.locale.china.idcard;

import org.yelong.locale.china.idcard.CHNIDCardAddressCode;

public class CHNIDCardAddressCodeTest {

	public static void main(String[] args) {
		String addressCodeCity = CHNIDCardAddressCode.getAddressCodeCity("110");
		System.out.println(addressCodeCity);
	}

}
