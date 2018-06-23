package org.wso2.carbon.sample.user.operation.event.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.user.core.UserStoreException;
import org.wso2.carbon.user.core.UserStoreManager;
import org.wso2.carbon.user.core.common.AbstractUserOperationEventListener;
import org.wso2.carbon.identity.core.util.IdentityUtil;

import java.util.Date;
import java.util.Map;

public class SampleUserOperationEventListener extends AbstractUserOperationEventListener {

    private static final String ACCOUNT_UNLOCK_TIME_CLAIM = "http://wso2.org/claims/identity/unlockTime";
    private static final String USER_OPERATION_EVENT_LISTENER_TYPE = "org.wso2.carbon.user.core.listener" + ".UserOperationEventListener";
    private static final Log log = LogFactory.getLog(SampleUserOperationEventListener.class);

    /**
     * The maximum time where a user account is locked in minutes
     */
    private static String MAX_ACCOUNT_LOCKED_PERIOD = "Maximum.Account.Locked.Period";

    /**
     * This listener should execute After the IdentityMgtEventListener and before the IdentityStoreEventListener
     * Hence the number should be 96 (Execution order ID of IdentityMgtEventListener is 95)
     *
     * @return 96 By default
     */
    @Override
    public int getExecutionOrderId() {

        return 96;
    }

    @Override
    public boolean doPreSetUserClaimValues(String userName, Map<String, String> claims, String profileName, UserStoreManager userStoreManager) throws UserStoreException {

        if (claims.containsKey(ACCOUNT_UNLOCK_TIME_CLAIM)) {
            String maxUnlockPeriod = IdentityUtil.readEventListenerProperty(USER_OPERATION_EVENT_LISTENER_TYPE,
                    this.getClass().getName()).getProperties().get(MAX_ACCOUNT_LOCKED_PERIOD).toString();
            Long maxUnlockPeriodMilli = Long.parseLong(maxUnlockPeriod) * 60000;     //Since the related claim is in milliseconds need to convert to milliseconds
            String currentAccountUnlockTime = claims.get(ACCOUNT_UNLOCK_TIME_CLAIM);
            if ((Long.parseLong(currentAccountUnlockTime) - System.currentTimeMillis()) > maxUnlockPeriodMilli) {
                String limitedAccountUnlockTime = String.valueOf(System.currentTimeMillis() + maxUnlockPeriodMilli);
                log.debug("Maximum user account unlock period exceeded, new unlock time is: " + new Date(Long.parseLong(limitedAccountUnlockTime)));
                claims.replace(ACCOUNT_UNLOCK_TIME_CLAIM, limitedAccountUnlockTime);
            }
        }
        return true;
    }
}