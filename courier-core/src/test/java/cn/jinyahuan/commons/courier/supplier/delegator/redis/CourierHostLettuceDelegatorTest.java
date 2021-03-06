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

package cn.jinyahuan.commons.courier.supplier.delegator.redis;

import cn.jinyahuan.commons.courier.supplier.CourierSupplier;
import cn.jinyahuan.commons.courier.supplier.delegator.CourierSupplierDelegator;
import cn.jinyahuan.commons.courier.supplier.delegator.redis.host.OtherCourierSupplier;
import cn.jinyahuan.commons.courier.supplier.delegator.redis.host.TestCourierSupplier;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.support.ConnectionPoolSupport;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Yahuan Jin
 * @since 0.1
 */
@Ignore("local redis instance, skip ...")
@Slf4j
public class CourierHostLettuceDelegatorTest {
    private static final String IP = "192.168.8.223";
    private static final int PORT = 6379;
    private static final String AUTH = "123456";

    private static final RedisClient REDIS_CLIENT = RedisClient.create(
            RedisURI.builder()
                    .withHost(IP)
                    .withPort(PORT)
                    .withPassword(AUTH)
                    .build()
    );

    private ObjectPool<StatefulRedisConnection<String, String>> pool;
    private CourierSupplierDelegator delegator;

    @Before
    public void before() {
        pool = ConnectionPoolSupport.createGenericObjectPool(
                () -> REDIS_CLIENT.connect(),
                new GenericObjectPoolConfig()
        );
        delegator = new CourierSupplierLettuceDelegator(pool);
    }

    @After
    public void after() {
        pool.close();
    }

    @Test
    public void testAssign() throws Exception {
        final String key = CourierSupplierDelegator.DEFAULT_DELEGATOR_KEY_NAME;
        String className = String.class.getName();

        this.delRedisKey(key);

        CourierSupplier host = delegator.assign();
        assertNull(host);

        setRedisKeyValue(key, "");
        host = delegator.assign();
        assertNull(host);

        setRedisKeyValue(key, className);
        host = delegator.assign();
        assertNull(host);

        className = TestCourierSupplier.class.getName();
        setRedisKeyValue(key, className);
        host = delegator.assign();
        assertTrue(host instanceof TestCourierSupplier);

        className = OtherCourierSupplier.class.getName();
        setRedisKeyValue(key, className);
        host = delegator.assign();
        assertTrue(host instanceof OtherCourierSupplier);

        this.delRedisKey(key);
    }

    private void delRedisKey(final String key) throws Exception {
        StatefulRedisConnection<String, String> redisClient = pool.borrowObject();
        RedisCommands<String, String> commands = redisClient.sync();
        commands.del(key);
    }

    private void setRedisKeyValue(final String key, final String value) throws Exception {
        StatefulRedisConnection<String, String> redisClient = pool.borrowObject();
        RedisCommands<String, String> commands = redisClient.sync();
        commands.set(key, value);
    }
}