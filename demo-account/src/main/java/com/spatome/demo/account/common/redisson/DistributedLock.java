package com.spatome.demo.account.common.redisson;

import org.redisson.api.RLock;

public interface DistributedLock {

    RLock lock(String lockKey);

    RLock lock(String lockKey, long timeout);

    boolean tryLock(String lockKey, long waitTime, long leaseTime);

    void unlock(String lockKey);

    void unlock(RLock lock);

}
