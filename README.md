## java auto testing tool on プログラミング基礎・プログラミング基礎演習

## How to install circleci CLI on local
https://circleci.com/docs/2.0/local-cli/
```
$ brew update
$ brew install circleci
```
or 
```
$ curl -o /usr/local/bin/circleci https://circle-downloads.s3.amazonaws.com/releases/build_agent_wrapper/circleci && chmod +x /usr/local/bin/circleci
```

## test
```
$ circleci build
```

## memo 
- 特定のテストだけ実行したい
`$ gradle -D test.single=K1/TestK11 test`
test.singleに渡すのは`src/test/`以下の該当テストコード

- コマンドラインからjunit実行
`$ java org.junit.runner.JUnitCore CLASS_NAME`