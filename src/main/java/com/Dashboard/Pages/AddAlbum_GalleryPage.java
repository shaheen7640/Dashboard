package com.Dashboard.Pages;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Dashboard.Base.BaseClass;


public class AddAlbum_GalleryPage extends BaseClass {
	
	public static String lbl_AlbumText;
	
	@FindBy(css = "ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(4)>a")
	WebElement menu_Gallery;
	
	@FindBy(className = "album-header")
	WebElement lbl_ViewAlbum;
	
	@FindBy(className = "btn-primary")
	static WebElement btn_addAlbum;
	
	@FindBy(xpath = "//div[@class=' css-2b097c-container']")
	WebElement albmContainer;
	
	@FindBy(name = "albumName")
	WebElement txtAlbumName;
	
	//Change the album category from here as option 0,1,2
	@FindBy(id = "react-select-2-option-2")
	WebElement albumCategory;
	
	@FindBy(xpath  = "//textarea[@name='description']")
	WebElement txtdescription;
	
	@FindBy(css = "button.chooseFileButton")
	WebElement selectImage;
	
	@FindBy(css = "div.uploadPictureContainer>img")
	public WebElement uploadedImages;
	
	@FindBy(css = "button.btn.btn-primary.btn-lg")
	WebElement btnUpload;
	
	@FindBy(css = "button.btn.btn-primary")
	public WebElement btnClose;
	
	public AddAlbum_GalleryPage() {
		
		PageFactory.initElements(driver, this);
	}
      public void view_album_lable() {
    	  
    	  menu_Gallery.click();
    	   lbl_AlbumText = lbl_ViewAlbum.getText();
    	  System.out.println(lbl_AlbumText);
    	  
      }
      public void add_album(String albumName, String description) throws AWTException {
    	  btn_addAlbum.click();
    	
    	  txtAlbumName.sendKeys(albumName);
    	  
    	 albmContainer.click();
    	 
    	 albumCategory.click();
    	 txtdescription.sendKeys(description);
    	 
    	 selectImage.click();
    	 
    	 robot =new Robot();
    	 
    	 String imagePath = System.getProperty("user.dir")+File.separator+"Upload_Album"+File.separator+property.getProperty("Album");
    	 StringSelection path = new StringSelection(imagePath);
    	// StringSelection imagePath = new StringSelection(property.getProperty("AlbumPath"));
    	
    	 try {
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
			 robot.setAutoDelay(3000);
			 
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 robot.keyPress(KeyEvent.VK_V);
			 
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 robot.keyRelease(KeyEvent.VK_V);
			 
			 robot.setAutoDelay(2000);
			 
			 robot.keyPress(KeyEvent.VK_ENTER);
			 robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (HeadlessException e) {
			
			System.out.println("Unable to copy-paste the album path");
			e.printStackTrace();
		}
    	
    	/*  List<WebElement> list = driver.findElements(By.xpath("//div[@class=' css-1wa3eu0-placeholder']"));
    	  System.out.println(list.size());
    	  for(int i=0; i<list.size(); i++)
    	  {
    		  if(list.get(i).getText().equals("Trips")) {
    			  list.get(i).click();
    			  break;
    		  }
    	  }*/
    	 
      }
      public boolean imageUploadVerification() {
    	       		    	  
    	  return uploadedImages.isDisplayed();
    	  
    	   }
      public void uploadAlbum() {
    	  btnUpload.click();
      }

		/*
		 * public boolean veryfingCloseButton() { //btnUpload.click(); return
		 * btnClose.isDisplayed();
		 * 
		 * }
		 */

}
     
      
