# Testing MVND

Using mvnd to compile and run tests faster.


## Install using SDKMAN

```
$ curl -s "https://get.sdkman.io" | bash
```

```
$ sdk install mvnd
```

## Install using Homebrew
```
$ brew install mvndaemon/homebrew-mvnd/mvnd
```

## Environment information

All tests were executed on my local machine, so there are other process running at same time.
I know that could shuffle test results sometimes.

Here is my local environment setup:

Configuration file content: `~/.m2/mvnd.properties`
```
java.home = /Users/iklassman/.sdkman/candidates/java/current/
mvnd.minThreads = 5
mvnd.threads = 15
mvnd.minHeapSize = 2G
mvnd.keepAlive = 10000
mvnd.maxLostKeepAlive = 120
```

```
$ java -version

openjdk version "1.8.0_322"
OpenJDK Runtime Environment Corretto-8.322.06.1 (build 1.8.0_322-b06)
OpenJDK 64-Bit Server VM Corretto-8.322.06.1 (build 25.322-b06, mixed mode)
```

```
$ mvnd -version

mvnd 0.8.0 darwin-amd64 native client (2cfffe23eebac7a0fddecf0268478ae963a8859f)
Terminal: org.jline.terminal.impl.PosixSysTerminal with pty org.jline.terminal.impl.jansi.osx.OsXNativePty
Apache Maven 3.8.5 (3599d3414f046de2324203b78ddcf9b5e4388aa0)
Maven home: /Users/iklassman/.sdkman/candidates/mvnd/current/mvn
Java version: 1.8.0_322, vendor: Amazon.com Inc., runtime: /Users/iklassman/.sdkman/candidates/java/8.322.06.1-amzn/jre
Default locale: en_BR, platform encoding: UTF-8
OS name: "mac os x", version: "11.6.5", arch: "x86_64", family: "mac"
```


## Testing https://github.tlcinternal.com/LendingClub/lc-bank-operations

### Running with Maven

```
$ mvn clean install
```

Usually the command is taking around `04:20 min`.
See output of summary below:

```
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO]
[INFO] build-tools 269.0-SNAPSHOT ......................... SUCCESS [  1.938 s]
[INFO] lc-bops 269.0-SNAPSHOT ............................. SUCCESS [  2.679 s]
[INFO] lc-bank-operations-api 269.0-SNAPSHOT .............. SUCCESS [  0.037 s]
[INFO] lc-bank-operations-api-model 266.0 ................. SUCCESS [  9.243 s]
[INFO] lc-bank-operations-api-client 266.0 ................ SUCCESS [ 13.745 s]
[INFO] lc-bank-operations-domain 269.0-SNAPSHOT ........... SUCCESS [ 10.059 s]
[INFO] lc-bank-operations-service 269.0-SNAPSHOT .......... SUCCESS [ 24.769 s]
[INFO] lc-bank-operations-server 269.0-SNAPSHOT ........... SUCCESS [02:51 min]
[INFO] lc-bank-operations-batch 269.0-SNAPSHOT ............ SUCCESS [ 22.581 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  04:17 min
[INFO] Finished at: 2022-05-31T23:27:53-03:00
[INFO] ------------------------------------------------------------------------
```

### Running with Maven Daemon

```
$ mvnd clean install
```

Using mvnd to compile and run tests, we're getting better results in matter of time.

Running for the first time we got `02:56 min`, witch means almost half time of `mvn clean install` command.

```
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO]
[INFO] build-tools 269.0-SNAPSHOT ......................... SUCCESS [  0.232 s]
[INFO] lc-bops 269.0-SNAPSHOT ............................. SUCCESS [  0.154 s]
[INFO] lc-bank-operations-api 269.0-SNAPSHOT .............. SUCCESS [  0.078 s]
[INFO] lc-bank-operations-api-model 266.0 ................. SUCCESS [  9.176 s]
[INFO] lc-bank-operations-api-client 266.0 ................ SUCCESS [ 17.125 s]
[INFO] lc-bank-operations-domain 269.0-SNAPSHOT ........... SUCCESS [ 13.823 s]
[INFO] lc-bank-operations-service 269.0-SNAPSHOT .......... SUCCESS [ 30.811 s]
[INFO] lc-bank-operations-server 269.0-SNAPSHOT ........... SUCCESS [02:11 min]
[INFO] lc-bank-operations-batch 269.0-SNAPSHOT ............ SUCCESS [ 31.740 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  02:56 min (Wall Clock)
[INFO] Finished at: 2022-05-31T23:32:04-03:00
[INFO] ------------------------------------------------------------------------
```

## Testing https://github.tlcinternal.com/LendingClub/main

### Running with Maven

```
$ mvn clean install -DskipTests -Djavax.xml.accessExternalSchema=all
```
Usually the command is taking around `08:00 min` to finish.

