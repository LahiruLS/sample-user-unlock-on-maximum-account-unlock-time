# User operation event listener to unlock a locked user on a maximum account unlock time 
##sample-user-unlock-on-maximum-account-unlock-time
This code repository contains a sample maven project that demonstrates how to use a user operation event listener to
unlock a locked user on a maximum account unlock time on  WSO2 IS 5.4.1.

##Instructions to use

1. Built the maven project using `mvn clean install`

2. Copy the `org.wso2.carbon.sample.user.operation.event.listener-1.0.0.jar` file from the target folder and place it in `<CARBON_HOME>/repository/epository/components/dropins/` folder.

3. Edit the `/repository/conf/identity/identity.xml` file and add the following lines under the `<EventListners>` tag.

`<EventListener type="org.wso2.carbon.user.core.listener.UserOperationEventListener" name="org.wso2.carbon.sample.user.operation.event.listener.SampleUserOperationEventListener" orderId="96" enable="true">`
`<Property name="Maximum.Account.Locked.Period">10</Property>`
`</EventListener>`

What your project does
How to install it
Example usage
How to set up the dev environment
How to ship a change
Change log
License and author info