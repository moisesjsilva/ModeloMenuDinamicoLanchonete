/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author moises
 */
public class ProdutoController {
    /**
     * 
     * @param cat categoria selecionada
     * @return Lista com filtros baseado na categoria
     */
    public static List<Produto> produtosPorCategoria(Categoria cat) {
        List<Produto> lista = new ArrayList<>();

        Long id = 1L;
        lista.add(new Produto(id++, "124", "Coca-cola", "https://www.paodeacucar.com/img/uploads/1/802/542802.JPG?type=product", new BigDecimal("1.25"), new Categoria(3L)));
        lista.add(new Produto(id++, "365", "Fanta", "https://s3-sa-east-1.amazonaws.com/deliveryon-uploads/products/via758/43_592cc4e83251a.jpg", new BigDecimal("1.25"), new Categoria(3L)));
        lista.add(new Produto(id++, "758", "Guarana", "https://s3-sa-east-1.amazonaws.com/deliveryon-uploads/products/gordofastfood/83_5a09cde860dea.jpg", new BigDecimal("1.25"), new Categoria(3L)));
        lista.add(new Produto(id++, "362", "Misto-quente", "http://wfarm3.dataknet.com/static/resources/icons/set41/de4d7870.png", new BigDecimal("1.25"), new Categoria(1L)));
        lista.add(new Produto(id++, "368", "Cochinha", "http://s.glbimg.com/po/rc/media/2015/03/30/14_57_38_927_coxinha_de_frango_receita_de_coxinha_650x350.jpg", new BigDecimal("1.25"), new Categoria(2L)));
        lista.add(new Produto(id++, "368", "Mc Flory Alp", "http://d701vexhkz032.cloudfront.net/media/images/promotion-pill/Thumb_Novidades-min.jpg", new BigDecimal("1.25"), new Categoria(5L)));
        // Filtra os dados da lista baseado na categoria passada por paramentro
        List<Produto> produtosPorCategoria = lista.stream()
                .filter(p -> Objects.equals(p.getCategoria().getId(), cat.getId()))
                .collect(Collectors.toList());
        // Adiciona um menu para voltar para categorias;
        produtosPorCategoria.add(0, new Produto(-1L, "-1", "Voltar", "https://www.clker.com/cliparts/d/3/0/b/1206569743961899636pitr_green_arrows_set_4.svg.med.png", null, null));
        return produtosPorCategoria;
    }
}
