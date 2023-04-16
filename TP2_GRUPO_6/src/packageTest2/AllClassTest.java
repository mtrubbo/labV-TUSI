package packageTest2;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

import frgp.utn.edu.ar.main.MatrizAdyacencia;


@RunWith(JUnitPlatform.class)
@SelectPackages("packageTest")
@SelectClasses(MatrizAdyacencia.class)

public class AllClassTest {

}
