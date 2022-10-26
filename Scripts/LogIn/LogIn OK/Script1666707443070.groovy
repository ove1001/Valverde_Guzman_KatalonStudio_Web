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

'Recargar la página principal si sale con una interfaz diferente a la habitual (a veces pasa)'
int flag = 0

while (flag == 0) {
    try {
        WebUI.verifyElementPresent(findTestObject('AmazonWeb/Barra de navegacion/Recuadro cuenta y listas'), 10)

        flag = 1
    }
    catch (Exception e) {
        WebUI.refresh()
    } 
}

'Cerrar mensaje cookies'
WebUI.click(findTestObject('AmazonWeb/Cartel cookies/boton continuar sin aceptar cookies'))

/*
if (WebUI.verifyElementClickable(findTestObject('AmazonWeb/Barra de navegacion/Boton Mi cuenta Pagina principal'))) {
    WebUI.click(findTestObject('AmazonWeb/Barra de navegacion/Boton Mi cuenta Pagina principal'))
}
*/
WebUI.mouseOver(findTestObject('AmazonWeb/Barra de navegacion/Recuadro cuenta y listas'))

WebUI.verifyElementPresent(findTestObject('AmazonWeb/Barra de navegacion - desplegable cuenta/Boton identificarse'), 15)

WebUI.verifyElementNotPresent(findTestObject('AmazonWeb/Barra de navegacion - desplegable cuenta/Boton cerrar sesion'), 
    15)

WebUI.click(findTestObject('AmazonWeb/Barra de navegacion - desplegable cuenta/Boton identificarse'))

WebUI.setText(findTestObject('Object Repository/AmazonWeb/Pagina inicio sesion/campo direccion de email'), GlobalVariable.correo_valido)

WebUI.click(findTestObject('Object Repository/AmazonWeb/Pagina inicio sesion/boton email introducido'))

WebUI.setEncryptedText(findTestObject('Object Repository/AmazonWeb/Pagina inicio sesion/campo password'), GlobalVariable.pass_valida)

WebUI.click(findTestObject('Object Repository/AmazonWeb/Pagina inicio sesion/boton password introducida'))

WebUI.click(findTestObject('AmazonWeb/Barra de navegacion/Boton cuenta y listas'))

WebUI.verifyMatch(WebUI.getUrl(), 'https://www.amazon.es/gp/css/homepage.html?ref_=nav_youraccount_btn', false)

WebUI.mouseOver(findTestObject('AmazonWeb/Barra de navegacion/Recuadro cuenta y listas'))

WebUI.verifyElementPresent(findTestObject('AmazonWeb/Barra de navegacion - desplegable cuenta/Boton cerrar sesion'), 15)

WebUI.verifyElementNotPresent(findTestObject('AmazonWeb/Barra de navegacion - desplegable cuenta/Boton identificarse'), 
    15)

WebUI.closeBrowser()

