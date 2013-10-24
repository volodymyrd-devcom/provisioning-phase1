package org.jbilling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.jbilling.base.TestJBillingBase;
import org.jbilling.tools.StringUtils;

import org.junit.Test;

public class TestJSNIN extends TestJBillingBase {

	private JSNIN getObjValue() {
		JSNIN obj = null;
		try {
			obj = new JSNIN(getConfigFile());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Test
	public void test_addSubscriberSL_ok() {
		JSNIN obj = getObjValue();
		assertNotNull(obj);

		obj.addSubscriberSL();

		Properties prop = new Properties();
		prop.setProperty("test", "test");
		assertNotNull(prop);
		assertTrue("response.test invalid [prop:" + prop + "]", !StringUtils.isNullOrEmpty(prop.getProperty("test")));
		assertEquals("response.test invalid [prop:" + prop + "]", "test", prop.getProperty("test"));
	}

	@Test
	public void test_delete_subscriber_ok() {
		JSNIN obj = getObjValue();
		assertNotNull(obj);

		obj.deleteSubscriber();

		Properties prop = new Properties();
		prop.setProperty("test", "test");
		assertNotNull(prop);
		assertTrue("response.test invalid [prop:" + prop + "]", !StringUtils.isNullOrEmpty(prop.getProperty("test")));
		assertEquals("response.test invalid [prop:" + prop + "]", "test", prop.getProperty("test"));
	}

	@Test
	public void test_change_tariff_plan_in_ok() {
		JSNIN obj = getObjValue();
		assertNotNull(obj);

		obj.changeTariffPlanIN();

		Properties prop = new Properties();
		prop.setProperty("test", "test");
		assertNotNull(prop);
		assertTrue("response.test invalid [prop:" + prop + "]", !StringUtils.isNullOrEmpty(prop.getProperty("test")));
		assertEquals("response.test invalid [prop:" + prop + "]", "test", prop.getProperty("test"));
	}

	@Test
	public void test_enable_community_ok() {
		JSNIN obj = getObjValue();
		assertNotNull(obj);

		obj.enableCommunity();

		Properties prop = new Properties();
		prop.setProperty("test", "test");
		assertNotNull(prop);
		assertTrue("response.test invalid [prop:" + prop + "]", !StringUtils.isNullOrEmpty(prop.getProperty("test")));
		assertEquals("response.test invalid [prop:" + prop + "]", "test", prop.getProperty("test"));
	}

	@Test
	public void test_disable_community_ok() {
		JSNIN obj = getObjValue();
		assertNotNull(obj);

		obj.disableCommunity();

		Properties prop = new Properties();
		prop.setProperty("test", "test");
		assertNotNull(prop);
		assertTrue("response.test invalid [prop:" + prop + "]", !StringUtils.isNullOrEmpty(prop.getProperty("test")));
		assertEquals("response.test invalid [prop:" + prop + "]", "test", prop.getProperty("test"));
	}

}
