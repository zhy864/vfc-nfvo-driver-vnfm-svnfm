/*
 * Copyright 2016-2017, Nokia Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.onap.vfc.nfvo.driver.vnfm.svnfm.msb.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.onap.vfc.nfvo.driver.vnfm.svnfm.common.bo.AdaptorEnv;
import org.onap.vfc.nfvo.driver.vnfm.svnfm.common.util.CommonUtil;
import org.onap.vfc.nfvo.driver.vnfm.svnfm.constant.CommonConstants;
import org.onap.vfc.nfvo.driver.vnfm.svnfm.http.client.HttpClientProcessorInf;
import org.onap.vfc.nfvo.driver.vnfm.svnfm.msb.bo.MsbServiceInfo;
import org.onap.vfc.nfvo.driver.vnfm.svnfm.msb.inf.IMsbMgmr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

@Component
public class MsbMgmrImpl implements IMsbMgmr {
	private static final Logger logger = LoggerFactory.getLogger(MsbMgmrImpl.class);
	
	@Autowired
	AdaptorEnv adaptorEnv;
	
	@Autowired
	HttpClientProcessorInf httpClientProcessor;
	
	private Gson gson = new Gson();
	
	@Override
	public void register() {
		
		try {
			String url = adaptorEnv.getMsbApiUriFront() + CommonConstants.MSB_REGISTER_SERVICE_PATH;
			HashMap<String, String> map = new HashMap<>();
			map.put(CommonConstants.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			
			String bodyPostStr = readVfcAdaptorInfoFromJsonFile();;
			
			String responseStr = httpClientProcessor.process(url, RequestMethod.POST, map, bodyPostStr).getContent();
			
			logger.info("MsbMgmrImpl -> register, responseStr is " + responseStr);
			
		}  catch (IOException e) {
			logger.error("IOException Failed to register nokia vnfm driver! ", e);
		} 
			
	}
	
	private String readVfcAdaptorInfoFromJsonFile() throws IOException {
        String filePath = "/etc/adapterInfo/vnfmadapterinfo.json";
		String fileContent = CommonUtil.getJsonStrFromFile(filePath);

        return fileContent;
    }

	@Override
	public void unregister() {
		try {
			String url = adaptorEnv.getMsbApiUriFront() + String.format(CommonConstants.MSB_UNREGISTER_SERVICE_PATH);
			
			String responseStr = httpClientProcessor.process(url, RequestMethod.DELETE, null, null).getContent();
			
			logger.info("MsbMgmrImpl -> unregister, responseStr is " + responseStr);
			
		}  catch (Exception e) {
			logger.error("IOException Failed to unregister nokia vnfm driver! ", e);
		}
		
	}
	
   public String getServiceUrlInMsbBySeriveNameAndVersion(String serviceName, String version) throws ClientProtocolException, IOException
   {
	   String url=adaptorEnv.getMsbApiUriFront() + String.format(CommonConstants.MSB_QUERY_SERVICE_PATH, serviceName, version);
		
		String responseStr = httpClientProcessor.process(url, RequestMethod.GET, null, null).getContent();
		logger.info("MsbMgmrImpl -> getServiceUrlInMsbBySeriveNameAndVersion, responseStr is " + responseStr);
		
		MsbServiceInfo serviceInfo = gson.fromJson(responseStr, MsbServiceInfo.class);
		if(null == serviceInfo)
		{
			   logger.error("There is no service in MSB for serviceName = {} and version = {}", serviceName, version);
		}
		
		String serviceUrl = serviceInfo.getUrl();
		logger.info("Service Url in MSB for serviceName = {} and version = {} is {}", serviceName, version, serviceUrl);
		
		return serviceUrl;
   }

	public void setAdaptorEnv(AdaptorEnv env) {
		this.adaptorEnv = env;
	}
	
	public static final void main(String[] args) {
		MsbMgmrImpl impl = new MsbMgmrImpl();
		impl.register();
	}

}
