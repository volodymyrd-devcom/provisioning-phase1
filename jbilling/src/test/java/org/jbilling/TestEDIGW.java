package org.jbilling;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.jbilling.base.TestJBillingBase;
import org.jbilling.tools.StringUtils;
import org.junit.Test;

public class TestEDIGW extends TestJBillingBase {

	private EDIGW getObjValue() {
		EDIGW obj = null;
		try {
			obj = new EDIGW(getConfigFile());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Test
	public void test_activate_ok() {
		EDIGW obj = getObjValue();
		assertNotNull(obj);

		String transactionId = "1";
		String providerId = "925";
		String providerName = "CUSTOMER1";
		String msisdn = MSISDN_SUCCESS;
		Date creationDate = new Date();
		String subscriptionId = "123000000001";
		String tariffPlan = "7123";

		String errorMessage = "";
		String responseTransactionId = "";
		try {
			responseTransactionId = obj.activate(transactionId, providerId, providerName, msisdn, creationDate, subscriptionId, tariffPlan);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		assertTrue("response invalid [errorMessage:" + errorMessage + "]", StringUtils.isNullOrEmpty(errorMessage));
		assertTrue("response invalid [transactionId:" + responseTransactionId + "]", !StringUtils.isNullOrEmpty(responseTransactionId));
	}

	@Test
	public void test_activate_fail() {
		EDIGW obj = getObjValue();
		assertNotNull(obj);

		String transactionId = "1";
		String providerId = "925";
		String providerName = "CUSTOMER1";
		String msisdn = MSISDN_ERROR;
		Date creationDate = new Date();
		String subscriptionId = "123000000001";
		String tariffPlan = "7123";

		String errorMessage = "";
		String responseTransactionId = "";
		try {
			responseTransactionId = obj.activate(transactionId, providerId, providerName, msisdn, creationDate, subscriptionId, tariffPlan);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		assertTrue("response invalid [errorMessage:" + errorMessage + "]", !StringUtils.isNullOrEmpty(errorMessage));
		assertTrue("response invalid [transactionId:" + responseTransactionId + "]", StringUtils.isNullOrEmpty(responseTransactionId));
	}

	@Test
	public void test_activate_gprs_ok() {
		EDIGW obj = getObjValue();
		assertNotNull(obj);

		String transactionId = "1";
		String providerId = "925";
		String providerName = "CUSTOMER1";
		String msisdn = MSISDN_SUCCESS;
		Date creationDate = new Date();
		String subscriptionId = "123000000001";
		String productT11 = "7123";

		String errorMessage = "";
		String responseTransactionId = "";
		try {
			responseTransactionId = obj.activateGPRS(transactionId, providerId, providerName, msisdn, creationDate, subscriptionId, productT11);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		assertTrue("response invalid [errorMessage:" + errorMessage + "]", StringUtils.isNullOrEmpty(errorMessage));
		assertTrue("response invalid [transactionId:" + responseTransactionId + "]", !StringUtils.isNullOrEmpty(responseTransactionId));
	}

	@Test
	public void test_activate_gprs_fail() {
		EDIGW obj = getObjValue();
		assertNotNull(obj);

		String transactionId = "1";
		String providerId = "925";
		String providerName = "CUSTOMER1";
		String msisdn = MSISDN_ERROR;
		Date creationDate = new Date();
		String subscriptionId = "123000000001";
		String productT11 = "7123";

		String errorMessage = "";
		String responseTransactionId = "";
		try {
			responseTransactionId = obj.activateGPRS(transactionId, providerId, providerName, msisdn, creationDate, subscriptionId, productT11);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		assertTrue("response invalid [errorMessage:" + errorMessage + "]", !StringUtils.isNullOrEmpty(errorMessage));
		assertTrue("response invalid [transactionId:" + responseTransactionId + "]", StringUtils.isNullOrEmpty(responseTransactionId));
	}

	@Test
	public void test_deactivate_ok() {
		EDIGW obj = getObjValue();
		assertNotNull(obj);

		String transactionId = "1";
		String providerId = "925";
		String providerName = "CUSTOMER1";
		String msisdn = MSISDN_SUCCESS;
		Date creationDate = new Date();
		String subscriptionId = "123000000001";

		String errorMessage = "";
		String responseTransactionId = "";
		try {
			responseTransactionId = obj.deactivate(transactionId, providerId, providerName, msisdn, creationDate, subscriptionId);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		assertTrue("response invalid [errorMessage:" + errorMessage + "]", StringUtils.isNullOrEmpty(errorMessage));
		assertTrue("response invalid [transactionId:" + responseTransactionId + "]", !StringUtils.isNullOrEmpty(responseTransactionId));
	}

	@Test
	public void test_deactivate_fail() {
		EDIGW obj = getObjValue();
		assertNotNull(obj);

		String transactionId = "1";
		String providerId = "925";
		String providerName = "CUSTOMER1";
		String msisdn = MSISDN_ERROR;
		Date creationDate = new Date();
		String subscriptionId = "123000000001";

		String errorMessage = "";
		String responseTransactionId = "";
		try {
			responseTransactionId = obj.deactivate(transactionId, providerId, providerName, msisdn, creationDate, subscriptionId);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		assertTrue("response invalid [errorMessage:" + errorMessage + "]", !StringUtils.isNullOrEmpty(errorMessage));
		assertTrue("response invalid [transactionId:" + responseTransactionId + "]", StringUtils.isNullOrEmpty(responseTransactionId));
	}

	@Test
	public void test_blocking_ok() {
		EDIGW obj = getObjValue();
		assertNotNull(obj);

		String transactionId = "1";
		String providerId = "925";
		String providerName = "CUSTOMER1";
		String msisdn = MSISDN_SUCCESS;
		Date creationDate = new Date();
		String subscriptionId = "123000000001";

		String errorMessage = "";
		String responseTransactionId = "";
		try {
			responseTransactionId = obj.blocking(transactionId, providerId, providerName, msisdn, creationDate, subscriptionId);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		assertTrue("response invalid [errorMessage:" + errorMessage + "]", StringUtils.isNullOrEmpty(errorMessage));
		assertTrue("response invalid [transactionId:" + responseTransactionId + "]", !StringUtils.isNullOrEmpty(responseTransactionId));
	}

	@Test
	public void test_blocking_fail() {
		EDIGW obj = getObjValue();
		assertNotNull(obj);

		String transactionId = "1";
		String providerId = "925";
		String providerName = "CUSTOMER1";
		String msisdn = MSISDN_ERROR;
		Date creationDate = new Date();
		String subscriptionId = "123000000001";

		String errorMessage = "";
		String responseTransactionId = "";
		try {
			responseTransactionId = obj.blocking(transactionId, providerId, providerName, msisdn, creationDate, subscriptionId);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		assertTrue("response invalid [errorMessage:" + errorMessage + "]", !StringUtils.isNullOrEmpty(errorMessage));
		assertTrue("response invalid [transactionId:" + responseTransactionId + "]", StringUtils.isNullOrEmpty(responseTransactionId));
	}

	@Test
	public void test_clearing_ok() {
		EDIGW obj = getObjValue();
		assertNotNull(obj);

		String transactionId = "1";
		String providerId = "925";
		String providerName = "CUSTOMER1";
		String msisdn = MSISDN_SUCCESS;
		Date creationDate = new Date();
		String subscriptionId = "123000000001";;

		String errorMessage = "";
		String responseTransactionId = "";
		try {
			responseTransactionId = obj.clearing(transactionId, providerId, providerName, msisdn, creationDate, subscriptionId);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		assertTrue("response invalid [errorMessage:" + errorMessage + "]", StringUtils.isNullOrEmpty(errorMessage));
		assertTrue("response invalid [transactionId:" + responseTransactionId + "]", !StringUtils.isNullOrEmpty(responseTransactionId));
	}

	@Test
	public void test_clearing_fail() {
		EDIGW obj = getObjValue();
		assertNotNull(obj);

		String transactionId = "1";
		String providerId = "925";
		String providerName = "CUSTOMER1";
		String msisdn = MSISDN_ERROR;
		Date creationDate = new Date();
		String subscriptionId = "123000000001";

		String errorMessage = "";
		String responseTransactionId = "";
		try {
			responseTransactionId = obj.clearing(transactionId, providerId, providerName, msisdn, creationDate, subscriptionId);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		assertTrue("response invalid [errorMessage:" + errorMessage + "]", !StringUtils.isNullOrEmpty(errorMessage));
		assertTrue("response invalid [transactionId:" + responseTransactionId + "]", StringUtils.isNullOrEmpty(responseTransactionId));
	}

	@Test
	public void test_net_service_change_ok() {
		EDIGW obj = getObjValue();
		assertNotNull(obj);

		String transactionId = "1";
		String providerId = "925";
		String providerName = "CUSTOMER1";
		String msisdn = MSISDN_SUCCESS;
		Date creationDate = new Date();
		String subscriptionId = "123000000001";
		int productT11Count = 1;
		String productT11 = "testProduct";

		String errorMessage = "";
		String responseTransactionId = "";
		try {
			responseTransactionId = obj.netServiceChange(transactionId, providerId, providerName, msisdn, creationDate, subscriptionId, productT11Count, productT11);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		assertTrue("response invalid [errorMessage:" + errorMessage + "]", StringUtils.isNullOrEmpty(errorMessage));
		assertTrue("response invalid [transactionId:" + responseTransactionId + "]", !StringUtils.isNullOrEmpty(responseTransactionId));
	}

	@Test
	public void test_net_service_change_fail() {
		EDIGW obj = getObjValue();
		assertNotNull(obj);

		String transactionId = "1";
		String providerId = "925";
		String providerName = "CUSTOMER1";
		String msisdn = MSISDN_ERROR;
		Date creationDate = new Date();
		String subscriptionId = "123000000001";
		int productT11Count = 1;
		String productT11 = "testProduct";

		String errorMessage = "";
		String responseTransactionId = "";
		try {
			responseTransactionId = obj.netServiceChange(transactionId, providerId, providerName, msisdn, creationDate, subscriptionId, productT11Count, productT11);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		assertTrue("response invalid [errorMessage:" + errorMessage + "]", !StringUtils.isNullOrEmpty(errorMessage));
		assertTrue("response invalid [transactionId:" + responseTransactionId + "]", StringUtils.isNullOrEmpty(responseTransactionId));
	}

	@Test
	public void test_tariff_plan_change_ok() {
		EDIGW obj = getObjValue();
		assertNotNull(obj);

		String transactionId = "1";
		String providerId = "925";
		String providerName = "CUSTOMER1";
		String msisdn = MSISDN_SUCCESS;
		Date creationDate = new Date();
		String subscriptionId = "123000000001";
		String tariffPlan = "7123";

		String errorMessage = "";
		String responseTransactionId = "";
		try {
			responseTransactionId = obj.tariffPlanChange(transactionId, providerId, providerName, msisdn, creationDate, subscriptionId, tariffPlan);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		assertTrue("response invalid [errorMessage:" + errorMessage + "]", StringUtils.isNullOrEmpty(errorMessage));
		assertTrue("response invalid [transactionId:" + responseTransactionId + "]", !StringUtils.isNullOrEmpty(responseTransactionId));
	}

	@Test
	public void test_tariff_plan_change_fail() {
		EDIGW obj = getObjValue();
		assertNotNull(obj);

		String transactionId = "1";
		String providerId = "925";
		String providerName = "CUSTOMER1";
		String msisdn = MSISDN_ERROR;
		Date creationDate = new Date();
		String subscriptionId = "123000000001";
		String tariffPlan = "7123";

		String errorMessage = "";
		String responseTransactionId = "";
		try {
			responseTransactionId = obj.tariffPlanChange(transactionId, providerId, providerName, msisdn, creationDate, subscriptionId, tariffPlan);
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		assertTrue("response invalid [errorMessage:" + errorMessage + "]", !StringUtils.isNullOrEmpty(errorMessage));
		assertTrue("response invalid [transactionId:" + responseTransactionId + "]", StringUtils.isNullOrEmpty(responseTransactionId));
	}

}
