/*
 * Copyright (c) 2020 The Courier Authors
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

package cn.jinyahuan.commons.courier.host.vacancy;

import cn.jinyahuan.commons.courier.api.Courier;
import cn.jinyahuan.commons.courier.api.model.ResponseAttribute;
import cn.jinyahuan.commons.courier.api.state.ServiceUnavailableResponse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Yahuan Jin
 * @see StatefulVacancyCourier_ResponseServiceUnavailableState_Test
 * @see VacancyCourier_ThrowException_Test
 * @since 0.1
 */
public class VacancyCourier_DefaultStrategy_Test {
    private Courier courier;
    private static final ResponseAttribute SERVICE_UNAVAILABLE_RESPONSE = new ServiceUnavailableResponse();

    @Before
    public void before() {
        courier = new VacancyCourier();
    }

    @Test
    public void testSend() {
        ResponseAttribute response = courier.send(null);
        assertEquals(SERVICE_UNAVAILABLE_RESPONSE, response);
    }

    @Test
    public void testQuery() {
        ResponseAttribute response = courier.query(null);
        assertEquals(SERVICE_UNAVAILABLE_RESPONSE, response);
    }

    @Test
    public void testSendAsync() {
        ResponseAttribute response = courier.sendAsync(null);
        assertEquals(SERVICE_UNAVAILABLE_RESPONSE, response);
    }

    @Test
    public void testSendBatch() {
        ResponseAttribute response = courier.sendBatch(null);
        assertEquals(SERVICE_UNAVAILABLE_RESPONSE, response);
    }

    @Test
    public void testQueryBatch() {
        ResponseAttribute response = courier.queryBatch(null);
        assertEquals(SERVICE_UNAVAILABLE_RESPONSE, response);
    }

    @Test
    public void testSendScheduled() {
        ResponseAttribute response = courier.sendScheduled(null);
        assertEquals(SERVICE_UNAVAILABLE_RESPONSE, response);
    }

    @Test
    public void testQueryScheduled() {
        ResponseAttribute response = courier.queryScheduled(null);
        assertEquals(SERVICE_UNAVAILABLE_RESPONSE, response);
    }
}