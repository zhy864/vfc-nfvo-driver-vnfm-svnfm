/*
* Copyright 2016-2017 Nokia Corporation
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
package org.onap.vfc.nfvo.driver.vnfm.svnfm.cbam.bo.entity;
import java.io.Serializable;

public enum VimInfoType implements Serializable{

	OPENSTACK_V2_INFO  {
		private OpenstackV2Info openstackv2;

	},
	OPENSTACK_V3_INFO{
		private OpenstackV3Info openstackv3;
	},
	VMWARE_VCLOUD_INFO{
		private VmwareVcloudInfo vmwareInfo;
	},
	OTHER_VIM_INFO{
		private OtherVimInfo other;
	}

}
