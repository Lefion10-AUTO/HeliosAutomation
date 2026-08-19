# Helios

Helios is a Java-based Selenium test automation framework built to practice modern automation architecture, parallel execution, CI integration, and AI-assisted software development.

## Tech Stack

- Java 21
- Selenium WebDriver 4
- TestNG
- Maven
- SLF4J + Logback
- GitHub Actions
- Selenium Grid
- GitHub Copilot
- ChatGPT

## Key Features

- Thread-safe WebDriver management using `ThreadLocal`
- Parallel TestNG execution
- Local and remote browser execution
- Chrome, Firefox, and Edge support
- Headless execution
- Page Object Model
- Explicit wait utilities
- Data-driven testing with TestNG `DataProvider`
- Smoke and regression test groups
- Configurable retry mechanism
- Automatic screenshots on failure
- Console and file logging
- Maven Surefire integration
- GitHub Actions CI pipeline
- CI artifact upload for logs, screenshots, and reports

## Project Structure

```text
src/
├── main/
│   └── java/
│       └── com/helios/
│           ├── config/
│           ├── driver/
│           └── utils/
│
└── test/
    ├── java/
    │   ├── com/helios/
    │   │   ├── data/
    │   │   └── tests/
    │   ├── listeners/
    │   └── pages/
    │
    └── resources/
        └── logback-test.xml
```

## Running the Tests

Run the complete TestNG suite:

```bash
mvn clean test
```

Run in headless mode:

```bash
mvn clean test -Dheadless=true
```

Run using a different browser:

```bash
mvn clean test -Dbrowser=firefox
```

Run using Selenium Grid:

```bash
mvn clean test -Dremote=true
```

Use a custom Grid URL:

```bash
mvn clean test -Dremote=true -DgridUrl=http://localhost:4444
```

Configure retry count:

```bash
mvn clean test -Dtest.retry.count=1
```

## Test Groups

Tests are organized using TestNG groups such as:

- `smoke`
- `regression`

Group execution is configured through `testng.xml`.

## Logging

Helios uses SLF4J with Logback.

Logs are written to:

```text
target/logs/helios.log
```

The framework logs key lifecycle events such as:

- WebDriver startup
- provider selection
- WebDriver shutdown
- retries
- screenshot creation

## Failure Screenshots

When a test fails, Helios automatically captures a screenshot.

Screenshots are stored under:

```text
target/screenshots/
```

Each screenshot includes the test name, execution thread, and timestamp.

## Test Reports

TestNG and Maven Surefire reports are generated under:

```text
target/surefire-reports/
```

## Continuous Integration

GitHub Actions automatically runs the Helios test suite on pushes and pull requests.

The CI workflow:

1. Creates a clean Ubuntu runner
2. Checks out the repository
3. Configures Java 21
4. Restores Maven dependencies
5. Runs Selenium tests in headless mode
6. Uploads logs, screenshots, and test reports as workflow artifacts

## Design Goals

Helios was built to focus on maintainable test automation rather than simply writing Selenium scripts.

The framework separates:

- test logic
- browser lifecycle management
- configuration
- page behavior
- test data
- reporting and diagnostics

## AI-Assisted Development

Helios was developed as a hands-on project to strengthen AI-assisted engineering skills.
