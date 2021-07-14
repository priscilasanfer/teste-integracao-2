package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.util.builder.LeilaoBuilder;
import br.com.alura.leilao.util.builder.UsuarioBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LeilaoDaoTest {

    private LeilaoDao dao;
    private EntityManager em;

    @BeforeEach
    void setUp() {
        this.em = JPAUtil.getEntityManager();
        this.dao = new LeilaoDao(em);
        em.getTransaction().begin();
    }

    @AfterEach
    void tearDown() {
        em.getTransaction().rollback();
    }

    @Test
    void deveriaCadastrarUmLeilao() {
        Usuario usuario = new UsuarioBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("123435").criar();

        em.persist(usuario);

        Leilao leilao = new LeilaoBuilder()
                .comNome("Cama")
                .comValorInicial("5000")
                .comData(LocalDate.now())
                .comUsuario(usuario)
                .criar();

        leilao = dao.salvar(leilao);

        Leilao leilaoSalvo = dao.buscarPorId(leilao.getId());

        assertNotNull(leilaoSalvo);
    }

    @Test
    void deveriaAtualizarUmLeilao() {
        Usuario usuario = new UsuarioBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("123435")
                .criar();

        em.persist(usuario);

        Leilao leilao = new LeilaoBuilder()
                .comNome("Cama")
                .comValorInicial("5000")
                .comData(LocalDate.now())
                .comUsuario(usuario)
                .criar();


        leilao = dao.salvar(leilao);

        leilao.setNome("Cama");
        leilao.setValorInicial(new BigDecimal("5000"));

        leilao = dao.salvar(leilao);
        Leilao leilaoSalvo = dao.buscarPorId(leilao.getId());

        assertEquals("Cama", leilao.getNome());
        assertEquals(new BigDecimal("5000"), leilaoSalvo.getValorInicial());
    }

}