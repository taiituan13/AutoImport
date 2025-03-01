import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class autoimport {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        // Khai báo ChromeOptions
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments(
                "user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");

        // Khởi tạo WebDriver với tùy chọn
        // Tự động thiết lập ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            // Mở Google
            driver.get("https://mobile.asmbca.vn/ui/so-do-phong");
            Thread.sleep(10000);
            // Tìm ô tìm kiếm và nhập từ khóa "vscode"
            WebElement searchBox = driver.findElement(By.xpath(
                    "/html/body/app-root/app-layout/div/div/div[1]/app-public/app-home/div/div/div/div[3]/div/div/div/div[5]/button"));
            searchBox.click();

            // Nhấn Enter để tìm kiếm
            searchBox.sendKeys(Keys.RETURN);

            // Chờ một lúc để trang kết quả tải xong (có thể dùng WebDriverWait thay thế)
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Đóng trình duyệt
            // driver.quit();
        }
    }

}
