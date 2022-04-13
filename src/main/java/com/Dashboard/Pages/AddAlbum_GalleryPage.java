package com.Dashboard.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dashboard.Base.BaseClass;
import com.Dashboard.utill.ExpliciteWait;

public class AddAlbum_GalleryPage extends BaseClass {
	
	public static String lbl_AlbumText;
	
	@FindBy(css = "ul.navbar-nav.mr-auto.nav-grp-left-pad>li:nth-of-type(4)>a")
	WebElement menu_Gallery;
	
	@FindBy(className = "album-header")
	WebElement lbl_ViewAlbum;
	
	@FindBy(className = "btn-primary")
	static WebElement btn_addAlbum;
	
	@FindBy(css = "body > div.modal > div > div > div.modal-content.modal-content1.modal-body >"
			+ " div > div > div.form-body1.p-4 > div > div:nth-child(2) > div > div > div > div > div > div.css-g1d714-ValueContainer")
	//@FindBy(xpath = "//div[@class=' css-2b097c-container']")
	WebElement albmContainer;
	
	@FindBy(name = "albumName")
	WebElement txtAlbumName;
	
	//@FindBy(xpath  = "//div[@class=' css-1uccc91-singleValue']")
	@FindBy(css = "body > div.modal > div > div > div.modal-content.modal-content1.modal-body >"
			+ " div > div > div.form-body1.p-4 > div > div:nth-child(2) > div > div > div > div > div > div.css-g1d714-ValueContainer > div.css-1wa3eu0-placeholder")
	WebElement albumCategory;
	
	public AddAlbum_GalleryPage() {
		
		PageFactory.initElements(driver, this);
	}
      public void view_album_lable() {
    	  
    	  menu_Gallery.click();
    	   lbl_AlbumText = lbl_ViewAlbum.getText();
    	  System.out.println(lbl_AlbumText);
    	  
      }
      public void sendKeys_albumName() {
    	  
      }
      public void add_album(String albumName) {
    	  btn_addAlbum.click();
    	
    	  txtAlbumName.sendKeys(albumName);
    	 albmContainer.click();
    	 
    	
    	
    	 albmContainer.sendKeys("Trips");
    	 
    	/*  List<WebElement> list = driver.findElements(By.xpath("//div[@class=' css-1wa3eu0-placeholder']"));
    	  System.out.println(list.size());
    	  for(int i=0; i<list.size(); i++)
    	  {
    		  if(list.get(i).getText().equals("Trips")) {
    			  list.get(i).click();
    			  break;
    		  }
    	  }*/
    	  
    	// albumCategory.sendKeys("Trips");
    	// ExpliciteWait.waitFor_albumCategory();
    	//albmContainer.sendKeys("Trips");
    	 
      }
      
}
