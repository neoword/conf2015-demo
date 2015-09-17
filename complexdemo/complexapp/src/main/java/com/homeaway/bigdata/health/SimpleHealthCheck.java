/**
 *
 */
package com.homeaway.bigdata.health;

import com.codahale.metrics.health.HealthCheck;


/**
 * Simple health check that returns healthy if app is up
 */
public class SimpleHealthCheck extends HealthCheck {

    /* (non-Javadoc)
     * @see com.codahale.metrics.health.HealthCheck#check()
     */
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }

}
