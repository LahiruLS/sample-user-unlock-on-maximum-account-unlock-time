package org.wso2.carbon.sample.user.unlock.on.maximum.account.unlock.time;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.CarbonConstants;
import org.wso2.carbon.context.CarbonContext;
import org.wso2.carbon.user.api.Permission;
import org.wso2.carbon.user.core.UserStoreException;
import org.wso2.carbon.user.core.UserStoreManager;
import org.wso2.carbon.user.core.common.AbstractUserOperationEventListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleUserOperationEventListener extends AbstractUserOperationEventListener {

    //private static Log log = LogFactory.getLog(SampleUserOperationEventListener.class);

    private static final Log audit = CarbonConstants.AUDIT_LOG;
    private static String AUDIT_MESSAGE = "Initiator : %s | Action : %s | Target : %s ";

    @Override
    public int getExecutionOrderId() {

        //This listener should execute before the IdentityMgtEventListener
        //Hence the number should be < 1357 (Execution order ID of IdentityMgtEventListener)
        return 1356;
    }


    @Override
    public boolean doPreAuthenticate(String userName, Object credential, UserStoreManager userStoreManager) throws UserStoreException {

        //return super.doPreAuthenticate(userName, credential, userStoreManager);
        return true;
    }

    @Override
    public boolean doPreSetUserClaimValue(String userName, String claimURI, String claimValue, String profileName, UserStoreManager userStoreManager) throws UserStoreException {
        //return super.doPreSetUserClaimValue(userName, claimURI, claimValue, profileName, userStoreManager);
        return true;
    }

    @Override
    public boolean doPostSetUserClaimValue(String userName, UserStoreManager userStoreManager) throws UserStoreException {
        //return super.doPostSetUserClaimValue(userName, userStoreManager);
        return true;
    }

    @Override
    public boolean doPreSetUserClaimValues(String userName, Map<String, String> claims, String profileName, UserStoreManager userStoreManager) throws UserStoreException {
        //return super.doPreSetUserClaimValues(userName, claims, profileName, userStoreManager);
        return true;
    }

    @Override
    public boolean doPostSetUserClaimValues(String userName, Map<String, String> claims, String profileName, UserStoreManager userStoreManager) throws UserStoreException {
        //return super.doPostSetUserClaimValues(userName, claims, profileName, userStoreManager);
        return true;
    }

    @Override
    public boolean doPreGetUserClaimValue(String userName, String claim, String profileName, UserStoreManager storeManager) throws UserStoreException {
        //return super.doPreGetUserClaimValue(userName, claim, profileName, storeManager);
        return true;
    }

    @Override
    public boolean doPreGetUserClaimValues(String userName, String[] claims, String profileName, Map<String, String> claimMap, UserStoreManager storeManager) throws UserStoreException {
        //return super.doPreGetUserClaimValues(userName, claims, profileName, claimMap, storeManager);
        return true;
    }

    @Override
    public boolean doPostGetUserClaimValue(String userName, String claim, List<String> claimValue, String profileName, UserStoreManager storeManager) throws UserStoreException {
        //return super.doPostGetUserClaimValue(userName, claim, claimValue, profileName, storeManager);
        return true;
    }

    @Override
    public boolean doPostGetUserClaimValues(String userName, String[] claims, String profileName, Map<String, String> claimMap, UserStoreManager storeManager) throws UserStoreException {
        //return super.doPostGetUserClaimValues(userName, claims, profileName, claimMap, storeManager);
        return true;
    }

}
