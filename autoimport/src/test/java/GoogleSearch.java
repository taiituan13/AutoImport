import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {
    public static void main(String[] args) {
        // Tự động thiết lập ChromeDriver
        WebDriverManager.chromedriver().setup();
        
        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();
        
        try {
            // Mở Google
            driver.get("https://www.google.com");
            
            // Tìm ô tìm kiếm và nhập từ khóa "vscode"
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("vscode");
            
            // Nhấn Enter để tìm kiếm
            searchBox.sendKeys(Keys.RETURN);
            
            // Chờ một lúc để trang kết quả tải xong (có thể dùng WebDriverWait thay thế)
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }
}