package TestCase;
	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.Toolkit;
	import java.awt.datatransfer.StringSelection;
	import java.awt.event.KeyEvent;
	import java.time.Duration;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Action;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.Assert;
	import org.testng.annotations.Test;
	import io.github.bonigarcia.wdm.WebDriverManager;
	import java.awt.*;
	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;

	public class Demo {
		
	   public static WebDriver driver ;
	    @Test
	    public static void Profile_Update() throws InterruptedException, AWTException {
	        WebDriverManager.chromedriver().setup();
	       driver = new ChromeDriver();
	        driver.get("https://www.naukri.com/nlogin/login?URL=https://www.naukri.com/mnjuser/homepage");
	        driver.manage().window().maximize();
//	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.MINUTES);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	        WebElement Username = driver.findElement(By.xpath("//*[@id='usernameField']"));
	        Username.click();
	        Username.sendKeys("venkatachalambabu4@gmail.com");
	        WebElement Password = driver.findElement(By.xpath("//*[@id='passwordField']"));
	        Password.click();
	        Password.sendKeys("Venkat@2001");
	        driver.findElement(By.xpath("//button[text()='Login']")).click();
	        driver.findElement(By.xpath("//img[@class='nI-gNb-icon-img']")).click();
	        driver.findElement(By.xpath("//*[@class='nI-gNb-info__sub-link']")).click();
	        WebElement fullname = driver.findElement(By.xpath("//*[@class=\"fullname\"]"));
	        String fullnamestr = fullname.getText();
	        System.out.println("fullname" + fullnamestr);
	        driver.findElement(By.xpath("//em[@class=\"icon edit \"]")).click();
	        WebElement namefiled = driver.findElement(By.xpath("//*[@id=\"name\"]"));
	        namefiled.click();
	        namefiled.click();
	        Thread.sleep(3000);
	        namefiled.clear();
	        Thread.sleep(2000);
	        namefiled.sendKeys("Venkatachalam Babu");
	        driver.findElement(By.xpath("//*[@data-value=\"15 Days or less\"]")).click();
	        //   driver.findElement(By.xpath("//*[@data-value=\"Serving Notice Period\"]")).click();

	        Thread.sleep(3000);

	        driver.findElement(By.xpath("//*[@class='notice-period-container ']//span[text()='Serving Notice Period']")).click();

	        WebElement year =  driver.findElement(By.xpath("//input[@placeholder='Select Year']"));
//	      //   Select sc= new Select(year);
	           year.click();
	        selectExpectedLastWorkingDay ();
	      //   selectExpectedLastWorkingDay();

	        // starting
	//
//	           WebElement year =  driver.findElement(By.xpath("//input[@placeholder='Select Year']"));
//	      //   Select sc= new Select(year);
//	            year.click();
//	            WebElement selectYear =  driver.findElement(By.xpath("//*[normalize-space(text())='2026']"));
//	            selectYear.click();
	//
	//
//	        WebElement selectmonth =  driver.findElement(By.xpath("//*[@placeholder='Select Month']"));
//	        selectmonth.click();
	//


	        String fullnamestr3 = fullname.getText();
	        System.out.println("fullnamestr3" + fullnamestr3);
	        if (fullnamestr.equalsIgnoreCase(fullnamestr3)) {
	            System.out.println("Full name was Matched");
	        } else {
	            System.out.println("Not Matched For you Full name");
	        }
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//*[@id='saveBasicDetailsBtn']")).click();
	        Thread.sleep(5000);
	        try {
	            driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/span")).click();
	        } catch (Exception e) {
	            // TODO: handle exception
	        }
	        Thread.sleep(5000);
	        try {
	            driver.findElement(By.xpath("//i[@data-title='delete-resume']")).click();
	            Thread.sleep(3000);
	            driver.findElement(By.xpath("(//*[@class='btn-dark-ot' and text()='Delete'])[2]")).click();
	        } catch (Exception e) {
	            WebElement uplodabtn = driver.findElement(By.xpath("//*[text()='Upload resume']"));
	            if (uplodabtn.isDisplayed()) {
	                Thread.sleep(3000);
	                driver.findElement(By.xpath("//*[@class='dummyUploadNewCTA']")).click();
	            }
	        }
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//*[@class='dummyUploadNewCTA']")).click();
	        String filePath = "VENKAT-Resume.pdf";
	        StringSelection selection = new StringSelection(filePath);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
	        Robot robot = new Robot();
	        robot.delay(2000);
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.delay(3000);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.delay(2000);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        // testcase.log(Status.PASS, "File uploaded successfully!");
	        System.out.println("Resume Updated SuccessFully Done ");
	    }


	    public static void selectExpectedLastWorkingDay() throws InterruptedException {

	        LocalDate today = LocalDate.now();

	        String year = String.valueOf(today.getYear());
	        String month = today.format(DateTimeFormatter.ofPattern("MMM"));

	        // Get Last Day of Current Month
	        int lastDay = today.lengthOfMonth();

	        String day = String.valueOf(lastDay);

	        String fullDate = day + "-" + month + "-" + year;

	        System.out.println("Expected Last Working Date : " + fullDate);

	        Thread.sleep(2000);
	        // Select Year
	  WebElement selectyearr =      driver.findElement(By.xpath("//input[@placeholder='Select Year']"));

	        Actions ac = new Actions(driver);

	        ac.moveToElement(selectyearr).click().perform();
	        driver.findElement(
	                        By.xpath("//*[normalize-space()='" + year + "']"))
	                .click();

	        // Select Month
	        driver.findElement(By.xpath("//input[@placeholder='Select Month']")).click();

	        driver.findElement(
	                        By.xpath("//*[normalize-space()='" + month + "']"))
	                .click();

	        // Select Last Day of Selected Month
	        driver.findElement(By.xpath("//input[@placeholder='Select Day']")).click();

	        driver.findElement(
	                        By.xpath("//*[normalize-space()='" + day + "']"))
	                .click();

	        System.out.println("Selected Year  : " + year);
	        System.out.println("Selected Month : " + month);
	        System.out.println("Selected Day   : " + day);

	        Assert.assertTrue(true,
	                "Expected Last Working Day Selected Successfully");

	        System.out.println(
	                "PASS - Expected Last Working Day : " + fullDate);
	    } }
	//
