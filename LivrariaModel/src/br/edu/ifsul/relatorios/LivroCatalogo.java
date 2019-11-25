package br.edu.ifsul.relatorios;

import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Formato;
import br.edu.ifsul.modelo.Idioma;
import br.edu.ifsul.modelo.Livraria;
import br.edu.ifsul.modelo.Livro;
import br.edu.ifsul.modelo.Usuario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class LivroCatalogo {
    
    public static List<Livro> carregaLivro(){
        List<Livro> lista = new ArrayList<>();
        Livro l = new Livro();
        
        Catalogo c = new Catalogo();
        c.setNome("Nome");
        c.setDescricao("Descrição");
        
        Livraria livraria = new Livraria();
        livraria.setNome("Livraria");
        livraria.setSite("www.com");
        c.setLivraria(livraria);
        
        Formato f = new Formato();
        f.setNome("Formato");
        
        Idioma i = new Idioma();
        i.setNome("Portugues");
        i.setSigla("PT");
        
        l.setAtivo(Boolean.TRUE);
        l.setCadastro(Calendar.getInstance());
        l.setCatalogo(c);
        l.setCodigoBarras("23357367357");
        l.setDataPublicacao(Calendar.getInstance());
        l.setEditora("Editora");
        l.setFormato(f);
        l.setISBN("1322624762462");
        l.setIdioma(i);
        l.setNumeroPaginas(114);
        l.setResumo("Resumo");
        l.setTitulo("1984");
        l.setValor(39.99);
        
        lista.add(l);
        return lista;
    }
    
    
    public static List<Catalogo> carregaCatalogo(){
        List<Catalogo> lista = new ArrayList<>();
        Catalogo c = new Catalogo();
        
        Livraria livraria = new Livraria();
            
        livraria.setNome("Livraria");
        livraria.setSite("www.com");
        
        List<Livro> listaLivros = new ArrayList<>();
        Livro l = new Livro();
        
        Catalogo c1 = new Catalogo();
        c1.setNome("Nome");
        c1.setDescricao("Descrição");
        
        Livraria livraria1 = new Livraria();
        livraria1.setNome("Livraria");
        livraria1.setSite("www.com");
        c1.setLivraria(livraria1);
        
        Formato f = new Formato();
        f.setNome("Formato");
        
        
        Idioma i = new Idioma();
        
        i.setNome("Portugues");
        i.setSigla("PT");
        
        l.setAtivo(Boolean.TRUE);
        l.setCadastro(Calendar.getInstance());
        l.setCatalogo(c1);
        l.setCodigoBarras("23357367357");
        l.setDataPublicacao(Calendar.getInstance());
        l.setEditora("Editora");
        l.setFormato(f);
        l.setISBN("1322624762462");
        l.setIdioma(i);
        l.setNumeroPaginas(114);
        l.setResumo("Resumo");
        l.setTitulo("1984");
        l.setValor(39.99);
        
        listaLivros.add(l);
        
        c.setNome("Nome");
        c.setDescricao("Descrição");
        c.setLivros(listaLivros);
        c.setLivraria(livraria);
        lista.add(c);
        return lista;
    }

}