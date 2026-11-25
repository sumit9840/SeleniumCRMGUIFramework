package com.crm.comcast.orgtest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseTest;

public class CreateOrgTest extends BaseTest{

		
		@Test
		public void createOrg() {
			System.out.println("execute createOrg & verify");
		}
		@Test
		public void createOrgWithIndustries() {
			System.out.println("execute createOrgWithIndustries & verify");
		}
		
		
	}



