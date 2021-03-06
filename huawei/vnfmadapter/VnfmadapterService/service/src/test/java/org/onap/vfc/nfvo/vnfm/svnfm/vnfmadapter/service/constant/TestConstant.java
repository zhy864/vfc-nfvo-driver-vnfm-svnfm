/*
 * Copyright 2017 Huawei Technologies Co., Ltd.
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
package org.onap.vfc.nfvo.vnfm.svnfm.vnfmadapter.service.constant;

import junit.framework.Assert;
import org.junit.Test;
import org.onap.vfc.nfvo.vnfm.svnfm.vnfmadapter.service.constant.ParamConstants;
import org.onap.vfc.nfvo.vnfm.svnfm.vnfmadapter.service.constant.UrlConstant;

import static org.onap.vfc.nfvo.vnfm.svnfm.vnfmadapter.service.constant.Constant.AUTHLIST;

import java.util.List;

/**
 * Created by QuanZhong on 2017/3/17.
 */
public class TestConstant {
    @Test
    public void testCreate(){
        List<String> authlist = AUTHLIST;
        authlist.contains("abc");
        String url = UrlConstant.PORT_COMMON;
        authlist.contains(url);
        String abc = ParamConstants.CONNECTMGR_CONNECT;
        authlist.contains(abc);
        Assert.assertTrue(true);
    }
}
