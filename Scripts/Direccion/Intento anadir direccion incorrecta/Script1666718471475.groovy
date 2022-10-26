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

/*
if (WebUI.verifyElementClickable(findTestObject('AmazonWeb/Barra de navegacion/Boton Mi cuenta Pagina principal'))) {
    WebUI.click(findTestObject('AmazonWeb/Barra de navegacion/Boton Mi cuenta Pagina principal'))
}
*/
WebUI.mouseOver(findTestObject('Object Repository/AmazonWeb/Barra de navegacion/Recuadro cuenta y listas'))

WebUI.verifyElementPresent(findTestObject('Object Repository/AmazonWeb/Barra de navegacion - desplegable cuenta/Boton identificarse'), 
    15)

WebUI.verifyElementNotPresent(findTestObject('Object Repository/AmazonWeb/Barra de navegacion - desplegable cuenta/Boton cerrar sesion'), 
    15)

WebUI.click(findTestObject('Object Repository/AmazonWeb/Barra de navegacion - desplegable cuenta/Boton identificarse'))

WebUI.setText(findTestObject('Object Repository/AmazonWeb/Pagina inicio sesion/campo direccion de email'), GlobalVariable.correo_valido)

WebUI.click(findTestObject('Object Repository/AmazonWeb/Pagina inicio sesion/boton email introducido'))

WebUI.setEncryptedText(findTestObject('Object Repository/AmazonWeb/Pagina inicio sesion/campo password'), GlobalVariable.pass_valida)

WebUI.click(findTestObject('Object Repository/AmazonWeb/Pagina inicio sesion/boton password introducida'))

WebUI.click(findTestObject('Object Repository/AmazonWeb/Barra de navegacion/Boton cuenta y listas'))

WebUI.verifyMatch(WebUI.getUrl(), 'https://www.amazon.es/gp/css/homepage.html?ref_=nav_youraccount_btn', false)

WebUI.mouseOver(findTestObject('Object Repository/AmazonWeb/Barra de navegacion/Recuadro cuenta y listas'))

WebUI.verifyElementPresent(findTestObject('Object Repository/AmazonWeb/Barra de navegacion - desplegable cuenta/Boton cerrar sesion'), 
    15)

WebUI.verifyElementNotPresent(findTestObject('Object Repository/AmazonWeb/Barra de navegacion - desplegable cuenta/Boton identificarse'), 
    15)

WebUI.refresh()

WebUI.click(findTestObject('Object Repository/AmazonWeb/Pagina mi cuenta/Boton mis direcciones'))

WebUI.navigateToUrl('https://www.amazon.es/a/addresses?ref_=ya_d_c_addr')

WebUI.click(findTestObject('Object Repository/AmazonWeb/Pagina mis direcciones/Boton anadir direccion'))

WebUI.scrollToPosition(0, 500)

WebUI.click(findTestObject('Object Repository/AmazonWeb/Pagina mis direcciones/Boton confirmar direccion'))

WebUI.verifyElementPresent(findTestObject('AmazonWeb/Pagina mis direcciones/Error introduce un nmero de telfono'), 15)

WebUI.verifyElementPresent(findTestObject('AmazonWeb/Pagina mis direcciones/Error introduce una direccin'), 15)

WebUI.verifyElementPresent(findTestObject('AmazonWeb/Pagina mis direcciones/Error introduce un nombre de ciudad'), 15)

WebUI.setText(findTestObject('Object Repository/AmazonWeb/Pagina mis direcciones/Campo ciudad'), 'Burgos')

WebUI.setText(findTestObject('Object Repository/AmazonWeb/Pagina mis direcciones/Campo provincia'), 'Burgos')

WebUI.setText(findTestObject('Object Repository/AmazonWeb/Pagina mis direcciones/Campo codigo postal'), '09006')

WebUI.setText(findTestObject('Object Repository/AmazonWeb/Pagina mis direcciones/Campo telefono'), '777777777')

WebUI.setText(findTestObject('Object Repository/AmazonWeb/Pagina mis direcciones/Campo calle'), 'vbfdsghghnfd')

WebUI.setText(findTestObject('Object Repository/AmazonWeb/Pagina mis direcciones/Campo numero'), 'sn')

WebUI.scrollToPosition(0, 500)

WebUI.click(findTestObject('Object Repository/AmazonWeb/Pagina mis direcciones/Boton confirmar direccion'))

WebUI.verifyElementPresent(findTestObject('AmazonWeb/Pagina mis direcciones/Aviso revisa tu direccion'), 15)

