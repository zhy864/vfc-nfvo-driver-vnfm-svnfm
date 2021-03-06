
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

package org.onap.vfc.nfvo.driver.vnfm.svnfm.cbam.bo;

import java.util.List;

import org.onap.vfc.nfvo.driver.vnfm.svnfm.cbam.bo.entity.ExtManagedVirtualLinkData;
import org.onap.vfc.nfvo.driver.vnfm.svnfm.cbam.bo.entity.ExtVirtualLinkData;
import org.onap.vfc.nfvo.driver.vnfm.svnfm.cbam.bo.entity.VimComputeResourceFlavour;
import org.onap.vfc.nfvo.driver.vnfm.svnfm.cbam.bo.entity.VimInfo;
import org.onap.vfc.nfvo.driver.vnfm.svnfm.cbam.bo.entity.VimSoftwareImage;
import org.onap.vfc.nfvo.driver.vnfm.svnfm.cbam.bo.entity.ZoneInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CBAMInstantiateVnfRequest {
	@JsonProperty("instantiationLevelId")
	private String instantiationLevelId;
	
	@JsonProperty("flavourId")
	private String flavourId;
	
	@JsonProperty("vims")
	private List<VimInfo> vims;
	
	@JsonProperty("extVirtualLinks")
	private List<ExtVirtualLinkData> extVirtualLinks;
	
	@JsonProperty("extManagedVirtualLinks")
	private List<ExtManagedVirtualLinkData> extManagedVirtualLinks;
	
	@JsonProperty("grantlessMode")
	private boolean grantlessMode;
	
	@JsonProperty("softwareImages")
	private List<VimSoftwareImage> softwareImages;
	
	@JsonProperty("additionalParams")
	private Object additionalParams;
	
	@JsonProperty("computeResourceFlavours")
	private List<VimComputeResourceFlavour> computeResourceFlavours;
	
	@JsonProperty("zones")
	private List<ZoneInfo> zones;

	public String getFlavourId() {
		return flavourId;
	}

	public void setFlavourId(String flavourId) {
		this.flavourId = flavourId;
	}

	

	public List<VimInfo> getVims() {
		return vims;
	}

	public void setVims(List<VimInfo> vims) {
		this.vims = vims;
	}

	public List<ExtVirtualLinkData> getExtVirtualLinks() {
		return extVirtualLinks;
	}

	public void setExtVirtualLinks(List<ExtVirtualLinkData> extVirtualLinks) {
		this.extVirtualLinks = extVirtualLinks;
	}

	public List<ExtManagedVirtualLinkData> getExtManagedVirtualLinks() {
		return extManagedVirtualLinks;
	}

	public void setExtManagedVirtualLinks(List<ExtManagedVirtualLinkData> extManagedVirtualLinks) {
		this.extManagedVirtualLinks = extManagedVirtualLinks;
	}

	public boolean isGrantlessMode() {
		return grantlessMode;
	}

	public void setGrantlessMode(boolean grantlessMode) {
		this.grantlessMode = grantlessMode;
	}

	public List<VimSoftwareImage> getSoftwareImages() {
		return softwareImages;
	}

	public void setSoftwareImages(List<VimSoftwareImage> softwareImages) {
		this.softwareImages = softwareImages;
	}

	public Object getAdditionalParams() {
		return additionalParams;
	}

	public void setAdditionalParams(Object additionalParams) {
		this.additionalParams = additionalParams;
	}

	public List<VimComputeResourceFlavour> getComputeResourceFlavours() {
		return computeResourceFlavours;
	}

	public void setComputeResourceFlavours(List<VimComputeResourceFlavour> computeResourceFlavours) {
		this.computeResourceFlavours = computeResourceFlavours;
	}

	public List<ZoneInfo> getZones() {
		return zones;
	}

	public void setZones(List<ZoneInfo> zones) {
		this.zones = zones;
	}

	public String getInstantiationLevelId() {
		return instantiationLevelId;
	}

	public void setInstantiationLevelId(String instantiationLevelId) {
		this.instantiationLevelId = instantiationLevelId;
	}
	
	
	
	
	
	


	
	
	

}
