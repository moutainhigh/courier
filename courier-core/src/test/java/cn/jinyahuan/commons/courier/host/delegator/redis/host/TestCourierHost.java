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

package cn.jinyahuan.commons.courier.host.delegator.redis.host;

import cn.jinyahuan.commons.courier.host.CourierHost;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Yahuan Jin
 * @since 0.1
 */
@Getter
@Setter
@ToString
public class TestCourierHost implements CourierHost {
    private Integer id;
    private String name;

    public TestCourierHost() {}

    public TestCourierHost(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
