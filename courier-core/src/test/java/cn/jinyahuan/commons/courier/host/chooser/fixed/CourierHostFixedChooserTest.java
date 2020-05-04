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

package cn.jinyahuan.commons.courier.host.chooser.fixed;

import cn.jinyahuan.commons.courier.host.CourierHost;
import cn.jinyahuan.commons.courier.host.chooser.CourierHostChoosable;
import cn.jinyahuan.commons.courier.host.chooser.CourierHostFixedChooser;
import cn.jinyahuan.commons.courier.host.chooser.fixed.host.OtherCourierHost;
import cn.jinyahuan.commons.courier.host.chooser.fixed.host.TestCourierHost;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * @author Yahuan Jin
 * @since 0.1
 */
public class CourierHostFixedChooserTest {
    private static final CourierHost courierHost = new TestCourierHost(1, "test");

    private CourierHostChoosable chooser;

    @Before
    public void before() {
        chooser = new CourierHostFixedChooser(courierHost);
    }

    @Test
    public void testChoose() {
        final int times = 666;
        for (int i = 0; i < times; i++) {
            assertEquals(courierHost, chooser.choose(null));
        }
    }

    @Test
    public void testGetEnableCourierHosts() {
        assertEquals(Collections.emptyList(), chooser.getEnableCourierHosts());
    }

    @Test
    public void testSetEnableCourierHosts() {
        chooser.setEnableCourierHosts(null);
        assertEquals(Collections.emptyList(), chooser.getEnableCourierHosts());

        chooser.setEnableCourierHosts(Arrays.asList(new TestCourierHost(), new OtherCourierHost()));
        assertEquals(Collections.emptyList(), chooser.getEnableCourierHosts());
    }
}