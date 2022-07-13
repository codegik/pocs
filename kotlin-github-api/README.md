# Github API client

Finding last week PRs from the user. 

## Requirement

- Java 17
- Maven 3

## Setup

1. Go to github account and create a accessToken.
2. Update `application.yml` file with your repositories.

```properties
github:
  repositories: LendingClub/batch-script-data, LendingClub/lc-bank-operations, Release/lc-bank-operations
```

## Running
```shell
./run.sh <username> <accessToken>
```

Output sample
```log
https://github.tlcinternal.com/LendingClub/batch-script-data/pull/9204
https://github.tlcinternal.com/LendingClub/batch-script-data/pull/9208
https://github.tlcinternal.com/LendingClub/lc-bank-operations/pull/126
https://github.tlcinternal.com/LendingClub/lc-bank-operations/pull/133
https://github.tlcinternal.com/LendingClub/lc-bank-operations/pull/132
https://github.tlcinternal.com/Release/lc-bank-operations/pull/18
https://github.tlcinternal.com/Release/lc-bank-operations/pull/17
```
