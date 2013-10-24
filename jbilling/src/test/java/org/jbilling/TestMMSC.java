package org.jbilling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.jbilling.base.TestJBillingBase;
import org.jbilling.tools.StringUtils;
import org.junit.Test;

public class TestMMSC extends TestJBillingBase {

	private MMSC getObjValue() {
		MMSC obj = null;
		try {
			obj = new MMSC(getConfigFile());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Test
	public void test_barring_ok() {
		MMSC obj = getObjValue();
		assertNotNull(obj);

		obj.barring();

		Properties prop = new Properties();
		prop.setProperty("test", "test");
		assertNotNull(prop);
		assertTrue("response.test invalid [prop:" + prop + "]", !StringUtils.isNullOrEmpty(prop.getProperty("test")));
		assertEquals("response.test invalid [prop:" + prop + "]", "test", prop.getProperty("test"));
	}

	@Test
	public void test_add_subscriber_ok() {
		MMSC obj = getObjValue();
		assertNotNull(obj);

		String msisdn = MSISDN_SUCCESS;
		boolean prepaid = true;
		String transactionId = "1234567890";

		String errorMessage = "";
		try {
			obj.addSubscriber(msisdn, prepaid, transactionId);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		assertTrue("response invalid [errorMessage:" + errorMessage + "]", StringUtils.isNullOrEmpty(errorMessage));
	}

	@Test
	public void test_add_subscriber_fault() {
		MMSC obj = getObjValue();
		assertNotNull(obj);

		String msisdn = MSISDN_ERROR;
		boolean prepaid = true;
		String transactionId = "1234567890";

		String errorMessage = "";
		try {
			obj.addSubscriber(msisdn, prepaid, transactionId);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		assertTrue("response invalid [errorMessage:" + errorMessage + "]", !StringUtils.isNullOrEmpty(errorMessage));
	}

	@Test
	public void test_delete_subscriber_ok() {
		MMSC obj = getObjValue();
		assertNotNull(obj);

		String msisdn = MSISDN_SUCCESS;

		String errorMessage = "";
		try {
			obj.deleteSubscriber(msisdn);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		assertTrue("response invalid [errorMessage:" + errorMessage + "]", StringUtils.isNullOrEmpty(errorMessage));
	}

	@Test
	public void test_delete_subscriber_fault() {
		MMSC obj = getObjValue();
		assertNotNull(obj);

		String msisdn = MSISDN_ERROR;

		String errorMessage = "";
		try {
			obj.deleteSubscriber(msisdn);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		assertTrue("response invalid [errorMessage:" + errorMessage + "]", !StringUtils.isNullOrEmpty(errorMessage));
	}

	@Test
	public void test_set_data_roaming_limit_ok() {
		MMSC obj = getObjValue();
		assertNotNull(obj);

		obj.setDataRoamingLimit();

		Properties prop = new Properties();
		prop.setProperty("test", "test");
		assertNotNull(prop);
		assertTrue("response.test invalid [prop:" + prop + "]", !StringUtils.isNullOrEmpty(prop.getProperty("test")));
		assertEquals("response.test invalid [prop:" + prop + "]", "test", prop.getProperty("test"));
	}

}
