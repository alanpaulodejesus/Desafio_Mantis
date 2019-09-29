package SuiteTest;

import TestLogin.LoginInvalidoTest;
import TestLogin.LoginValidoTest;
import TestTarefas.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        LoginInvalidoTest.class,
        LoginValidoTest.class,
        AlterarCategoriaTarefasTest.class,
        ApagarTarefasTest.class,
        CriarTarefasTest.class,
        FecharTarefasTest.class,
        PesquisarTarefasTest.class
})
public class SuiteTest {

}
