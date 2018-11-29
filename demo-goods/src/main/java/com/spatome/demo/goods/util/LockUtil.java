package com.spatome.demo.goods.util;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockUtil {

	public static final Lock prizeBalanceLock = new ReentrantLock();

}
