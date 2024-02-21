import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def testData = findTestData('Data Files/DataTest')
def username = testData.getObjectValue('username', 1)
def password = testData.getObjectValue('password', 1)
def product = testData.getObjectValue('product', 1)
def FirstName = testData.getObjectValue('FirstName', 1)
def LastName = testData.getObjectValue('LastName', 1)
def ZipCode = testData.getObjectValue('ZipCode', 1)

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.saucedemo.com/')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Swag Labs/Page_Swag Labs/div_Swag Labs'), 10, FailureHandling.OPTIONAL)

String view = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/Page_Swag Labs/div_Swag Labs'))

WebUI.verifyMatch(view, 'Swag Labs', false)

CustomKeywords.'demo.Login.login'(username, password)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Swag Labs/span_Products'), 10, FailureHandling.OPTIONAL)

String product1 = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/Page_Swag Labs/div_Sauce Labs Backpack'))

WebUI.verifyMatch(product1, 'Sauce Labs Backpack', false)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/product' , [product : product] ))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Swag Labs/Page_Swag Labs/button_Back to products'), 10, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/Page_Swag Labs/button_Add to cart'))

String remove = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/Page_Swag Labs/button_Remove'))

WebUI.verifyMatch(remove, 'Remove', false)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/a_Swag Labs_shopping_cart_link'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Swag Labs/Page_Swag Labs/span_Your Cart'), 10, FailureHandling.OPTIONAL)

String cart = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/Page_Swag Labs/span_Your Cart'))

WebUI.verifyMatch(cart, 'Your Cart', false)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/Page_Swag Labs/button_Checkout'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Swag Labs/Page_Swag Labs/span_Checkout Your Information'), 10, FailureHandling.OPTIONAL)

String information = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/Page_Swag Labs/span_Checkout Your Information'))

WebUI.verifyMatch(information, 'Checkout: Your Information', false)

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/Page_Swag Labs/input_Checkout Your Information_firstName'), FirstName)

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/Page_Swag Labs/input_Checkout Your Information_lastName'), LastName)

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/Page_Swag Labs/input_Checkout Your Information_postalCode'), ZipCode)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/Page_Swag Labs/input_Cancel_continue'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Swag Labs/Page_Swag Labs/Page_Swag Labs/Page_Swag Labs/span_Checkout Overview'), 10, FailureHandling.OPTIONAL)

WebUI.closeBrowser()


