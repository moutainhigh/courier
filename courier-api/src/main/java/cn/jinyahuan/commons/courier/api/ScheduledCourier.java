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

package cn.jinyahuan.commons.courier.api;

import cn.jinyahuan.commons.courier.api.model.RequestAttribute;
import cn.jinyahuan.commons.courier.api.model.ResponseAttribute;

/**
 * 定时操作的信使。
 *
 * @author Yahuan Jin
 * @since 0.1
 */
public interface ScheduledCourier extends Courierable {
    /**
     * 派送定时的信件。
     *
     * @param requestAttribute
     * @return
     */
    default ResponseAttribute sendScheduled(RequestAttribute requestAttribute) {
        throw new UnsupportedOperationException();
    }

    /**
     * 查询定时的信件。
     *
     * @param requestAttribute
     * @return
     */
    default ResponseAttribute queryScheduled(RequestAttribute requestAttribute) {
        throw new UnsupportedOperationException();
    }
}