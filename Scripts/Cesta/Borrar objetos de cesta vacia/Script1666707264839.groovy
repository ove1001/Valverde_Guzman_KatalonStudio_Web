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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.amazon.es')

int flag = 0

while (flag == 0) {
    try {
        WebUI.verifyElementPresent(findTestObject('Object Repository/AmazonWeb/Barra de navegacion/Recuadro cuenta y listas'), 
            10)

        flag = 1
    }
    catch (Exception e) {
        WebUI.refresh()
    } 
}

WebUI.click(findTestObject('Object Repository/AmazonWeb/Cartel cookies/boton continuar sin aceptar cookies'))

WebUI.navigateToUrl('https://www.amazon.es/gp/cart/view.html?ref_=nav_cart')

WebUI.verifyElementText(findTestObject('Object Repository/AmazonWeb/Barra de navegacion/Cantidad items en carrito'), '0')

try {
    WebUI.click(findTestObject('AmazonWeb/Page_Cesta de compra Amazon.es/boton eliminar item'))
}
catch (Exception e) {
    WebUI.closeBrowser()
} 

WebUI.closeBrowser()

