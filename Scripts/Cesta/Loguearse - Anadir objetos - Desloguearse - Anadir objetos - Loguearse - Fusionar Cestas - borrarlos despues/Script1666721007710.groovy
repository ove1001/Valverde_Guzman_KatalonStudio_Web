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
        WebUI.verifyElementPresent(findTestObject('AmazonWeb/Barra de navegacion/Recuadro cuenta y listas'), 10)

        flag = 1
    }
    catch (Exception e) {
        WebUI.refresh()
    } 
}

WebUI.click(findTestObject('AmazonWeb/Cartel cookies/boton continuar sin aceptar cookies'))

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

cantidad_usuario_inicial = WebUI.getText(findTestObject('Object Repository/AmazonWeb/Barra de navegacion/Cantidad items en carrito'))

Integer cant_user_inicial = Integer.parseInt(cantidad_usuario_inicial)

Integer cant_user_final = 0

for (def articulo : GlobalVariable.articulos) {
    WebUI.navigateToUrl(articulo)

    cantidad_usuario_inicial = WebUI.getText(findTestObject('Object Repository/AmazonWeb/Barra de navegacion/Cantidad items en carrito'))

    cant_user_inicial = Integer.parseInt(cantidad_usuario_inicial)

    WebUI.click(findTestObject('Object Repository/AmazonWeb/Pagnia item/Anadir al carrito'))

    WebUI.navigateToUrl('https://www.amazon.es/gp/cart/view.html?ref_=nav_cart')

    cant_user_final = (cant_user_inicial + 1)

    cantidad_usuario_final = cant_user_final.toString()

    WebUI.verifyElementText(findTestObject('Object Repository/AmazonWeb/Barra de navegacion/Cantidad items en carrito'), 
        cantidad_usuario_final)
}

cant_user_inicial = cant_user_final

WebUI.mouseOver(findTestObject('AmazonWeb/Barra de navegacion/Recuadro cuenta y listas'))

WebUI.click(findTestObject('AmazonWeb/Barra de navegacion - desplegable cuenta/Boton cerrar sesion'))

WebUI.navigateToUrl('https://www.amazon.es/')

WebUI.mouseOver(findTestObject('AmazonWeb/Barra de navegacion/Recuadro cuenta y listas'))

WebUI.verifyElementPresent(findTestObject('AmazonWeb/Barra de navegacion - desplegable cuenta/Boton identificarse'), 15)

WebUI.verifyElementNotPresent(findTestObject('AmazonWeb/Barra de navegacion - desplegable cuenta/Boton cerrar sesion'), 
    15)

WebUI.click(findTestObject('Object Repository/AmazonWeb/Cartel cookies/boton continuar sin aceptar cookies'))

Integer cant_inicial = 0

Integer cant_final = 0

for (def articulo : GlobalVariable.articulos) {
    WebUI.navigateToUrl(articulo)

    cantidad_inicial = WebUI.getText(findTestObject('Object Repository/AmazonWeb/Barra de navegacion/Cantidad items en carrito'))

    cant_inicial = Integer.parseInt(cantidad_inicial)

    WebUI.click(findTestObject('Object Repository/AmazonWeb/Pagnia item/Anadir al carrito'))

    WebUI.navigateToUrl('https://www.amazon.es/gp/cart/view.html?ref_=nav_cart')

    cant_final = (cant_inicial + 1)

    cantidad_final = cant_final.toString()

    WebUI.verifyElementText(findTestObject('Object Repository/AmazonWeb/Barra de navegacion/Cantidad items en carrito'), 
        cantidad_final)
}

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

WebUI.navigateToUrl('https://www.amazon.es/gp/cart/view.html?ref_=nav_cart')

cant_user_final = (cant_final + cant_user_inicial)

cantidad_usuario_final = cant_user_final.toString()

WebUI.verifyElementText(findTestObject('Object Repository/AmazonWeb/Barra de navegacion/Cantidad items en carrito'), cantidad_usuario_final)

WebUI.navigateToUrl('https://www.amazon.es/gp/cart/view.html?ref_=nav_cart')

cantidad_inicial = WebUI.getText(findTestObject('Object Repository/AmazonWeb/Barra de navegacion/Cantidad items en carrito'))

cant_inicial = Integer.parseInt(cantidad_inicial)

while (cant_inicial > 0) {
    WebUI.click(findTestObject('AmazonWeb/Pagina cesta de compra/boton eliminar item'))

    WebUI.delay(5)

    WebUI.refresh(FailureHandling.STOP_ON_FAILURE)

    cant_final = (cant_inicial - 2)

    cantidad_final = cant_final.toString()

    WebUI.verifyElementText(findTestObject('Object Repository/AmazonWeb/Barra de navegacion/Cantidad items en carrito'), 
        cantidad_final)

    cantidad_inicial = WebUI.getText(findTestObject('Object Repository/AmazonWeb/Barra de navegacion/Cantidad items en carrito'))

    cant_inicial = Integer.parseInt(cantidad_inicial)
}

WebUI.verifyElementText(findTestObject('Object Repository/AmazonWeb/Barra de navegacion/Cantidad items en carrito'), '0')

WebUI.closeBrowser()

