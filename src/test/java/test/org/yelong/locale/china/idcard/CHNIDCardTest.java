package test.org.yelong.locale.china.idcard;

import org.yelong.locale.china.idcard.CHNIDCard;
import org.yelong.test.ObjectTests;

public class CHNIDCardTest {

	public static void main(String[] args) {
		CHNIDCard idCard = new CHNIDCard("1311252001021624a7");
		ObjectTests.printAllField(idCard);
	}

}
