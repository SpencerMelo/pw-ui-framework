# Web UI e2e repository using Playwright

[![Run tests](https://github.com/SpencerMelo/pw-ui-framework/actions/workflows/maven.yml/badge.svg)](https://github.com/SpencerMelo/pw-ui-framework/actions/workflows/maven.yml)

## Minimum Requirements

- Java 21
- Maven 3.6.3
- [You might to install the Browsers](https://playwright.dev/java/docs/browsers)

## How to run

#### System properties

```properties
-Dheadless=true|false
-Dbrowser=chrome|firefox|safari
-Dscreenshot=true|false
```

#### Basic command 

```shell
mvn clean test -Dheadless=false -Dbrowser=chrome -Dscreenshot=true
```

#### Debug command (windows)
```shell
$env:PLAYWRIGHT_JAVA_SRC="src/main/java";$env:PWDEBUG=1;
```

## Notes
- In case you don't define the `-Dbrowser` it will default to `chrome`
- In case you don't define the `-Dheadless` it will default to `true`
- In case you don't define the `-Dscreenshot` it will default to `false`
- Screenshots will be created on the root (`pw-ui-framework`) folder of the project