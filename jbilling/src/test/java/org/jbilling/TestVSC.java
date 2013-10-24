package org.jbilling;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.jbilling.base.TestJBillingBase;
import org.jbilling.tools.StringUtils;
import org.junit.Test;

public class TestVSC extends TestJBillingBase {

	private VSC getObjValue() {
		VSC obj = null;
		try {
			obj = new VSC(getConfigFile());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Test
	public void test_add_subscriber_nc_ok() {
		VSC obj = getObjValue();
		assertNotNull(obj);

		String msisdn = MSISDN_SUCCESS;
		String ownerCLI = "123000000001";
		String brandedResellerName = "7123";

		String errorMessage = "";
		try {
			obj.addSubscriberNC(msisdn, ownerCLI, brandedResellerName);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		assertTrue("response invalid [errorMessage:" + errorMessage + "]", StringUtils.isNullOrEmpty(errorMessage));
	}

	@Test
	public void test_add_subscriber_nc_fault() {
		VSC obj = getObjValue();
		assertNotNull(obj);

		String msisdn = MSISDN_ERROR;
		String ownerCLI = "123000000001";
		String brandedResellerName = "7123";

		String errorMessage = "";
		try {
			obj.addSubscriberNC(msisdn, ownerCLI, brandedResellerName);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		assertTrue("response invalid [errorMessage:" + errorMessage + "]", !StringUtils.isNullOrEmpty(errorMessage));
	}

	@Test
	public void test_delete_subscriber_ok() {
		VSC obj = getObjValue();
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
		VSC obj = getObjValue();
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

}
