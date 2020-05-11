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

package cn.jinyahuan.commons.courier.host.delegator;

import cn.jinyahuan.commons.courier.api.model.CourierRequest;
import cn.jinyahuan.commons.courier.host.CourierHost;

/**
 * No-Operation courier host delegator.
 *
 * @author Yahuan Jin
 * @since 0.1
 */
public class CourierHostNoOpDelegator implements CourierHostDelegate {
    private static final long serialVersionUID = 1L;

    @Override
    public CourierHost assign() {
        return null;
    }

    @Override
    public CourierHost assign(String key) {
        return null;
    }

    @Override
    public CourierHost assign(CourierRequest request) {
        return null;
    }

    @Override
    public CourierHost assign(String key, CourierRequest request) {
        return null;
    }
}
