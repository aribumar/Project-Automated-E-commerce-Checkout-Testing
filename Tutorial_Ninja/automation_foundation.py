import selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from time import sleep as wait

def setup_driver():
    # Set up the Chrome driver
    options = webdriver.ChromeOptions()
    options.add_argument("--start-maximized")
    driver = webdriver.Chrome(options=options)
    return driver   
def Url():
    # Return the URL of the website to be tested
    url = "https://tutorialsninja.com/demo/"
    return url

def open_website(driver, url):
    # Open the specified URL
    driver.get(url)
    wait(2)  # Wait for the page to load

if __name__ == "__main__":
    driver = setup_driver()
    url = Url()
    open_website(driver, url)
    url = driver.current_url
    print(f"Opened URL: {url}")
    # Perform some actions on the website
    
    wait(5)  # Keep browser open for 5 seconds
    driver.quit()