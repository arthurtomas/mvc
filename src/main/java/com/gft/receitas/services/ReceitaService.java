package com.gft.receitas.services;

import com.gft.receitas.entities.Receita;
import com.gft.receitas.repositories.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    public Receita salvarReceita(Receita receita) {
        return receitaRepository.save(receita);
    }

    private List<Receita> listarReceitasPorNome(String nome) {
        return receitaRepository.findByNomeContains(nome);
    }
    private List<Receita> listarReceitasPorItens(String itensString) {
        return receitaRepository.findByItensStringContains(itensString);
    }

    public List<Receita> listarTodasReceitas() {
        return receitaRepository.findAll();
    }

    public List<Receita> listarReceitas(String nome, String itensString) {
        if ((nome != null)&&(itensString == null))
            return listarReceitasPorNome(nome);
        if ((nome == null)&&(itensString != null))
            return listarReceitasPorItens(itensString);
        return listarTodasReceitas();
    }

    public Receita obterReceita(Long id) throws Exception {

        Optional<Receita> receita = receitaRepository.findById(id);
        if (receita.isEmpty()) {
            throw new Exception("Receita não encontrada");
        }
        return receita.get();
    }

    public void excluirReceita(Long id) {
        receitaRepository.deleteById(id);
    }

    public void popularBancoReceita(){

        Receita receita01 = new Receita();
        receita01.setNome("Cuscuz Simples");
        receita01.setTempoPreparo("15 min");
        receita01.setRendimento("5 porções");
        receita01.setItensString("""
                300 g de Farinha de milho
                1 copo (americano) de água
                sal a gosto
                """);
        receita01.setModoPreparo("""
                Coloque a milharina e o sal em um recipiente.
                Acrecente água ao poucos e mexa bem.
                Após a mistura, coloque tudo em uma cuscuzeira e leve ao fogo.
                Quando a água da cuscuzeira começar a ferver coloque em fogo baixo e deixe no vapor por 5 minutos.
                Sirva do modo que desejar.
                """);
        receita01.setUrl("https://www.youtube.com/watch?v=F3CAFJgok9w");
        salvarReceita(receita01);

        Receita receita02 = new Receita();
        receita02.setNome("Costelinha com Molho Barbecue");
        receita02.setTempoPreparo("70 min");
        receita02.setRendimento("5 porções");
        receita02.setItensString("""
                2 kg costelinhas bovina aferventadas em água quente
                1 colher (sopa) óleo
                2 colheres (sopa) cebola picada
                1/2 xícara (chá) açúcar mascavo
                1/2 xícara (chá) vinagre branco
                2 colheres (sopa) molho inglês
                2 xícaras (chá) catchup
                1 folha de louro
                1 colher (sopa) chilli em pó
                1/2 xícara (chá) água
                Sal e pimenta do reino a gosto
                """);
        receita02.setModoPreparo("""
                Espalhe sal por toda a carne e coloque para ferver por 10 minutos em um panela com bastante água quente.
                Escorra a água, arrume as costelinhas em uma assadeira, cubra com papel alumínio e leve ao forno baixo ( 180º) por 40 minutos.
                Em uma panela, refogue a cebola no óleo, acrescente o açúcar mascavo e o vinagre e deixe o açúcar dissolver.
                Acrescente o molho inglês, o catchup, o louro, o chilli em pó e a água e cozinhe por 30 minutos em fogo baixo ou até o molho engrossar.
                Tempere com sal e pimenta-do-reino, coe e reserve.
                Após os 40 minutos retire as costelinhas do forno, retire o papel alumínio e pincele com o molho.
                Aumente a temperatura do forno, asse as costelinhas por mais 10 minutos, pincele novamente com o molho, asse mais 5 minutos e repita mais uma vez esta operação.
                Sirva com mais molho à parte.
                """);
        receita02.setUrl("https://www.youtube.com/watch?v=oCz9dAq3l2Q");
        salvarReceita(receita02);

        Receita receita03 = new Receita();
        receita03.setNome("Maçã do Amor");
        receita03.setTempoPreparo("30 min");
        receita03.setRendimento("12 porções");
        receita03.setItensString("""
                1 kg de açúcar
                500 ml de água
                1 colher (sopa) de vinagre
                corante vermelho (pó ou líquido)
                12 maçãs (pequena/média)
                palitos de sorvete
                """);
        receita03.setModoPreparo("""
                MAÇÃS:
                Lave e seque as maçãs.
                Espete-as com 1 ou 2 palitos (ajudará na firmeza na hora de caramelizar).
                Unte formas de alumínio (pode ser de bolo) com óleo, bem pouco.
                
                CALDA:
                Coloque todos os ingredientes dentro de uma panela.
                Nesta receita não se usa nenhuma colher (pois, pode açucarar a calda).
                Misture/mexa apenas a panela - não use nenhum tipo de colher, pois, pode quebrar o ponto da calda.
                Até a fervura, pode usar fogo alto, quando ferver, mude para médio e mantenha por aproximadamente 25 minutos.
                Mergulhe a ponta de um palito de sorvete na calda e pingue na forma em segundos.
                Pressione com o dedo (ela amassará) e solte sobre a forma; se ela fizer barulho de sólida, desligue imediatamente e comece o processo de mergulhar as maçãs e colocá-las sobre a forma previamente untada.
                Note que o ideal é realizar este processo o mais breve possível, pois a calda vai, naturalmente, endurecendo.
                """);
        receita03.setUrl("https://www.youtube.com/watch?v=tV3Hrz8wynk");
        salvarReceita(receita03);

        Receita receita04 = new Receita();
        receita04.setNome("Cocada com Leite Condensado");
        receita04.setTempoPreparo("40 min");
        receita04.setRendimento("5 porções");
        receita04.setItensString("""
                2 xícaras de coco fresco ralado
                1 lata de leite condensado
                2 xícaras de açúcar
                1 colher (sopa) de manteiga
                óleo para untar
                """);
        receita04.setModoPreparo("""
                Unte uma pedra de mármore ou uma assadeira com um pouco de óleo.
                Misture em uma panela o coco, o leite condensado e o açúcar.
                Leve ao fogo e misture bem, cozinhe misturando regularmente com uma colher de pau.
                Quando o doce começar a ser soltar do fundo da panela, retire do fogo e acrescente a manteiga.
                Bata bem com a colher de pau para que o doce açucare.
                Despeje sobre o mármore untado e deixe esfriar.
                Corte quadrados de 10 x 10 cm.
                """);
        receita04.setUrl("https://www.youtube.com/watch?v=bWZkdirtxYM");
        salvarReceita(receita04);

        Receita receita05 = new Receita();
        receita05.setNome("Bolo Integral de Banana");
        receita05.setTempoPreparo("60 min");
        receita05.setRendimento("12 porções");
        receita05.setItensString("""
                4 ovos inteiros
                6 bananas caturra cortadas em rodelas
                1/2 xícara de chá de óleo de canola
                1/2 xícara de leite desnatado
                1 xícara de chá de farinha de trigo integral
                1 xícara de chá de aveia
                2 xícaras de chá, não muito cheias, de açúcar mascavo.
                canela para salpicar
                1 colher de sopa de fermento em pó
                """);
        receita05.setModoPreparo("""
				Bata todos os ingredientes no liqüidificador com apenas 1 banana, coloque em forma untada com óleo e farinha.
				Ponha as rodelas de banana sobre essa massa e salpique com canela.
				Assar em forno pré-aquecido, a 180° por aproximadamente 50 minutos.
				""");
        receita05.setUrl("https://www.youtube.com/watch?v=nbEM-Hb7ISE");
        salvarReceita(receita05);

        Receita receita06 = new Receita();
        receita06.setNome("Coxinha Low Carb");
        receita06.setTempoPreparo("45 min");
        receita06.setRendimento("5 porções");
        receita06.setItensString("""
                1 fio de azeite
                1 cebola picada
                5 dentes de alho picado
                1 tomate picado
                500 g de peito de frango desfiado
                sal a gosto
                pimenta-do-reino a gosto
                cheiro-verde a gosto
                1 couve-flor picada
                150 g de creme de ricota
                100 g de queijo meia cura ralado
                1 xícara de farinha de linhaça
                """);
        receita06.setModoPreparo("""
                Em uma frigideira, aqueça 1 fio de óleo e reogue a cebola e o alho picado.
                Adicione o tomate e deixe refogar um pouco.
                Acrescente o frango desfiado, o sal, a pimenta-do-reino e o cheiro-verde.
                Transfira essa mistura para um processador e acresente a couve-flor picada.
                Bata tudo muito bem até formar a massa da coxinha.
                Em outra tigela misture o creme de ricota com o queijo meia cura ralado.
                Pegue um pedaço da massa e abra na mão.
                Recheie com a msitura de creme de ricota com queijo e feche, formando uma coxinha.
                Passe as coxinhas na farinha de linhaça.
                Coloque as coxinhas em uma forma e leve ao forno preaquecido (180° C) por cerca de 35 minutos.
                """);
        receita06.setUrl("https://www.youtube.com/watch?v=WAZwHN_GPco");
        salvarReceita(receita06);

        Receita receita07 = new Receita();
        receita07.setNome("Torta Sensação");
        receita07.setTempoPreparo("120 min");
        receita07.setRendimento("5 porções");
        receita07.setItensString("""
                200 g de biscoito de chocolate
                100 g de manteiga sem sal
                1 xicara de água
                1 pacote de gelatina incolor
                1 pacote de gelatina de morango
                1 lata de leite condensado
                2 copos de iogurte natural
                2 caixas de creme de leite
                1 caixa de morangos picados
                300 g de chocolate meio amargo
                1 caixa de creme de leite quente
                raspas de chocolate para decorar
                """);
        receita07.setModoPreparo("""
                MASSA:
                Triture os biscoitos e misture com a manteiga derretida até formar uma farofinha úmida.
                Transfira para uma forma forrada com papel-manteiga.
                Aperte com os dedos para a base da torta ficar bem firme.
                Leve ao forno preaquecido (180° C) por 10 minutos.
                RECHEIO:
                Dissolva a gelatina incolor em 1/2 xícara de água e leve ao micro-ondas por 30 segundos.
                Dissolva a gelatina de morango em 1/2 xícara de água quente.
                Transfira as gelatinas para o liquidificador.
                Adicione o leite condensado, o iogurte natural e o creme de leite; bata bem.
                Adicione os morangos picados e misture.
                Despeje essa mistura sobre a massa.
                Leve à geladeira por 1 hora.
                COBERTURA:
                Misture o chocolate meio amargo com o creme de leite quente.
                Despeje sobre a torta e volte à geladeira por 3 horas.
                Finalize com raspas de chocolate.
                """);
        receita07.setUrl("https://www.youtube.com/watch?v=ZMXP5UJvc44");
        salvarReceita(receita07);

        Receita receita08 = new Receita();
        receita08.setNome("Cebola Empanada");
        receita08.setTempoPreparo("30 min");
        receita08.setRendimento("5 porções");
        receita08.setItensString("""
                1 cebola grande
                1 ovo
                1 xícara de leite integral
                1 xícara de farinha de trigo
                3 colheres (sopa) de fubá
                1 colher (chá) de páprica picante
                1 colher (chá) de páprica defumada
                1 colher (chá) de cominho em pó
                1 colher (chá) de tomilho
                1 colher (chá) de pimenta-do-reino preta
                1/2 colher (chá) de açafrão
                sal a gosto
                óleo
                """);
        receita08.setModoPreparo("""
                Junte a farinha de trigo com sal, tomilho, cominho e pimenta.
                Junte o fubá e misture tudo.
                Em outro recipiente misture o ovo com o leite.
                Reserve os dois recipientes e comece a cortar a cebola
                Retire as duas pontas da cebola.
                Faça um corte maior em uma das pontas para que se forme uma base fixa.
                Retire a casca por completo com cuidado.
                Apoie a cebola com esse pedaço para baixo e comece a fazer os outros cortes
                Corte ao meio, mas não passe a faca até o final, deixe 2 cm entre a base e o final do corte.
                Faça isso em todos os cortes seguintes: comece no meio, faça uma cruz, depois corte um x entre a cruz e finalize com mais dois cortes.
                O ideal é que ela pareça com fatias de pizza do mesmo tamanho.
                Coloque água bem gelada em um recipiente e coloque a cebola com os cortes para baixo.
                Leve isso para à geladeira por duas horas.
                Retire da geladeira e mergulhe a cebola na mistura de leite e ovo (passe bastante no meio dos cortes).
                Misture os temperos à farinha de trigo e ao fubá
                Passe a cebola na farinha e faça o mesmo processo, com cuidado para tudo ficar empanado. Leve à geladeira por mais 10 minutos para a primeira camada firmar.
                Repita o mesmo processo de ovo e farinha.
                Coloque uma panela de óleo para esquentar que caiba a cebola, de modo que ela fique em pé.
                Frite a cebola até dourar.
                """);
        receita08.setUrl("https://www.youtube.com/watch?v=bg4xnXhuPlo");
        salvarReceita(receita08);

        Receita receita09 = new Receita();
        receita09.setNome("Salada de Macarrão com Atum");
        receita09.setTempoPreparo("30 min");
        receita09.setRendimento("6 porções");
        receita09.setItensString("""
                250 g de macarrão parafuso
                1/2 cebola bem picadinha
                2 tomates sem sementes cortados em cubinhos
                1 lata de milho verde
                2 latas de atum ralado sem o óleo da conserva
                2 colheres (sopa) de mostarda
                1 xícara de maionese
                sal, pimenta-do-reino e cheiro verde a gosto
                """);
        receita09.setModoPreparo("""
                Em uma panela ferva a água para cozinhar o macarrão.
                Cozinhe da forma tradicional deixando o macarrão al dente.
                Enquanto isso prepare a mistura para temperar o macarrão.
                Coloque em uma vasilha grande as 2 latas de atum, a cebola, os tomates, o milho, a maionese, a mostarda, sal, pimenta do reino e o cheiro verde.
                Cuidadosamente misture bem.
                Depois que o macarrão estiver cozido, colque em um refratário e adicione a mistura mexendo levemente para não quebrar o macarrão.
                Quando a mistura estiver bem incorporada ao macarrão leve para a geladeira por no mínimo 1 hora e meia.
                Eu prefiro fazer com de um dia para o outro, pois o sabor fica bem mais apurado.
                Sirva como prato principal em dias quentes acompanhado de um frango grelhado.
                """);
        receita09.setUrl("https://www.youtube.com/watch?v=Y5lrxBEHlfo");
        salvarReceita(receita09);

        Receita receita10 = new Receita();
        receita10.setNome("Meninas Superpoderosas");
        receita10.setTempoPreparo("30 min");
        receita10.setRendimento("135 Episódios");
        receita10.setItensString("""
				Açúcar
				Tempero
				Tudo que há de bom
				E acidentalmente o Elemento X
				""");
        receita10.setModoPreparo("""
                Açúcar, tempero e tudo que há de bom
                Estes foram os ingredientes escolhidos para criar as garotinhas perfeitas
                Mas o professor Utônio, acidentalmente, acrescentou um ingrediente extra na mistura
                O elemento X!
                E assim nasceram as meninas Superpoderosas, usando seus ultra-super poderes
                Florzinha, Lindinha e Docinho, têm dedicado suas vidas
                Combatendo o crime, e as forças do mal!
                """);
        receita10.setUrl("https://www.youtube.com/watch?v=E-ocCeYezJ8");
        salvarReceita(receita10);

    }

}
