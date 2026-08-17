HeliosAutomation
=================

Lightweight Selenium + TestNG automation example.

Tech stack
- Java 21 (Maven)
- Selenium 4
- TestNG

Repository layout
- src/main/java/pages — Page objects
- src/main/java/com/helios/driver — WebDriver provider/manager
- src/test/java — TestNG tests and data providers
- testng.xml — TestNG suite configuration

Quick start (local)
Prerequisites: JDK 21, Maven, Chrome + ChromeDriver installed or WebDriverManager configured.

Run tests:

mvn test -Dheadless=true -Dbrowser=chrome

Main system properties
- browser: chrome | firefox | edge (default: chrome)
- headless: true|false (default: false)
- remote: true|false (default: false)
- waitTimeout: seconds for explicit waits (default: 10)
- test.retry.count: number of retries for flaky tests (default: 1)

CI
A GitHub Actions workflow (.github/workflows/ci.yml) runs the test suite on ubuntu-latest using JDK 21 and installs Chromium + Chromedriver. Artifacts: target/surefire-reports and target/screenshots are uploaded after the run.

Troubleshooting
- If tests fail locally due to driver errors, ensure ChromeDriver matches Chrome or add WebDriverManager to the project.
- For flaky failures, increase waitTimeout or test.retry.count.

License
MIT