//	    public static void selectExpectedLastWorkingDay() {
	//
//	        LocalDate today = LocalDate.now();
	//
//	        String year = String.valueOf(today.getYear());
//	        String month = today.format(DateTimeFormatter.ofPattern("MMM"));
//	        String day = String.valueOf(today.getDayOfMonth());
	//
//	        String fullDate =
//	                today.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
	//
//	        System.out.println("Expected Last Working Date : " + fullDate);
	//
//	        // Year Dropdown
//	        driver.findElement(By.xpath("//input[@placeholder='Select Year']")).click();
	//
//	        driver.findElement(
//	                        By.xpath("//*[normalize-space()='" + year + "']"))
//	                .click();
	//
//	        // Month Dropdown
//	        driver.findElement(By.xpath("//input[@placeholder='Select Month']")).click();
	//
//	        driver.findElement(
//	                        By.xpath("//*[normalize-space()='" + month + "']"))
//	                .click();
	//
//	        // Day Dropdown
//	        driver.findElement(By.xpath("//input[@placeholder='Select Day']")).click();
	//
//	        driver.findElement(
//	                        By.xpath("//*[normalize-space()='" + day + "']"))
//	                .click();
	//
//	        // Validation
	//
//	        String selectedYear =
//	                driver.findElement(By.xpath("//input[@placeholder='Select Year']"))
//	                        .getAttribute("value");
	//
//	        String selectedMonth =
//	                driver.findElement(By.xpath("//input[@placeholder='Select Month']"))
//	                        .getAttribute("value");
	//
//	        String selectedDay =
//	                driver.findElement(By.xpath("//input[@placeholder='Select Day']"))
//	                        .getAttribute("value");
	//
//	        Assert.assertEquals(selectedYear, year,
//	                "Year Validation Failed");
	//
//	        Assert.assertEquals(selectedMonth, month,
//	                "Month Validation Failed");
	//
//	        Assert.assertEquals(selectedDay, day,
//	                "Day Validation Failed");
	//
//	        System.out.println("Selected Year  : " + selectedYear);
//	        System.out.println("Selected Month : " + selectedMonth);
//	        System.out.println("Selected Day   : " + selectedDay);
	//
//	        System.out.println("PASS - Expected Last Working Day Selected Successfully : "
//	                + fullDate);
//	    }
	//}


