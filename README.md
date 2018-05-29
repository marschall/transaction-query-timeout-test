Test for verifications that the transaction timeout is properly propagated to the query timeout

The application can be found under:

* http://127.0.0.1:8080/query-timeout/tx
* http://127.0.0.1:8080/query-timeout/no-tx


```xml
                    <timeout>
                        <set-tx-query-timeout>true</set-tx-query-timeout> 
                        <query-timeout>300</query-timeout>
                    </timeout>
```


```xml
        <subsystem xmlns="urn:jboss:domain:transactions:4.0">
            <core-environment>
                <process-id>
                    <uuid/>
                </process-id>
            </core-environment>
            <recovery-environment socket-binding="txn-recovery-environment" status-socket-binding="txn-status-manager"/>
            <coordinator-environment default-timeout="300"/>
            <object-store path="tx-object-store" relative-to="jboss.server.data.dir"/>
        </subsystem>
```

