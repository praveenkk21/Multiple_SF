package Subforms;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubForm {

	public static void subForm(WebDriver driver, String subformlibraryid) throws Exception {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		// iterate through your windows
		@SuppressWarnings("unused")
		String parent = null, newwin = null;
		while (it.hasNext()) {
			parent = it.next();
			newwin = it.next();
		}
		driver.switchTo().window(newwin);
		
		//driver.findElement(By.id("btnSave")).click();
		
		  if (subformlibraryid.equalsIgnoreCase("562")) { vn558.vn_558(driver);
		  System.out.println("test");
		  
		  }
		  
		  else if (subformlibraryid.equalsIgnoreCase("564")) { vn564.vn_564(driver);
		  
		  }
		  else {SubForm.placeHolders(driver);}
		 

	}
	
	@SuppressWarnings("unused")
	public static <webElement> void placeHolders(WebDriver driver) throws Exception {

		List<WebElement> DateBox = driver.findElements(By.xpath("//*[@type='text' and @onblur='Checkdate(this)']"));
		System.out.println("Datebox size " + DateBox.size());

		List<WebElement> TextSmallBox = driver.findElements(By.xpath(
				"//*[@class='txtbox' and @id!='txtDate_EffectiveTO' and not(contains(@onblur,'javascript:TimeValidByID')) and not(contains(@onblur,'IsMilitaryTimeFormat')) and not(contains(@id,'Phone')) and not(contains(@name,'Phone')) and not(contains(@id,'phone')) and not(contains(@class,'phone'))]"));

		System.out.println("TextSmallbox size " + TextSmallBox.size());

		List<WebElement> TextTime = driver.findElements(By.xpath("//*[contains(@onblur,'javascript:TimeValidByID')]"));
		System.out.println("TextTime size " + TextTime.size());

		List<WebElement> ZipBox = driver
				.findElements(By.xpath("//*[@class='txtbox' and contains(@onfocusout,'GetCityOfzipcode')]"));
		System.out.println("Zipbox size " + ZipBox.size());

		List<WebElement> chkBox = driver.findElements(By.xpath("//*[@type='checkbox']"));
		System.out.println("checkbox size " + chkBox.size());

		List<WebElement> AreaBox = driver.findElements(By.xpath("//*[contains(@id,'txtarea')]"));
		System.out.println("TextAreaa size " + AreaBox.size());

		List<WebElement> AutoComplete = driver.findElements(By.xpath("//input[contains(@class,'autocomplete')]"));
		System.out.println("AutoComplete size " + AutoComplete.size());

		List<WebElement> Radio = driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println("Radio size " + Radio.size());

		List<WebElement> Email = driver
				.findElements(By.xpath("//input[contains(@name,'Email') or contains(@id,'email') ]"));
		System.out.println("Email size " + Email.size());

		List<WebElement> Phone = driver.findElements(By.xpath(
				"//*[contains(@id,'phone') or contains(@name,'phone') or contains(@id,'Phone') or contains(@name,'Phone') "
						+ "or contains(@id,'Cell') or contains(@name,'Cell') or contains(@id,'cell') or contains(@name,'cell')]"));
		System.out.println("Phone size " + Phone.size());

		// phone code
		System.out.println("Into the Phone code");
		for (int i = 0; i < Phone.size(); i++) {
			try {
				WebElement elPhone = Phone.get(i);
				// System.out.println(el3);
				if (elPhone.isEnabled()) {
					if (elPhone.getAttribute("value").isEmpty()) {
						elPhone.sendKeys("8660440171");
					} else {
						System.out.println(elPhone + " " + i + "" + " Is filled already");
					}
				} else {
					System.out.println(elPhone + " " + i + "" + " is disabled");
				}
			} catch (Exception e) {

				System.err.println(i + " " + e.getMessage());
			}
		}

		// Email code
		System.out.println("Into the Phone code");
		for (int i = 0; i < Email.size(); i++) {
			try {
				WebElement elEmail = Email.get(i);
				// System.out.println(el3);
				if (elEmail.isEnabled()) {
					if (elEmail.getAttribute("value").isEmpty()) {
						elEmail.sendKeys("testfromPraveen@kanrad.com");
					} else {
						System.out.println(elEmail + " " + i + "" + " Is filled already");
					}
				} else {
					System.out.println(elEmail + " " + i + "" + " is disabled");
				}
			} catch (Exception e) {

				System.err.println(i + " " + e.getMessage());
			}
		}

		// Radio code
		System.out.println("Into the Radio code");
		for (int i = 0; i < Radio.size(); i++) {
			try {
				WebElement elRadio = Radio.get(i);
				// System.out.println(el3);
				if (elRadio.isEnabled()) {
					if (elRadio.isSelected()) {
						System.out.println(elRadio + " " + i + "" + " Is selected already");

					} else {
						elRadio.click();
					}
				} else {
					System.out.println(elRadio + " " + i + "" + " is disabled");
				}
			} catch (Exception e) {

				System.err.println(i + " " + e.getMessage());
			}
		}

		// Checkbox code
		System.out.println("Into the CheckbOx code");
		for (int i = 0; i <= chkBox.size(); i++) {
			try {
				WebElement el2 = chkBox.get(i);
				JavascriptExecutor je2 = (JavascriptExecutor) driver;
				je2.executeScript("arguments[0].scrollIntoView(true)", el2);
				if (el2.isEnabled()) {
					if (el2.isSelected()) {
						System.out.println(el2 + " " + i + "" + " is already selected");
					} else {
						el2.click();
					}
				} else {
					System.out.println(el2 + " " + i + "" + " is disabled");
				}
			} catch (Exception e) {
				System.err.println(i + " " + e.getMessage());
			}
		}

		// code for date box
		System.out.println("Into the date code");
		for (int i = 0; i < DateBox.size(); i++) {
			try {
				WebElement el = DateBox.get(i);
				JavascriptExecutor je = (JavascriptExecutor) driver;
				je.executeScript("arguments[0].scrollIntoView(true)", el);
				if (el.getAttribute("value").isEmpty()) {
					el.click();
					el.sendKeys("1/10/2021");
				} else {
					System.out.println(el + " " + i + "" + " is already selected");
				}
			} catch (Exception e) {
				System.err.println(i + " " + e.getMessage());
			}
		}

		// code for time code
		System.out.println("Into the time code");
		for (int i = 0; i < TextTime.size(); i++) {
			try {
				WebElement elTextTime = TextTime.get(i);
				JavascriptExecutor je = (JavascriptExecutor) driver;
				je.executeScript("arguments[0].scrollIntoView(true)", elTextTime);
				if (elTextTime.isEnabled()) {
					if (elTextTime.getAttribute("value").isEmpty()) {
						elTextTime.click();
						elTextTime.sendKeys("12:00 AM");
					} else {
						System.out.println(elTextTime + " " + i + "" + " is already have time");
					}
				} else {
					System.out.println(elTextTime + " " + i + "" + " is disabled");
				}
			} catch (Exception e) {
				System.err.println(i + " " + e.getMessage());
			}
		}

		// code for Draggable areatext box
		System.out.println("Into the dragbOx code");
		for (int i = 0; i < AreaBox.size(); i++) {
			try {
				Thread.sleep(300);
				WebElement elAreaBox = AreaBox.get(i);
				// System.out.println(elAreaBox);
				JavascriptExecutor je = (JavascriptExecutor) driver;
				je.executeScript("arguments[0].scrollIntoView(true)", elAreaBox);
				// elAreaBox.click();
				if (elAreaBox.isEnabled()) {
					if (elAreaBox.getAttribute("value").isEmpty()) {
						elAreaBox.sendKeys("AreaBox");
					} else {
						System.out.println(elAreaBox + " " + i + "" + " is already have text");
					}
				} else {
					System.out.println(elAreaBox + " " + i + "" + " is Disabled");
				}
			} catch (Exception e) {
				System.err.println(i + " " + e.getMessage());
			}
		}

		// Zipcode
		System.out.println("Into the ZipbOx code");
		for (int i = 0; i < ZipBox.size(); i++) {
			try {
				WebElement elZip = ZipBox.get(i);
				hasAlert(driver);
				Thread.sleep(500);
				JavascriptExecutor jezip = (JavascriptExecutor) driver;
				jezip.executeScript("arguments[0].scrollIntoView(true)", elZip);
				if (elZip.getAttribute("value").isEmpty()) {
					elZip.click();
					// System.out.println(elZip);
					elZip.sendKeys("12345");
					Thread.sleep(500);
					hasAlert(driver);
				} else {
					System.out.println(elZip + " " + i + "" + " is already havee date");
				}
			} catch (Exception e) {

				System.err.println(i + " " + e.getMessage());
			}
		}

		// textbox code
		System.out.println("Into the SmallbOx code");
		for (int i = 0; i < TextSmallBox.size(); i++) {
			try {
				WebElement el3 = TextSmallBox.get(i);
				// System.out.println(el3);
				if (el3.isEnabled()) {
					if (el3.getAttribute("value").isEmpty()) {
						el3.sendKeys("Test");
					} else {
						System.out.println(el3 + " " + i + "" + " Is filled already");
					}
				} else {
					System.out.println(el3 + " " + i + "" + " is disabled");
				}
			} catch (Exception e) {

				System.err.println(i + " " + e.getMessage());
			}
		}

		// phone code
		System.out.println("Into the Phone code");
		for (int i = 0; i < Phone.size(); i++) {
			try {
				WebElement elPhone = Phone.get(i);
				// System.out.println(el3);
				if (elPhone.isEnabled()) {
					if (elPhone.getAttribute("value").isEmpty()) {
						elPhone.sendKeys("8660440171");
					} else {
						System.out.println(elPhone + " " + i + "" + " Is filled already");
					}
				} else {
					System.out.println(elPhone + " " + i + "" + " is disabled");
				}
			} catch (Exception e) {

				System.err.println(i + " " + e.getMessage());
			}
		}

		// Code for autofill box
		System.out.println("Into the AutoComplete code");

		WebDriverWait wait = new WebDriverWait(driver, 20);

		for (int k = 0; k < AutoComplete.size(); k++) {
			try {
				WebElement elAutoComplete = AutoComplete.get(k);
				JavascriptExecutor je2C = (JavascriptExecutor) driver;
				je2C.executeScript("arguments[0].scrollIntoView(true)", elAutoComplete);
				// wait.until(ExpectedConditions.elementToBeClickable(elAutoComplete));
				if (elAutoComplete.isEnabled()) {
					if (true) {
						elAutoComplete.click();
						elAutoComplete.sendKeys("a");
						Thread.sleep(2000);
						elAutoComplete.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
					} else {
						System.out.println(elAutoComplete + " " + k + "" + " Is filled already");
					}
				} else {
					System.out.println(elAutoComplete + " " + k + "" + " is disabled");
				}
			} catch (Exception e) {
				System.err.println(k + e.getMessage());
			}
		}
	}

	public static void hasAlert(WebDriver driver2) {
		boolean hasAlert = ExpectedConditions.alertIsPresent().apply(driver2) != null;
		System.out.println(hasAlert);
		if (hasAlert) {
			driver2.switchTo().alert().accept();
			System.out.println("alert was  present");
		}
		// return hasAlert;
	}
}
