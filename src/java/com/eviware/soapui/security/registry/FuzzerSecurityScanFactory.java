/*
 *  soapUI, copyright (C) 2004-2011 eviware.com 
 *
 *  soapUI is free software; you can redistribute it and/or modify it under the 
 *  terms of version 2.1 of the GNU Lesser General Public License as published by 
 *  the Free Software Foundation.
 *
 *  soapUI is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without 
 *  even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 *  See the GNU Lesser General Public License for more details at gnu.org.
 */

package com.eviware.soapui.security.registry;

import com.eviware.soapui.config.SecurityCheckConfig;
import com.eviware.soapui.impl.wsdl.teststeps.HttpTestRequestStep;
import com.eviware.soapui.impl.wsdl.teststeps.RestTestRequestStep;
import com.eviware.soapui.impl.wsdl.teststeps.WsdlTestRequestStep;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.model.testsuite.TestStep;
import com.eviware.soapui.security.scan.AbstractSecurityScan;
import com.eviware.soapui.security.scan.FuzzerSecurityScan;

/**
 * Factory for creation Fuzzer scan
 * 
 * @author nebojsa.tasic
 */

public class FuzzerSecurityScanFactory extends AbstractSecurityCheckFactory
{

	public FuzzerSecurityScanFactory()
	{
		super( FuzzerSecurityScan.TYPE, FuzzerSecurityScan.NAME, "Executes the specified fuzzer security scan",
				"/fuzzer_security_scan.gif" );
	}

	@Override
	public SecurityCheckConfig createNewSecurityScan( String name )
	{
		SecurityCheckConfig securityCheckConfig = SecurityCheckConfig.Factory.newInstance();
		securityCheckConfig.setType( FuzzerSecurityScan.TYPE );
		securityCheckConfig.setName( name );
		return securityCheckConfig;
	}

	@Override
	public AbstractSecurityScan buildSecurityScan( TestStep testStep, SecurityCheckConfig config, ModelItem parent )
	{
		return new FuzzerSecurityScan( testStep, config, parent, null );
	}

	@Override
	public boolean canCreate( TestStep testStep )
	{
		return testStep instanceof WsdlTestRequestStep || testStep instanceof RestTestRequestStep
				|| testStep instanceof HttpTestRequestStep;
	}
}