See output of summary below:
```
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for Root POM 270.0-SNAPSHOT:
[INFO]
[INFO] lc-parent-pom ...................................... SUCCESS [  0.483 s]
[INFO] Root POM ........................................... SUCCESS [  0.027 s]
[INFO] lc-idanalytics ..................................... SUCCESS [  7.950 s]
[INFO] lc-fusion-charts ................................... SUCCESS [  1.399 s]
[INFO] wm ................................................. SUCCESS [ 41.750 s]
[INFO] lc-test-util ....................................... SUCCESS [  0.384 s]
[INFO] lc-main-parent-pom ................................. SUCCESS [  0.007 s]
[INFO] lc-core ............................................ SUCCESS [  5.340 s]
[INFO] LC EDGAR Automation ................................ SUCCESS [  3.383 s]
[INFO] lc-legacy .......................................... SUCCESS [  0.157 s]
[INFO] lc-main ............................................ SUCCESS [03:23 min]
[INFO] workflow-contracts-test ............................ SUCCESS [  1.873 s]
[INFO] lcui-contracts-test ................................ SUCCESS [  0.474 s]
[INFO] lc-service-order ................................... SUCCESS [  0.125 s]
[INFO] lc-service-wm ...................................... SUCCESS [  2.353 s]
[INFO] lc-service ......................................... SUCCESS [ 20.317 s]
[INFO] lc-collections ..................................... SUCCESS [  1.600 s]
[INFO] lc-investor-returns ................................ SUCCESS [  3.874 s]
[INFO] lc-docs ............................................ SUCCESS [  3.320 s]
[INFO] lc-batch-uberjar ................................... SUCCESS [  1.740 s]
[INFO] lc-service-json .................................... SUCCESS [ 29.523 s]
[INFO] batch-job-spi ...................................... SUCCESS [  0.206 s]
[INFO] lc-batch-test-jdbc ................................. SUCCESS [ 17.863 s]
[INFO] quartz-service-provider ............................ SUCCESS [  0.272 s]
[INFO] performance-reports ................................ SUCCESS [  2.964 s]
[INFO] lc-batch ........................................... SUCCESS [ 43.620 s]
[INFO] lc-batch-payment ................................... SUCCESS [ 28.629 s]
[INFO] lc-batch-reports ................................... SUCCESS [ 30.740 s]
[INFO] lc-dice ............................................ SUCCESS [ 15.923 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  07:51 min
[INFO] Finished at: 2022-06-08T21:56:25-03:00
[INFO] ------------------------------------------------------------------------
```

### Running with Maven Deamon

```
$ mvnd clean install -DskipTests -Djavax.xml.accessExternalSchema=all
```

We can see better results as well in matter of time. Its taking around `04:30 min` to finish.

```
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for Root POM 270.0-SNAPSHOT:
[INFO]
[INFO] lc-parent-pom ...................................... SUCCESS [  0.185 s]
[INFO] Root POM ........................................... SUCCESS [  0.012 s]
[INFO] lc-idanalytics ..................................... SUCCESS [ 13.804 s]
[INFO] lc-fusion-charts ................................... SUCCESS [  7.802 s]
[INFO] wm ................................................. SUCCESS [ 29.551 s]
[INFO] lc-test-util ....................................... SUCCESS [  1.766 s]
[INFO] lc-main-parent-pom ................................. SUCCESS [  0.125 s]
[INFO] lc-core ............................................ SUCCESS [ 12.996 s]
[INFO] LC EDGAR Automation ................................ SUCCESS [ 13.165 s]
[INFO] lc-legacy .......................................... SUCCESS [ 10.348 s]
[INFO] lc-main ............................................ SUCCESS [03:28 min]
[INFO] workflow-contracts-test ............................ SUCCESS [  1.626 s]
[INFO] lcui-contracts-test ................................ SUCCESS [  1.626 s]
[INFO] lc-service-order ................................... SUCCESS [  1.268 s]
[INFO] lc-service-wm ...................................... SUCCESS [  3.414 s]
[INFO] lc-service ......................................... SUCCESS [ 36.212 s]
[INFO] lc-collections ..................................... SUCCESS [ 15.492 s]
[INFO] lc-investor-returns ................................ SUCCESS [ 11.691 s]
[INFO] lc-docs ............................................ SUCCESS [ 17.192 s]
[INFO] lc-batch-uberjar ................................... SUCCESS [ 14.131 s]
[INFO] lc-service-json .................................... SUCCESS [ 39.762 s]
[INFO] batch-job-spi ...................................... SUCCESS [ 11.562 s]
[INFO] lc-batch-test-jdbc ................................. SUCCESS [ 30.261 s]
[INFO] quartz-service-provider ............................ SUCCESS [ 11.741 s]
[INFO] performance-reports ................................ SUCCESS [  5.447 s]
[INFO] lc-batch ........................................... SUCCESS [01:20 min]
[INFO] lc-batch-payment ................................... SUCCESS [ 50.164 s]
[INFO] lc-batch-reports ................................... SUCCESS [01:34 min]
[INFO] lc-dice ............................................ SUCCESS [ 54.030 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  04:13 min (Wall Clock)
[INFO] Finished at: 2022-06-08T22:31:13-03:00
[INFO] ------------------------------------------------------------------------
```

## Final thoughts

The tests were executed with `~/.m2/mvnd.properties` configuration. 
Which means, there is space to improve the performance for each environment.

Reducing the build time for all applications we have, will reduce the infrastructure costs and will enable the engineers to deliver faster.