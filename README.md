# 🧪 Automated Testing for Almosafer Website using Selenium & TestNG

This document provides a comprehensive overview of an automated test suite for the [Almosafer](https://www.almosafer.com/en?ncr=1) website using **Java**, **Selenium WebDriver**, and **TestNG**. The purpose is to validate the core UI functionalities of the site in both Arabic and English interfaces.

---

## 📦 Project Structure

- **Package:** `NewProject.Almosafer`
- **Test Class:** `AppTest.java`
- **Base Class:** `TestData.java` (assumed to contain test data like expected texts, cities, dropdown options)

---

## ⚙️ Setup

- **WebDriver:** ChromeDriver  
- **Testing Framework:** TestNG  
- **Browser:** Google Chrome  
- **Language Support:** Arabic & English  
- **Navigation URL:** `https://www.almosafer.com/en?ncr=1`  
- **Test Mode:** Manual priority using TestNG annotations  
- **Precondition:** Browser window is maximized on test start.

---

## ✅ Test Cases Overview

### 1. `Language`
- **Purpose:** Verify the default language of the website.
- **Validation:** `<html lang>` attribute is as expected.

### 2. `Sar`
- **Purpose:** Ensure the displayed currency is SAR (Saudi Riyal).
- **Validation:** Text content of the currency element matches expected.

### 3. `Number`
- **Purpose:** Check the phone/contact number visibility and correctness.
- **Validation:** Matches the expected static number.

### 4. `Logo`
- **Purpose:** Ensure the website logo is visible after scrolling down.
- **Validation:** Logo element is displayed.

### 5. `Search_Tab`
- **Purpose:** Verify that the "Flights" tab is active by default.
- **Validation:** Tab element contains class `active`.

### 6. `Flight_departure`
- **Purpose:** Check if departure date is set to tomorrow.
- **Validation:** Date button contains tomorrow's date.

### 7. `Flight_return`
- **Purpose:** Ensure the return date is correctly displayed.
- **Validation:** Matches `aftertoday` test data.

### 8. `RLanguage`
- **Purpose:** Randomly switch between English/Arabic and confirm page language.
- **Validation:** `<html lang>` starts with the randomly selected language.

### 9. `Random_Hotel`
- **Purpose:** Randomly pick a city (based on selected language) and enter it in the search field under the Hotels tab.
- **Validation:** City is typed into the autocomplete input.

### 10. `Randomly_Select`
- **Purpose:** Randomly select an option from a dropdown (e.g., number of guests).
- **Validation:** Selected dropdown value matches expected.

### 11. `Hotelsbtn`
- **Purpose:** Check if the "Hotels" tab activates after clicking.
- **Validation:** Class contains `active`.

### 12. `NewPage` (Main Flow)
- **Purpose:** Full hotel search flow with dynamic input.
- **Steps:**
  1. Click on the Hotels tab.
  2. Enter a random city from English cities.
  3. Select a guest option from the dropdown.
  4. Pick specific check-in and check-out dates.
  5. Click search.
  6. Validate that at least one hotel appears.
- **Validation:** First hotel name element is displayed and printed to console.

---

## 🗂️ Test Data Assumptions (from `TestData`)

- `ExpectedLanguage` — default expected site language  
- `ExpectedSar` — expected currency display ("SAR")  
- `ExpectedNumber` — support contact number  
- `ExpectedActionTab` — expected class indicator for active tab  
- `tomorrow`, `aftertoday` — dynamically generated dates  
- `OPTION_1[]` — dropdown options like number of guests  
- `englishCities[]`, `arabicCities[]` — available cities for each language

---

## 🔍 Notes

- All tests use `@Test(priority = X, enabled = true/false)` to control execution.
- `enabled = false` means the test is currently skipped.
- The full flow (`NewPage`) is the most complete scenario to validate functionality.
- Use `WebDriverWait` to wait for dynamic elements instead of hard-coded `Thread.sleep()` where possible.

---

## 🧼 Cleanup / Future Suggestions

- Use `@AfterTest` to close the browser after tests.
- Replace deprecated warnings and optimize waits.
- Parameterize language/city options to avoid duplication.
- Implement logging instead of `System.out.println`.

---

## 📸 Screenshots

> Not included in this document. To capture screenshots on failure, integrate with TestNG `@AfterMethod` and Selenium’s `TakesScreenshot`.

---

## ✅ Example Console Output

```text
Hotel Name Found: Holiday Inn Riyadh

