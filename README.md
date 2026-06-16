# untitled2

This project uses Maven + TestNG + Selenium.

## Run the TestNG suite

The Maven Surefire plugin is configured to execute `testng.xml` from the project root.

```powershell
mvn test
```

## Suite details

- Suite file: `testng.xml`
- Test class: `tests.ParallelTest`
- Browsers: Chrome and Firefox
- Execution: parallel TestNG tests

If a browser is unavailable, the test skips cleanly instead of failing.

