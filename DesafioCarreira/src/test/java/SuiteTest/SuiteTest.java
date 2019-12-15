package SuiteTest;

import TestCampoPersonalizado.AdicionarCampoPersonalizadoEmProjetoTest;
import TestCampoPersonalizado.AlterarCampoPersonalizadoTest;
import TestCampoPersonalizado.CriarCampoPersonalizadoTest;
import TestCampoPersonalizado.RemoverCampoPersonalizadoEmProjetoTest;
import TestCategoria.CadastrarCategoriaTest;
import TestLogin.LoginInvalidoTest;
import TestLogin.LoginValidoTest;
import TestMarcador.AlterarMarcadorTest;
import TestMarcador.CriarMarcadorTDDTest;
import TestMarcador.CriarMarcadorTest;
import TestMarcador.ExcluirMarcadorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({


        LoginInvalidoTest.class,
        LoginValidoTest.class,


        AdicionarCampoPersonalizadoEmProjetoTest.class,
        AlterarCampoPersonalizadoTest.class,
        CriarCampoPersonalizadoTest.class,
        RemoverCampoPersonalizadoEmProjetoTest.class,



        //==>AlterarCategoriaEmTarefasTest.class,
        //==>ApagarCategoriaTest.class,
        CadastrarCategoriaTest.class,


        AlterarMarcadorTest.class,
        CriarMarcadorTest.class,
        ExcluirMarcadorTest.class,
        CriarMarcadorTDDTest.class

        /*
        AdicionarUsuarioEmProjetoTest.class,
        AlterarUsuarioTest.class,
        ApagarUsuarioTest.class,
        CriarUsuarioTest.class,
        MostrarUsuarioDesabilitadoTest.class,
        MostrarUsuarioHabilitadoTest.class,
        PesquisarUsuarioTest.class,
        RedefinirSenhaUsuarioTest.class,
        RemoverUsuarioEmProjetoTest.class,
        RepresentarUsuarioTest.class,
        GerarTokenTest.class,
        RevogarTokenTest.class,
        AdicionarFiltroTarefasTest.class,
        AdicionarMarcadorEmTarefasTest.class,

        AlterarStatusTarefasTest.class,
        ApagarMarcadorEmTarefasTest.class,

        ClonarTarefasTest.class,
        CriarTarefasTest.class,
        DesmarcarTarefaPegajosaTest.class,
        FecharTarefasTest.class,
        ImprimirTarefasTest.class,
        MarcarTarefaPegajosaTest.class,
        MonitorarTarefasTest.class,
        MoverTarefasTest.class,
        //=====
        PararDeMonitorarTarefasTest.class,
        PesquisarTarefasTest.class,
        RedefinirFiltroTarefasTest.class,
        //=====
        AlterarProjetoTest.class,
        AlterarVisibilidadeDeProjetoPrivadoTest.class,
        AlterarVisibilidadeDeProjetoPublicoTest.class,
        CriarProjetoTest.class,
        ExcluirProjetoTest.class,
        AlterarPerfilTest.class,
        CriarPerfilTest.class,
        ExcluirProjetoTest.class,
        AlterarCategoriaTest.class,
        ApagarCategoriaTest.class,



        AdicionarCampoPersonalizadoEmProjetoTest.class,
        AlterarCampoPersonalizadoTest.class,
        CriarCampoPersonalizadoTest.class,
        ExcluirMarcadorTest.class,
        RemoverCampoPersonalizadoEmProjetoTest.class

        */
})
public class SuiteTest {

}
