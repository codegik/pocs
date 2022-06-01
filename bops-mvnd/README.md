# MVND for BOPS app

Using mvnd to compile and run tests faster.

The repository used for testing was `https://github.tlcinternal.com/LendingClub/lc-bank-operations`.

## Install using SDKMAN

```
curl -s "https://get.sdkman.io" | bash
```

```
sdk install mvnd
```

## Install using Homebrew
```
brew install mvndaemon/homebrew-mvnd/mvnd
```

## Running with Maven

```
mvn clean install
```

Usually the `mvn clean install` is taking around `04:20`.
See example of summary below:

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

## Running with Maven Deamon

```
mvnd clean install
```

Using mvnd to compile and run tests, we're getting better results in matter of time.

### First run with mvnd

Running `mvnd clean install` for the first time we got `02:56 min`, witch means almost half time of `mvn clean install` command.

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
